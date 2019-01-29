package com.huang.annotation.test;
/**
 * Test.java
 * 
 * @author ITÌÆ²®»¢ 2014Äê7ÔÂ11ÈÕ
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