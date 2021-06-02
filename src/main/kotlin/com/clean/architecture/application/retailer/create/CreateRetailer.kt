package com.clean.architecture.application.retailer.create

import com.clean.architecture.application.retailer.RetailerRepository
import com.clean.architecture.domain.model.retailer.Retailer

class CreateRetailer(private val repository: RetailerRepository,
                     private val getProducts: GetProducts,
                     private val sendPartnerInfo: SendPartnerInfo) : Create {

    override fun execute(retailer: Retailer): Retailer {
        val products = getProducts.execute(retailer.name)
        val newRetailer = retailer.copy(products = products)

        try {
            repository.save(newRetailer)
            sendPartnerInfo.execute("some_partner", "Sucess!")
            return newRetailer
        } catch (e: Exception) {
            throw Exception("")
        }
    }
}