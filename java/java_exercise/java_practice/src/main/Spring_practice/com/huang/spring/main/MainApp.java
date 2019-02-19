package com.huang.spring.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	private static final String XMLPATH = "classpath:spring/applicationContext.xml";
	public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(XMLPATH);

	public static void main(String[] args) {

	}
}
