package com.springboot.demo.modelresponse;

import java.util.List;

import com.springboot.demo.entity.Employee;

public class EmployeeModelResponse {

	private String errorDec;
	private Employee employee;
	private List<Employee> employeeList;
	
	public EmployeeModelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeModelResponse(String errorDec, Employee employee, List<Employee> employeeList) {
		super();
		this.errorDec = errorDec;
		this.employee = employee;
		this.employeeList = employeeList;
	}

	public String getErrorDec() {
		return errorDec;
	}

	public void setErrorDec(String errorDec) {
		this.errorDec = errorDec;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "EmployeeModelResponse [errorDec=" + errorDec + ", employee=" + employee + ", employeeList="
				+ employeeList + "]";
	}
	
	
}
