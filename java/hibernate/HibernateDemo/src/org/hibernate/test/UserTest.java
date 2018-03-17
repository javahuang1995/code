package org.hibernate.test;
import org.hibernate.dao.*;
import org.hibernate.entity.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	@Before
	public void setUp() throws Exception {
	}
	@Test //test注释表明该方法为一个测试方法
	public void testSave() {
		UserDAO userdao=new UserDAOImpl();	
	     try{
		  User u=new User();			//创建User对象
		  //设置User对象中的各个属性值
		  u.setId(20);
		  u.setName("zhangsan");
		  u.setPassword("456");
		  u.setType("admin");
		  userdao.save(u);				//使用userdaoimpl的save方法将User对象存入数据库
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	}
}
