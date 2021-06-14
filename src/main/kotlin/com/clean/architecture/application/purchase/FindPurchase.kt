package com.clean.architecture.application.purchase

import com.clean.architecture.domain.model.purchase.Purchase

interface FindPurchase {

    suspend fun execute(orderId: String): Purchase
}