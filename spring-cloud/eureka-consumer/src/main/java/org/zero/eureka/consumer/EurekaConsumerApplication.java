package org.zero.eureka.consumer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EurekaConsumerApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(EurekaConsumerApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
