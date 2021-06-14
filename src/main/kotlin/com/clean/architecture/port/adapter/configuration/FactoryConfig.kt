package com.clean.architecture.port.adapter.configuration

import com.clean.architecture.application.purchase.FindPurchaseInfo
import com.clean.architecture.application.retailer.RetailerRepository
import com.clean.architecture.application.retailer.create.CreateRetailer
import com.clean.architecture.application.retailer.create.GetProducts
import com.clean.architecture.application.retailer.create.SendPartnerInfo
import com.clean.architecture.application.retailer.find.FindRetailer
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
                          sendPartnerInfo: SendPartnerInfo) =
            CreateRetailer(repository, getProducts, sendPartnerInfo)

    @Bean
    fun getFindRetailer(repository: RetailerRepository) = FindRetailer(repository)

    @Bean
    fun getFindPurchase() = FindPurchaseInfo()

    @Bean
    fun getProducts(): GetProducts {
        return when (productsSource) {
            "s3" -> GetProductsFromS3()
            "service" -> GetProductsFromService()
            else -> GetProductsFromFile()
        }
    }
}

