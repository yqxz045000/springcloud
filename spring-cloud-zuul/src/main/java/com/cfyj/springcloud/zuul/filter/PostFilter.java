package com.cfyj.springcloud.zuul.filter;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {

	private Logger log = Logger.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 获取保存在session中的数据，打印响应头
	 */
	@Override
	public Object run() {
		log.info("执行PostFile过滤器--------------------------------------------------------------");
		log.info("打印响应头：------------------------------------");
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
//		Collection<String> headerNames = response.getHeaderNames();
//		Iterator<String> iterator = headerNames.iterator();
//		while (iterator.hasNext()) {
//			String headerName = iterator.next();
//			String headerValue = response.getHeader(headerName);
//			log.info("headerName:" + headerName + "----------------headerValue:" + headerValue);
//		}
		String value = response.getHeader("x-auth-token");
		log.info("x-auth-token:"+value);
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
