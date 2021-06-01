package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer

class FindRetailer(private val repository: RetailerRepository) : Find {

    override fun findAll(): List<Retailer> {
        return repository.findAll()
    }

    override fun findRetailer(id: Long): Retailer {
        return repository.findById(id)
    }

    override fun findRetailerProducts(retailerId: Long): List<Product> {
        TODO("Not yet implemented")
    }
}