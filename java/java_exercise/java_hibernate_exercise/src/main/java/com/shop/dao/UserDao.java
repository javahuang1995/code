package com.shop.dao;

import com.shop.model.User;

public interface UserDao extends BaseDao<User> {
	//用户登陆，成功返回该User
	public User login(User user);
}
