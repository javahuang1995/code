package com.java.annotation.test2;

import java.lang.reflect.Method;


/**
 * UserFactory.java
 * 注解解析器
 * 1.通过反射获取注解对象 Init init = method.getAnnotation(Init.class);
 * 2.获取注解的值 init.value()，也就是配置的值
 * 3.通过这个配置的值来进行配置，这里是传入构造方法
 * @author IT唐伯虎 2014年7月10日
 */
public class UserFactory
{
    public static User create()
    {
        User user = new User();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();

        try
        {
            for (Method method : methods)
            {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (method.isAnnotationPresent(Init.class))
                {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());//init.value()获取注解的配置的值
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