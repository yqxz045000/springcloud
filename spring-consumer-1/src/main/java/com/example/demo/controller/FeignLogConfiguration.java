package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;



@Configuration
public class FeignLogConfiguration {

	@Bean
	Logger.Level feignLoggerLeverl(){
		
		return Logger.Level.FULL;
	}
	
	
}
