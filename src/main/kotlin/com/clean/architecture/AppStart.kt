package com.clean.architecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
//@EnableSwagger2
class CleanArchitectureApplication

fun main(args: Array<String>) {
	runApplication<CleanArchitectureApplication>(*args)
}
