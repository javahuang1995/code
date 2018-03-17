package com.huang.mytest;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.impl.CategoryServiceImpl;
import cn.it.shop.utils.HibernateSessionFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class SSHTest {

	@Resource  
    private Date date;  
	@Resource  
    private CategoryService categoryService;  
      
    @Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
	}
    
    
    @Test  //测试Hibernate的开发环境，因为没有整合，可以直接new  
    public void hihernate() {  
        CategoryService categoryService = new CategoryServiceImpl();  
        Category category = new Category("男士休闲", true);  
        categoryService.save(category);  
    }  
    
    @Test //测试Hibernate和Spring整合后  
    public void hibernateAndSpring() {  
        categoryService.update(new Category(1, "情趣内衣", true)); //categoryService通过Spring从上面注入进来的  
    }  
   
      
    @Test  
     public void testQueryJoinAccount() {  
        for(Category c : categoryService.queryJoinAccount("",1,2)) {  
             System.out.println(c);  
             System.out.println(c.getAccount());  
        }  
    }  


}

