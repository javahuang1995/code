package com.huang.hibernate.test;

import com.shop.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class HibernateTest {

	@Resource
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(HibernateTest.class);

	/**
	 * save() delete() update() get()/fetch()
	 * 
	 * HQL查询::Hibernate Query Language
	 */
	@Test
	@Transactional
	public void testCRUD() {

		List<Product> result = null;
		String hql = "from Product where name = ?";//这里要写Product类名，而不是表名，踩坑了。
		
		Query q = getSession().createQuery(hql).setParameter(0,"dsf");
		//Criteria c = getSession().createCriteria(Product.class).add(Restrictions.eq("name", "jack"));
		
		//result = c.list();
		result = q.list();
		
		travse(result);
		
	}

	public <T> void travse(List<T> list){
		for(T tmp:list){
			logger.info("travese"+tmp.toString());
		}
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
