package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@Controller
@RequestMapping("/rest")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/findAll")
	public @ResponseBody List<Employee> findAll() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}
	
	@RequestMapping("/findById/{eid}")
	public @ResponseBody Employee findById(@PathVariable("eid") int eid) {
		return employeeService.findById(eid);
	}
	


	@RequestMapping(value = "/addEmp",method = RequestMethod.POST)
	public @ResponseBody String saveEmp(@RequestBody Employee employee) {
		System.out.println(employee);
		employeeService.add(employee);
		return "Inserted Successfully";
	}
	
//	@RequestMapping("/updateEmp")
//	public String updateEmp(@RequestParam int eid,Model model) {
//		Employee employee = employeeService.findById(eid);
//		model.addAttribute(employee);
//		return "updateEmp";
//	}
//	
//	
//	@RequestMapping(value = "/updateEmp",method = RequestMethod.POST)
//	public String updateEmp(Employee employee) {
//		employeeService.update(employee);
//		return "redirect:/findAll";
//	}
//	
//	@RequestMapping("/deleteEmp")
//	public String delteEmp(@RequestParam int eid) {
//	    employeeService.delete(eid);
//		return "redirect:/findAll";
//	}
	
	

}
