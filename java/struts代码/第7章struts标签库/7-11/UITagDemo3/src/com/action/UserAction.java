package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID  = 1L;
	//fruit����
	private String fruit;
	//fruit���Ե�getter��setter����
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}

}
