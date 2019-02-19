package com.shop.service.impl;

import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

}
