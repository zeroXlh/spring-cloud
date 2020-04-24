package org.zero.eureka.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

	@Bean
	@LoadBalanced
	public RestTemplate loadbalance() {
		return new RestTemplate();
	}
	
	@Bean
	@Primary
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
