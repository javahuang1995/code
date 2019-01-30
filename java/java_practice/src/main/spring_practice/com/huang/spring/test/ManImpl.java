package com.huang.spring.test;
 
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
