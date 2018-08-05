package com.example.demo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name="spring-producer-1",fallback=RefundFallBack.class)
public interface RefundTemplate {

	
	@RequestMapping(method=RequestMethod.POST,value="/refund")
	public String refund(@RequestParam(value = "userName") String userName,@RequestParam(value = "money") double money);
	

}


/**
 * 
 * @author cfyj
 * 2017年8月29日 下午5:00:43
 * 降级操作不成功。
 *
 */
@Component
class RefundFallBack implements RefundTemplate{

	@Override
	public String refund(String userName, double money) {
		String result = "降级操作：账户 "+userName+"退款 "+money+"元失败"; 
		return result;
	}

}


