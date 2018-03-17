package org.hibernate.dao;

import org.hibernate.*;
import org.hibernate.entity.*;

public class UserDAOImpl implements UserDAO {
	// ����û�
	public void save(User user) {
		Session session = HibernateUtil.getSession(); // ����Sessionʵ��
		Transaction tx = session.beginTransaction(); // ����Transactionʵ��
		try {
			session.save(user); // ʹ��Session��save�������־û����󱣴浽���ݿ�
			tx.commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Sessionʵ��
		}
	}

	// �����û���ʶ����ָ���û�
	public User findById(int id) {
		User user = null;
		Session session = HibernateUtil.getSession(); // ����Sessionʵ��
		Transaction tx = session.beginTransaction(); // ����Transactionʵ��
		try {
			user = (User) session.get(User.class, id); // ʹ��Session��get������ȡָ��id���û����ڴ���
			tx.commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Sessionʵ��
		}
		return user;
	}

	// ɾ���û�
	public void delete(User user) {
		Session session = HibernateUtil.getSession(); // ����Sessionʵ��
		Transaction tx = session.beginTransaction(); // ����Transactionʵ��
		try {
			session.delete(user); // ʹ��Session��delete�������־û�����ɾ��
			tx.commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Sessionʵ��
		}
	}

	// �޸��û���Ϣ
	public void update(User user) {
		Session session = HibernateUtil.getSession(); // ����Sessionʵ��
		Transaction tx = session.beginTransaction(); // ����Transactionʵ��
		try {
			session.update(user); // ʹ��Session��update�������³־û�����
			tx.commit(); // �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); // �ع�����
		} finally {
			HibernateUtil.closeSession(); // �ر�Sessionʵ��
		}
	}
}
