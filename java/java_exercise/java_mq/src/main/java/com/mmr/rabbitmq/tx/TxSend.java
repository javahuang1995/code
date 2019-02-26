package com.mmr.rabbitmq.tx;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.mmr.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
/**
 * 消息确认机制事务机制。
 * 使用事务的方式确认消息是否送达到消息中间件。
 *  这种方式是很耗时间的，降低了rabbitmq的消息吞吐量。
 */

public class TxSend {
	
	private static final String QUEUE_NAME="test_queue_tx";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		String msgString="hello tx message!";
		
		try {
			channel.txSelect();
			channel.basicPublish("", QUEUE_NAME, null,msgString.getBytes());
			int xx=1/0;
			System.out.println("send "+msgString);
			channel.txCommit();
		} catch (Exception e) {
			channel.txRollback();
			System.out.println(" send message txRollback");
		}
		
		channel.close();
		connection.close();
		
	}

}
