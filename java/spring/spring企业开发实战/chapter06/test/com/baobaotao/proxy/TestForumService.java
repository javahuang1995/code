package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

public class TestForumService {
	public static void main(String[] args) {
		// ҵ������������Ĳ���
		// ForumService forumService = new ForumServiceImpl();
		// forumService.removeForum(10);
		// forumService.removeTopic(1012);

		// ʹ��JDK��̬����ȱ����ֻ��Ϊ�ӿڴ�������ʵ��
//		ForumService target = new ForumServiceImpl();//target��
//		PerformaceHandler handler = new PerformaceHandler(target);//Advice,Ҫֲ��Ĵ���
//		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
//				.getClass().getClassLoader(),
//				target.getClass().getInterfaces(), handler);//���ݽӿڻ�ȡ�����࣬����Ǵ�����
//		proxy.removeForum(10);
//		proxy.removeTopic(1012);
		
//		//ʹ��CGLib��̬����
//		CglibProxy proxy = new CglibProxy();//�����Advice,Ҫ��ǿ�Ĵ���
//		
//		//����������
//		ForumService forumService = 
//			(ForumService)proxy.getProxy(ForumServiceImpl.class);//��java������̬������ȣ�����Ҫ����targetʵ������
//		forumService.removeForum(10);
//		forumService.removeTopic(1023);
		
	}
}