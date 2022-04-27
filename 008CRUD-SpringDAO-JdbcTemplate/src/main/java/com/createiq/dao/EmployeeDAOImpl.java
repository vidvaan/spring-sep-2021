package com.createiq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.createiq.mappers.EmployeeRowMapper;
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

	// public List<Employee> findAll() {
	// return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new
	// BeanPropertyRowMapper<Employee>(Employee.class));
	// }

	// public List<Employee> findAll() {
	// return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new RowMapper<Employee>()
	// {
	// public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	// Employee employee = new Employee();
	// employee.setEid(rs.getInt("eid"));
	// employee.setEname(rs.getString("ename"));
	// employee.setEsal(rs.getDouble("esal"));
	// return employee;
	// }
	// });
	// }

	// public List<Employee> findAll() {
	// return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());
	// }

	// public List<Employee> findAll() {
	// return jdbcTemplate.query("SELECT * FROM EMPLOYEE", (rs,rowNum) -> {
	// Employee employee = new Employee();
	// employee.setEid(rs.getInt("eid"));
	// employee.setEname(rs.getString("ename"));
	// employee.setEsal(rs.getDouble("esal"));
	// return employee;
	// });
	// }

	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM EMPLOYEE", new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> employees = new ArrayList<Employee>();
				while (rs.next()) {

					Employee employee = new Employee();
					employee.setEid(rs.getInt("eid"));
					employee.setEname(rs.getString("ename"));
					employee.setEsal(rs.getDouble("esal"));
					employees.add(employee);
				}
				return employees;
			}
		});
	}

	public Employee findById(int eid) {
		return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE EID = ?", new Object[] { eid },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
