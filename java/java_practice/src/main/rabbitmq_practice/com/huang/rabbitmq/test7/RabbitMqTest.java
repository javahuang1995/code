package com.huang.rabbitmq.test7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huang.log.test.LogTest;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-mq.xml")
public class RabbitMqTest {
	
	//@Autowired
	//private ConnectionFactory connectionFactory;
	private static final Logger logger = LoggerFactory.getLogger(RabbitMqTest.class);

	
	@Autowired
	private AmqpTemplate amqpTemplate;
 
	
	@Test
	public void rabbitMqTest() throws Exception{
		//Connection connection = connectionFactory.newConnection();
		//System.out.println(connection);
		amqpTemplate.convertAndSend("huang.directEx", "money", "6666");
		logger.info("end");

	}

}
