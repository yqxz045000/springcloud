package com.cfyj.rabbitMQ.topic;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * topic 匹配模式，匹配的是routingkey
 * 
 * @author exception 不过一定要记住，路由关键字【routingKey】不能超过255个字节（bytes） 匹配交换器的匹配符:
 *         （星号）表示一个单词 #（井号）表示零个或者多个单词
 * 
 *         注意 交换器在匹配模式下：
 *         如果消费者端的路由关键字只使用【#】来匹配消息，在匹配【topic】模式下，它会变成一个分发【fanout】模式，接收所有消息。
 *         如果消费者端的路由关键字中没有【#】或者【*】，它就变成直连【direct】模式来工作。
 * 
 */
public class ReceiveLogsTopic1 {
	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		// 声明一个匹配模式的交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		String queueName = channel.queueDeclare().getQueue();
		// 路由关键字
		String[] routingKeys = new String[] { "*.orange.*" };
		// 绑定路由关键字
		for (String bindingKey : routingKeys) {
			channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
			System.out.println("ReceiveLogsTopic1 exchange:" + EXCHANGE_NAME + ", queue:" + queueName
					+ ", BindRoutingKey:" + bindingKey);
		}

		System.out.println("ReceiveLogsTopic1 [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out
						.println("ReceiveLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
