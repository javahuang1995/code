package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//leftsides����
	private String[] leftSides;
	//rightsides����
	private String[] rightSides;
	//������getter��setter����
	public String[] getLeftSides() {
		return leftSides;
	}
	public void setLeftSides(String[] leftSides) {
		this.leftSides = leftSides;
	}
	public String[] getRightSides() {
		return rightSides;
	}
	public void setRightSides(String[] rightSides) {
		this.rightSides = rightSides;
	}
	//��дexecute����
	public String execute() throws Exception {	
		//����success
		return SUCCESS;
	}
}
