#struts2后台没有 报错，访问出现404
##1.jsp页面
inde.jsp如下图

``` xml
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>

<body>
	<!-- 下面两种写法都可以访问 -->
	</span>
	<a
		href="${pageContext.request.contextPath}/category_update.action?category.id=2&category.type=gga&category.hot=false">访问update</a>
	<a href="category_save.action">访问save</a>
	
	<a href="category_query.action">查询所有类别</a><br/>  
    <c:forEach items="${requestScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${sessionScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
      
    <c:forEach items="${applicationScope.categoryList }" var="category">  
        ${category.id } | ${category.type } | ${category.hot } <br/>  
    </c:forEach>  
    
</body>
</html>
```
##2.action文件
``` java
package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cn.it.shop.model.Category;
import cn.it.shop.service.CategoryService;

//
//@Controller("categoryAction")
//@Scope("prototype")
//public class CategoryAction extends BaseAction<Category> {
//	
//	public String queryJoinAccount() {
//		System.out.println("type:" + model.getType());
//		System.out.println("page：" + page);
//		System.out.println("rows：" + rows);
//		
//		//用来存储分页的数据
//		pageMap = new HashMap<String, Object>();
//		
//		//根据关键字和分页的参数查询相应的数据
//		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
//		pageMap.put("rows", categoryList); //存储为JSON格式
//		//根据关键字查询总记录数
//		Long total = categoryService.getCount(model.getType());
////		System.out.println(total);
//		pageMap.put("total", total); //存储为JSON格式
//
//		return "jsonMap";
//	}
//	
//	public String deleteByIds() {
//		System.out.println(ids);
//		categoryService.deleteByIds(ids);
//		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台
//		inputStream = new ByteArrayInputStream("true".getBytes());
//		return "stream";
//	}
//	
//	public void save() {
//		System.out.println(model);
//		categoryService.save(model);
//	}
//	
//	public void update() {
//		System.out.println(model);
//		categoryService.update(model);
//	}
//	
//	public String query() {
//		jsonList = categoryService.query();
//		return "jsonList";
//	}
//}

public class CategoryAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{  
    /**
	 * 
	 */
	private static final long serialVersionUID = -5332737807813004041L;
	private CategoryService categoryService; //设置categoryService是为了很直观的看出与Spring整合前后的不同  
    private Category category;//设置一个私有成员变量接收url带过来的参数，注意下面要写好get和set方法  
  
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCategoryService(CategoryService categoryService) {  
        this.categoryService = categoryService;  
    }  
      
    public String update() {  
        System.out.println("----update----");  
        System.out.println(categoryService); //整合前后输出不同  
        categoryService.update(category); //新加一条语句，来更新数据库  
        return "index";  
    }  
      
    public String save() {  
        System.out.println("----save----");  
        System.out.println(categoryService);//整合前后输出不同  
        return "index";  
    }

    public String query() {  
        //解决方案一，采用相应的map取代原来的内置对象，这样与jsp没有依赖，但是代码量比较大  
//     ActionContext.getContext().put("categoryList", categoryService.query()); //放到request域中  
//     ActionContext.getContext().getSession().put("categoryList", categoryService.query()); //放到session域中  
//     ActionContext.getContext().getApplication().put("categoryList", categoryService.query()); //放到application域中  
         
       //解决方案二，实现相应的接口(RequestAware,SessionAware,ApplicationAware)，让相应的map注入  
       request.put("categoryList", categoryService.query());   
       session.put("categoryList", categoryService.query());   
       application.put("categoryList", categoryService.query());   
       return "index";  
   }  
    
    private Map<String, Object> request;  
    private Map<String, Object> session;  
    private Map<String, Object> application;  
    
    @Override  
    public void setApplication(Map<String, Object> application) {  
        this.application = application;  
    }  
  
    @Override  
    public void setSession(Map<String, Object> session) {  
        this.session = session;  
    }  
  
    @Override  
    public void setRequest(Map<String, Object> request) {  
        this.request = request;  
    }  
    
}  


```

##3.struts.xml文件
``` xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC
	"-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
	"http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>

	<constant name="struts.devMode" value="true" />
	<package name="shop" extends="struts-default">

		<!-- class对应的是Spring中配置该Action的id值，因为要交给Spring管理 -->
		<action name="category_*" class="categoryAction" method="{1}">
			<result name="index">/index.jsp</result>
		</action>
	</package>

</struts>

```

##4.beans.xml
我怀疑是改了这个文件的原因，就是把service的公共部分抽出到抽象类baseService里面去了，就发生了这个问题
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop-4.2.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">

	<bean id="date" class="java.util.Date" />
	<!-- com.mchange.v2.c3p0.ComboPooledDataSource类在c3p0-0.9.5.1.jar包的com.mchange.v2.c3p0包中 -->
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<property name="driverClass" value="com.mysql.jdbc.Driver" />
		<property name="jdbcUrl" value="jdbc:mysql://localhost:3306/shop" />
		<property name="user" value="root" />
		<property name="password" value="1995" />
	</bean>
	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation" value="classpath:hibernate.cfg.xml" /> <!-- 加载hibernate配置文件 -->
	</bean>

	<!-- org.springframework.orm.hibernate4.HibernateTransactionManager类spring-orm-4.2.4.RELEASE.jar包的org.springframework.orm.hibernate4包中 -->
	<bean id="transactionManager"
		class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory" />
	</bean>

	<tx:advice id="advice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="save*" propagation="REQUIRED" />
			<tx:method name="update*" propagation="REQUIRED" />
			<tx:method name="delete*" propagation="REQUIRED" />
			<tx:method name="*" propagation="SUPPORTS" />
		</tx:attributes>
	</tx:advice>

	<aop:config>
		<!-- 配置哪些包的类要切入事务 -->
		<aop:pointcut id="pointcut"
			expression="execution(* cn.it.shop.service.impl.*.*(..))" />
		<aop:advisor advice-ref="advice" pointcut-ref="pointcut" /><!-- 
			连接了<span style="font-family:Microsoft YaHei;">上</span>面的advice和上面的pointcut -->
		<!-- aop:pointcut要写在aop:advisor上面，否则会报错 -->
	</aop:config>

	<!-- 泛型类是不能实例化的，所以要加lazy-init属性 -->
	<bean id="baseService" class="cn.it.shop.service.impl.BaseServiceImpl"
		lazy-init="true">
		<property name="sessionFactory" ref="sessionFactory" />
	</bean>
	<!-- 因为父类已经注入了sessionFactory，所以子类不需要注入 -->
	<bean id="categoryService" class="cn.it.shop.service.impl.CategoryServiceImpl"
		parent="baseService" />
	<bean id="accountService" class="cn.it.shop.service.impl.AccountServiceImpl"
		parent="baseService" />


	<!-- <bean id="categoryService" class="cn.it.shop.service.impl.CategoryServiceImpl"> 
		<property name="sessionFactory" ref="sessionFactory" />依赖的sessionFactory用我们之前配好的sessionFactory 
		</bean> -->

	<bean id="categoryAction" class="cn.it.shop.action.CategoryAction"
		scope="prototype">
		<property name="categoryService" ref="categoryService" /> <!-- 依赖的categoryService用上面和Hibernate整合时配置好的categoryService -->
	</bean>


</beans>
```









