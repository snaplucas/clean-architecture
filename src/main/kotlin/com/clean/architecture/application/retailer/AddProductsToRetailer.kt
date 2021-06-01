package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer

class AddProductsToRetailer(private val repository: RetailerRepository) : AddProducts {

    override fun execute(retailer: Retailer, products: List<Product>) {
        TODO("Not yet implemented")
    }
}