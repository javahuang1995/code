package cn.it.shop.sevice.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.User;
import cn.it.shop.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserServiceImplTest {
	@Resource
	protected UserService userService;

	@Test
	public void queryUser() {
		User u = new User();
		u.setId(1);
		u.setPass("123456");
		//前台用户登录，要用id登录而不是name
		User result = null;
		result = userService.login(u);
		if(result==null){
			System.out.println("找不到用户");
		}else{
			System.out.println("找得到用户");
		}
	}

}
