package org.zero.eureka.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonConsumerController {
	private static Logger logger = LoggerFactory.getLogger(RibbonConsumerController.class);
	@LoadBalanced
	@Autowired private RestTemplate restTemplate;
	
	@GetMapping("/ribbonDiscovery")
	public String ribbonDiscovery() {
		String string = restTemplate.getForObject("http://eureka-client/discoveryList", String.class);
		logger.info("result of call：{}",string);
		return string;
	}
}
