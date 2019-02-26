package com.mmr.rabbitmq.confirm;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.mmr.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author old wang
 * 消息确认机制之confirm模式 普通模式
 * 生产者将信道channel设置成confirm模式，所以在该信道发送的消息都会指定一个id,一旦消息被投放到指定的队列后
 * rabbitmq会发送一个回执给生产者，生产者就知道消息已经发送成功了。
 * confirm模式是最大的好处是他是异步的
 */
public class Send1 {
	private static final String QUEUE_NAME="test_queue_confirm1";
	
	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		
		//生产者调用confirmSelect 将channel设置为confirm模式 注意
		channel.confirmSelect();
		
		String msgString="hello confirm message!";
		channel.basicPublish("", QUEUE_NAME, null,msgString.getBytes());
		
		if(!channel.waitForConfirms()){
			System.out.println("message send failed");
		}else {
			System.out.println("message send ok");
		}
		
		channel.close();
		connection.close();
	}
}
