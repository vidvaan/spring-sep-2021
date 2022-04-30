package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.createiq.service.GetNameService;

@Controller
public class HomeController {
	
	@Autowired
	private GetNameService getNameService;
	
	@RequestMapping("/sayHello")
	public ModelAndView hello() {
		String name = getNameService.getName();
		return new ModelAndView("hello", "name", name);
	}
	
	@RequestMapping("/saywelcome")
	public ModelAndView welcome() {
		String name = getNameService.getName();
		return new ModelAndView("welcome", "name", name);
	}

}
