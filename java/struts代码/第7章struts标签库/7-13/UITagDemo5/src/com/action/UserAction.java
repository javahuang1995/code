package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//fruits����
	private String[] fruits;
	//fruits���Ե�getter��setter����
	public String[] getFruits() {
		return fruits;
	}
	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
