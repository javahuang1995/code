package org.hibernate.entity;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.User;

public class HibernateDemo {
	public static void main(String[] args) {
		Session session = null;
		Session newSession = null;
		try {
			// 读hibernate.cfg.xml配置文件
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			// 创建新的User对象
			System.out.println("Inserting Record");
			User user = new User();
			user.setId(4);
			user.setName("John");
			user.setPassword("bbb");
			user.setType("admin");
			session.save(user);
			tx.commit();

			System.out.println("Done");

			/*
			 * newSession=sessionFactory.openSession(); Transaction
			 * newTransaction = newSession.beginTransaction(); List
			 * users=newSession
			 * .createQuery("from User u order by u.id ASC").list();
			 * System.out.println(users.size()+"user(s) found:"); for(Iterator
			 * iter=(Iterator)users.iterator();iter.hasNext();) { User
			 * loadedUser=(User)iter.next();
			 * System.out.println(loadedUser.getName()); }
			 * newTransaction.commit();
			 */
			// newSession.close();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			// newSession.close();
		}
	}
}
