package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author cfyj
 * 2017年8月30日 下午5:37:49
 * 使用sleuth+zipkin做服务追踪，这是client端，既下游的微服务最前层。
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringSleuthZipkinClientConsumerApplication {
	
	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(SpringSleuthZipkinClientConsumerApplication.class, args);
	}
	
	@RequestMapping("getInfo")
	public String getInfo() {
		String result = restTemplate.getForObject("http://localhost:10032/getUserInfo", String.class);
		
		return result;
	}
	
	
	
}
