package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//��дexecute����
	public String execute() throws Exception {
		//���������Ϣ
		addActionError("the first error!"); 
	    addActionError("the second error!"); 
	    //������Ϣ
	    addActionMessage("the first message!");
	    addActionMessage("the second message");
	    addFieldError("f1","the first field error!");
	    addFieldError("f2", "the second field error!");
		return SUCCESS;
	}
}
