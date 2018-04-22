package com.action;


import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	private String tel;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		if(!getName().equals("tom"))
		{
			throw new SecurityException("wrong name!!!!!!");
			
		}
		else if(!getAge().equals("20"))
		{
			throw new Exception("wrong age!!!!!");
		}
		else if(!getTel().equals("15202208200"))
		{
			throw new java.sql.SQLException();
		}
		else
		{
		    return SUCCESS;	
		}
	}

}
