package com.cfyj.springcloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudClientOperationApplication {

	/**
	 * @EnableDiscoveryClient :
	 * 该注解能激活Eureka中的DiscoveryClient实现，才能实现Controller中对服务信息的输出.
	 * 
	 * other:
	 * 1.通过spring.application.name属性，我们可以指定微服务的名称后续在调用的时候只需要使用该名称就可以进行服务的访问。
	 * 2.eureka.client.serviceUrl.defaultZone属性对应服务注册中心的配置内容，指定服务注册中心的位置
	 * 3. 该配置管理服务注册在注册管理器上的名字
 			spring.application.name=cloud-config-customer
	 */

	public static void main(String[] args) {
		SpringApplication.run(CloudClientOperationApplication.class, args);
	}
}
