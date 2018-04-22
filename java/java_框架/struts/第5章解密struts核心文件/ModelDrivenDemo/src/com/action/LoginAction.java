package com.action;
import com.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class LoginAction extends ActionSupport implements ModelDriven<UserModel>{
	private static final long serialVersionUID = 1L;
	//创建UserModel实例
    private UserModel user=new UserModel();
    //getter方法，必须实现
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//重载execute方法
    public String execute() throws Exception {
    	//得到ActionContext实例
    	ActionContext context=ActionContext.getContext();
    	//将（“user”，user）放入ActionContext中
    	context.put("user", user);
    	return SUCCESS;
    }
}
