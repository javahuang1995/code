package com.huang.rabbitmq.test3;
import com.rabbitmq.client.*;

import java.io.IOException;

public class ReceiveLogs1 {
    private static final String EXCHANGE_NAME = "logs";
    private final static String HOST = "192.168.0.104";


    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();//获取队列
        channel.queueBind(queueName, EXCHANGE_NAME, "");//这个队列和交换机绑定

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
