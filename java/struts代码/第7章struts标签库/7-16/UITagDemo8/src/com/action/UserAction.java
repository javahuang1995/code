package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//myselection����
	private String mySelection;
	//myselection���Ե�getter��setter����
	public String getMySelection() {
		return mySelection;
	}
	public void setMySelection(String mySelection) {
		this.mySelection = mySelection;
	}
	//��дexecute����
	public String execute() throws Exception {
		//����success
		return SUCCESS;
	}
}
