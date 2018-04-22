package com.action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//����execute()����
	public String execute() throws Exception {
		//�õ�ActionContextʵ��
		ActionContext context=ActionContext.getContext();
		//����name����request��tom������ActionContext��
		context.put("name", "request:tom");
		//�õ�application������name����application��tom��������
		context.getApplication().put("name", "application:tom");
		//�õ�session������name����session��tom��������
		context.getSession().put("name", "session:tom");
        //����hello
		return "hello";
	}
}
