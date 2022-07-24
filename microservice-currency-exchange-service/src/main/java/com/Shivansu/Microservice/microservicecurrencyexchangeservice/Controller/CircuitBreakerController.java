package com.Shivansu.Microservice.microservicecurrencyexchangeservice.Controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//this will retry to a service if it fails
	@Retry(name="sample-api", fallbackMethod = "hardcoadedResponse")
//Circuit breaker will not provide a default response if service is down it will not hit again and again	
//	@CircuitBreaker(name="sample-api", fallbackMethod = "hardcoadedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String sampleApi(){
		logger.info("Sample api call received");
		//Dummy url which we know will fail
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/demmuUrl", 
				String.class);
		return forEntity.getBody();
	}
	
	public String hardcoadedResponse(Exception e) {
		return "Fallback method response";
	}
}
