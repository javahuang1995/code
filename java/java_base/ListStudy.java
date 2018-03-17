package com.huang.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListStudy {
	private static List<String> test;
	static{
		test = new ArrayList<String>();
		test.add("hello");
		test.add("guita");
	}
	public static void for1(){
		for(String a:test){
			System.out.println(a);
		}
	}
	public static void for2(){
		for(int i = 0;i<test.size();i++){
			System.out.println(test.get(i));
		}
	}
	public static void for3(){
		Iterator<String> itr = test.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
}






