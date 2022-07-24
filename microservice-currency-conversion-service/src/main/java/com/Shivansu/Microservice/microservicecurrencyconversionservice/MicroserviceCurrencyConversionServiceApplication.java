package com.Shivansu.Microservice.microservicecurrencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceCurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCurrencyConversionServiceApplication.class, args);
	}

}
