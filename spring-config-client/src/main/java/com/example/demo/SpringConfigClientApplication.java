package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * config client 端，去config server端获取配置
 * @author cfyj
 * 2017年8月29日 下午7:47:42
 *
 *
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringConfigClientApplication {
	
//	@Autowired
//	private Logger log = Logger.getLogger(SpringConfigClientApplication.class);
	
	@Value("serverProperties")
	private String serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientApplication.class, args);
	}
	
	@RequestMapping("getProperty")
	public String getProperty() {
//		log.info("从config-server获取的配置:"+serverProperties);
		System.out.println("从config-server获取的配置:"+serverProperties);
		return serverProperties;
	}
	
}
