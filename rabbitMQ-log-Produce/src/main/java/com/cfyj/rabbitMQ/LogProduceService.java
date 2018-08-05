package com.cfyj.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.rabbitMQ.config.RabbitmqExchange;
import com.cfyj.rabbitMQ.config.RoutingKey;
import com.cfyj.rabbitMQ.entity.User;

@Service
public class LogProduceService {

	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;
	
	public void sendError(String message){
		rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_topic, RoutingKey.log_error, message);	
	}
	
	public void sendInfo(String message){
		rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_topic, RoutingKey.log_info, message);		
	}
	
	public void sendUser(User message){
		rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_direct, RoutingKey.log_user, message);		
	}
	
}
