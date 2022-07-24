package com.Shivansu.Microservice.microservicecurrencyconversionservice.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Shivansu.Microservice.microservicecurrencyconversionservice.Bean.CurrencyConversionBean;


//@FeignClient(name="currency-exchange-service", url="localhost:8000")
// as we have Implemented Eureka NAming Server > no need to give URl , 
//if multiple instance are there it will load balance
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangevalue(@PathVariable String from ,@PathVariable String to);

}
