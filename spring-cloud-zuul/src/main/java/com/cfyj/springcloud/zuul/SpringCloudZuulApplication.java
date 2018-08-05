package com.cfyj.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@SpringBootApplication
@SpringCloudApplication
@EnableZuulProxy

/**
 * @SpringCloudApplication:
 * 它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
 *
 *@EnableZuulProxy: 注解开启Zuul
 */

public class SpringCloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}
}
