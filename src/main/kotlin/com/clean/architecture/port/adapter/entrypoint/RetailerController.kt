package com.clean.architecture.port.adapter.entrypoint

import com.clean.architecture.application.retailer.Create
import com.clean.architecture.application.retailer.Find
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/retailer")
class RetailerController(private val create: Create,
                         private val find: Find) {

    @PostMapping("/save")
    fun save(@RequestBody retailerDto: RetailerDto): RetailerDto = create.execute(retailerDto.toDomain()).toDto()

    @GetMapping
    fun findAll(): List<RetailerDto> = find.findAll().map { it.toDto() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): RetailerDto = find.findRetailer(id).toDto()

    @GetMapping("/{id}/products")
    fun findProducts(@PathVariable id: Long): List<ProductDto> = find.findRetailerProducts(id).map { it.toDto() }
}