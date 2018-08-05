package com.cfyj.sleuth;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServerZipkinServiceApplication {
	
	private static final Logger LOG = Logger.getLogger(ServerZipkinServiceApplication.class.getName());	
	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinServiceApplication.class, args);
	}



	@RequestMapping("/hi")
	public String callHome() {
		LOG.log(Level.INFO, "calling trace service-hi  ");
		String result =  restTemplate.getForObject("http://localhost:8082/miya", String.class);
		return result;
	}

	@RequestMapping("/infoi")
	public String infoi() {
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}
	
	@RequestMapping("/test")
	public String test() {
		LOG.log(Level.INFO, "calling trace service-hi ");
		return "i'm service-hi";
	}
	
	

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
}
