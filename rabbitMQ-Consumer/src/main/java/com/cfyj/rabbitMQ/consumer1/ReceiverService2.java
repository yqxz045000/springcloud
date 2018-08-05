package com.cfyj.rabbitMQ.consumer1;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cfyj.rabbitMQ.consumer1.config.RabbitmqExchange;
import com.cfyj.rabbitMQ.consumer1.config.RabbitmqQueue;
import com.cfyj.rabbitMQ.consumer1.config.RoutingKey;
import com.cfyj.rabbitMQ.entity.User;
/**
 * 接受来自rabbitMQ-log-Produce项目的日志信息
 * @author exception
 *
 *类活注解上可以有多个@RabbitListener注解
 */
@Component
public class ReceiverService2 {

	private Logger log = Logger.getLogger(ReceiverService2.class);
	

	@RabbitListener(priority="10",bindings = @QueueBinding(
			value = @Queue(value = RabbitmqQueue.log_error_queue,durable="true"),
			exchange = @Exchange(value = RabbitmqExchange.log_topic,type="topic",durable = "true"),
			key = RoutingKey.log_error))
	public void receiveQueueError(String message) {	
		log.info("error日志信息："+message);	
	}
	
	
	
	@RabbitListener(priority="9",bindings = @QueueBinding(
			value = @Queue(value = RabbitmqQueue.log_info_queue,durable="true"),
			exchange = @Exchange(value = RabbitmqExchange.log_topic,type="topic",durable = "true"),
			key =RoutingKey.log_info )) //# 接受该交换器上所有队列的信息（不接受临时队列的信息）
	public void receiveQueueInfo(String message) {	
		log.info("info日志信息："+message);	
	}
	
	@RabbitListener(priority="8",bindings = @QueueBinding(
			value = @Queue(value = RabbitmqQueue.log_user_queue,durable="true"),
			exchange = @Exchange(value = RabbitmqExchange.log_direct,type="direct",durable="true"),
			key =RoutingKey.log_user )) //# 接受该交换器上所有队列的信息（不接受临时队列的信息）
	public void receiveQueueInfo(User message) {	
		log.info("info日志信息："+message.getDescription());	
		log.info("info日志信息："+message.getPassword());	
		log.info("info日志信息："+message.getUserName());	
//		log.info("info日志信息："+message.get);	
	}
	

	
	
}
