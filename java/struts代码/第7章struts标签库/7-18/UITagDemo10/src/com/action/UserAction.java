package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//name����
	private String name;
	//password����
	private String password;
	//�������Ե�getter��setter����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
