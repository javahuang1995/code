package com.huang.classloader;

/**
 * ExtClassLoader
 * 
 * @author huang
 *
 */
public class MainApp {
	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));

		ClassLoader cl = MainApp.class.getClassLoader();
		System.out.println("ClassLoader is:" + cl.toString());
		System.out.println("Parent ClassLoader is:"+cl.getParent().toString());
		
		ClassLoader c2=String.class.getClassLoader();
		//System.out.println(c2.toString());//无法获取BootStrap，所以会报空指针错误
		
		Test b = new Test();
		System.out.println("bbbb"+b.getClass().getClassLoader());
		try {
			Class c = Class.forName("com.huang.classloader.Test");//
			Test a = (Test)c.newInstance();
			System.out.println("aaaa"+Test.class.getClassLoader());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
