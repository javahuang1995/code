package com.action;

import com.opensymphony.xwork2.ActionSupport;
public class FirstAliasAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String firstCountry;
	public String getFirstCountry() {
		return firstCountry;
	}
	public void setFirstCountry(String firstCountry) {
		this.firstCountry = firstCountry;
	}
	@Override
	public String execute() throws Exception {
		
		 System.out.println("the value of firstCountry is "+firstCountry);  
		return SUCCESS;
	}
}
