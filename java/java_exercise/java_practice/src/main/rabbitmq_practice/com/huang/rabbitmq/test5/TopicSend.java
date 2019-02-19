package com.huang.rabbitmq.test5;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 * 这一个实例学习的是Topic实例模式。
 * 路由方式变成topic
 * @author huang
 *
 */
public class TopicSend {

	private static final String EXCHANGE_NAME = "topic_logs";
    private final static String HOST = "192.168.0.104";


	public static void main(String[] argv) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(HOST);
			factory.setUsername("huang");
			factory.setPassword("1995");
			connection = factory.newConnection();
			channel = connection.createChannel();
//			声明一个匹配模式的交换器
			channel.exchangeDeclare(EXCHANGE_NAME, "topic");//路由方式变成topic

			// 待发送的消息
			String[] routingKeys = new String[]{"quick.orange.rabbit", 
												"lazy.orange.elephant", 
												"quick.orange.fox", 
												"lazy.brown.fox", 
												"quick.brown.fox", 
												"quick.orange.male.rabbit", 
												"lazy.orange.male.rabbit"};
//			发送消息
	        for(String severity :routingKeys){
	        	String message = "From "+severity+" routingKey' s message!";
	        	channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes());
	        	System.out.println("TopicSend [x] Sent '" + severity + "':'" + message + "'");
	        }
			
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
