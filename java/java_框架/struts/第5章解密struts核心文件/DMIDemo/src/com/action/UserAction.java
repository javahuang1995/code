package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{	
	private static final long serialVersionUID=1L;
	//info����
	private String info;
	//info���Ե�getter����
	public String getInfo() {
	return info;
	}
	//info���Ե�setter����
	public void setInfo(String info) {
		this.info = info;
	}
	//����execute()����
	public String execute() throws Exception {
		info="hello,world";
		return "hello";
	}
	//update()����������info����
	public String update()throws Exception{
	   info="ok,updated";
	   return "update";
   }
}
