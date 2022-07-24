package com.Shivanshu.Microservice.limitsservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shivanshu.Microservice.limitsservice.bean.Limits;

@RestController
public class LimitsController {
	@GetMapping("/limits")
  public Limits retreiveLimits() {
	  return  new Limits(1000, 1);
	  }
}
