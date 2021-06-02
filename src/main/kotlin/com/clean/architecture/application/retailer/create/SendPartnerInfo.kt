package com.clean.architecture.application.retailer.create

interface SendPartnerInfo {

    fun execute(partner: String, message: String)

}