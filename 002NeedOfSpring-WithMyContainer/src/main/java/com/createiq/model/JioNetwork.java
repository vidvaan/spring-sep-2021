package com.createiq.model;

public class JioNetwork implements Network {
	public void sms() {
		System.out.println("JIO SMS");
	}

	public void data() {
		System.out.println("JIO Data");
	}

	public void calls() {
		System.out.println("JIO Calls");
	}
}
