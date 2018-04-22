package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//fruits属性
	private String[] fruits;
	//fruits属性的getter和setter方法
	public String[] getFruits() {
		return fruits;
	}
	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}
	//重写execute方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
