package com.Shivanshu.Microservice.limitsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shivanshu.Microservice.limitsservice.Configuration;
import com.Shivanshu.Microservice.limitsservice.bean.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
  public Limits retreiveLimits() {
	  return  new Limits(configuration.getMaximum(), configuration.getMinimum());
	  }
}
