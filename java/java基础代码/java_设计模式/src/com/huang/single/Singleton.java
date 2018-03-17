package com.huang.single;

public class Singleton {
	private Singleton(){}//私有构造方法
	private static Singleton instance = null;
	//静态工厂方法
	public static Singleton getInstance(){
		if(null == instance){
			instance = new Singleton();
		}
		return instance;
	}
}
