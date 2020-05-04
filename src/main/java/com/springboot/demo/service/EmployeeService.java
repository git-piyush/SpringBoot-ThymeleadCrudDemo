package com.springboot.demo.service;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

public interface EmployeeService {

	public EmployeeModelResponse findAll();
	public EmployeeModelResponse addEmployee(EmployeeModelRequest modelRequest);
	public EmployeeModelResponse updateEmployee(EmployeeModelRequest modelRequest);
	public EmployeeModelResponse deleteEmployee(EmployeeModelRequest modelRequest);
	public Employee findById(int employeeId);
}
