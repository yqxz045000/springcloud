package com.example.demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

	@Autowired
	private RechargeTemplate rechargeTemplate;

	@Autowired
	private RefundTemplate refundTemplate;

	@Autowired
	private EurekaClient discoveryClient;

	@GetMapping("rechargeUser")
	public String rechargeUser() {
		// 获取账户，给账户充值
		String result = rechargeTemplate.recharge("小明", 212.11);
		return result;
	}

	/**
	 * 经过zuul的请求
	 * 
	 * @return
	 */
	@GetMapping("getInfo")
	public String getInfo() {
		ApplicationInfoManager applicationInfoManager = discoveryClient.getApplicationInfoManager();
		InstanceInfo info = applicationInfoManager.getInfo();
		
		String result = "经过网关到达下游服务------------"+info.getAppName();
		return result;
	}

	// @HystrixCommand(fallbackMethod = "refund(String userName, double money)")
	// 降级失败
	@GetMapping("refundUser")
	public String refundUser() {
		// 获取账户，给账户退款
		String result = refundTemplate.refund("小明", 212.11);
		return result;
	}

	// public String refund(String userName, double money) {
	// String result = "降级操作：账户 "+userName+"退款 "+money+"元失败";
	// return result;
	// }
}
