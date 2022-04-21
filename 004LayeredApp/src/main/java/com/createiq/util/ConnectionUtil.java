package com.createiq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionUtil {
	
	@Value("${driver}")
	private String driver;
	@Value("${url}")
	private String url;
	@Value("${uname}")
	private String uname;
	@Value("${pass}")
	private String password;
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public void getConnection() {
		System.out.println(url+" "+driver+" "+uname+" "+password);
	}
	
	
	

}
