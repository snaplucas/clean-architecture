package com.clean.architecture.port.adapter.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType.SWAGGER_2
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    @Bean
    fun configSwagger(): Docket = Docket(SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.clean.architecture.port.adapter.entrypoint"))
            .paths(PathSelectors.any())
            .build()
}