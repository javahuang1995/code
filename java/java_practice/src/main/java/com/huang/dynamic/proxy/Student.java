package com.huang.dynamic.proxy;
/**
 * ��Ҫ��������� ʵ����һ���ӿ�Person
 * @author yujie.wang
 *
 */
public class Student implements Person{

	@Override
	public void sayHello(String content, int age) {
		// TODO Auto-generated method stub
		System.out.println("student say hello" + content + " "+ age);
	}

	@Override
	public void sayGoodBye(boolean seeAgin, double time) {
		// TODO Auto-generated method stub
		System.out.println("student sayGoodBye " + time + " "+ seeAgin);
	}

}
