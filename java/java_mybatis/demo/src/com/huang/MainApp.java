package com.huang;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.model.User;

public class MainApp {
	public static void main(String[] args) {
		String resource = "SqlMapConfig.xml";
		//ͨ���������������ļ�����
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ͨ�����������ļ�������, �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�����������Ự
		SqlSession session = factory.openSession();
		
		System.out.println(session);
		
		User user = session.selectOne("user.findUserById",1); 
        
		System.out.println(user.getId()+user.getUsername()+user.getType()+user.getPassword());
	}
}
