package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class FirstInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("	第一个拦截器，在调用下一个拦截器 或Action前");    
		 String result = invocation.invoke();      
		 System.out.println("	第一个拦截器，在调用下一个拦截器 或Action后");    
		return result;
	
	}

}
