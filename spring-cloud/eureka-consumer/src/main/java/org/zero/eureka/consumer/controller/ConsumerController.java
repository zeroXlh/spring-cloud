package org.zero.eureka.consumer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/discoveryService")
	public String discoveryService() {
		ServiceInstance instance = loadBalancerClient.choose("eureka-client");
		
		Map<String, String> metadata = instance.getMetadata();
		System.out.println(metadata);
		
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/discoveryList";
		return restTemplate.getForObject(url, String.class);
	}

}
