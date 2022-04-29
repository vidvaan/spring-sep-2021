package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;
@Service
public  class EmployeeServiceImpl implements EmployeeService {
     @Autowired
	private EmployeeDAO employeeDAO;

	

	public void save(Employee employee) {
		System.out.println("Employee Service Save Called....");
		employeeDAO.save(employee);
	}



	public void update(Employee employee) {
		employeeDAO.update(employee);
	}



	public void delete(int eid) {
		employeeDAO.delete(eid);
	}



	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}



	public Employee findById(int eid) {
		return employeeDAO.findById(eid);
	}

}
