package com.createiq.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.createiq.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Map<Integer, Employee> map = null;

	{
		map = new HashMap<Integer, Employee>();
		map.put(1001, new Employee(1001, "Balaji", 20000.00));
		map.put(1002, new Employee(1002, "Raja", 20000.00));
		map.put(1003, new Employee(1003, "Roy", 20000.00));
		map.put(1004, new Employee(1004, "Joy", 20000.00));
	}

	public List<Employee> findAll() {
		return new ArrayList<Employee>(map.values());
	}

	public Employee findById(int eid) {
		return null;
	}

	public void add(Employee employee) {
        map.put(employee.getEid(), employee);
	}

	public void update(Employee employee) {

	}

	public void delete(int eid) {

	}

}
