package com.cfyj.springcloud.feign2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class SpringCloudFeign2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeign2Application.class, args);
	}
}
