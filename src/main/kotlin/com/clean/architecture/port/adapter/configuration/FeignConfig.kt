package com.clean.architecture.port.adapter.configuration

import com.clean.architecture.application.retailer.create.SendPartnerInfo
import com.clean.architecture.port.adapter.communication.SendPartnerInfoFeign
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import feign.Feign
import feign.Logger
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {

    @Bean
    fun getSendRetailerInfo(): SendPartnerInfo = createFeignBuilder(objectMapper()).target(SendPartnerInfoFeign::class.java, "someUrl")

    private fun createFeignBuilder(mapper: ObjectMapper): Feign.Builder {
        return Feign.builder()
                .logLevel(Logger.Level.FULL)
                .encoder(JacksonEncoder())
                .decoder(JacksonDecoder(mapper))
    }

    private fun objectMapper(): ObjectMapper {
        return ObjectMapper()
                .registerModule(ParameterNamesModule())
                .registerModule(Jdk8Module())
                .registerModule(JavaTimeModule())
    }
}