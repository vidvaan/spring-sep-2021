package com.createiq.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		Network network = (Network) applicationContext.getBean("network");
		network.calls();
		network.data();
		network.sms();
	}

}
