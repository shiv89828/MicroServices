package com.Shivansu.Microservice.microservicelimitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shivansu.Microservice.microservicelimitsservice.Configuration.Configuration;
import com.Shivansu.Microservice.microservicelimitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retreiveLimitsFromCOnfiguration() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
		
	}

}
