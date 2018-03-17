package com.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//重载execute()方法
	public String execute() throws Exception {
		//得到ActionContext实例
		ActionContext context=ActionContext.getContext();
		//将（name，“request：tom”）到ActionContext中
		context.put("name", "request:tom");
		//得到application并将（name，“application：tom”）放入
		context.getApplication().put("name", "application:tom");
		//得到session并将（name，“session：tom”）放入
		context.getSession().put("name", "session:tom");
        //返回hello
		return "hello";
	}
}
