package com.cfyj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaApplication {
	
	/**
	 * @EnableEurekaServer
	 * 通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话,这是服务端的注解。
	 * 在默认情况下，该服务注册中心也会将自己作为客户端注册自己，下面禁用掉服务端自己注册的行为，在application中通过
	 * eureka.client.register-with-eureka=false  默认true
	 * 指示此实例是否应将其信息注册到尤里卡服务器以供其他人发现,在某些情况下，您不希望您的实例被发现，而您只希望发现其他实例.
	 * eureka.client.fetch-registry=true  默认true 指示此客户端是否应从尤里卡服务器获取尤里卡注册表信息
	 * 
	 *  
	 *  
	 * */
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaApplication.class, args);
	}
}
