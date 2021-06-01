package com.clean.architecture.port.adapter.entrypoint

import com.clean.architecture.application.retailer.Create
import com.clean.architecture.application.retailer.Find
import com.clean.architecture.domain.model.retailer.Retailer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/retailer")
class RetailerController(private val create: Create,
                         private val find: Find) {

    @PostMapping("/save")
    fun save(@RequestBody retailer: Retailer) = create.execute(retailer)

    @GetMapping
    fun findAll() = find.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = find.findRetailer(id)

    @GetMapping("/{id}/products")
    fun findProducts(@PathVariable id: Long) = find.findRetailerProducts(id)
}