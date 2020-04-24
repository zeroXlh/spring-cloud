package org.zero.eureka.consumer.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zero.eureka.consumer.hystrix.service.HystrixService;

@RestController
public class HystrixController {
	@Autowired
	private HystrixService hystrixService;

	@GetMapping("/hystrixConsumer")
	public String hystrixConsumer() {
		return hystrixService.consumer();
	}
}
