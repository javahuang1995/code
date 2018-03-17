package com.huang.single;

public class Singleton4
{
	private static class LazyHolder
	{
		private static final Singleton4 INSTANCE = new Singleton4();
	}

	private Singleton4()
	{
	}

	public static Singleton4 getInstance()
	{
		return LazyHolder.INSTANCE;
	}
}
