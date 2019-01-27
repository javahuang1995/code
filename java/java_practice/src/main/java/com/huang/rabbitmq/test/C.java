package com.huang.rabbitmq.test;
import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * ��Ϣ������
 * 
 * @author hushuang
 * rabbitMQ���Ժ�spring���ɣ�Ȼ�����Ǻ�mybatis����ˡ�������һ��xml��������xml�������ã�Ȼ���û���������϶���д�������ļ�����ġ���
 * 
 */
public class C {

	private final static String QUEUE_NAME = "hello";
	private final static String HOST = "192.168.0.104";

	public static void main(String[] argv) throws Exception {
		// �������ӹ���
		ConnectionFactory factory = new ConnectionFactory();
//		����RabbitMQ��ַ
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
		//�˿�Ĭ����5672
		
		System.out.println(factory.getPort());
//		����һ���µ�����
		Connection connection = factory.newConnection();
//		����һ��Ƶ��
		Channel channel = connection.createChannel();
//		����Ҫ��ע�Ķ��� -- ��RabbitMQ�У������������ݵ��Եģ�һ���ݵȲ������ص�����������ִ����������Ӱ�����һ��ִ�е�Ӱ����ͬ����Ҳ����˵����������ڣ��ʹ�����������ڣ�������Ѿ����ڵĶ��в����κ�Ӱ�졣
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("C [*] Waiting for messages. To exit press CTRL+C");
//		DefaultConsumer��ʵ����Consumer�ӿڣ�ͨ������һ��Ƶ�������߷�����������Ҫ�Ǹ�Ƶ������Ϣ�����Ƶ��������Ϣ���ͻ�ִ�лص�����handleDelivery
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("C [x] Received '" + message + "'");
			}
		};
//		�Զ��ظ�����Ӧ�� -- RabbitMQ�е���Ϣȷ�ϻ��ƣ������½ڻ���ϸ����
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
