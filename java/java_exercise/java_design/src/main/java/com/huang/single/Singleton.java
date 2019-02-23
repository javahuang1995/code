package com.huang.single;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/23 20:55
 * @Description:
 */
public class Singleton
{
    private volatile static Singleton singleton;

    private Singleton()
    {
    }

    public static Singleton getSingleton()
    {
        if (singleton == null)
        {
            synchronized (Singleton.class)
            {
                if (singleton == null)
                {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
