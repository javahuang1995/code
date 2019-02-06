package com.taotao.web.test;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:resource/applicationContext.xml")
public class PropTest {
	
	@Value("${jdbc.driver}")
	private String driver;	
	
	@Value("fuck")
	private String hello;
	dsf
	@Test
	public void propTest(){
		//属性读不出来，这里获取一下
		System.out.println(driver);
		System.out.println(hello);
	}

}
