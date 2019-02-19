package com.huang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/hello")
	public ModelAndView success(Model model){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		
		
		mv.addObject("girl","菲菲");
		model.addAttribute("size", "D罩杯");
		logger.info("hihihihihihihihihi");
		return mv;
	}
}
