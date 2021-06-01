package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer

interface AddProducts {

    fun execute(retailer: Retailer, products: List<Product>)
}