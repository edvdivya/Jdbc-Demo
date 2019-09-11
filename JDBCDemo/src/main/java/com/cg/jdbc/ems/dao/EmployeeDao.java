package com.cg.jdbc.ems.dao;

import java.math.BigInteger;
import java.sql.Connection;
import com.cg.jdbc.ems.exception.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.jdbc.ems.exception.EmployeeException;
import com.cg.jdbc.ems.model.Employee;
import com.cg.jdbc.ems.util.DBUtil;

public class EmployeeDao implements IEmployeeDao {
	private static Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	static {
		try {
			connection = DBUtil.getConnection();
		} catch (MyException e) {
			System.out.println("Connection not obtained at Employee dao");
		}
	}

	public Employee addEmployee(Employee employee) throws EmployeeException {
		String sql = "Insert into my_emp(emp_name,emp_sal) values(?,?)";
		try {
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, employee.getEmpName());
			ps.setBigDecimal(2, employee.getEmpSalary());
			int noOfRec = ps.executeUpdate();
			BigInteger generatedId = BigInteger.valueOf(0L);
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				generatedId = BigInteger.valueOf(rs.getLong(1));
				 System.out.println("Auto generated Id " + generatedId);
			}
		//setting the auto-generated Id to current emp obj
			employee.setEmpId(generatedId);
		} catch (SQLException e) {
			System.out.println(" Error at addEmployee Dao method : " + e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(" 2nd Error at addEmployee Dao method : " + e);
				}
			}
		}
		return employee;
	}

	public List<Employee> showEmployee() throws EmployeeException {
		String sql = "Select * from my_emp";
		List<Employee> empList = new ArrayList<Employee>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(BigInteger.valueOf(rs.getLong("emp_id")));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpSalary(rs.getBigDecimal("emp_sal"));
			}
		} catch (SQLException e) {
			System.out.println("Exception occured at showEmployee dao method: "+e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e1) {
					System.out.println(" 2nd Error at list employee dao method");
				}
			}

			return empList;
		}
	}
}
