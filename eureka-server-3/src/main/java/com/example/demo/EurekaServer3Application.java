package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author cfyj
 * 2017年8月28日 下午3:35:00
 *实现带有用户认证的eureka服务端，需要登录才能访问。
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer3Application.class, args);
	}
}
