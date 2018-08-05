package com.cfyj.springcloud.client.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudClientFeignApplication {

	/**
	 * @EnableFeignClients:
	 * 通过@EnableFeignClients注解开启Feign功能
	 * 
	 * 使用@FeignClient("compute-service")注解来绑定该接口对应compute-service服务
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(CloudClientFeignApplication.class, args);
	}
}
