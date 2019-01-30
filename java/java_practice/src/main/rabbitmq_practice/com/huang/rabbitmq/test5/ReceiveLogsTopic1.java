package com.huang.rabbitmq.test5;
import com.rabbitmq.client.*;
import java.io.IOException;
/**
 * ģ��ƥ��
 * @author huang
 * ������֮ǰ�Ǹ�ûʲô���𣬾���routingKey��ͨ�����ʾ�ˡ�
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
//		����һ��ƥ��ģʽ�Ľ�����
		channel.exchangeDeclare(EXCHANGE_NAME, "topic");
		String queueName = channel.queueDeclare().getQueue();
		// ·�ɹؼ���
		String[] routingKeys = new String[]{"*.orange.*"};//����Ĺؼ�����ͨ�������ʾ�ˡ�
//		��·�ɹؼ���
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
