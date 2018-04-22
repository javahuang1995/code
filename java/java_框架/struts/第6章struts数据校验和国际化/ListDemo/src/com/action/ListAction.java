package com.action;
import java.util.List;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//users���ԣ�ΪList����
	private List<User> users;
	//getter����
	public List<User> getUsers() {
		return users; 
	}
	//setter����
	public void setUsers(List<User> users) {
		this.users = users;
	}
	//����execute()����
	public String execute() throws Exception {
		for (User user : users) {
			System.out.println("Name:"+user.getName()+" Age:"+user.getAge()+" Tel:"+user.getTel());
		}
		
		return SUCCESS;
	}
}
