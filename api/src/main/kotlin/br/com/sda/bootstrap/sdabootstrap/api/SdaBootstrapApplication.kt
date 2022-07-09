package br.com.sda.bootstrap.sdabootstrap.api

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@SpringBootConfiguration
class SdaBootstrapApplication

fun main(args: Array<String>) {
	runApplication<SdaBootstrapApplication>(*args)
}
