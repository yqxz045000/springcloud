package com.example.demo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author cfyj
 * 2017年8月29日 上午10:34:30
 *通过feignClient调用服务提供者的接口，使用自定义的log配置。
 *
 */
//@FeignClient(name="spring-producer-1",configuration=FeignLogConfiguration.class)
@FeignClient(name="spring-producer-1")
public interface RechargeTemplate {

	@RequestMapping(method=RequestMethod.POST,value="/recharge")
	public String recharge(@RequestParam(value = "userName") String userName,@RequestParam(value = "money") double money);
	
	
}
