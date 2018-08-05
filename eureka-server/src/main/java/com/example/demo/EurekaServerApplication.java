package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer  //开启eureka server
public class EurekaServerApplication {
	
	/**
	 * yml配置详解：
	 * server.port=8761 指定端口
	 * eureka.client.register-with-eureka=false  不向eureka服务端注册自身（默认为true）
	 * eureka.client.fetch-registry=false   是否从eureka获取注册服务信息，默认为true
	 * eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/  设置与eureka server的交互地址，
	 * 查询服务和注册服务都需要依赖这个地址默认是http://localhost:${server.port}/eureka/ ，多个地址可用，分隔
	 */
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
