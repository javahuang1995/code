package com.huang.spring.yuanli;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {
	
	private Map<String , Object> beans = new HashMap<String, Object>();
	//IOC Inverse of Control DI Dependency Injection
	public ClassPathXmlApplicationContext() throws Exception {
		SAXBuilder sb=new SAXBuilder();
	    Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml")); //构造文档对象
	    Element root=doc.getRootElement(); //获取根元素HD
	    List beanlist=root.getChildren("bean");//取名字为disk的所有元素
	    
	    //遍历所有注册的bean
	    for(int i=0;i<beanlist.size();i++){
	       Element element=(Element)beanlist.get(i);
	       String id=element.getAttributeValue("id");
	       String clazz=element.getAttributeValue("class");
	       Object o = Class.forName(clazz).newInstance();//实例化对象
	       System.out.println(id);
	       System.out.println(clazz);
	       beans.put(id, o);//放到Map里面
	       
	       for(Element propertyElement : (List<Element>)element.getChildren("property")) {
	    	   String name = propertyElement.getAttributeValue("name"); //userDAO
	    	   String bean = propertyElement.getAttributeValue("bean"); //u
	    	   Object beanObject = beans.get(bean);//UserDAOImpl instance
	    	   
	    	   String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	    	   System.out.println("method name = " + methodName);
	    	   
	    	   Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
	    	   m.invoke(o, beanObject);
	       }
	       
	       
	    }  
	  
	}

	public Object getBean(String id) {
		return beans.get(id);
	}

}
