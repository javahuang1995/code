package com.action;
import com.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class LoginAction extends ActionSupport implements ModelDriven<UserModel>{
	private static final long serialVersionUID = 1L;
	//����UserModelʵ��
    private UserModel user=new UserModel();
    //getter����������ʵ��
	public UserModel getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//����execute����
    public String execute() throws Exception {
    	//�õ�ActionContextʵ��
    	ActionContext context=ActionContext.getContext();
    	//������user����user������ActionContext��
    	context.put("user", user);
    	return SUCCESS;
    }
}
