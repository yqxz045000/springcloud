package com.cfyj.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCircuitBreaker 
@EnableHystrixDashboard
/**
 * 
 * 使用EnableCircuitBreaker或者 EnableHystrix 表明Spring boot工程启用hystrix,两个注解是等价的.
 * EnableHystrixDashboard注解表示启动对hystrix的监控
 * @author exception
 *
 */
public class SpringCloudHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixApplication.class, args);
	}
}
