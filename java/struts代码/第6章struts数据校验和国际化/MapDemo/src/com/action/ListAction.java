package com.action;
import java.util.Map;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//Map���� users����
	private  Map<String, User> users;
	//getter����
	public Map<String, User> getUsers() {
		return users;
	}
	//setter����
	public void setUsers(Map<String, User> users) {
		this.users = users;
	}
	//����execute����
	public String execute() throws Exception {		
		return SUCCESS;
	}                                   
}
