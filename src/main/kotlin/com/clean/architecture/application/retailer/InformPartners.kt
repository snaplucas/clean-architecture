package com.clean.architecture.application.retailer

import com.clean.architecture.domain.model.retailer.Retailer

interface InformPartners {

    fun execute(retailer: Retailer, message: String)
}