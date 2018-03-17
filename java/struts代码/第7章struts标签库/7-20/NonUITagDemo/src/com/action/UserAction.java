package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//重写execute方法
	public String execute() throws Exception {
		//加入错误信息
		addActionError("the first error!"); 
	    addActionError("the second error!"); 
	    //加入消息
	    addActionMessage("the first message!");
	    addActionMessage("the second message");
	    addFieldError("f1","the first field error!");
	    addFieldError("f2", "the second field error!");
		return SUCCESS;
	}
}
