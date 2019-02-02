package cn.it.shop.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("helloAction")
@Scope("prototype")
public class HelloAction {
	private static final Logger logger = LoggerFactory.getLogger(HelloAction.class);

	public String hello() {
		logger.info("hello,this is a test hello action");
		return "index";
	}

}
