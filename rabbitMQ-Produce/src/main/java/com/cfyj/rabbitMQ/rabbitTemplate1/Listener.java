package com.cfyj.rabbitMQ.rabbitTemplate1;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

//@Configuration  
//@RabbitListener(queues = "foo")
//public class Listener {
//
//	
//	private static final Logger log = Logger.getLogger(Listener.class);  
//	  
//    @Bean  
//    public Queue fooQueue() {  
//        return new Queue("foo");  
//    }  
//  
//    @RabbitHandler  
//    public void process(@Payload String foo) {  
//    	log.info("Listener: " + foo);  
//    }  
//}
