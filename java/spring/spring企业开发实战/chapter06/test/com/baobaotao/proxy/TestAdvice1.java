package com.baobaotao.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baobaotao.advice.Waiter;
/**
 * ��xml�ļ����ô����࣬������Ӽ��
 * @author Administrator
 *
 */
public class TestAdvice1 {
	public static void main(String[] args) {
		String configPath = "com/baobaotao/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
	}
}