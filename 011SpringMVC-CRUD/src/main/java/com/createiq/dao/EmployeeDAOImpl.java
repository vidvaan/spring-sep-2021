package com.createiq.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Employee> findAll() {
		return (List<Employee>) hibernateTemplate.find("from Employee");
	}

	public Employee findById(int eid) {
		return hibernateTemplate.get(Employee.class, eid);
	}

	public void add(Employee employee) {
          hibernateTemplate.save(employee);	
	}

	public void update(Employee employee) {
		hibernateTemplate.update(employee);
	}

	public void delete(int eid) {
		   Employee employee = new Employee();
		   employee.setEid(eid);
           hibernateTemplate.delete(employee);		
	}

	

}
