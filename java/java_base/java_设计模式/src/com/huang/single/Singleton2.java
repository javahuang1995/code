package com.huang.single;

public class Singleton2
{
	private Singleton2() 
	{
	}// ˽�й��췽��

	private static Singleton2 instance = null;

	// ��̬��������
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
