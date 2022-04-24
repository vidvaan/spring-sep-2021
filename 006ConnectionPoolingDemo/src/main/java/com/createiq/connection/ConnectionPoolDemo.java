package com.createiq.connection;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPoolDemo {
	
	public static void main(String[] args) throws PropertyVetoException, SQLException {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setMaxActive(100);
		System.out.println("Basic Data Source"+basicDataSource.getConnection());
		
		
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcdemo");
		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		System.out.println("C3po Data Source"+comboPooledDataSource.getConnection());
	}

}
