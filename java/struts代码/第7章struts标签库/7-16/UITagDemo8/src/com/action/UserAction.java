package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//myselection属性
	private String mySelection;
	//myselection属性的getter和setter方法
	public String getMySelection() {
		return mySelection;
	}
	public void setMySelection(String mySelection) {
		this.mySelection = mySelection;
	}
	//重写execute方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
