package com.huang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/success")
	public ModelAndView success(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("huang", "jjjjj");
		mv.setViewName("success");
		logger.info("hihihihihihihihihi");
		return mv;
	}
}
