package com.huang.hibernate.test;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.dao.AccountDao;
import cn.it.shop.dao.BaseDao;
import cn.it.shop.dao.CategoryDao;
import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.dao.UserDao;
import cn.it.shop.service.BaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class ConnTest {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private SqlSessionFactory sqlsessionFactory;
	
	private BaseDao baseDao;
	@Resource
	private AccountDao accountDao;
	@Resource
	private CategoryDao categoryDao;
	@Resource
	private ForderDao forderDao;
	@Resource
	private ProductDao productDao;
	@Resource
	private SorderDao sorderDao;
	@Resource
	private UserDao userDao;
	
	
	
	@Test
	public void testCon(){
		//这样没办法获取连接
		//Session s = sessionFactory.getCurrentSession();
		Session s = sessionFactory.openSession();
		System.out.println(s);
		
	}
	
	@Test
	public void testConViaMybatis(){
		SqlSession s = sqlsessionFactory.openSession();
		System.out.println(s);
		
		
		
	}

}
