package com.huang.single;

public class Singleton3
{
	private Singleton3()
	{
	}

	private volatile static Singleton3 instance = null;

	public static Singleton3 getInstance()
	{
		if (null == instance)
		{
			synchronized (Singleton.class)
			{
				if (null == instance)
				{
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}
