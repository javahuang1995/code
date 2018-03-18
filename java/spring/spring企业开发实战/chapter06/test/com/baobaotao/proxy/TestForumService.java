package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {
	public static void main(String[] args) {
		// ҵ������������Ĳ���
		// ForumService forumService = new ForumServiceImpl();
		// forumService.removeForum(10);
		// forumService.removeTopic(1012);

		// ʹ��JDK��̬����
		ForumService target = new ForumServiceImpl();
		PerformaceHandler handler = new PerformaceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(1012);
		
		//ʹ��CGLib��̬����
//		CglibProxy proxy = new CglibProxy();
//		ForumService forumService = (ForumService)proxy.getProxy(ForumServiceImpl.class);
//		forumService.removeForum(10);
//		forumService.removeTopic(1023);
		
	}
}