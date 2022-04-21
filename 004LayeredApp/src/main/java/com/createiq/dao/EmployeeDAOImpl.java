package com.createiq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;
import com.createiq.util.ConnectionUtil;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	//@Qualifier("connectionUtil1")
	private ConnectionUtil connectionUtil;
	
	public void save(Employee employee) {
		System.out.println("Employee DAO Save Called ");
		connectionUtil.getConnection();
	}

}
