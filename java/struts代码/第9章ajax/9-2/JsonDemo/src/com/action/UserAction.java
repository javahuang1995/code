package com.action;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//user����
	private User user=new User();
	//��������ΪUSER
    @JSON(name="USER")
	public User getUser() {
	return user;
    }
    //setter����
    public void setUser(User user) {
    	this.user = user;
    }
	//����execute����
	public String execute() throws Exception {
		//����user���������ֵ
	   user.setName("tom");
	   user.setAge(20);
		return SUCCESS;
	}
}
