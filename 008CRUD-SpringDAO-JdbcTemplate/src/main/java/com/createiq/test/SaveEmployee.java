package com.createiq.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.config.SpringConfig;
import com.createiq.controller.EmployeeController;
import com.createiq.model.Employee;

public class SaveEmployee {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeController employeeController = (EmployeeController) applicationContext.getBean("employeeController");
		employeeController.save(new Employee(1005,"Prasad",20000.00));
	}

}
