package com.Shivansu.Microservice.microserviceapigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	// Adding a router so if any URL hits it is redirected after adding some params/headers
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f->f.addRequestHeader("myHeader", "myURI")
						.addRequestParameter("myParam", "myParamValue"))
				        .uri("http://httpbin.org:80"))
				      .build();
	}

}
