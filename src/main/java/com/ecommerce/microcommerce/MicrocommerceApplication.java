package com.ecommerce.microcommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class MicrocommerceApplication {

	public static void main(final String[] args) {

		SpringApplication.run(MicrocommerceApplication.class, args);
	}
}
