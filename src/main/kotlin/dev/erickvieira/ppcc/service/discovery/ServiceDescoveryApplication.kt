package dev.erickvieira.ppcc.service.discovery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
open class ServiceDescoveryApplication

fun main(args: Array<String>) {
    runApplication<ServiceDescoveryApplication>(*args)
}
