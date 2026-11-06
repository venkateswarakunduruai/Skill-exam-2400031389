package com.klef.exam.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI universityOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("University API")
                        .description("Spring Boot CRUD API for University with PostgreSQL")
                        .version("1.0.0"));
    }
}
