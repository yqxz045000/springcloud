package com.cfyj.springcloud.feign2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FeignController {

	@Autowired
	private FeignTemplate feignTemplate;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return feignTemplate.add(10, 20);
    }
	
	
}
