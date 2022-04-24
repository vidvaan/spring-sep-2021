package com.createiq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;
import com.createiq.template.CreateIqTemplate;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private CreateIqTemplate createIqTemplate;

	public void save(Employee employee) {

		createIqTemplate.update("INSERT INTO EMPLOYEE VALUES(?,?,?)",
				new Object[] { employee.getEid(), employee.getEname(), employee.getEsal() });
	}

	public void update(Employee employee) {
		createIqTemplate.update("UPDATE EMPLOYEE SET ENAME  = ?, ESAL = ? WHERE EID = ?",
				new Object[] { employee.getEname(), employee.getEsal(), employee.getEid() });
	}

	public void delete(int eid) {
		createIqTemplate.update("DELETE FROM EMPLOYEE WHERE EID = ?", new Object[] { eid });
	}

}
