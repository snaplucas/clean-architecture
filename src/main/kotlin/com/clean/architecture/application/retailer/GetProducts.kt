package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product

interface GetProducts {

    fun execute(retailerId: Long): List<Product>
}