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
		//通过流将核心配置文件读入
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过核心配置文件输入流, 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂创建会话
		SqlSession session = factory.openSession();
		
		System.out.println(session);
		
		User user = session.selectOne("user.findUserById",1); 
        
		System.out.println(user.getId()+user.getUsername()+user.getType()+user.getPassword());
	}
}
