package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//����execute()����������SUCCESS
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	//redirect()����������ERROR
	public String redirect() throws Exception {
		return ERROR;
	}
}
