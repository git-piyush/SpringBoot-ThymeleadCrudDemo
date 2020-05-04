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
	int theEmployeId;
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
	
	@GetMapping("/showFormForUpdate")
	public ModelAndView showFormForUpdate(@ModelAttribute("modelRequest") EmployeeModelRequest modelRequest, Model theModel) {
		ModelAndView modelAndView = new ModelAndView();
		theEmployeId = modelRequest.getEmployeeId();
		Employee employee = employeeService.findById(modelRequest.getEmployeeId());
		System.out.println("s");
		theModel.addAttribute("modelRequest",employee);
		modelAndView.setViewName("employees/employee-update-form");
		return modelAndView;
	}
	
	@PostMapping("/updateemployeebyid")
	public ModelAndView updateEmployee(@ModelAttribute("modelRequest") EmployeeModelRequest modelRequest, Model theModel) {
		ModelAndView modelAndView = new ModelAndView();
		modelRequest.setEmployeeId(theEmployeId);
		employeeService.updateEmployee(modelRequest);
		modelAndView.setViewName("redirect:/getall");
		return modelAndView;
	}
	
	
	@GetMapping("/deleteemployee")
	public ModelAndView deleteEmployee(@ModelAttribute("modelRequest") EmployeeModelRequest modelRequest, Model theModel) {
		ModelAndView modelAndView = new ModelAndView();
		employeeService.deleteEmployee(modelRequest);
		modelAndView.setViewName("redirect:/getall");
		return modelAndView;
	}
	
	
	
}
