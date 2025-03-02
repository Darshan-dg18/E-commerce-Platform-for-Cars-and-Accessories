package com.CarEcommerse.CarEcommerse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CarEcommerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarEcommerseApplication.class, args);
	}

}
