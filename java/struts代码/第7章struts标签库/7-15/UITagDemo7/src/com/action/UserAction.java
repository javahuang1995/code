package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//months����
	private String[] months;
	//moths���Ե�getter��setter����
	public String[] getMonths() {
		return months;
	}
	public void setMonths(String[] months) {
		this.months = months;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
