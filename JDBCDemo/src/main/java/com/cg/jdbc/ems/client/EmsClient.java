package com.cg.jdbc.ems.client;

import java.util.List;
import java.math.BigDecimal;
import java.util.EmptyStackException;

import com.cg.jdbc.ems.dao.*;
import com.cg.jdbc.ems.exception.EmployeeException;
import com.cg.jdbc.ems.model.Employee;

public class EmsClient {

	private static IEmployeeDao employeeDao;
	static {
		employeeDao = new EmployeeDao();
	}

	public static void main(String[] args) throws EmployeeException {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		employee.setEmpName("Zara");
		employee.setEmpSalary(BigDecimal.valueOf(9000.0));
		employee = employeeDao.addEmployee(employee);
		List<Employee> empList = employeeDao.showEmployee();
		if (empList != null) {
			empList.forEach(System.out::println);

		} else {
			System.out.println("No record found");
		}
	}

}
