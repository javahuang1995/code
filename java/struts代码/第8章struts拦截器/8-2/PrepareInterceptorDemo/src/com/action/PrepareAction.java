package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PrepareAction extends ActionSupport implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("	when prepare() is invoked, the msg is "+msg);
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("	when execute() is invoked, the msg is "+msg);
		return SUCCESS;
	}

}
