package com.cfyj.springcloud.client.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignLogConfigration {

	  @Bean
	    Logger.Level feignLoggerLevel() {
	        return Logger.Level.FULL;
	    }
}
