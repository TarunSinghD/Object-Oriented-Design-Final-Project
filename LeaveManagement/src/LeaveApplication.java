
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
		return null;

	}
	public void viewLeaveApp() {
		
	}
	public void  updateLeaveAppStatus(Status applicationStatus) {
		
	}
	public Leave getLeaveType() {
		return leaveType;
		
	}
	public int getEmployeeID() {
		return 0;
		
	}
	public int getNoOfDays() {
		return 0;
		
	}
	public int getApplicationID() {
		return applicationID;
		
	}
	public Status getApplicationStatus() {
		return applicationStatus;
		
	}
	public void setLeaveType(Leave leaveType ) {
		
	}
	public void setEmployeeID(int employeeID ) {
		
	}
	public void setNoOfDays(int noOfDays ) {
		
	}
	public void setApplicationID(int applicationID ) {
		
	}
	public void  setApplicationStatus(Status applicationStatus ) {
		
	}

}
