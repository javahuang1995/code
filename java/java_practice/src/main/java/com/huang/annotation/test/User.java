package com.huang.annotation.test;
/**
 * User.java
 * ������ģ����ʹ��ע��
 * @author IT�Ʋ��� 2014��7��11��
 */
public class User
{
    @Validate(min = 2, max = 5)
    private String name;

    @Validate(isNotNull = false)
    private String age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }
}