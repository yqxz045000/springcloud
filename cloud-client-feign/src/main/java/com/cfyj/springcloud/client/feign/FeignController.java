package com.cfyj.springcloud.client.feign;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
	
	private Logger log = Logger.getLogger(FeignController.class);

	@Autowired
	private FeignTemplate feignTemplate;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return feignTemplate.add(10, 20);
	}

	@RequestMapping(value = "/viewSession", method = RequestMethod.GET)
	public String viewSession(HttpServletRequest request,HttpServletResponse response) {
		log.info("feign 打印请求头：------------------------------------");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			log.info("headerName:" + headerName + "----------------headerValue:" + headerValue);
		}

		log.info("打印SessionData：------------------------------------");
		HttpSession session = request.getSession();
		log.info("userName" + ":" + session.getAttribute("userName"));
		log.info("password" + ":" + session.getAttribute("password"));
		log.info("flag" + ":" + session.getAttribute("flag"));
//		log.info("打印响应头：------------------------------------");
//		Collection<String> responseheaderNames = response.getHeaderNames();
//		Iterator<String> iterator = responseheaderNames.iterator();
//		while (iterator.hasNext()) {
//			String headerName = iterator.next();
//			String headerValue = response.getHeader(headerName);
//			log.info("headerName:" + headerName + "----------------headerValue:" + headerValue);
//		}

		return feignTemplate.viewSession();
	}

}
