package com.leave.model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.*;


import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Employee extends User implements Observer {
	private ArrayList<LeaveApplication> empLeaveRequestQ;
	private LeaveBalance empLeaveBalance;
	
	
	public ArrayList<LeaveApplication> getEmpLeaveRequestQ() {
		return empLeaveRequestQ;
	}


	public void setEmpLeaveRequestQ(ArrayList<LeaveApplication> empLeaveRequestQ) {
		this.empLeaveRequestQ = empLeaveRequestQ;
	}

	
	// This function will be called when user clicks on the apply leave button
	public void applyLeave(String leaveType, String startDate, String endDate) 
	{
		int noOfDays = 0;
		//Create a new object of type leave application
		LeaveApplication leaveApplication = new LeaveApplication();
		
		LocalDate startDate1 = LocalDate.parse(startDate);
		LocalDate endDate1 = LocalDate.parse(endDate);
		noOfDays = (int)startDate1.until(endDate1, ChronoUnit.DAYS);
		
		System.out.println("Employee::applyLeave::NoOfDays=" + noOfDays);
		
		leaveApplication.createLeaveApp(this.getEmployeeID(), startDate, endDate, leaveType, noOfDays);
		
		//empLeaveRequestQ.add(leaveApplication);		
	}
	
	
	public void checkLeaveBalance(String leaveType) {
		
		// Get the leave balance from leave balance class
		empLeaveBalance.viewLeaveBalance(leaveType);		
		//Need to display this on the web page
	
	}
	
	
	public ArrayList<LeaveApplication> viewApplications() {
		
		if (this.empLeaveRequestQ == null)
		{
			this.empLeaveRequestQ = new ArrayList<LeaveApplication>();
		
		}
		
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			//select all from leave_application table
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.leave_application");
			this.empLeaveRequestQ.clear();
			while(rs.next())
			{	
				if (rs.getInt(1) == this.employeeID)
				{
					LeaveApplication leaveApplication = new LeaveApplication();
					leaveApplication.setAttributes(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
					this.empLeaveRequestQ.add(leaveApplication);

				}
			}
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
		
		// Fetch and return Leave Application Status
		return empLeaveRequestQ;
	}
	
	public boolean cancelLeave(int applicationID) {
		
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.leave_application");
			while(rs.next())
			{	
				if (rs.getInt(2) == applicationID)
				{
					//update in database when employee cancel the leave
					String sql = "UPDATE `employee`.`leave_application` SET `status`='Cancelled' WHERE `applicationID`=?";

					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setInt(1, applicationID);

					preparedStatement.executeUpdate(); 
					return true;
				}
			}
			
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
		
		return false;	
	}
	
	public void updateLeaveRequest(LeaveApplication updatedleaveApplication) {
		
		for (LeaveApplication leaveApplication : empLeaveRequestQ)
		{
			// Check for the required Leave Application by matching the ID
			if (leaveApplication.getApplicationID() == updatedleaveApplication.getApplicationID())
			{
				leaveApplication.setLeaveType(updatedleaveApplication.getLeaveType());
				leaveApplication.setNoOfDays(updatedleaveApplication.getNoOfDays());
				leaveApplication.setApplicationStatus(updatedleaveApplication.getApplicationStatus());
			}
		}
		
	}
	
	
	public LeaveBalance getLeaveBalance() {
		return empLeaveBalance;
	}
		
	//conncetion to servlet when employee login
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("Employee!!!!!!!!!");
		printUserDetails();
		try
		{
			request.setAttribute("Employee", this);
			request.getRequestDispatcher("/JSP/Employee.jsp").forward(request, response); 
			//response.sendRedirect("/LeaveManagement/JSP/Employee.jsp");
		}
		catch (ServletException se)
		{
			se.printStackTrace();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
	}
	
	public void update(LeaveApplication leaveApplication)
	{
		
	}
	
}
