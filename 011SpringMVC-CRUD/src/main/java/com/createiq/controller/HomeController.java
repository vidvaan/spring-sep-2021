package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createiq.service.GetNameService;

@Controller
public class HomeController {
	
	@Autowired
	private GetNameService getNameService;
	
	
	
	@RequestMapping("/")
	public String welcome() {
		return "home";
	}

}
