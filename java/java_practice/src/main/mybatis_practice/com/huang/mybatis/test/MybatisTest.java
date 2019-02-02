package com.huang.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbStudentMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
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
	
	/**
	 * 这个测试下用mybatis调用存储过程，其实也是拼凑sql而已。
	 */
	public void testCallFuncPro(){
		
	}

	/**
	 * 这个测试下pageHelper的分页插件
	 */
	@Test
	public void testPageQuery() {
		// 分页处理，显示第一页的10条数据
		PageHelper.startPage(1, 10);
		TbItemExample example = new TbItemExample();
		List<TbItem> list =  itemMapper.selectByExample(example);
		// 取商品列表
        for(TbItem item : list) {
           logger.info(item.getTitle());
        }
	}

	/**
	 * crud 测试
	 */
	@Test
	public void testCRUD() {

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

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

		TbStudent student3 = null;
		student3 = stuMapper.getStudentByName("黄宁");
		logger.info(student3.getStudentSex());

		Map<String, Object> cond = new HashMap<String, Object>();
		cond.put("sex", "女");
		List<TbStudent> list = stuMapper.getStudentByMap(cond);
		for (TbStudent tmp : list) {
			logger.info(tmp.getStudentName());
		}

		/////
		TbStudent student2 = new TbStudent();
		student2.setStudentName("哈哈哈哈学渣");

		// 插入
		stuMapper.insertStudent(student2);

		// update
		student2.setStudentName("fuckyou");
		stuMapper.updateStudent(student2);
		// System.out.println(a.getTitle());

		// delete
		// stuMapper.deleteStudent(student2);

	}

}
