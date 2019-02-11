package com.huang.rabbitmq.test7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huang.common.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-mq.xml")
public class RabbitMqTest {
	
	//@Autowired
	//private ConnectionFactory connectionFactory;
	private static final Logger LOG = LoggerFactory.getLogger(RabbitMqTest.class);

	
	@Autowired
	private AmqpTemplate amqpTemplate;
 
	
	 
    @Test
    public void send() throws Exception{
         
        List<String> submobileList=new ArrayList<String>();        
        submobileList.add("1");
        submobileList.add("2");
        submobileList.add("3");
        
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("batchNo", "递四方速递");    
        bodyMap.put("item", submobileList);           
        String jsonStr=JsonUtils.objectToJson(bodyMap);
        amqpTemplate.convertAndSend("hello", jsonStr);   
        LOG.info("complete");
    }

}
