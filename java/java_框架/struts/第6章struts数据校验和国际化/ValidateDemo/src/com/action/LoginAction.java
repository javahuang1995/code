package com.action;
import com.opensymphony.xwork2.ActionSupport;
public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//name属性
	private String name;
	//age属性
	private int age;
	//tel属性
	private String tel;
	//name属性getter方法
	public String getName() {
		return name;
	}
	//name属性setter方法
	public void setName(String name) {
		this.name = name;
	}
	//age属性getter方法
	public int getAge() {
		return age;
	}
	//age属性setter方法
	public void setAge(int age) {
		this.age = age;
	}
	//tel属性getter方法
	public String getTel() {
		return tel;
	}
	//tel属性setter方法
	public void setTel(String tel) {
		this.tel = tel;
	}
	//重载execute方法
	public String execute() throws Exception {
		return "hello";
	}
	//log方法，Action调用的method方法
	public String log()throws Exception{
		System.out.println("log");
		return "hello";
	}
	//校验方法
	public void validate() {
		System.out.println("validate");
	}
	//log method的校验方法
    public void validateLog(){
    	System.out.println("validatelog");
    	//age值必须在10-30之间
    	if(age<10||age>30)
    	{
    		addFieldError("age", "age must be from 10 to 30!");
    	}
    }
}
