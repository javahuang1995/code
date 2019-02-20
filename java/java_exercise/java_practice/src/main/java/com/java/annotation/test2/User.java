package com.java.annotation.test2;


/**
 * User.java
 * 
 * @author IT唐伯虎 2014年7月10日
 */
public class User
{
    private String name;
    private String age;

    public String getName()
    {
        return name;
    }

    @Init(value = "liang")
    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    @Init(value = "23")
    public void setAge(String age)
    {
        this.age = age;
    }
}