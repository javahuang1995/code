package com.taotao.manage.test;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-dao.xml")
public class PropTest {
	
	@Value("${jdbc.driver}")
	private String driver;	
	
	@Value("fuck")
	private String hello;
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_SYNC_URL}")
	private String REST_SYNC_URL;
	
	@Test
	public void propTest(){
		//属性读不出来，这里获取一下
		System.out.println(driver);
		System.out.println(hello);
		System.out.println(REST_BASE_URL+REST_SYNC_URL);
	}

}
