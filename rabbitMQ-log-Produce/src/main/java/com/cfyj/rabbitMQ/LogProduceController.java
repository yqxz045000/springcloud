package com.cfyj.rabbitMQ;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.rabbitMQ.entity.User;





@RestController
@RequestMapping("log")
public class LogProduceController {
	
	private Logger log = Logger.getLogger(LogProduceController.class); 
	
	@Autowired
	private LogProduceService produceService;
	
	@RequestMapping(value = "/topic/sendError")
    public void topic_error() {
		String message = "log-------------------------error";
		log.info("发送log-error ");
		produceService.sendError(message);  
    }
	
	@RequestMapping(value = "/topic/sendInfo")
    public void topic_info() {
		String message = "log-------------------------info";
		log.info("发送log-info");
		produceService.sendInfo(message);  
    }
	
	@RequestMapping(value = "/topic/sendEntity")
    public void sendEntity() {
//		String message = "log-------------------------entity";
		log.info("发送entity");
		User u = new User();
		u.setId(1);
		u.setDescription("传送entity");
		u.setPassword("123456");
		u.setUserName("codi");
		
		produceService.sendUser(u);  
    }
	

}
