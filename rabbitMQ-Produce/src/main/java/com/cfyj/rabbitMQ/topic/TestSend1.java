package com.cfyj.rabbitMQ.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * 
 * 1.在匹配交互器模式下，消费者端路由关键字 “*” 能接收到生产者端发来路由关键字为空的消息吗？   false
 * 
 * 2.在匹配交换器模式下，消费者端路由关键字“#.*”能接收到生产者端以“..”为关键字的消息吗？true
 * 如果发送来的消息只有一个单词，能匹配上吗？  true  *标识零或一个单词
 * 
 * 3.“a.*.#” 与 “a.#” 有什么不同吗？ 后者能兼容前者，前者不能兼容后者
 * 
 * @author exception
 *
 */
public class TestSend1 {

	private static final String EXCHANGE_NAME = "topic_logs";

	public static void main(String[] argv) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");

			connection = factory.newConnection();
			channel = connection.createChannel();
			// 声明一个匹配模式的交换器
			channel.exchangeDeclare(EXCHANGE_NAME, "topic");
			// 发送消息
			String message = " message!";
//			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			channel.basicPublish(EXCHANGE_NAME, ".", null, message.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception ignore) {
				}
			}
		}
	}
}
