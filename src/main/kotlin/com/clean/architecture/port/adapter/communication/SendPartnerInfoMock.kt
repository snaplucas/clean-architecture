package com.clean.architecture.port.adapter.communication

import com.clean.architecture.application.retailer.create.PartnerResponse
import com.clean.architecture.application.retailer.create.SendPartnerInfo

class SendPartnerInfoMock : SendPartnerInfo {
    override fun execute(partner: String, message: String): PartnerResponse {
        return PartnerResponse("Success")
    }
}