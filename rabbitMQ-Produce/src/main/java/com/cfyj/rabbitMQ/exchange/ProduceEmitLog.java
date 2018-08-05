package com.cfyj.rabbitMQ.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 发布订阅模式
 * 使用exchange交换器，在建立连接后，我们声明了一个交互。如果当前没有队列被绑定到交换器，消息将被丢弃，
 * 因为没有消费者监听，这条消息将被丢弃。（手动声明队列消息仍然被丢弃）
 * 
 * @author exception
 */
public class ProduceEmitLog {

	public static final String EXCHANGE_NAME = "logs";
	public static final String test_QUEUE = "exchange_testque";
	

	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		// 选择使用的交换器类型
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//		channel.queueDeclare(test_QUEUE, true, false, false, null);
		// 分发消息
		for (int i = 0; i < 5; i++) {
			String message = "Hello World! " + i;
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
		channel.close();
		connection.close();
	}

}
