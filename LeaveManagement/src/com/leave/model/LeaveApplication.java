package com.leave.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class LeaveApplication {
	
	private ArrayList<Manager> subscribers;
	private int employeeID;
    private String leaveType;
    private String startDate;
    private String endDate;
	private int noOfDays;
	private int applicationID ;
	private String applicationStatus;
	public static int applicationCount;
	
	public void createLeaveApp (int employeeID ,String startDate, String endDate, String leaveType , int noOfDays ) 
	{
		//Set employee ID, information available in this class itself
		this.setEmployeeID(employeeID);
		
		// Set the leave type, information obtained from HTML page
		this.setLeaveType(leaveType);
		
		// Set no of days, information obtained from HTML page
		this.setNoOfDays(noOfDays);		
		
		// Set leave application ID
		this.setApplicationID(LeaveApplication.appCounter());
		
		// Set default application status to Processing
		this.setApplicationStatus("New");
		
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","sao!381TsL");
			Statement stmt=con.createStatement();
			
			
			//stmt.executeQuery("INSERT INTO employee.user (employeeID, username, password) VALUES (7, 'ta', 'emp')");
			String sql = "INSERT INTO employee.leave_application (empID, startDate, endDate, leaveType, noOfDays, status)" +
			        "VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, employeeID);
			//preparedStatement.setInt(2, this.applicationID);
			preparedStatement.setString(2, startDate);
			preparedStatement.setString(3, endDate);
			preparedStatement.setString(4, leaveType);
			preparedStatement.setInt(5, noOfDays);
			preparedStatement.setString(6, "New");
			preparedStatement.executeUpdate(); 
			
				
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
	}
	
	public void register(Manager newSubscriber)
	{
		if (this.subscribers == null)
		{
			this.subscribers = new ArrayList<Manager>();
			newSubscriber.printUserDetails();
		}
		subscribers.add(newSubscriber);
	}

	public void unregister(User deleteSubscriber)
	{
		int subscriberIndex = subscribers.indexOf(deleteSubscriber);
		System.out.println("Observer " + (subscriberIndex+1) + " deleted");
		subscribers.remove(subscriberIndex);
	}
	
	public void notifySubscriber()
	{
		System.out.println("3. Inside notify function");
		if (subscribers == null)
		{
			System.out.println("Subscribers is null");
		}
		for (Manager subscriber: this.subscribers)
		{
			subscriber.update(this);
		}
	}
	
	public void  updateLeaveAppStatus(String applicationStatus) {
		System.out.println("2. Inside status change function");
		notifySubscriber();
		setApplicationStatus(applicationStatus);
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setAttributes(int employeeID ,int applicationID, String startDate, String endDate, String leaveType , int noOfDays, String status)
	{
		this.setEmployeeID(employeeID);
		this.setApplicationID(applicationID);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setLeaveType(leaveType);
		this.setNoOfDays(noOfDays);
		this.setApplicationStatus(status);
	}
	
	public static int appCounter() {
		// Increment the static variable keeping track of no of leave applications
		return LeaveApplication.applicationCount++;
		
	
	}
	
	// This function will be called when the anyone wants see the leave application details
	public void viewLeaveApp() {
		
		// The details to be displayed in the HTML table is populated using this function
		
	}
	
	
	
	
	public String getLeaveType() {
		return leaveType;
		
	}
	public int getEmployeeID() {
		return employeeID;
		
	}
	public int getNoOfDays() {
		return noOfDays;
		
	}
	public int getApplicationID() {
		return applicationID;
		
	}
	public String getApplicationStatus() {
		return applicationStatus;
		
	}
	public void setLeaveType(String _leaveType ) {
		this.leaveType = _leaveType;
	}
	public void setEmployeeID(int _employeeID ) {
		this.employeeID = _employeeID;
	}
	public void setNoOfDays(int _noOfDays ) {
		this.noOfDays = _noOfDays;
	}
	public void setApplicationID(int _applicationID ) {
		this.applicationID = _applicationID;
	}
	public void  setApplicationStatus(String _applicationStatus ) {
		
		//System.out.println("4. Inside setter function");
		this.applicationStatus = _applicationStatus;
	}

}
