package com.pms.pensionerdetail;

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
public class PensionerDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerDetailApplication.class, args);
	}

	@Bean
	@SuppressWarnings("deprecation")
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/PensionerDetailByAadhaar/*"))
				.apis(RequestHandlerSelectors.basePackage("com.pms.pensionerdetail")).build()
				.apiInfo(new ApiInfo("Pensioner Detail",
						"This Application receives Aadhar Number as input and provides Pensioner detail as output after authorization",
						"1.0", "", "", "", ""));
	}

}
