package com.cfyj.springcloud.hystrix;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 调用依赖服务，通过hystrix包装调用服务
 * @author exception
 *
 */
@Service
public class HystrixService {

	private Random random = new Random();

	/**
	 * 模拟获取用户信息(通过网络调用)
	 * HystrixCommand 表明该方法为hystrix包裹，可以对依赖服务进行隔离、降级、快速失败、快速重试等等hystrix相关功能 
		该注解属性较多，下面讲解其中几个
		
		fallbackMethod 降级方法
		commandProperties 普通配置属性，可以配置HystrixCommand对应属性，例如采用线程池还是信号量隔离、熔断器熔断规则等等
		ignoreExceptions 忽略的异常，默认HystrixBadRequestException不计入失败
		groupKey() 组名称，默认使用类名称
		commandKey 命令名称，默认使用方法名
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "fallback")
	public String callDependencyService() {
		int randomInt = random.nextInt(10);
		if (randomInt < 8) { // 模拟调用失败情况
			throw new RuntimeException("call dependency service fail.");
		} else {
			return "UserName:liaokailin;number:" + randomInt;
		}
	}
	
	 public String fallback(){
	        return "some exception occur call fallback method.";
	    }
}