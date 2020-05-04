package com.springboot.demo.service;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.demo.dao.EmployeeDAO;
import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	@Override
	public EmployeeModelResponse findAll() {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.findAll();
		return modelResponse;
	}

	@Override
	public EmployeeModelResponse addEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.addEmployee(modelRequest);
		modelResponse.setErrorDec("Employee added");
		return modelResponse;
	}

	@Override
	public EmployeeModelResponse updateEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeDAO.updateEmployee(modelRequest);
		if(modelResponse.getErrorDec()==null) {
			modelResponse.setErrorDec("Employee Updated");
			return modelResponse;
		}
	
		return modelResponse;
		
	}

	@Override
	public EmployeeModelResponse deleteEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse =	employeeDAO.deleteEmployee(modelRequest);
		return modelResponse;
	}

	@Override
	public Employee findById(int employeeId) {
		Employee employee = employeeDAO.findById(employeeId);
		return employee;
	}

}
