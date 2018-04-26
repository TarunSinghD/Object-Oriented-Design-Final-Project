package com.leave.model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Manager extends User {
	private ArrayList<LeaveApplication> empLeaveRequestQ;
	private int managerID;
	private ArrayList<Employee> empList;
	
	public ArrayList<LeaveApplication> viewLeaveRequest() {
		if (this.empLeaveRequestQ == null)
		{
			this.empLeaveRequestQ = new ArrayList<LeaveApplication>();
		
		}
		
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.leave_application");
			//this.empLeaveRequestQ.clear();
			while(rs.next())
			{	
				//if (rs.getInt(1) == this.employeeID)
				{
					LeaveApplication leaveApplication = new LeaveApplication();
					leaveApplication.setAttributes(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
					this.empLeaveRequestQ.add(leaveApplication);
				//System.out.println("Inside HR Class");
				//emp.printUserDetails();
				}
			}
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
		return empLeaveRequestQ;
		
	}
	
	public boolean approveLeaveRequest(int applicationID, String status) {
		try {
			System.out.println("status");
            System.out.println(status);
			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.leave_application");
			while(rs.next())
			{	
				if (rs.getInt(2) == applicationID && status.equals("Approve"))
				{
					String sql = "UPDATE `employee`.`leave_application` SET `status`='approved' WHERE `applicationID`=?";

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
	
	public boolean denyLeaveRequest(int applicationID,String status) {
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.leave_application");
			while(rs.next())
			{	
				if (rs.getInt(2) == applicationID && status.equals("Deny"))
				{
					String sql = "UPDATE `employee`.`leave_application` SET `status`='Denied' WHERE `applicationID`=?";

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
	
	public int getManagerID() {
		
		return managerID;
	}
	
	public void setManagerID(int managerID) {
		
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("Manager!!!!!!!!!");
		printUserDetails();
		try
		{
			response.sendRedirect("/LeaveManagement/JSP/Manager.jsp");
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
		
	}

}
