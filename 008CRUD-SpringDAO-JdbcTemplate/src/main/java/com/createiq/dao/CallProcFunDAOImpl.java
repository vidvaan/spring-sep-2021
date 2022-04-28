package com.createiq.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

@Repository
public class CallProcFunDAOImpl implements CallProcFunDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int callAdditionFunction(int num1, int num2) {
		try {
			CallableStatement callableStatement = jdbcTemplate.getDataSource().getConnection()
					.prepareCall("{? = call addition(?,?)}");
			callableStatement.setInt(2, num1);
			callableStatement.setInt(3, num2);
			callableStatement.registerOutParameter(1, Types.INTEGER);
			callableStatement.executeUpdate();
			return callableStatement.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Map<String, Integer> callCalProc(int num1, int num2) {

		List paramList = new ArrayList();
		paramList.add(new SqlParameter(Types.INTEGER));
		paramList.add(new SqlParameter(Types.INTEGER));
		paramList.add(new SqlOutParameter("Sum", Types.INTEGER));
		paramList.add(new SqlOutParameter("Sub", Types.INTEGER));

		return jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement callableStatement = con.prepareCall("{call cal(?, ?, ?, ?)}");
				callableStatement.setInt(1, num1);
				callableStatement.setInt(2, num2);
				callableStatement.registerOutParameter(3, Types.INTEGER);
				callableStatement.registerOutParameter(4, Types.INTEGER);
				return callableStatement;
			}
		}, paramList);
	}

}
