package com.createiq.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		Employee employee = (Employee) ac.getBean("employee");
		
		System.out.println(employee);
	}

}
