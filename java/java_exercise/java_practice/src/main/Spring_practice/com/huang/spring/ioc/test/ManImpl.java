package com.huang.spring.ioc.test;
 
import org.springframework.stereotype.Service;
 
 
@Service
public class ManImpl implements Human {
 
	public void speak() {
		System.out.println(" man speaking!");
 
	}
 
	public void walk() {
		System.out.println(" man walking!");
 
	}
 
}
