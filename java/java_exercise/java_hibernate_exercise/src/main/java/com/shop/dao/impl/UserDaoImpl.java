package com.shop.dao.impl;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements
		UserDao {

	@Override
	public User login(User user) {
		String hql = "from User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql) //
			.setString("login", user.getLogin()) //
			.setString("pass", user.getPass()) //
			.uniqueResult();
	}

}
