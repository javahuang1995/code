package com.baobaotao.advisor;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
/**
 * 定义一个切面，静态方法切面，描述了类名和方法名的匹配规则
 * 注意这个切面类里面并没有实现具体的advice代码，advice是写在GreetingBeforeAdvice类中
 * advice是通过bean配置注入到这个切面里面来的。
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
	 * 切点方法匹配规则
	 */
	public boolean matches(Method method, Class clazz) {
		return "greetTo".equals(method.getName());
	}	
	/**
	 * 切点类匹配规则
	 */
	public ClassFilter getClassFilter(){
		return new ClassFilter(){
			public boolean matches(Class clazz){
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
		
	}
}