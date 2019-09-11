package com.cg.jdbc.ems.dao;
import java.util.List;

import com.cg.jdbc.ems.exception.EmployeeException;
import com.cg.jdbc.ems.model.Employee;
//import com.cg.jdbc.ems.Exception.*;
public interface IEmployeeDao {

	public  Employee addEmployee(Employee employee) throws EmployeeException, EmployeeException;
	public List<Employee> showEmployee() throws EmployeeException;
	
}
