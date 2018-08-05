package com.cfyj.rabbitMQ.rabbitTemplate2.serivce;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.rabbitMQ.carrier.LogCarrier;
import com.cfyj.rabbitMQ.rabbitTemplate2.config.RabbitmqExchange;
import com.cfyj.rabbitMQ.rabbitTemplate2.config.RabbitmqQueue;
import com.cfyj.rabbitMQ.rabbitTemplate2.config.RoutingKey;

@Service
public class ProduceService implements ConfirmCallback {

	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;

	public void sendTopic_error( LogCarrier logCarrier) {
		rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_topic, RoutingKey.log_error,
				logCarrier);
		
	}
	
	public void sendTopic_info( LogCarrier logCarrier) {
		rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_topic, RoutingKey.log_info,
				logCarrier);		
	}

	public void sendDirect_error( LogCarrier ContractRabbitmq) {
		this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.log_direct,  RoutingKey.log_error,
				ContractRabbitmq);
	}

	/**
	 * 回调函数不起作用，暂时没搞清楚
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		if (ack) {
			System.out.println("消息确认成功");
		} else {
			System.out.println("消息确认失败");
		}
	}

}
