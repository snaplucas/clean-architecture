package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product

interface GetProducts {

    fun execute(retailerName: String): List<Product>
}