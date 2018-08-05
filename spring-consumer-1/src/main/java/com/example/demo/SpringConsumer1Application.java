package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient 
//向eureka服务端注册自身，也可以使用@EnableEurekaClient但只能与eureka联用，@EnableDiscoveryClient可以与多种服务发现组件
//联用，比如consul、zookeeper等
@EnableFeignClients
@EnableCircuitBreaker
public class SpringConsumer1Application {
	
	/**
	 * spring.application.name: spring-consumer-1  指定注册到eureka server上的应用名称
	 *  eureka.client.instance.prefer-ip-address: true  将自身的id注册到eureka server上，默认为true，为false也会注册。
		
		server显示结果：SPRING-CONSUMER-1	n/a (1)	(1)	UP (1) - 192.168.0.104:spring-consumer-1
	 */
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringConsumer1Application.class, args);
	}
}
