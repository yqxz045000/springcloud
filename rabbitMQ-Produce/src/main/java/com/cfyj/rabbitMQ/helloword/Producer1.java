package com.cfyj.rabbitMQ.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 我们我们通过2个java程序，一个发送消息的生产者，和一个接收信息并打印的消费者
 * @author exception
 *
 */
public class Producer1 {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		// 创建连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置RabbitMQ地址
		factory.setHost("localhost");
//		factory.setPort(15672);
		// 创建一个新的连接
		Connection connection = factory.newConnection();
		// 创建一个频道
		Channel channel = connection.createChannel();
		// 声明一个队列 --
		/**
		 * 在RabbitMQ中，队列声明是幂等性的（一个幂等操作的特点是其任意多次执行所产生的影响均与一次执行的影响相同），
		也就是说，如果不存在，就创建，如果存在，不会对已经存在的队列产生任何影响。
			queueDeclare（）声明一个队列，有无参有有参的重载方法
			queue  队列名称
			durable 如果我们声明持久队列（如果队列已经存在，将在服务器重新启动时生存）
			exclusive 如果我们声明独占队列（仅限于此连接）
			autoDelete 消息完毕后自动删除队列
			arguments 队列的其他属性（结构参数）的参数
		 */ 
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Hello World!";
		// 发送消息到队列中
		/**
		 * basicPublish方法的四个参数
		 * String exchange 交易所将消息发布到的Exchange
		 * String routingKey  路由关键 （指定的是queue）
		 * BasicProperties  props   消息路由头等的其他属性 
		 * byte[] body   消息体 
		 */
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println("P [x] Sent '" + message + "'");
		// 关闭频道和连接
		channel.close();
		connection.close();
	}

}
