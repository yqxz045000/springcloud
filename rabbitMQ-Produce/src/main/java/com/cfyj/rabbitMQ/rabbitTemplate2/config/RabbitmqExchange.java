package com.cfyj.rabbitMQ.rabbitTemplate2.config;

/**
 * 交换器
 * 
 * @author exception
 *
 */
public class RabbitmqExchange {

	public final static  String log_fanout = "log_fanout"; //分发
	public final static String log_topic = "log_topic"; //匹配
	public final static String log_direct = "log_direct"; //直连
}
