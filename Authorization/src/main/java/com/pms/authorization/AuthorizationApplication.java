package com.pms.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class AuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationApplication.class, args);
	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.pms"))
				.build()
				.apiInfo(new ApiInfo("Authorization",
						"This Application receives username and password from client application and if username and passwrod is valid then this microservice will return JSON Web Token(JWT) to client so that client can pass JWT token to pass along with header for every request",
						"1.0", "", "", "", ""));
	}

}
