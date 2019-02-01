package com.huang.mybatis.test;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbStudentMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbStudent;
import com.taotao.pojo.TbTeacher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MybatisTest {

	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private SqlSessionFactory sqlsessionFactory;

	@Resource
	private TbItemMapper itemMapper;

	@Resource
	private TbStudentMapper stuMapper;

	@Test
	public void testConViaMybatis() {

		logger.info("hi");
		SqlSession s = sqlsessionFactory.openSession();

		// System.out.println(s);

		TbItem a = itemMapper.selectByPrimaryKey((long) 536563);

		// 这个是级联查询。。
		TbStudent student = stuMapper.getStudent("1");
		TbTeacher tt = student.getTeacher();

		logger.info(student.getStudentName());
		if (tt == null) {
			logger.info("teacher is null");
		} else {
			logger.info(tt.getTeacherName());
		}

		// System.out.println(a.getTitle());

	}

}
