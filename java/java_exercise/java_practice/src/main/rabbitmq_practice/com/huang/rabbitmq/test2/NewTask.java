package com.huang.rabbitmq.test2;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @author hushuang
 * 这个实验的内容是将消息发送给多个消费者。。
 * 
 */
public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";
	private final static String HOST = "192.168.0.104";


    public static void main(String[] argv) throws java.io.IOException, Exception {

        ConnectionFactory factory = new ConnectionFactory();
//		设置RabbitMQ地址
		factory.setHost(HOST);
		factory.setUsername("huang");
		factory.setPassword("1995");
		
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
//      分发消息 发布了5个消息。
        for(int i = 0 ; i < 5; i++){
            String message = "Hello World! " + i;
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
