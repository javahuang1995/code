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
        Field fieldx = rp1.getClass().getField("x");//������x����y
        System.out.println(fieldx.get(rp1));

        /*
         * private�ĳ�Ա��������ʹ��getDeclaredField����setAccessible(true),���򿴵õ��ò���
         */
        Field fieldy = rp1.getClass().getDeclaredField("y");
        fieldy.setAccessible(true);//��������
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
        Class cls3 = null;//����Ҫ����null
        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);

        System.out.println(cls1.isPrimitive());
        System.out.println(int.class.isPrimitive());//�ж�ָ���� Class �����Ƿ��ʾһ���������͡�
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());
	}
	/**
	 * ��ӡ�������
	 * @param obj
	 */
	void printClassName(Object obj) {
	       System.out.println("The class of " + obj +
		                            " is " + obj.getClass().getName());
		    }
	
	//��������͵����ַ�ʽ        
	//Class cls1 = Role.class;        
	//Class cls2 = Class.forName("yui.Role");
	
	// Object o = cls1.newInstance(); 
	//����һ��ʵ��        
	 //Object o1 = new Role();   //������ķ����ȼ�
	
	

	
}











