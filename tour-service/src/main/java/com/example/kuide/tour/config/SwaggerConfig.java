package com.example.kuide.tour.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean 
    public GroupedOpenApi visitApi() {
        return GroupedOpenApi.builder()
                .group("visit")
                .pathsToMatch("/api/v1/visit/**")
                .build();
    }

    @Bean
    public GroupedOpenApi parkingApi() {
        return GroupedOpenApi.builder()
                .group("parking")
                .pathsToMatch("/api/v1/parking/**")
                .build();
    }
    
}
