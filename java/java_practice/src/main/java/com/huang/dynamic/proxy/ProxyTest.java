package com.huang.dynamic.proxy;
/**
 * ��̬�������������Ҳ����Ҫʵ�ֺͱ���������ͬ��Person�ӿ�
 * @author yujie.wang
 *
 */
public class ProxyTest implements Person{
	
	private Person o;
	
	public ProxyTest(Person o){
		this.o = o;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sΪ������Ķ���ĳЩ����� ���ǲ�ϣ���޸����еĴ��룬���ǲ��ô�������ӷ���
		Student s = new Student();
		//�������������
		ProxyTest proxy = new ProxyTest(s);
		//���ô��������ķ���
		proxy.sayHello("welcome to java", 20);
		System.out.println("******");
		//���ô��������ķ���
		proxy.sayGoodBye(true, 100);

	}

	@Override
	public void sayHello(String content, int age) {
		// TODO Auto-generated method stub
		System.out.println("ProxyTest sayHello begin");
		//�ڴ�����ķ����� ��ӷ��ʱ��������ķ���
		o.sayHello(content, age);
		System.out.println("ProxyTest sayHello end");
	}

	@Override
	public void sayGoodBye(boolean seeAgin, double time) {
		// TODO Auto-generated method stub
		System.out.println("ProxyTest sayHello begin");
		//�ڴ�����ķ����� ��ӷ��ʱ��������ķ���
		o.sayGoodBye(seeAgin, time);
		System.out.println("ProxyTest sayHello end");
	}

}
