package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer

interface Find {

    fun findAll(): List<Retailer>

    fun findRetailer(id: Long): Retailer

    fun findRetailerProducts(retailerId: Long): List<Product>

}