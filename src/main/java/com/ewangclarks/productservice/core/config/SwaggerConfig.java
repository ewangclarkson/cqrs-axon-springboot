package com.ewangclarks.productservice.core.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(applicationName + " Service")
                        .version("1.0.0"))
                .components(new Components()
                        .addSecuritySchemes("Authorization", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .in(SecurityScheme.In.HEADER)
                                .scheme("Bearer")
                                .name("Authorization")))
                .addSecurityItem(new SecurityRequirement().addList("Authorization"));
    }

}
