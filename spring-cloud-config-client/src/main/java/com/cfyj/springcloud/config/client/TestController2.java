package com.cfyj.springcloud.config.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
	
	private Logger log = Logger.getLogger(TestController2.class); 

	@Value("${clientName2}")
	private String configName2;

	@RequestMapping("test2")
	public void test2(){
		log.info("test1--configName2:"+configName2);
				
	}
	
	
	
}
