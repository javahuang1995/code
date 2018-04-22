package com.huang.single;

public class Singleton2
{
	private Singleton2() 
	{
	}// 私有构造方法

	private static Singleton2 instance = null;

	// 静态工厂方法
	public static Singleton2 getInstance()
	{
		if (null == instance) {
			synchronized(Singleton.class)
			{
				if (null == instance)
				{
					instance = new Singleton2();
				}
				
			}
		}
		return instance;
	}
}
