package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	public Employee findById(int eid) {
		return employeeDAO.findById(eid);
	}

	public void add(Employee employee) {
		employeeDAO.add(employee);
	}

	public void update(Employee employee) {
		employeeDAO.update(employee);
	}

	public void delete(int eid) {
		employeeDAO.delete(eid);		
	}

	

}
