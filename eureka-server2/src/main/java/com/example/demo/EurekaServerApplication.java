package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 
 * @author cfyj
 * 2017年8月28日 下午2:58:18
 *	与eureka Server 进行相互注册，构建高可用Eureka server
 * 原理：EurekaServer 多实例相互注册，实例会彼此增量的同步注册信息，从而确保所有节点数据一致
 * 
 */
@SpringBootApplication
@EnableEurekaServer  //开启eureka server
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
