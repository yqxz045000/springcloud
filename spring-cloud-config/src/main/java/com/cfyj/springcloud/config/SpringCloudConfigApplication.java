package com.cfyj.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置服务中心
 * @EnableConfigServer  开启config Server
 * 默认获取  applicationName-default.yml的配置文件
 * 
 * 文件的格式:{applicationName}-{profile}.properties
 * 在客户端的配置文件中可以指定去configServer中拿对应的文件，比如configServer中有一个demo-dev.yml文件，
	在client中的配置文件这样制定：
	spring.cloud.config.name=demo
	spring.cloud.config.profile=dev
	
	1.git管理
	2.svn管理
	3.本地项目管理
	4.文件系统管理
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication.class, args);
	}
}
