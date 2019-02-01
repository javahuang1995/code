package com.huang.spring.test;
 
import org.springframework.stereotype.Service;
 
 
@Service
public class WomanImpl implements Human {
 
	public void speak() {
		System.out.println(" woman speaking!");
 
	}
 
	public void walk() {
		System.out.println(" woman walking!");
 
	}
 
}
