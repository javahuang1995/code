package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//province属性
	private String province;
	//city属性
	private String city;
	//各个属性的getter和setter方法
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	//重写execute方法
	public String execute() throws Exception {
		//返回success
		return SUCCESS;
	}
}
