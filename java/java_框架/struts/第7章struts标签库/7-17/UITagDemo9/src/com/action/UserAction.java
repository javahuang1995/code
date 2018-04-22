package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//gender属性
	private String gender;
	//gender属性的getter和setter方法
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//重写execute方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
