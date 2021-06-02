package com.clean.architecture.port.adapter.communication

import com.clean.architecture.application.retailer.create.GetProducts
import com.clean.architecture.domain.model.retailer.Product

class GetProductsFromService : GetProducts {

    override fun execute(retailerName: String): List<Product> {
        TODO("Not yet implemented")
    }
}