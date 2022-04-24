package com.createiq.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = "com.createiq")
@PropertySource(value = { "db.properties" })
public class SpringConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("driver"));
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername(env.getProperty("uname"));
		dataSource.setPassword(env.getProperty("pass"));
		return dataSource;
	}
}
