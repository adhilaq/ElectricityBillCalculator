package com.example.demo.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .useDefaultResponseMessages(false);                                           
    }

	private ApiInfo apiInfo() {
		return new ApiInfo(
			      "Electricity Bill Calculator", 
			      "Developed by Team 3", 
			      "API TOS", 
			      "Terms of service", 
			      new Contact("Team 3", "www.example.com", "myeaddress@company.com"), 
			      "License of API", "API license URL", Collections.emptyList());
	}
}
