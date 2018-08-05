package com.cfyj.rabbitMQ.consumer1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cfyj.rabbitMQ.carrier.LogCarrier;
import com.cfyj.rabbitMQ.consumer1.config.RabbitmqQueue;

@Component
public class ReceiverService {

//	@RabbitListener(queues =RabbitmqQueue.log_error_queue )
//	public void receiveContractQueue(LogCarrier contract) {
//		System.out.println("error:<" + contract + ">");
//	}

//	@RabbitListener(queues = RabbitmqQueue.log_info_queue)
//	public void receiveTenantQueue(LogCarrier tenant) {
//		System.out.println("info<" + tenant + ">");
//	}

}
