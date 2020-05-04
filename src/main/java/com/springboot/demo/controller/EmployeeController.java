package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.entity.Employee;
import com.springboot.demo.modelrequest.EmployeeModelRequest;
import com.springboot.demo.modelresponse.EmployeeModelResponse;
import com.springboot.demo.service.EmployeeService;


@RestController
@RequestMapping("/")
public class EmployeeController {
	private EmployeeService employeeService;
	private List<Employee> employeeList;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//@GetMapping("/getall")
	@RequestMapping(method = RequestMethod.GET, value = "/getall")
	public ModelAndView findAll(Model theModel) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		ModelAndView modelAndView = new ModelAndView();
		modelResponse = employeeService.findAll();
		employeeList = modelResponse.getEmployeeList();		
		theModel.addAttribute("employees",employeeList);
		modelAndView.setViewName("employees/employeelist");
		return modelAndView;
	}
	
	@GetMapping("/showFormForAdd")
	public ModelAndView showFormForAdd(Model theModel) {
		ModelAndView modelAndView = new ModelAndView();
		Employee theEmployee = new Employee();
		EmployeeModelRequest modelRequest = new EmployeeModelRequest();
		theModel.addAttribute("modelRequest",modelRequest);
		modelAndView.setViewName("employees/employee-form");
		return modelAndView;
	}
	
	@PostMapping("/createemployee")
	public ModelAndView addEmployee(@ModelAttribute("modelRequest") EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		ModelAndView modelAndView = new ModelAndView();
		modelResponse = employeeService.addEmployee(modelRequest);
		modelAndView.setViewName("redirect:/getall");
		return modelAndView;
	}
	
	@PutMapping("/updateemployeebyid")
	public EmployeeModelResponse updateEmployee(@Valid @RequestBody EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeService.updateEmployee(modelRequest);
		return modelResponse;
	}
	
	@DeleteMapping("/deleteemployee")
	public EmployeeModelResponse deleteEmployee(@Valid @RequestBody EmployeeModelRequest modelRequest) {
		EmployeeModelResponse modelResponse = new EmployeeModelResponse();
		modelResponse = employeeService.deleteEmployee(modelRequest);
		return modelResponse;
	}
	
	
	
}
