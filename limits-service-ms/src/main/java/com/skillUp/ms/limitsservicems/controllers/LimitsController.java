package com.skillUp.ms.limitsservicems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillUp.ms.limitsservicems.beans.Limits;
import com.skillUp.ms.limitsservicems.configuration.LimitServiceConfig;

@RestController
public class LimitsController {
	@Autowired
	private LimitServiceConfig config;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(config.getMin(), config.getMax());
	}
	
	@GetMapping("/test")
	public String connectTest() {
		return "****** SUCCESSFULLY DEPLOYED TO DOCKER CONTAINER ********";
	}
}
