package com.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String msg;  
	 
    public String getMsg() {  
        return msg;  
    }  
    public void setMsg(String msg) {  
        this.msg = msg;  
    }  
    public String method1() throws Exception {  
        ActionContext.getContext().put("msg", "the method1 is invoked!");
        System.out.println("the method1 is invoked!");  
        return SUCCESS;  
    }  
    public String method2() throws Exception {  
    	ActionContext.getContext().put("msg", "the  method2 is invoked!");  
    	 System.out.println("the method2 is invoked!");  
        return SUCCESS;  
    }  
    public String method3() throws Exception {  
    	ActionContext.getContext().put("msg", "the method3 is invoked!");
    	 System.out.println("the method3 is invoked!");  
        return SUCCESS;  
    }  
	@Override
	public String execute() throws Exception {
		ActionContext.getContext().put("msg", "the execute() method is invoked!");
		 System.out.println("the execute() method is invoked!");  
		return SUCCESS;
	}
}
