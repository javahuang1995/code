package com.huang.single;

public class Singleton {
	private Singleton(){}//˽�й��췽��
	private static Singleton instance = null;
	//��̬��������
	public static Singleton getInstance(){
		if(null == instance){
			instance = new Singleton();
		}
		return instance;
	}
}
