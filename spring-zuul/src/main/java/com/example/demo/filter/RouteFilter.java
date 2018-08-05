package com.example.demo.filter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class RouteFilter extends ZuulFilter{

	
	private Logger log = Logger.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		log.info("进入route过滤器---------------------------------------------------------，准备路由----------------");
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setResponseBody("经过route过滤器-------------------");
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
