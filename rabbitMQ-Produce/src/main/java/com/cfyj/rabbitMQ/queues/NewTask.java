package com.cfyj.rabbitMQ.queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 我们将创建一个工作队列，将信息发送到多个消费者。这中分配方式主要场景是消费者需要根据消息中的内容进行业务逻辑处理，这
 * 种消息可以看成是一个任务指令，处理起来比较耗时，通过多个消费者来处理这些消息，来提高数据的吞吐能力。
 * 
 * @author exception
 *
 */
public class NewTask {

	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] argv) throws java.io.IOException, Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		// 分发消息
		for (int i = 0; i < 5; i++) {
			String message = "Hello World! " + i;
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
		channel.close();
		connection.close();
	}

}
