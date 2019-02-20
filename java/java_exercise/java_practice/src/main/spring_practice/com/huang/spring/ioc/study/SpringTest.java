package com.huang.spring.ioc.study;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class SpringTest {

	
	@Resource
	private HuManService huManService;
	
	@Test
	public void test() {
		huManService.func();
	}


}
