package com.action;

import com.convertor.Line;
import com.opensymphony.xwork2.ActionSupport;

public class LineAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//����Lineʵ��
	private Line line;
	//getter����
   public Line getLine() {
		return line;
	}
   //setter����
	public void setLine(Line line) {
		this.line = line;
	}
	//����execute����
   public String execute() throws Exception {
	// TODO Auto-generated method stub
	return SUCCESS;
   }
}
