package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//gender����
	private String gender;
	//gender���Ե�getter��setter����
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
