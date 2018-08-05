package com.cfyj.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.DirectExchangeRoutingKeyConfigurer;
import org.springframework.amqp.core.BindingBuilder.TopicExchangeRoutingKeyConfigurer;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeConfig {

	 /**
	 * 广播型
	 *
	 * @param rabbitAdmin
	 * @return
	 */
	 @Bean
	 FanoutExchange contractFanoutExchange(RabbitAdmin rabbitAdmin) {
		 FanoutExchange contractFanoutExchange = new FanoutExchange(RabbitmqExchange.log_fanout);
		 rabbitAdmin.declareExchange(contractFanoutExchange);
		 return contractFanoutExchange;
	 }

	/**
	 * 匹配型 默认：, durable = true, autoDelete = false
	 * 
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin) {
		TopicExchange contractTopicExchange = new TopicExchange(RabbitmqExchange.log_topic);
		rabbitAdmin.declareExchange(contractTopicExchange);
		return contractTopicExchange;
	}

	/**
	 * 直连型
	 * 
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	DirectExchange contractDirectExchange(RabbitAdmin rabbitAdmin) {
		DirectExchange contractDirectExchange = new DirectExchange(RabbitmqExchange.log_direct);
		rabbitAdmin.declareExchange(contractDirectExchange);
		return contractDirectExchange;
	}
	
	
	/**
	 * 将队列绑定到交换机上，因为fanout交换器忽略routingKey属性，所以设置其没有用
	 * @param queue
	 * @param exchange
	 * @param rabbitAdmin
	 * @return
	 */
//	 @Bean
//	 Binding bindingExchangeContract1(Queue queue, FanoutExchange
//	 exchange, RabbitAdmin rabbitAdmin) {
//		 Binding binding = BindingBuilder.bind(queue).to(exchange);
//		 //声明队列与Exchange的绑定
//		 rabbitAdmin.declareBinding(binding);
//		 return binding;
//	 }
	 
	//直连
	@Bean
	Binding bindingDirectExchange(DirectExchange exchange, RabbitAdmin rabbitAdmin) {
		
		//声明队列
		Queue queue = new Queue(RabbitmqQueue.log_user_queue, true);
		
		rabbitAdmin.declareQueue(queue);
		DirectExchangeRoutingKeyConfigurer exchangeConfig = BindingBuilder.bind(queue).to(exchange);		
		Binding binding = exchangeConfig.with(RoutingKey.log_user);	
		
		rabbitAdmin.declareBinding(binding);
		return binding;
	}
	
	 //匹配
	@Bean
	Binding bindingTopicExchange_error(TopicExchange exchange, RabbitAdmin rabbitAdmin) {
		//声明队列
		Queue queue = new Queue(RabbitmqQueue.log_error_queue, true);
		rabbitAdmin.declareQueue(queue);
		//交换器上绑定队列
		TopicExchangeRoutingKeyConfigurer exchangeconfig = BindingBuilder.bind(queue).to(exchange);		
				
		//绑定路由key
		Binding binding = exchangeconfig.with(RoutingKey.log_error);	
		rabbitAdmin.declareBinding(binding);
		return binding;
	}
	
	@Bean
	Binding bindingTopicExchange_info(TopicExchange exchange, RabbitAdmin rabbitAdmin) {
		Queue queue = new Queue(RabbitmqQueue.log_info_queue, true);
		rabbitAdmin.declareQueue(queue);
		
		TopicExchangeRoutingKeyConfigurer exchangeconfig = BindingBuilder.bind(queue).to(exchange);		
		Binding binding = exchangeconfig.with(RoutingKey.log_info);	
		rabbitAdmin.declareBinding(binding);
		return binding;
	}
}
