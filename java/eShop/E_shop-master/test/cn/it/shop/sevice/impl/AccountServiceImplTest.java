package cn.it.shop.sevice.impl;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class AccountServiceImplTest {

	@Resource
	private AccountService accountService;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Test
	public void testSave() {
		accountService.save(new Account("admin", "Сǿ", "admin"));
	}
	
	@Test
	public void testCon(){
		//����û�취��ȡ����
		//Session s = sessionFactory.getCurrentSession();
		Session s = sessionFactory.openSession();
		System.out.println(s);
		
		
	}

}
