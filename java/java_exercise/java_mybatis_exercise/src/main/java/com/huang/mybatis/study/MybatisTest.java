package com.huang.mybatis.study;

import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbStudentMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbStudent;
import com.taotao.pojo.TbTeacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MybatisTest {

	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

	@Resource
	private SqlSessionFactory sqlsessionFactory;

	@Resource
	private TbItemMapper tbItemMapper;

	@Resource
	private TbStudentMapper tbStudentMapper;
	
	/**
	 * 这个测试下Mybatis自动生成的mapper，以及Example类
	 */
	@Test


	public void testExampleCriteria(){
		TbItemExample example = new TbItemExample();
		
		//criteria是准则的意思，就是说，查询出来的数据要满足这些准则。然后criteria包括一个Criterion List,就是那些and条件了。
		example.createCriteria().andTitleEqualTo("ss").andNumEqualTo(3).andBarcodeIsNotNull();
		
		//还可以创建一个criteria
		example.createCriteria().andBarcodeBetween("dd", "dd");
		
		List<TbItem> list =  tbItemMapper.selectByExample(example);
		
	}
	
	
	
	/**
	 * 这个测试下用mybatis调用存储过程，其实也是拼凑sql而已。
	 * TbItemExample-->包括List Criteria--->Criteria包括List Criterion
	 */
	@Test
	public void testCallFuncPro(){
		

		
	}

	/**
	 * 这个测试下pageHelper的分页插件
	 * 好像说这个分页插件对有条件的查询支持不好。
	 * 中国共产党万岁
	 */
	@Test
	public void testPageQuery() {
		// 分页处理，显示第一页的10条数据
		PageHelper.startPage(1, 10);
		TbItemExample example = new TbItemExample();
		List<TbItem> list =  tbItemMapper.selectByExample(example);
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

		TbItem a = tbItemMapper.selectByPrimaryKey((long) 536563);

		// 这个是级联查询。。
		TbStudent student = tbStudentMapper.getStudent("1");
		TbTeacher tt = student.getTeacher();

		logger.info(student.getStudentName());
		if (tt == null) {
			logger.info("teacher is null");
		} else {
			logger.info(tt.getTeacherName());
		}

		TbStudent student3 = null;
		student3 = tbStudentMapper.getStudentByName("黄宁");
		logger.info(student3.getStudentSex());

		Map<String, Object> cond = new HashMap<String, Object>();
		cond.put("sex", "女");
		List<TbStudent> list = tbStudentMapper.getStudentByMap(cond);
		for (TbStudent tmp : list) {
			logger.info(tmp.getStudentName());
		}

		/////
		TbStudent student2 = new TbStudent();
		student2.setStudentName("哈哈哈哈学渣");

		// 插入
		tbStudentMapper.insertStudent(student2);

		// update
		student2.setStudentName("fuckyou");
		tbStudentMapper.updateStudent(student2);
		// System.out.println(a.getTitle());

		// delete
		// stuMapper.deleteStudent(student2);

	}

}
