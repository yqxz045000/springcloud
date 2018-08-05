package com.cfyj.springcloud.client.histrix;

import org.springframework.stereotype.Component;

@Component
public class ComputeClientHystrix implements FeignTemplate{

	@Override
	public Integer add(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return -9999;
	}

}
