package com.huang.annotation.test2;

import java.lang.reflect.Method;


/**
 * UserFactory.java
 * ע�������
 * 1.ͨ�������ȡע����� Init init = method.getAnnotation(Init.class);
 * 2.��ȡע���ֵ init.value()��Ҳ�������õ�ֵ
 * 3.ͨ��������õ�ֵ���������ã������Ǵ��빹�췽��
 * @author IT�Ʋ��� 2014��7��10��
 */
public class UserFactory
{
    public static User create()
    {
        User user = new User();

        // ��ȡUser�������еķ�����getDeclaredMethodsҲ�У�
        Method[] methods = User.class.getMethods();

        try
        {
            for (Method method : methods)
            {
                // ����˷�����ע�⣬�Ͱ�ע����������ݸ�ֵ��user����
                if (method.isAnnotationPresent(Init.class))
                {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());//init.value()��ȡע������õ�ֵ
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return user;
    }
}