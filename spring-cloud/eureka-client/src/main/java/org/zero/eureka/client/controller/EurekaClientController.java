package org.zero.eureka.client.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;

@RestController
public class EurekaClientController {
	private static final Logger logger = LoggerFactory.getLogger(EurekaClientController.class);
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/")
	public String home() {
		return "Hello world!";
	}

	@GetMapping("/discoveryList")
	public String discoveryList() {
		List<String> services = discoveryClient.getServices();
		List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
//		instances.forEach(System.out::println);
		for(ServiceInstance instance : instances) {
			System.out.println(instance.getClass());
			System.out.println("mataData: " + instance.getMetadata());
			EurekaServiceInstance parent = (EurekaServiceInstance) instance;
			System.out.println(instance.getInstanceId());
			System.out.println(instance.getServiceId());
			
			System.out.println();
			System.out.println(parent.getHost());
			System.out.println(parent.getScheme());
			InstanceInfo instanceInfo = parent.getInstanceInfo();
			
			System.out.println(instanceInfo.getHealthCheckUrl());
		}
		
		String s = "Services: " + services;
		logger.info("{}", s);
		return s;
	}

}
