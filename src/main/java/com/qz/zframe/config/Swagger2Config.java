package com.qz.zframe.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.paths(regex("/api.*|/zframe.*")).build();
		//.apis(RequestHandlerSelectors.basePackage("com.qz.zframe.material.controller")).paths(PathSelectors.any())
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RESTful APIs").description("just do it.")
				.termsOfServiceUrl("http://www.sample.com/").version("1.0").build();
	}

}
