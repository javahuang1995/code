package com.interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
public class ThirdInterceptor extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub     
		 System.out.println("	���������������ڵ�����һ�������� ��Actionǰ");    
		 String result = invocation.invoke();      
		 System.out.println("	���������������ڵ�����һ�������� ��Action��");    
		return result;
	}
}
