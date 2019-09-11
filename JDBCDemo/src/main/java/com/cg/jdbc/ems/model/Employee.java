package com.cg.jdbc.ems.model;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Employee {
private BigInteger empId;
private String empName;
private BigDecimal empSalary;


	@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empSalary == null) ? 0 : empSalary.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empSalary == null) {
			if (other.empSalary != null)
				return false;
		} else if (!empSalary.equals(other.empSalary))
			return false;
		return true;
	}


	public BigInteger getEmpId() {
	return empId;
}


public void setEmpId(BigInteger empId) {
	this.empId = empId;
}


public String getEmpName() {
	return empName;
}


public void setEmpName(String empName) {
	this.empName = empName;
}


public BigDecimal getEmpSalary() {
	return empSalary;
}


public void setEmpSalary(BigDecimal empSalary) {
	this.empSalary = empSalary;
}


	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
