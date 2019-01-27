package com.huang.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �����Զ���classloader����
		DiskClassLoader diskLoader = new DiskClassLoader("D:\\lib");
		try {
			// ����class�ļ�
			Class c = diskLoader.loadClass("com.huang.classloader.Test");

			if (c != null) {
				try {
					//��������class�����쵥��ģʽ���ɲ����Դ��������󣿣�
					
					
					Object obj = c.newInstance();
					Method method = c.getDeclaredMethod("say", null);
					// ͨ���������Test���say����
					method.invoke(obj, null);
					//���Ƿ����õ����ĵط�����������,spring��IOC����ͨ������+����ģʽʵ�ֵģ�����class��Ϣ��������beans.xml���棬
					//���������Ϣ�Ǵ��ļ�����������ģ�ֻ����Դ��ͬ����
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
