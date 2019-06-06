package com.twistresources.MaintenanceProject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket( DocumentationType.SWAGGER_2)
                .select()
                .apis( RequestHandlerSelectors.basePackage("com.twistresources.MaintenanceProject.controllers"))
                .paths(regex("/books.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Users API",
                "Exercise for backend",
                "v1.0",
                "Terms of service",
                new Contact("Francis Ian S. Aquino", "https://github.com/trfrancisianaquino/", "tr.francisian.aquino@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}