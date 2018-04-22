package com.huang.factory;

public class TestFactory {
	public static void main(String[] args) {
		Apple a = CommonFactory.getClass(Apple.class);
		Apple b = CommonFactory.getClass(Apple.class);
		System.out.println(a.getName()+b.getName());
	}
}

class Apple{
	private String name="aplle";
	public String getName(){
		return this.name;
	}
}
