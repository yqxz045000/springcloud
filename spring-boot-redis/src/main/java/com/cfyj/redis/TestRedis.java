//package com.cfyj.redis;
//
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.SetOperations;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.core.ZSetOperations;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * 
// * 
// * redis基本命令。
// * 实战中我们还经常会在Redis中存储对象，这时候我们就会想是否可以使用类似RedisTemplate<String, User>来初始化并进行操作。
// * 但是Spring Boot并不支持直接使用，需要我们自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化，
// * 
// * 
// * @author exception
// *
// */
//
//@RestController
//@RequestMapping("redis1")
//public class TestRedis {
//
//	private Logger log = Logger.getLogger(TestRedis.class);
//
//	@Autowired
//	private StringRedisTemplate stringRedisTemplate;
//
//	@RequestMapping("string")
//	public void test1() {
//		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
//		// opsForValue.set("k1", "1");
//		// opsForValue.set("k2", "2");
//		// opsForValue.set("k3", "3");
//		opsForValue.increment("k1", -100);
//		// opsForValue.set("k4", "4", 5, TimeUnit.SECONDS);
//		String k1 = opsForValue.get("k1");
//		String k2 = opsForValue.get("k2");
//		String k3 = opsForValue.get("k3");
//		String k4 = opsForValue.get("k4");
//		// log.info("k1:"+k1);
//		// log.info("k2:"+k2);
//		// log.info("k3:"+k3);
//		log.info("k4:" + k4);
//
//	}
//
//	@RequestMapping("hash")
//	public void test2() {
//		HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
////		opsForHash.put("hash1", "k1", "1");
////		opsForHash.put("hash1", "k2", "2");
////		opsForHash.put("hash1", "k3", "3");
////
////		String k1 = (String) opsForHash.get("hash1", "k1");
////		String k2 = (String) opsForHash.get("hash1", "k2");
////		String k3 = (String) opsForHash.get("hash1", "k3");
////
////		log.info("k1:" + k1);
////		log.info("k2:" + k2);
////		log.info("k3:" + k3);
//		//保存对象
//		User u  = new User("ll",20);
//		opsForHash.put("hash1", "user", u);
////java.lang.ClassCastException: com.cfyj.redis.User cannot be cast to java.lang.String		
////		报错，使用默认的StringRedisTemplate只能存储String类型的数据，不能保存对象，需要自己去实现一些东西
//		
//		
//	}
//
//	@RequestMapping("list")
//	public void test3() {
//		ListOperations<String, String> opsForList = stringRedisTemplate.opsForList();
//
//		opsForList.leftPush("list1", "k1");
//		opsForList.leftPush("list1", "k2");
//		opsForList.leftPush("list1", "k3");
//		// List<String> lists = opsForList.range("list1", 0, -1);
//		int i = 0;
//		while (i < 3) {
//			i++;
//			String key = opsForList.leftPop("list1");
//			log.info("key:" + key);
//		}
//	}
//
//	@RequestMapping("zset")
//	public void test4() {
//		ZSetOperations<String, String> opsForZSet = stringRedisTemplate.opsForZSet();
//		opsForZSet.add("zset1", "k1",500 );
//		opsForZSet.add("zset1", "k2",400 );
//		opsForZSet.add("zset1", "k3",300 );
//		Set<String> range = opsForZSet.range("zset1", 0, -1);
//		for(String value :range){
//			//有序迭代
//			log.info("value:" + value);
//		}
////		opsForZSet.count(key, min, max)
//		
//	}
//	
//	@RequestMapping("set")
//	public void test5() {
//		 SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
//		 opsForSet.add("set1", "a","c","d","e","f");
//		 List<String> randomMembers = opsForSet.randomMembers("set1", 5);
//		 for(String value:randomMembers){
//			 log.info("value:" + value);
//		 }		
//	}
//	
//
//}
