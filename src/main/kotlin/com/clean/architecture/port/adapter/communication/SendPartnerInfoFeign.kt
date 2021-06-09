package com.clean.architecture.port.adapter.communication

import com.clean.architecture.application.retailer.create.PartnerResponse
import com.clean.architecture.application.retailer.create.SendPartnerInfo
import feign.Headers
import feign.Param
import feign.RequestLine

interface SendPartnerInfoFeign : SendPartnerInfo {

    @RequestLine("POST /{partner}")
    @Headers("Content-Type: application/json")
    override fun execute(@Param("partner") partner: String, message: String) : PartnerResponse
}