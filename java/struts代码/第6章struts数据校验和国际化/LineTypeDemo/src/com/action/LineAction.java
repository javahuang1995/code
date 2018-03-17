package com.action;

import com.convertor.Line;
import com.opensymphony.xwork2.ActionSupport;

public class LineAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//生面Line实例
	private Line line;
	//getter方法
   public Line getLine() {
		return line;
	}
   //setter方法
	public void setLine(Line line) {
		this.line = line;
	}
	//重载execute方法
   public String execute() throws Exception {
	// TODO Auto-generated method stub
	return SUCCESS;
   }
}
