package com.createiq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Employee employee) {

		jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?)",
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsal() });
	}

	public void update(Employee employee) {
		jdbcTemplate.update("UPDATE EMPLOYEE SET ENAME  = ?, ESAL = ? WHERE EID = ?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });
	}

	public void delete(int eid) {
		jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE EID = ?", new Object[] { eid });
	}

}
