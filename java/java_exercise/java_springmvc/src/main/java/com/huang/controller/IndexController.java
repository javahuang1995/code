package com.huang.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping("/index")
	public String index(){
		LOG.info("wori");
		return "index";
	}
	
	
	@RequestMapping("/form")
	public String form(){
		LOG.info("wori");
		return "form";
	}
	
	@RequestMapping("/send")
	public String send(@RequestParam("name") String name,@RequestParam("password") String password,Model model){
		LOG.info(name+password);
		model.addAttribute("name","名字是"+name);
		model.addAttribute("password","密码是"+password);
		
		return "send";
	}
	
	@RequestMapping("/sendAjax")
	@ResponseBody
	public List<String> sendAjax(@RequestBody InfoTest info){
		List<String> result = new ArrayList<String>();
		result.add(info.getName());
		result.add(info.getPassword());
		return result;
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public List<String> json(){
		List<String> result = new ArrayList<String>();
		result.add("ddddd");
		result.add("xxx");
		return result;
	}
	
	


}
