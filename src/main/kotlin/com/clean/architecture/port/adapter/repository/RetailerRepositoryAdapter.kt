package com.clean.architecture.port.adapter.repository

import com.clean.architecture.application.retailer.RetailerRepository
import com.clean.architecture.domain.model.retailer.Retailer

class RetailerRepositoryAdapter(private val jpaRepository: RetailerJpaRepository) : RetailerRepository {

    override fun save(retailer: Retailer): Retailer {
        val table = jpaRepository.save(retailer.toTable())
        return table.toDomain()
    }

    override fun findById(id: Long): Retailer {
        val persisted = jpaRepository.findById(id)
        if (persisted.isPresent) {
            return persisted.get().toDomain()
        }
        throw Exception("")
    }

    override fun findAll(): List<Retailer> {
        return jpaRepository.findAll().map { it.toDomain() }
    }
}