package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("test1")
	public String test1() {
		System.out.println("判断该请求是否经过zuul的过滤器");
		return "1";
	}
	
}
