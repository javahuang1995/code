package com.huang.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("helloAction")
@Scope("prototype")
public class HelloAction {
	private static final Logger logger = LoggerFactory.getLogger(HelloAction.class);
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Logger getLogger() {
		return logger;
	}
	public String hello() {
		logger.info("hello,this is a study hello action");
		return "index";
	}

}
