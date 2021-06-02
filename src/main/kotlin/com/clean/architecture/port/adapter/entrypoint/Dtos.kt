package com.clean.architecture.port.adapter.entrypoint

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer

data class ProductDto(val id: Long, val name: String, val brand: String) {

    fun toDomain() = Product(id, name, brand)
}

fun Product.toDto() = ProductDto(id, name, brand)

data class RetailerDto(val id: Long, val name: String, var products: List<ProductDto> = emptyList()) {

    fun toDomain() = Retailer(id, name, products.map { it.toDomain() })
}

fun Retailer.toDto() = RetailerDto(id, name, products.map { it.toDto() })