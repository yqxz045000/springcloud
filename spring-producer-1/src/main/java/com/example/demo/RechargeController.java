package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RechargeController {

	@PostMapping("recharge")
	public String recharge(String userName,double money) {
		String result = "账户："+userName+"充值"+money+"元" ;
		System.out.println("调用:"+result);
		return result;
	}
	
	@PostMapping("refund")
	public String refund(String userName,double money) {
		String result = "账户："+userName+"退款"+money+"元" ;
		System.out.println("调用:"+result);
		return result;
	}
	
	
}
