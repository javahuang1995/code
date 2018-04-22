package com.baobaotao.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
/**
 * ����һ�����棬��̬�������棬�����������ͷ�������ƥ�����
 * ע��������������沢û��ʵ�־����advice���룬advice��д��GreetingBeforeAdvice����
 * advice��ͨ��bean����ע�뵽��������������ġ�
 * <bean id="greetingAdvisor" class="com.baobaotao.advisor.GreetingAdvisor"
		p:advice-ref="greetingAdvice" />
 * @author Administrator
 *
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539815556578748225L;
	/**
	 * �е㷽��ƥ�����
	 */
	public boolean matches(Method method, Class clazz) {
		return "greetTo".equals(method.getName());
	}	
	/**
	 * �е���ƥ�����
	 */
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
		
	}
}