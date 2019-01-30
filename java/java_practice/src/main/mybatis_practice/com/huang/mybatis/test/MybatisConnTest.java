package com.huang.mybatis.test;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class MybatisConnTest {

	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private SqlSessionFactory sqlsessionFactory;
	
	@Resource
	private TbItemMapper itemMapper;
	

	@Test
	public void testConViaMybatis(){
		SqlSession s = sqlsessionFactory.openSession();
		System.out.println(s);
		
		TbItem a = itemMapper.selectByPrimaryKey((long) 536563);
		System.out.println(a.getTitle());
		
	}

}
