package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//country����
	private String[] country;
	//country���Ե�getter��setter����
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
