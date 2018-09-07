package com.rental.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import static springfox.documentation.builders.PathSelectors.*;

@Configuration
public class ApiDocumentationConfiguration {
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());
    }
    @Bean
    public UiConfiguration uiConfig() {
        return UiConfiguration.DEFAULT;
    }
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Rental Database REST API with JPA")
                .description("Rental Database REST API with JPA")
                .version("1.0")
                .contact("jbdomingo76@gmail.com")
                .build();
    }
}