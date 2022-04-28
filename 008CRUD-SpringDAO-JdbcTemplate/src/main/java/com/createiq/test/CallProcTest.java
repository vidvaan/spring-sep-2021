package com.createiq.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.config.SpringConfig;
import com.createiq.controller.CallProcFunController;
import com.createiq.controller.EmployeeController;
import com.createiq.dao.EmployeeDAOImpl;
import com.createiq.model.Employee;

public class CallProcTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		CallProcFunController callProcFunController = (CallProcFunController) applicationContext.getBean("callProcFunController");
//	    int result = callProcFunController.callAdditionFunction(12, 23);
//	    System.out.println("Result : "+result);
		
		
		Map<String, Integer> results = callProcFunController.callCalProc(13, 12);
		
		System.out.println("Sum : "+results.get("Sum"));
		System.out.println("Sub : "+results.get("Sub"));
	
	}

}
