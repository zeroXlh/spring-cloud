package org.zero.eureka.consumer.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
//@EnableCircuitBreaker
public class EurekaConsumerHystrixApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(EurekaConsumerHystrixApplication.class)
			.web(WebApplicationType.SERVLET).run(args);
		// SpringApplication.run(EurekaConsumerHystrixApplication.class, args);
	}

}
