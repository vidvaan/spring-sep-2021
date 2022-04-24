package com.createiq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private DataSource dataSource;

	public void save(Employee employee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?)");
			preparedStatement.setInt(1, employee.getEid());
			preparedStatement.setString(2, employee.getEname());
			preparedStatement.setDouble(3, employee.getEsal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void update(Employee employee) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE EMPLOYEE SET ENAME = ?, ESAL = ? WHERE EID = ?");
			preparedStatement.setInt(3, employee.getEid());
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setDouble(2, employee.getEsal());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void delete(int eid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE EID = ?");
			preparedStatement.setInt(1, eid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					connection.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
