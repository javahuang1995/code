package com.action;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//name 属性
	private String name;
	//password 属性
	private String password;
	//name属性 getter方法
	public String getName() {
		return name;
	}
	//name属性setter方法
	public void setName(String name) {
		this.name = name;
	}
	//password属性getter方法
	public String getPassword() {
		return password;
	}
	//password属性setter方法
	public void setPassword(String password) {
		this.password = password;
	}
	//重载execute()方法
	public String execute() throws Exception {
		//httpservletresponse 类型变量
		HttpServletResponse response=ServletActionContext.getResponse();
		//设置返回内容类型
		response.setContentType("text/xml;charset=UTF-8");
		//设置头
		response.setHeader("Cache-Control", "no-cache");
		//输出success
		response.getWriter().println("success");
		//检查name password属性
		if(name.equals("tom")&&password.equals("123"))
		{
			response.getWriter().println("welcome login!");
			
		}else {
			response.getWriter().println("error,please input again!");
		}
		//返回success
		return SUCCESS;
	}
}
