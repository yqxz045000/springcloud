package com.cfyj.springcloud.client.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * 1.spring session，配置类，启动redis做为Session的外部存储 其中注解 EnableRedisHttpSession
 * 创建了一个名为springSessionRepositoryFilter的Spring Bean，该Bean实现了Filter接口。
 * 该filter负责通过 Spring Session 替换HttpSession从哪里返回。这里Spring Session是通过 redis 返回。
 * 2. httpSessionStrategy()，用来定义Spring Session的 HttpSession 集成使用HTTP的头来取代使用
 * cookie 传送当前session信息。
 * 
 * 
 * @author exception
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200,redisFlushMode=RedisFlushMode.IMMEDIATE)
@Configuration
public class RedisHttpSessionConfig {

	@Bean
	public RedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		// 指定redis的相关信息
		connectionFactory.setPort(46379);
		connectionFactory.setHostName("localhost");
		connectionFactory.setDatabase(3);
		return connectionFactory;
	}

	@Bean//使用Header来传递session标识
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
	
	/*
	 * 如果使用下面的代码，则是使用cookie来传送 session 信息。
	 * @Bean  
	public HttpSessionStrategy httpSessionStrategy() {  
	    return new CookieHttpSessionStrategy();  
	}*/
	

}
