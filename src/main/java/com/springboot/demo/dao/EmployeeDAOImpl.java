package com.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public EmployeeModelResponse findAll() {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employeeList = query.getResultList();
		modelResponse.setEmployeeList(employeeList);
		return modelResponse;
	}

	@Override
	@Transactional
	public EmployeeModelResponse addEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		Employee employee = new Employee();
		employee.setFirstName(modelRequest.getFirstName());
		employee.setLastName(modelRequest.getLastName());
		employee.setEmail(modelRequest.getEmail());
		
		entityManager.merge(employee);
		
		return modelResponse;
	}

	@Override
	@Transactional
	public EmployeeModelResponse updateEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		Employee employee = new Employee();
		employee = entityManager.find(Employee.class, modelRequest.getEmployeeId());
	
		if(employee!=null) {
			employee.setFirstName(modelRequest.getFirstName());
			employee.setLastName(modelRequest.getLastName());
			employee.setEmail(modelRequest.getEmail());
			employee = entityManager.merge(employee);
			return modelResponse;
		}
		modelResponse.setErrorDec("Employee not found");
		return modelResponse;
	}

	@Override
	@Transactional
	public EmployeeModelResponse deleteEmployee(EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		
		try {
			Employee employee = entityManager.find(Employee.class, modelRequest.getEmployeeId());
			entityManager.remove(employee);
			modelResponse.setErrorDec("Employee removed");
			return modelResponse;
		} catch (Exception e) {
			// TODO: handle exception
		}
		modelResponse.setErrorDec("Employee removel failed");
		return modelResponse;
	}

	@Override
	@Transactional
	public Employee findById(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}

}
