package com.huang.reflect;

import java.lang.reflect.*;

public class DumpMethods {
	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName("java.util.Stack");

			Method m[] = c.getDeclaredMethods();

			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
		} catch (Throwable e) {
			System.err.println(e);
		}
		 isPrimitiveTest();
		 
		  try {
			getConstructorTest();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		try {
			getFieldTest();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void getFieldTest() throws NoSuchFieldException,
			IllegalAccessException {
		StringBuffer rp1 = new StringBuffer("sdfdkk");
        Field fieldx = rp1.getClass().getField("x");//必须是x或者y
        System.out.println(fieldx.get(rp1));

        /*
         * private的成员变量必须使用getDeclaredField，并setAccessible(true),否则看得到拿不到
         */
        Field fieldy = rp1.getClass().getDeclaredField("y");
        fieldy.setAccessible(true);//暴力反射
        System.out.println(fieldy.get(rp1));
	}
	private static void getConstructorTest() throws NoSuchMethodException {
		// TODO Auto-generated method stub
		    String str = "abc";

		    System.out.println(String.class.getConstructor(StringBuffer.class));
	}
	private static void isPrimitiveTest() {
		// TODO Auto-generated method stub
        String str = "abc";
        Class cls1 = str.getClass();
        Class cls2 = String.class;
        Class cls3 = null;//必须要加上null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());//判定指定的 Class 对象是否表示一个基本类型。
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());
	}
	/**
	 * 打印类的名字
	 * @param obj
	 */
	void printClassName(Object obj) {
	       System.out.println("The class of " + obj +
		                            " is " + obj.getClass().getName());
		    }
	
	//获得类类型的两种方式        
	//Class cls1 = Role.class;        
	//Class cls2 = Class.forName("yui.Role");
	
	// Object o = cls1.newInstance(); 
	//创建一个实例        
	 //Object o1 = new Role();   //与上面的方法等价
	
	

	
}











