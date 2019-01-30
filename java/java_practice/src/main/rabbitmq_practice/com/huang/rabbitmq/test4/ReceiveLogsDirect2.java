package com.huang.rabbitmq.test4;
import com.rabbitmq.client.*;
 
import java.io.IOException;
 
/**
 * ֻ����error
 * @author huang
 *
 */
public class ReceiveLogsDirect2 {
	// ����������
	private static final String EXCHANGE_NAME = "direct_logs";
	// ·�ɹؼ���
	private static final String[] routingKeys = new String[]{"error"};
    private final static String HOST = "192.168.0.104";

	
	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
//		����������
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
//		��ȡ������������
		String queueName = channel.queueDeclare().getQueue();
//		����·�ɹؼ��ֽ��ж��ذ� ÿ��������ֻ��һ�����У�������а󶨵�ruotingKeys�� "error"
		//�������������ֻ�ܽ��ܵ� "error"������Ϣ��
		for (String severity : routingKeys) {
			channel.queueBind(queueName, EXCHANGE_NAME, severity);
			System.out.println("ReceiveLogsDirect1 exchange:"+EXCHANGE_NAME+", queue:"+queueName+", BindRoutingKey:" + severity);
		}
		System.out.println("ReceiveLogsDirect1 [*] Waiting for messages. To exit press CTRL+C");
 
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
