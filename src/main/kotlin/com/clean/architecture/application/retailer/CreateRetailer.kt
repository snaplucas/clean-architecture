package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Retailer

class CreateRetailer(private val repository: RetailerRepository) : Create {

    override fun execute(retailer: Retailer): Retailer {
        return repository.save(retailer)
    }
}