package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//country属性
	private String[] country;
	//country属性的getter和setter方法
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	//重写execute方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
