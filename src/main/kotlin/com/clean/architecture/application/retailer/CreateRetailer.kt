package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Retailer

class CreateRetailer(private val repository: RetailerRepository,
                     private val getProducts: GetProducts,
                     private val informPartners: InformPartners) : Create {

    override fun execute(retailer: Retailer): Retailer {
        val products = getProducts.execute(retailer.name)
        val newRetailer = retailer.copy(products = products)

        repository.save(newRetailer)
        informPartners.execute(newRetailer, "Success!")

        return newRetailer
    }
}