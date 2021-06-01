package com.clean.architecture.port.adapter.repository

import org.springframework.data.jpa.repository.JpaRepository

interface RetailerJpaRepository : JpaRepository<RetailerTable, Long>