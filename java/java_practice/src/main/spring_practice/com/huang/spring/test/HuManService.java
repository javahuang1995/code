package com.huang.spring.test;
 
 
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
 
@Service
public class HuManService   {
 

	
	@Resource(name="womanImpl")
	private Human human;
	
	
	@Resource
	private Human womanImpl;
	
	
	@Autowired
	@Qualifier("manImpl")
	private Human human2;
	

	public void func(){
		human.walk();
		human2.walk();
	}
	
 
}
