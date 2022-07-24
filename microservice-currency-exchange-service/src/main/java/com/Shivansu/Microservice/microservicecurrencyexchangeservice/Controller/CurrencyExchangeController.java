package com.Shivansu.Microservice.microservicecurrencyexchangeservice.Controller;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Shivansu.Microservice.microservicecurrencyexchangeservice.Service.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	
	//gives values like which port running etc
	@Autowired
	org.springframework.core.env.Environment environment;


	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangevalue(@PathVariable String from ,@PathVariable String to) {
		ExchangeValue exchangeValue= new ExchangeValue(100L, from, to, BigDecimal.valueOf(65));
	    exchangeValue.setRunningPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
