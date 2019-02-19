package com.huang.annotation.test;
/**
 * Test.java
 * 
 * @author IT唐伯虎 2014年7月11日
 */
public class Test
{
    public static void main(String[] args)
    {
        User user = new User();
        
        user.setName("liang");
        user.setAge("1");
        
        System.out.println(UserCheck.check(user));
    }
}