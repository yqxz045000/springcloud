package com.cfyj.springcloud.zuul.filter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class RoutFilter extends ZuulFilter{

	
	private Logger log = Logger.getLogger(RoutFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		log.info("执行RoutingFile过滤器--------------------------------------------------------------");
	
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "route";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
