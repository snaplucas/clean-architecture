package com.clean.architecture.domain.model.retailer

data class Retailer(val id: Long, val name: String, var products: List<Product> = emptyList()) {

    fun hasInvalidProducts() = products.any { !it.isBrandValid() || !it.isNameValid() }

    fun hasProducts() = products.isNotEmpty()

}