package com.huang.hibernate.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.it.shop.model.Product;
import org.hibernate.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class HibernateTest {

	@Resource
	private SessionFactory sessionFactory;


	/**
	 * save() delete() update() get()/fetch()
	 * 
	 * HQL查询::Hibernate Query Language
	 */
	@Test
	public void testCRUD() {

		String hql = "select * from product where name like ?";
		getSession().createQuery(hql) //
				.setParameter("0", "hi").list();
		Criteria  c = getSession().createCriteria(Product.class);
		List<Product> result=c.list();

	}

	protected Session getSession() {
		// 从当前线程获取session，如果没有则创建一个新的session
		return sessionFactory.getCurrentSession();
	}

	@Test
	public void testCon() {
		// 这样没办法获取连接
		// Session s = sessionFactory.getCurrentSession();
		Session s = sessionFactory.openSession();
		System.out.println(s);

	}

}
