package com.clean.architecture.port.adapter.repository

import com.clean.architecture.domain.model.retailer.Product
import com.clean.architecture.domain.model.retailer.Retailer
import javax.persistence.*

@Entity
@Table(name = "retailer")
data class RetailerTable(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
                         var name: String,
                         @OneToMany(mappedBy = "retailer", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
                         var products: List<ProductTable> = emptyList()) {

    fun toDomain() = Retailer(id, name, products.map { it.toDomain() })
}

@Entity
@Table(name = "product")
data class ProductTable(@Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
                        var name: String,
                        var brand: String,
                        @ManyToOne(fetch = FetchType.EAGER)
                        @JoinColumn(name = "product_id")
                        var retailer: RetailerTable? = null) {

    fun toDomain() = Product(id, name, brand)
}

fun Retailer.toTable(): RetailerTable {
    return RetailerTable(id, name, products.map { it.toTable() })
}

fun Product.toTable(): ProductTable {
    return ProductTable(id, name, brand)
}
