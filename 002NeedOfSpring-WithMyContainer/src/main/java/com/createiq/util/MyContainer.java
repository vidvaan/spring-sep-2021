package com.createiq.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyContainer {

	private String fileName;

	Properties properties = null;

	public MyContainer(String fileName) {
		super();
		this.fileName = fileName;
		properties = new Properties();
		try {
			InputStream is = MyContainer.class.getClassLoader().getResourceAsStream(fileName);
			properties.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String beanName) {

		try {
			Class clz = Class.forName(properties.getProperty(beanName));
			return clz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return fileName;

	}
	
	

}
