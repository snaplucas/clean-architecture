package com.clean.architecture.port.adapter.configuration

import com.clean.architecture.application.retailer.*
import com.clean.architecture.port.adapter.communication.GetProductsFromService
import com.clean.architecture.port.adapter.file.operations.GetProductsFromFile
import com.clean.architecture.port.adapter.file.operations.GetProductsFromS3
import com.clean.architecture.port.adapter.repository.RetailerJpaRepository
import com.clean.architecture.port.adapter.repository.RetailerRepositoryAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FactoryConfig(@Value("\${products.source}") private val productsSource: String = "") {

    @Bean
    fun getRepositoryAdapter(jpaRepository: RetailerJpaRepository) = RetailerRepositoryAdapter(jpaRepository)

    @Bean
    fun getCreateRetailer(repository: RetailerRepository,
                          getProducts: GetProducts,
                          informPartners: InformPartners) =
        CreateRetailer(repository, getProducts, informPartners)

    @Bean
    fun getFindRetailer(repository: RetailerRepository) = FindRetailer(repository)

    @Bean
    fun getInformPartners() = InformAllPartners()

    @Bean
    fun getProducts(): GetProducts {
        return when (productsSource) {
            "s3" -> GetProductsFromS3()
            "service" -> GetProductsFromService()
            else -> GetProductsFromFile()
        }
    }
}

