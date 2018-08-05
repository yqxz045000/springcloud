//package com.cfyj.rabbitMQ.rabbitTemplate1;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 调用service发送消息
// * @author exception
// *
// */
//@RestController
//@RequestMapping("web1")
//public class SendMessageController {
//	
//	@Autowired
//	private ProduceService produceService;
//	
//	@RequestMapping("send1")
//	public String send1(){
//		produceService.sendMessage("server info");
//		return "success";
//	}
//	
//	
//	
//
//}
