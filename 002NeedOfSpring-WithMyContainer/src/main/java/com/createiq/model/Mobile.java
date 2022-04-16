package com.createiq.model;

import com.createiq.util.MyContainer;

public class Mobile {
	
	public static void main(String[] args) {
		
		MyContainer myContainer = new MyContainer("beans.properties");
		Network network = (Network) myContainer.getBean("network");
		network.calls();
		network.data();
		network.sms();
	}

}
