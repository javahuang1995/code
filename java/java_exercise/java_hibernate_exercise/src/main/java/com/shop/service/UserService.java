package com.shop.service;

import com.shop.model.User;

public interface UserService extends BaseService<User> {
	//用户登陆，成功返回该User
	public User login(User user);
}
