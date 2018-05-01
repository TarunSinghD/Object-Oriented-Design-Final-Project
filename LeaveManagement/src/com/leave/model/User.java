package com.leave.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
public abstract class User {

	protected int employeeID;
	private String password;
	private String name;
	private String roleType;
	
	// Methods

	public boolean login(String username, String password) {
		return false;

	}

	public String getPassword() {
		return password;

	}

	public String getName() {
		return name;

	}

	public String getRoleType() {
		return roleType;
		// return null;

	}

	public int getEmployeeID() {
		return employeeID;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoleType(String roletype) {
		this.roleType = roletype;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setAttributes(int employeeID, String password, String name, String roleType) 
	{
		System.out.println("Setting attributes");
		this.setEmployeeID(employeeID);
		this.setPassword(password);
		this.setName(name);
		this.setRoleType(roleType);
	}
	
	public void printUserDetails()
	{
		System.out.println(this.getEmployeeID());
		System.out.println(this.getPassword());
		System.out.println(this.getName());
		System.out.println(this.getRoleType());
	}
	
	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;
	public abstract void update(LeaveApplication leaveApplication);
	
}
