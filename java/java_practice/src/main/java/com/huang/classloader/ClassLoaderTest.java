package com.huang.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 创建自定义classloader对象。
		DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
		try {
			// 加载class文件
			Class c = diskLoader.loadClass("com.huang.classloader.Test");

			if (c != null) {
				try {
					//这里是用class对象创造单例模式，可不可以创造多个对象？？
					
					
					Object obj = c.newInstance();
					Method method = c.getDeclaredMethod("say", null);
					// 通过反射调用Test类的say方法
					method.invoke(obj, null);
					//这是反射用的最多的地方，方法调用,spring的IOC就是通过反射+工厂模式实现的，他的class信息是配置在beans.xml里面，
					//这里的类信息是从文件里面读出来的，只是来源不同罢了
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
						| IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
