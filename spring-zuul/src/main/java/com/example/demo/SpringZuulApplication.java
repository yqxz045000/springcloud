package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.filter.PostFilter;
import com.example.demo.filter.PreFilter1;
import com.example.demo.filter.RouteFilter;

/**
 * 
 * @author cfyj
 * 2017年8月30日 下午4:37:18
 *	经过zuul会带一些代理头：
 *zuul.add-proxy-headers   true  默认是开启的。可以通过这个头来判断请求是否经过网关。
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulApplication.class, args);
	}
	
	@Bean
	public PreFilter1 preFilter1() {
		return new PreFilter1();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	
}
