package com.leave.model;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
public class Manager extends User {
	private ArrayList<LeaveApplication> empLeaveRequestQ;
	private int managerID;
	private ArrayList<Employee> empList;
	public ArrayList<LeaveApplication> viewLeaveRequest() {
		return empLeaveRequestQ;
		
	}
	
	public void approveLeaveRequest() {
		
	}
	
	public void denyLeaveRequest() {
		
	}
	
	public int getManagerID() {
		
		return managerID;
	}
	
	public void setManagerID(int managerID) {
		
	}
	
	public void handleRequest(HttpServletResponse response)
	{
		
	}

}
