package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author cfyj
 * 2017年9月6日 下午5:52:52
 * 配合这文章使用
 *http://blog.csdn.net/u012702547/article/details/54319508，
 *最后的权限控制是在页面中使用<div sec:authorize="hasRole('ROLE_USER')"></div> 来控制的，看用户是否有对应的角色，来显示
 *div中的内容。
 *
 *根据这个，security也可以做到权限控制，只要在他需要返回权限标识的地方返回定义的权限就可以实现权限控制，
 *但真正过滤的地方在页面的标签上
 *
 */
@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
}
