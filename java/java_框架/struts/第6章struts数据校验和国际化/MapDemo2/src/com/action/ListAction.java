package com.action;
import java.util.Map;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//Mpa����users���ԣ�������Ԫ������
	private Map users;
	//getter����
	public Map getUsers() {
		return users;
	}
	//setter����
	public void setUsers(Map users) {
		this.users = users;
	}
	@Override
	//����execute����
	public String execute() throws Exception {
		return SUCCESS;
	}

}
