package com.clean.architecture.port.adapter.configuration

import com.clean.architecture.application.retailer.AddProductsToRetailer
import com.clean.architecture.application.retailer.CreateRetailer
import com.clean.architecture.application.retailer.FindRetailer
import com.clean.architecture.application.retailer.RetailerRepository
import com.clean.architecture.port.adapter.repository.RetailerJpaRepository
import com.clean.architecture.port.adapter.repository.RetailerRepositoryAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FactoryConfig {

    @Bean
    fun getRepositoryAdapter(jpaRepository: RetailerJpaRepository) = RetailerRepositoryAdapter(jpaRepository)

    @Bean
    fun getAddProducts(repository: RetailerRepository) = AddProductsToRetailer(repository)

    @Bean
    fun getCreateRetailer(repository: RetailerRepository) = CreateRetailer(repository)

    @Bean
    fun getFindRetailer(repository: RetailerRepository) = FindRetailer(repository)


}

