package com.action;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Date now=new Date();
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().put("hello", "hello,world£¡");
		
		return SUCCESS;
	}

}
