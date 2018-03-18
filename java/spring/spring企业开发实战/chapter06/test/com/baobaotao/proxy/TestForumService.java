package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {
	public static void main(String[] args) {
		// 业务类正常编码的测试
		// ForumService forumService = new ForumServiceImpl();
		// forumService.removeForum(10);
		// forumService.removeTopic(1012);

		// 使用JDK动态代理，缺点是只能为接口创建代理实例
//		ForumService target = new ForumServiceImpl();//target类
//		PerformaceHandler handler = new PerformaceHandler(target);//Advice,要植入的代码
//		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
//				.getClass().getClassLoader(),
//				target.getClass().getInterfaces(), handler);//根据接口获取代理类，这个是代理类
//		proxy.removeForum(10);
//		proxy.removeTopic(1012);
		
//		//使用CGLib动态代理
//		CglibProxy proxy = new CglibProxy();//这个是Advice,要增强的代码
//		
//		//创建代理类
//		ForumService forumService = 
//			(ForumService)proxy.getProxy(ForumServiceImpl.class);//和java创建动态代理相比，不需要创建target实例对象
//		forumService.removeForum(10);
//		forumService.removeTopic(1023);
		
	}
}