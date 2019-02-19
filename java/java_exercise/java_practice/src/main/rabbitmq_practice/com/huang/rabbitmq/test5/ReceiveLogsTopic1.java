package com.huang.rabbitmq.test5;
import com.rabbitmq.client.*;
import java.io.IOException;
/**
 * 模糊匹配
 * @author huang
 * 这个类和之前那个没什么区别，就是routingKey用通配符表示了。
 */
public class ReceiveLogsTopic1 {

	private static final String EXCHANGE_NAME = "topic_logs";
    private final static String HOST = "192.168.0.104";

	 
	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
//		声明一个匹配模式的交换器
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		String queueName = channel.queueDeclare().getQueue();
		// 路由关键字
		String[] routingKeys = new String[]{"*.orange.*"};//这里的关键字用通配符pattern来表示了。
//		绑定路由关键字
		for (String bindingKey : routingKeys) {
			channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
			System.out.println("ReceiveLogsTopic1 exchange:"+EXCHANGE_NAME+", queue:"+queueName+", BindRoutingKey:" + bindingKey);
		}

		System.out.println("ReceiveLogsTopic1 [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("ReceiveLogsTopic1 [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}

