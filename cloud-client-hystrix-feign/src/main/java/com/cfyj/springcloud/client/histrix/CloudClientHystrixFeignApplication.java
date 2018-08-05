package com.cfyj.springcloud.client.histrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
/**
 * 
 * 不需要在Feigh工程中引入Hystix，Feign中已经依赖了Hystrix
 *	使用FeignClient中的fallback元素指定回调类，回调类实现了feginClient接口,回调类需要加入ioc容器中
 */
public class CloudClientHystrixFeignApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(CloudClientHystrixFeignApplication.class, args);
	}
}
