package com.cfyj.springcloud.config.client;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController1 {
	
	private Logger log = Logger.getLogger(TestController1.class); 

	@Value("${clientName}")
	private String configName;

	@RequestMapping("test")
	public void test1(){
		log.info("test1--configName:"+configName);
				
	}
	
	
	
}
