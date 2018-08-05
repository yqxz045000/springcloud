package com.cfyj.rabbitMQ.rpc;

import java.util.UUID;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * 
 * 在客户端，我们也建立一个连接和通道，并声明一个专用的“回调”队列 我们设置调队列中的唯一编号和回调队列名称 然后我们发送任务消息到RPC服务器
 * 接下来循环监听回调队列中的每一个消息，找到与我们刚才发送任务消息编号相同的消息
 * 
 * 我们通过RabbitMQ搭建一个RPC系统，一个客户端和一个RPC服务器，客户端有一个斐波那契数列方面的问题需要解决（Fibonacci
 * numbers），RPC服务器负责技术收到这个消息，然后计算结果，并且返回这个斐波那契数列。
 * 
 * 消息属性
传输一条消息，AMQP协议预定义了14个属性，下面几个是使用比较频繁的几个属性：
deliveryMode：配置一个消息是否持久化。（2表示持久化）这个在第二章中有说明。
contentType ：用来描述编码的MIME类型。与html的MIME类型类似，例如，经常使用JSON编码是将此属性设置为一个很好的做法：application/json。
replyTo ： 回调队列的名称。
correlationId：RPC响应请求的相关编号。这个在下一节讲。

关联编号  Correlation Id
 * 
 * 
 * @author exception
 *
 */

public class RPCClient {

	private Connection connection;
	private Channel channel;
	private String requestQueueName = "rpc_queue";
	private String replyQueueName;
	private QueueingConsumer consumer;

	public RPCClient() throws Exception {
		// 设置连接
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		connection = factory.newConnection();
		channel = connection.createChannel();
		// 声明临时队列
		replyQueueName = channel.queueDeclare().getQueue();

		consumer = new QueueingConsumer(channel);
		channel.basicConsume(replyQueueName, true, consumer);
	}

	public String call(String message) throws Exception {
		String response = null;
		String corrId = UUID.randomUUID().toString();

		BasicProperties props = new BasicProperties.Builder().correlationId(corrId).replyTo(replyQueueName).build();

		channel.basicPublish("", requestQueueName, props, message.getBytes("UTF-8"));

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			if (delivery.getProperties().getCorrelationId().equals(corrId)) {
				response = new String(delivery.getBody(), "UTF-8");
				break;
			}
		}

		return response;
	}

	public void close() throws Exception {
		connection.close();
	}

	public static void main(String[] argv) {
		RPCClient fibonacciRpc = null;
		String response = null;
		try {
			fibonacciRpc = new RPCClient();

			System.out.println("RPCClient [x] Requesting fib(30)");
			response = fibonacciRpc.call("30");
			System.out.println("RPCClient [.] Got '" + response + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fibonacciRpc != null) {
				try {
					fibonacciRpc.close();
				} catch (Exception ignore) {
				}
			}
		}
	}
}
