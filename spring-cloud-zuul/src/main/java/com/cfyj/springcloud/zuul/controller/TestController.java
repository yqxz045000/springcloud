package com.cfyj.springcloud.zuul.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1(HttpServletRequest request ) {
		
		return "local service";
	}
}
