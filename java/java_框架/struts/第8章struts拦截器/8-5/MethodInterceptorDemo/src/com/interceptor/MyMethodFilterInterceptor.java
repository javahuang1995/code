package com.interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyMethodFilterInterceptor extends MethodFilterInterceptor{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		String className = invocation.getAction().getClass().getName();     
		long startTime = System.currentTimeMillis();       
		 System.out.print("------������"+name+"��Action" + className+"ִ��ǰ: ");    
		 String result = invocation.invoke();      
		 long endTime = System.currentTimeMillis();       
		 System.out.println("------��Action" + className+"ִ�к�: "+ " Time taken: " + (endTime - startTime) + " ms");
		return result;
	}
}
