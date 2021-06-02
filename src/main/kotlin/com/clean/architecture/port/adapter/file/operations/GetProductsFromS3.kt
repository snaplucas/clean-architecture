package com.clean.architecture.port.adapter.file.operations

import com.clean.architecture.application.retailer.GetProducts
import com.clean.architecture.domain.model.retailer.Product

class GetProductsFromS3 : GetProducts {

    override fun execute(retailerName: String): List<Product> {
        TODO("Not yet implemented")
    }
}