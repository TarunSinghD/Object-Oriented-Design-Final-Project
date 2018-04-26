package com.leave.model;
import java.sql.*;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HR extends User  {

	private ArrayList<LeaveApplication> hrLeaveAprrovalQ;
	private ArrayList<Employee> empList;

	public ArrayList<Employee> viewLeaveApproval() {
		return empList;

	}

	public void updateleaveBalance() {

	}

	public ArrayList<Employee> viewEmployeeDetails() {
		
		if (this.empList == null)
		{
		
			this.empList = new ArrayList<Employee>();
		}
		try {

				// load and register JDBC driver for MySQL
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
				Statement stmt=con.createStatement();
				
				
				
				ResultSet rs=stmt.executeQuery("SELECT * FROM employee.user");
				while(rs.next())
				{	
					Employee emp = new Employee();
					emp.setAttributes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					this.empList.add(emp);
					//System.out.println("Inside HR Class");
					emp.printUserDetails();
				}
			}
		
			catch (Exception exc) {
				System.out.print(exc);
			}
		return this.empList;
	}

	public void addEmployee(Employee emp) {
		
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			
			//stmt.executeQuery("INSERT INTO employee.user (employeeID, username, password) VALUES (7, 'ta', 'emp')");
			String sql = "INSERT INTO employee.user (employeeID, password, name, roleType)" +
			        "VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, emp.getEmployeeID());
			preparedStatement.setString(2, emp.getPassword());
			preparedStatement.setString(3, emp.getName());
			preparedStatement.setString(4, emp.getRoleType());
			preparedStatement.executeUpdate(); 
			
				
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
	}

	public boolean deleteEmployee(int employeeID) {
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","sao!381TsL");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.user");
			while(rs.next())
			{	
				if (rs.getInt(1) == employeeID)
				{
					String sql = "DELETE FROM employee.user WHERE employeeID=?";

					PreparedStatement preparedStatement = con.prepareStatement(sql);
					preparedStatement.setInt(1, employeeID);

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

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("HR!!!!!!!!!");
		printUserDetails();
		try
		{
			response.sendRedirect("/LeaveManagement/JSP/HR.jsp");
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
	}
}