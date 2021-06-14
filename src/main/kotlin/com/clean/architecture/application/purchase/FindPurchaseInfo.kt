package com.clean.architecture.application.purchase

import com.clean.architecture.domain.model.purchase.Purchase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.random.Random

class FindPurchaseInfo : FindPurchase {

    override suspend fun execute(orderId: String): Purchase {
        return coroutineScope {
            val deliveryCostFuture: Deferred<String> = async { fetchDeliveryCost(orderId) }
            val stockInformationFuture: Deferred<String> = async { fetchStockInfo(orderId) }
            Purchase(orderId, deliveryCostFuture.await(), stockInformationFuture.await())
        }
    }

    private suspend fun fetchDeliveryCost(orderId: String): String {
        // fetching delivery cost somewhere
        delay(3000)
        val cost = Random.nextInt(0, 100)
        return cost.toString()
    }

    private suspend fun fetchStockInfo(orderId: String): String {
        // fetching delivery stock info somewhere
        delay(2000)
        return "Last units"
    }
}