package org.hibernate.dao;

import java.util.List;
import org.hibernate.entity.User;
//����UserDAO�ӿ�
public interface UserDAO {
	 void save(User user);				//����û�
	 User findById(int id);				//�����û���ʶ����ָ���û�	 
void delete(User user);				//ɾ���û�	
	 void update(User user);				//�޸��û���Ϣ
}

