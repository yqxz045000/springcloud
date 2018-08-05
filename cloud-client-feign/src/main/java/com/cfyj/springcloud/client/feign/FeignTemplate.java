package com.cfyj.springcloud.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "compute-service",configuration = FooConfiguration.class) //使用自定义的配置类。
@FeignClient("hi")
public interface FeignTemplate {
	
	 @RequestMapping(method = RequestMethod.GET,value = "/add")
	  Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
	
	 @RequestMapping(method = RequestMethod.GET,value = "/session/viewSession")
	  String viewSession();
	


}
