package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "findAll";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	
	
	@RequestMapping(value = "/addEmp",method = RequestMethod.POST)
	public String addEmp(Employee employee) {
		System.out.println(employee);
		employeeService.add(employee);
		return "redirect:/findAll";
	}

}
