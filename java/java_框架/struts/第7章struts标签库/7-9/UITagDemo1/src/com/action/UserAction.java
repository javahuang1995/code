package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//sex属性
	private String sex;
	//role属性
	private String role;
	//各个属性的getter和setter方法
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
	//重写execute()方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
