package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//name����
	private String name;
	//age����
	private int age;
	//tel����
	private String tel;
	//name����getter����
	public String getName() {
		return name;
	}
	//name����setter����
	public void setName(String name) {
		this.name = name;
	}
	//age����getter����
	public int getAge() {
		return age;
	}
	//age����setter����
	public void setAge(int age) {
		this.age = age;
	}
	//tel����getter����
	public String getTel() {
		return tel;
	}
	//tel����setter����
	public void setTel(String tel) {
		this.tel = tel;
	}
	//����execute����
	public String execute() throws Exception {
		return "hello";
	}
	//log������Action���õ�method����
	public String log()throws Exception{
		System.out.println("log");
		return "hello";
	}
	
}
