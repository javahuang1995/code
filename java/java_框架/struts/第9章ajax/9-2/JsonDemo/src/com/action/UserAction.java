package com.action;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//user对象
	private User user=new User();
	//更新名字为USER
    @JSON(name="USER")
	public User getUser() {
	return user;
    }
    //setter方法
    public void setUser(User user) {
    	this.user = user;
    }
	//重载execute方法
	public String execute() throws Exception {
		//设置user对象的属性值
	   user.setName("tom");
	   user.setAge(20);
		return SUCCESS;
	}
}
