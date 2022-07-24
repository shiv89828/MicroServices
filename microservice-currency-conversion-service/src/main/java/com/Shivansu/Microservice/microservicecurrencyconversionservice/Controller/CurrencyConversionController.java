package com.Shivansu.Microservice.microservicecurrencyconversionservice.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Shivansu.Microservice.microservicecurrencyconversionservice.Bean.CurrencyConversionBean;
import com.Shivansu.Microservice.microservicecurrencyconversionservice.Proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;
	
	
	@GetMapping("/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from , @PathVariable String to , 
			@PathVariable BigDecimal quantity) {
		int currentPort= Integer.parseInt(env.getProperty("local.server.port"));
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		//Calling other webservice to get the response
		ResponseEntity<CurrencyConversionBean> resposeEntity = new RestTemplate().getForEntity(
		 "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
		 CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean response = resposeEntity.getBody();
		
		//setting response as per response from other webservoce
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), 
				quantity, quantity.multiply(response.getConversionMultiple()), response.getRunningPort());
	}
	
	//to get other service response through Feign
	@GetMapping("/currency-convertorFeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from , @PathVariable String to , 
			@PathVariable BigDecimal quantity) {
		int currentPort= Integer.parseInt(env.getProperty("local.server.port"));
		
	CurrencyConversionBean response = currencyExchangeProxy.retrieveExchangevalue(from, to);
		
		
		//setting response as per response from other webservoce
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), 
				quantity, quantity.multiply(response.getConversionMultiple()), response.getRunningPort());
	}

}
