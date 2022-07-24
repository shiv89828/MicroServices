package com.Shivansu.Microservice.microservicenamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroserviceNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceNamingServerApplication.class, args);
	}

}
