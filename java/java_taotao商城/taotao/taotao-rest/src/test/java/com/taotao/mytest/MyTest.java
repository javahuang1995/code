package com.taotao.mytest;


import static org.junit.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-*.xml")
public class MyTest {

	@Autowired
	private ContentService contentService;
	
	
	@Test
	public void connDb(){
		List<TbContent> result = contentService.getContentList(0);
		System.out.println(result);
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
