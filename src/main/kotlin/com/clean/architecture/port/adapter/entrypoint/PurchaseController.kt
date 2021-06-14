package com.clean.architecture.port.adapter.entrypoint

import com.clean.architecture.application.purchase.FindPurchase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/purchase")
class PurchaseController(private val findPurchase: FindPurchase) {

    @GetMapping("/{orderId}")
    suspend fun coroutines(@PathVariable orderId: String) = findPurchase.execute(orderId)
}