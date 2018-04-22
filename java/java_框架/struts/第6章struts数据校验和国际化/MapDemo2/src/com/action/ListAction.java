package com.action;
import java.util.Map;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//Mpa类型users属性，不包含元素类型
	private Map users;
	//getter方法
	public Map getUsers() {
		return users;
	}
	//setter方法
	public void setUsers(Map users) {
		this.users = users;
	}
	@Override
	//重载execute方法
	public String execute() throws Exception {
		return SUCCESS;
	}

}
