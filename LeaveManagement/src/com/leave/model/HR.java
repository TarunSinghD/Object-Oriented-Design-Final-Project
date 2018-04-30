package com.leave.model;
import java.sql.*;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.ISourceMethod;

public class HR extends User  {


	private ArrayList<LeaveApplication> hrLeaveAprrovalQ;
	private ArrayList<Employee> empList;

	private static HR hr=null;
	
	private HR() {
		
	}
	public static HR getInstance() {
		if(hr == null)
			hr = new HR();
		return hr;
	}
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
		
		this.empList.clear();
		{
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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.user");
			while(rs.next())
			{	
				if (rs.getInt(1) == employeeID)
				{
					String sql = "DELETE FROM employee.user WHERE employeeID=?";
					String sql1 = "DELETE FROM employee.leave_balance WHERE employeeID=?";
					String sql2 = "DELETE FROM employee.leave_application WHERE empID=?";

					PreparedStatement preparedStatement = con.prepareStatement(sql);
					PreparedStatement preparedStatement1 = con.prepareStatement(sql1);
					PreparedStatement preparedStatement2 = con.prepareStatement(sql2);
					preparedStatement.setInt(1, employeeID);
					preparedStatement1.setInt(1, employeeID);
					preparedStatement2.setInt(1, employeeID);

					 
					preparedStatement1.executeUpdate(); 
					preparedStatement2.executeUpdate(); 
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