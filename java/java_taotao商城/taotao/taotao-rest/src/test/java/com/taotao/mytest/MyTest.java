package com.taotao.mytest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-*.xml")
public class MyTest {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private JedisPool jedisPool;
	
	private static final Logger LOG = LoggerFactory.getLogger(MyTest.class);

	@Test
	public void connDb(){
		List<TbContent> result = contentService.getContentList(0);
		System.out.println(result);
	}
	@Test
	public void jedisTest() {
		
		Jedis jedis = jedisPool.getResource();
		jedis.set("黄宁", "大帅哥");
		String get = jedis.get("黄宁");
		LOG.info(get);
		
	}

}












