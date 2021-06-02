package com.clean.architecture.application.retailer.create

import com.clean.architecture.domain.model.retailer.Retailer

interface Create {

    fun execute(retailer: Retailer): Retailer
}