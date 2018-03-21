
public class LeaveApplication {
	
	private int employeeID;
    private Leave leaveType;
	private int noOfDays;
	private int applicationID ;
	private Status applicationStatus;
	public static applicationCount;
	
	public LeaveApplication createLeaveApp (int employeeID ,Leave leaveType , int noOfDays ) 
	{
		//Set employee ID, information available in this class itself
		leaveApplication.setEmployeeID(employeeID);
		
		// Set the leave type, information obtained from HTML page
		leaveApplication.setLeaveType(leaveType);
		
		// Set no of days, information obtained from HTML page
		leaveApplication.setNoOfDays(noOfDays);
		
		// Increment the static variable keeping track of no of leave applications
		LeaveApplication.applicationCount++;
		
		// Set leave application ID
		LeaveApplication.setApplicationID(LeaveApplication.applicationCount);
		
		// Set default application status to Processing
		LeaveApplication.setApplicationStatus(Processing);
		
		return this;
	}
	
	// This function will be called when the anyone wants see the leave application details
	public void viewLeaveApp() {
		
		// The details to be displayed in the HTML table is populated using this function
		
	}
	
	// Function is called when anyone clicks on update
	public void  updateLeaveAppStatus(Status applicationStatus) {
		
		setApplicationStatus(applicationStatus);
	}
	
	public Leave getLeaveType() {
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
	public Status getApplicationStatus() {
		return applicationStatus;
		
	}
	public void setLeaveType(Leave _leaveType ) {
		this.leaveType = _leaveType
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
	public void  setApplicationStatus(Status _applicationStatus ) {
		this.applicationStatus = _applicationStatus;
	}

}
