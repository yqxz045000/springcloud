package com.cfyj.springcloud.client.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class CloudClientRibbonConsumerApplication {

	/**
	 * @LoadBalanced注解开启均衡负载能力
	 * 使用restTemplate时，这个模版类具备了负载均衡的能力
	 * 
	 * 在下面使用RestTemplate时，访问这个服务两次，开启的两个客户端服务都收到了一次请求。
	 * 
	 * 
	 */
	
	private RestTemplate restTemplate ;
	
		
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		restTemplate = new RestTemplate();
		return restTemplate;
		
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CloudClientRibbonConsumerApplication.class, args);
	}
}
