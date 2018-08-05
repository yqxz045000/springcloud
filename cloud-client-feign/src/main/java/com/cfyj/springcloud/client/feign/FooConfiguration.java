package com.cfyj.springcloud.client.feign;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

/**
 * 自定义的feign配置类
 * 
 * @author exception
 *
 */
//@Configuration 如果加上这个注解会变为全局的feignClient的配置类。
public class FooConfiguration {
	
	private Logger log = Logger.getLogger(FooConfiguration.class);
	
	@Bean
	public Contract feignContract() {
		log.info("------------返回自定义的配置类：Contract");
		return new feign.Contract.Default();
	}

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("user", "password");
	}

}
