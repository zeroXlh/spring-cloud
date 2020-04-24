package org.zero.eureka.consumer.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	public String consumer() {
		String string = restTemplate.getForObject("http://eureka-client/discoveryList", String.class);
		return string;
	}

	public String fallback() {

		return "方法失败了，需要降级！";
	}
}
