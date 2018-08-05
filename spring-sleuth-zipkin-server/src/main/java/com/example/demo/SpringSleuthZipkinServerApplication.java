package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 * 
 * @author cfyj
 * 2017年8月30日 下午5:37:11
 *使用sleuth+zipkin做服务追踪，这是server端,
 *访问http://localhost:9411去zipkin的主界面看请求过程
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class SpringSleuthZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSleuthZipkinServerApplication.class, args);
	}
}
