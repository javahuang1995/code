package com.java.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class LogTest {

	private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

	@Test
	public void Logtest(){
		logger.debug("xxx");
		logger.info("fufffff");
		logger.error("dddddddddddddddddd");
	}
}
