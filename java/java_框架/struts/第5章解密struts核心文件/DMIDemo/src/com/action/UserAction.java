package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{	
	private static final long serialVersionUID=1L;
	//info属性
	private String info;
	//info属性的getter方法
	public String getInfo() {
	return info;
	}
	//info属性的setter方法
	public void setInfo(String info) {
		this.info = info;
	}
	//重载execute()方法
	public String execute() throws Exception {
		info="hello,world";
		return "hello";
	}
	//update()方法，更新info属性
	public String update()throws Exception{
	   info="ok,updated";
	   return "update";
   }
}
