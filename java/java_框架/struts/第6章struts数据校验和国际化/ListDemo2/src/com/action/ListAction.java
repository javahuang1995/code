package com.action;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
public class ListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//List���ͣ�ûָ��Ԫ������
	private List users;
	//getter����
     public List getUsers() {
		return users;
	}
     //setter����
	public void setUsers(List users) {
		this.users = users;
	}
	//����execute����
	public String execute() throws Exception {
		return SUCCESS;
	}
}
