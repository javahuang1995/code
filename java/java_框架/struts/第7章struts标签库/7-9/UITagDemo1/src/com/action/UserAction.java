package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//sex����
	private String sex;
	//role����
	private String role;
	//�������Ե�getter��setter����
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//��дexecute()����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
