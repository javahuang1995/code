package com.action;

import com.opensymphony.xwork2.ActionSupport;
public class SecondAliasAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String secondCountry;
	
	public String getSecondCountry() {
		return secondCountry;
	}

	public void setSecondCountry(String secondCountry) {
		this.secondCountry = secondCountry;
	}

	@Override
	public String execute() throws Exception {
		
		 System.out.println("the value of secondCountry is "+secondCountry);  
		return SUCCESS;
	}
}
