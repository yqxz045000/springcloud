package com.example.demo.filter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
@Component
public class PostFilter extends ZuulFilter{

	

	private Logger log = Logger.getLogger(RouteFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		log.info("进入post过滤器-----------------------------------------------------");
		RequestContext ctx = RequestContext.getCurrentContext();
		//把前面body的内容覆盖了，正确操作：先取出前面服务写入的body，然后进行追加
		ctx.setResponseBody("经过post过滤器-------------------");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
