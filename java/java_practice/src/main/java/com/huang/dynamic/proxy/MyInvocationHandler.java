package com.huang.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��̬����,��̬�����಻Ҫ��ʾ��ʵ�ֱ���������ʵ�ֵĽӿ�
 * @author yujie.wang
 *
 */
public class MyInvocationHandler implements InvocationHandler{
	
	private Object object;
	
	public MyInvocationHandler(Object object){
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyInvocationHandler invoke begin");
		System.out.println("proxy: "+ proxy.getClass().getName());
		System.out.println("method: "+ method.getName());
		for(Object o : args){
			System.out.println("arg: "+ o);
		}
		//ͨ��������� ��������ķ���
		method.invoke(object, args);
		System.out.println("MyInvocationHandler invoke end");
		return null;
	}
	
	public static void main(String [] args){
		//������Ҫ���������
		Student s = new Student();
		//��һ�������ɴ������class�ļ���ǰ��������Ҫ�ڹ��̸�Ŀ¼�´���com/sun/proxyĿ¼����Ȼ�ᱨ�Ҳ���·����io�쳣
		//System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		//��ü��ر�������� �������
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//ָ����������ʵ�ֵĽӿ�
		Class<?>[] interfaces = s.getClass().getInterfaces();
		// �������������ί����,֮����Ҫ���ñ�������ķ���ʱ������ί�и�������invoke(Object proxy, Method method, Object[] args)����
		MyInvocationHandler h = new MyInvocationHandler(s);
		//���ɴ�����
		Person proxy = (Person)Proxy.newProxyInstance(loader, interfaces, h);
		//ͨ����������� ��������ķ���
		proxy.sayHello("yujie.wang", 20);
		proxy.sayGoodBye(true, 100);
		System.out.println("end");
	}

}
