package com.cfyj.rabbitMQ.rabbitTemplate2.config;

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
	 *上面三个是创建三种类型的交换器，并指定了交换器的名称 
	 *
	 */
	
	
	/**
	 * 将队列绑定到交换机上，因为fanout交换器忽略routingKey属性，所以设置其没有用
	 * @param queue
	 * @param exchange
	 * @param rabbitAdmin
	 * @return
	 */
	 @Bean
	 Binding bindingExchangeContract1(Queue queue, FanoutExchange
	 exchange, RabbitAdmin rabbitAdmin) {
		 Binding binding = BindingBuilder.bind(queue).to(exchange);
		 //声明队列与Exchange的绑定
		 rabbitAdmin.declareBinding(binding);
		 return binding;
	 }
	 
	 //匹配
	@Bean
	Binding bindingExchangeContract2(Queue queue, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
//		Binding binding = BindingBuilder.bind(queue).to(exchange).with(RabbitmqQueue.CONTRACE_SELF);
		TopicExchangeRoutingKeyConfigurer exchangeconfig = BindingBuilder.bind(queue).to(exchange);		
		Binding binding = exchangeconfig.with(RoutingKey.log_error);	
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

	//直连
	@Bean
	Binding bindingExchangeContract(Queue queueContract, DirectExchange exchange, RabbitAdmin rabbitAdmin) {
//		Binding binding = BindingBuilder.bind(queueContract).to(exchange).with(RabbitmqQueue.CONTRACE_SELF);
		
		DirectExchangeRoutingKeyConfigurer exchangeConfig = BindingBuilder.bind(queueContract).to(exchange);
//		Binding binding = exchangeConfig.with(RoutingKeys);
		Binding binding = exchangeConfig.with(RoutingKey.log_error);	
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

	/*@Bean
	Binding bindingExchangeTenant(Queue queueTenant, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
		Binding binding = BindingBuilder.bind(queueTenant).to(exchange).with(RabbitmqQueue.CONTRACE_TENANT);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}

	@Bean
	Binding bindingExchangeTenant(Queue queueTenant, DirectExchange exchange, RabbitAdmin rabbitAdmin) {
		Binding binding = BindingBuilder.bind(queueTenant).to(exchange).with(RabbitmqQueue.CONTRACE_TENANT);
		rabbitAdmin.declareBinding(binding);
		return binding;
	}*/

	/**
	 * 所有关于contract exchange的queue
	 * 
	 * @param rabbitAdmin
	 * @return
	 */
	@Bean
	Queue queueContract(RabbitAdmin rabbitAdmin) {
		Queue queue = new Queue(RabbitmqQueue.log_error_queue, true);
		rabbitAdmin.declareQueue(queue);
		return queue;
	}

//	@Bean
//	Queue queueTenant(RabbitAdmin rabbitAdmin) {
//		Queue queue = new Queue(RabbitmqQueue.CONTRACE_TENANT, true);
//		rabbitAdmin.declareQueue(queue);
//		return queue;
//	}

}
