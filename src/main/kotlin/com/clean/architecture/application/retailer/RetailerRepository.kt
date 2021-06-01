package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Retailer

interface RetailerRepository {

    fun save(retailer: Retailer): Retailer

    fun findById(id: Long): Retailer

    fun findAll(): List<Retailer>

}