package com.cfyj.springcloud.zuul.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreFilter extends ZuulFilter{
	
	private Logger log = Logger.getLogger(PreFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 将用户数据保存在session中，下游服务从session中取出网关保存的用户数据
	 */
	@Override
	public Object run() {
		log.info("执行PreFile过滤器--------------------------------------------------------------");
		log.info("打印请求头：------------------------------------");
		//在postFilter中查看响应头
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			log.info("headerName:"+headerName+"----------------headerValue:"+headerValue);
		}
		HttpSession session = request.getSession(false);
		if(session!=null){
			log.info("session已存在，打印session信息：------------------------------------");		
			log.info("userName"+":"+session.getAttribute("userName" ));
			log.info("password"+":"+session.getAttribute("password"));
			log.info("flag"+":"+session.getAttribute("flag"));			
//			Enumeration<String> attributeNames = session.getAttributeNames();
//			while(headerNames.hasMoreElements()){
//				String key = headerNames.nextElement();
//				String value = request.getHeader(key);
//				log.info(key+":"+value);
//			}
		}else{
			session = request.getSession();
			session.setAttribute("userName", "过网关保存的userName");
			session.setAttribute("password", "123456");
			session.setAttribute("flag", "true");		
		}
		// 将sessionid添加到请求头上，否则下游接受不到这个请求头
		RequestContext.getCurrentContext().addZuulRequestHeader("sessionId", session.getId());
		RequestContext.getCurrentContext().addZuulRequestHeader("x-auth-token", session.getId());
	
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 20;
	}

}
