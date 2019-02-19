package com.huang.collection;

import java.util.HashSet;
import java.util.Hashtable;

public class MainApp {
	
	public static void main(String[] args) {
		Hashtable a = new Hashtable<String,String>();
		
		HashSet b = new HashSet<String>();//可以把hashset理解为传统的哈希表，因为value为null.即使有冲突也不报错
		b.add("aa");
		b.add("aa");
		
		//有的时候需要从另外一个对象里面取数据，同是要求过滤重复数据。
		//1.把数据添加到HashSet里面
		//2.使用其他集合框架，比如HashMap,HashTable,ArrayList,在添加的时候加入一个判断
		//if(!list.contains(this)) list.add(this)
		
		System.out.println(b);
		
	}

}
