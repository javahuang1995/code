package com.huang.spring.yuanli;
import org.junit.Test;

import com.huang.spring.yuanli.BeanFactory;
import com.huang.spring.yuanli.ClassPathXmlApplicationContext;
import com.huang.spring.yuanli.User;
import com.huang.spring.yuanli.UserDAO;
import com.huang.spring.yuanli.UserService;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
		
		
		UserService service = (UserService)applicationContext.getBean("userService");
		
		
		
		
		
		User u = new User();
		u.setUsername("zhangsan");
		u.setPassword("zhangsan");
		service.add(u);
	}

}
