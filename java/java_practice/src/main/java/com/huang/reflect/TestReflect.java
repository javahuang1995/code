package com.huang.reflect;
/**
 * дһ����������û��ṩ�����������ø�������main������
 */
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        String str = args[0];
        /*
         * ����������Ǳ�Խ�磬��Ϊѹ��û������ַ�����
         * ��Ҫ�Ҽ���run as-configurations-arguments������b.Inter������������
         * 
         */
        Method m = Class.forName(str).getMethod("main",String[].class);
        //���������ַ�ʽ������,main������Ҫһ������
        //invoke�ĵ�һ�������Ƕ��ĸ���������������������Ǿ�̬��������ô��û�ж��󣬵�һ����������null,���������Ƿ����Ĳ���
        m.invoke(null, new Object[]{new String[]{"111","222","333"}});
        m.invoke(null, (Object)new String[]{"111","222","333"});//�������˵��������Ҳ��Object
        /*
         * m.invoke(null, new String[]{"111","222","333"})
         * ����Ĳ�����,��Ϊjava���Զ����
         */
    }
}

class Inter {
    public static void main(String[] args) {
        for(Object obj : args) {
            System.out.println(obj);
        }
    }
}