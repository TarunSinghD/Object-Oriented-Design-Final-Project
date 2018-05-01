package com.leave.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// user factory design pattern
public class UserFactory {

	//create an object based on the roleType passed at run time 
	public User createUser(String roleType, int empid, String password, String name)
	{
		System.out.println("Creating User");
		User user = new Employee();
		
		if (roleType.equals("Employee"))
		{
			user = new Employee();
		}
		
		else if (roleType.equals("HR"))
		{
			System.out.println("Creating HR");
			user = HR.getInstance();
		}
		
		else if (roleType.equals("Manager"))
		{
			user = new Manager(getLeaveApplications(), empid, password, name, roleType);
		}

		return user;
	}

	public ArrayList<LeaveApplication> getLeaveApplications()
	{
			ArrayList<LeaveApplication> leaveRequests = new ArrayList<LeaveApplication>();
		
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
					leaveRequests.add(leaveApplication);
				}
			}
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
		return leaveRequests;
	}
}
