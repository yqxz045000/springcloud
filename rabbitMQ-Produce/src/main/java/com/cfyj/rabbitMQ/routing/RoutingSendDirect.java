package com.cfyj.rabbitMQ.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 使用routingkay做消息路由：
 * 1.routingkay的多重绑定（看消费者代码）
 * 2.允许多个队列以相同的路由关键字绑定到同一个交换器中（这样作用就类似于分发，但仅能相应接受routingkay的消息）
 * @author exception
 *
 */
public class RoutingSendDirect {

	private static final String EXCHANGE_NAME = "direct_logs";
	// 路由关键字
	private static final String[] routingKeys = new String[] { "info", "warning", "error" };

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		// 发送消息
		for (String severity : routingKeys) {
			String message = "Send the message level:" + severity;
			channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
			System.out.println(" [x] Sent '" + severity + "':'" + message + "'");
		}
		channel.close();
		connection.close();
	}
}
