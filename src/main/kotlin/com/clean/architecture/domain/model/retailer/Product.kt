package com.clean.architecture.domain.model.retailer

data class Product(val id: Long, val name: String, val brand: String) {

    fun isNameValid() = true

    fun isBrandValid() = true
}