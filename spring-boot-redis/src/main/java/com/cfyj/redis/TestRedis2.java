package com.cfyj.redis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 保存对象
 * @author exception
 *
 */
@RestController
@RequestMapping("redis2")
public class TestRedis2 {

	
	private Logger log = Logger.getLogger(TestRedis2.class);
	
	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	
	
	@RequestMapping("saveUser")
	public void test1() {
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		User u  = new User("ll",20);
		opsForHash.put("hash1", "user", u);
		u = (User) opsForHash.get("hash1", "user");
		log.info("取出的对象："+u.toString());
	}
	
	
	
}
