package br.com.sda.bootstrap.sdabootstrap.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI().info(
            Info().title("SDA Bootstrap App")
                .description("This API provides resources for SDA Bootstrap Application.")
        )
    }
}
