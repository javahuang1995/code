package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{ 
	private static final long serialVersionUID = 1L;
//处理用户请求的execute方法
	public String execute() throws Exception {
		Thread.sleep(100);
		return SUCCESS;
	}
}
