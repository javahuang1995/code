package com.action;
import java.util.List;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//users属性，为List类型
	private List<User> users;
	//getter方法
	public List<User> getUsers() {
		return users; 
	}
	//setter方法
	public void setUsers(List<User> users) {
		this.users = users;
	}
	//重载execute()方法
	public String execute() throws Exception {
		for (User user : users) {
			System.out.println("Name:"+user.getName()+" Age:"+user.getAge()+" Tel:"+user.getTel());
		}
		
		return SUCCESS;
	}
}
