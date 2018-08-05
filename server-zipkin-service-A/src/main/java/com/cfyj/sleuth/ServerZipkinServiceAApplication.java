package com.cfyj.sleuth;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServerZipkinServiceAApplication {

	private RestTemplate restTemplate = new RestTemplate();
	private static final Logger LOG = Logger.getLogger(ServerZipkinServiceAApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinServiceAApplication.class, args);
	}

	@RequestMapping("/hi")
	public String home() {
		LOG.log(Level.INFO, "hi is being called");
		return "hi i'm miya!";
	}

	@RequestMapping("/miya")
	public String info() {
		LOG.log(Level.INFO, "info is being called");
		String result =  restTemplate.getForObject("http://192.168.40.129:8081/infoi", String.class);
		return result;
	}

}
