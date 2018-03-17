package com.action;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//List类型，没指定元素类型
	private List users;
	//getter方法
     public List getUsers() {
		return users;
	}
     //setter方法
	public void setUsers(List users) {
		this.users = users;
	}
	//重载execute方法
	public String execute() throws Exception {
		return SUCCESS;
	}
}
