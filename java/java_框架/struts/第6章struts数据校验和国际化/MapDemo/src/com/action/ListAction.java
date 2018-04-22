package com.action;
import java.util.Map;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//Map类型 users属性
	private  Map<String, User> users;
	//getter方法
	public Map<String, User> getUsers() {
		return users;
	}
	//setter方法
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
	//重载execute方法
	public String execute() throws Exception {		
		return SUCCESS;
	}                                   
}
