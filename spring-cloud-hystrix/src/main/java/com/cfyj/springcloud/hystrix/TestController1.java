package com.cfyj.springcloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 随后模拟一个调用三方依赖服务

controller-> service -> dependency service
 * @author exception
 *
 */
@RestController
public class TestController1 {	
	 @Autowired
	    private HystrixService service;
	    /**
	     * 调用依赖的服务
	     */
	    @RequestMapping("/call")
	    public String callDependencyService(){
	        return service.callDependencyService();
	    }		
}
