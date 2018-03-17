package org.hibernate.test;
import org.hibernate.dao.*;
import org.hibernate.entity.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	@Before
	public void setUp() throws Exception {
	}
	@Test //testע�ͱ����÷���Ϊһ�����Է���
	public void testSave() {
		UserDAO userdao=new UserDAOImpl();	
	     try{
		  User u=new User();			//����User����
		  //����User�����еĸ�������ֵ
		  u.setId(20);
		  u.setName("zhangsan");
		  u.setPassword("456");
		  u.setType("admin");
		  userdao.save(u);				//ʹ��userdaoimpl��save������User����������ݿ�
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	}
}
