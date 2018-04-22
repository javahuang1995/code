package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//leftsides属性
	private String[] leftSides;
	//rightsides属性
	private String[] rightSides;
	//各属性getter和setter方法
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
	//重写execute方法
	public String execute() throws Exception {	
		//返回success
		return SUCCESS;
	}
}
