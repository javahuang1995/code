package com.huang.redis.test;

import java.io.Serializable;

public class MyUser implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;

	public MyUser(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "name:"+this.name + "sex："+this.sex;
	}
}