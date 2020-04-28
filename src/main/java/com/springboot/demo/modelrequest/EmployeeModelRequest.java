package com.springboot.demo.modelrequest;

public class EmployeeModelRequest {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String newFirstName;
	private String newLastName;
	private String newEmail;
	public EmployeeModelRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModelRequest(int employeeid, String firstName, String lastName, String email, String newFirstName,
			String newLastName, String newEmail) {
		super();
		this.email = email;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.newFirstName = newFirstName;
		this.newLastName = newLastName;
		this.newEmail = newEmail;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNewFirstName() {
		return newFirstName;
	}
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}
	public String getNewLastName() {
		return newLastName;
	}
	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EmployeeModelRequest [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", newFirstName=" + newFirstName + ", newLastName=" + newLastName + ", newEmail="
				+ newEmail + "]";
	}
	
	
	
	
}
