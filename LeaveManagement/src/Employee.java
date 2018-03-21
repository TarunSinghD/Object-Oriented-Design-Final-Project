import java.util.*;
public class Employee extends User {
	private ArrayList<LeaveApplication> empLeaveRequestQ;
	private int managerID;
	private LeaveBalance empLeaveBalance;
	private Leave leaveType;
	
	// This function will be called when user clicks on the apply leave button
	public void applyLeave(Leave leaveType, int noOfDays) 
	{
		//Create a new object of type leave application
		LeaveApplication leaveApplication = new LeaveApplication();
		
		leaveApplication.createLeaveApp(this.getEmployeeID(), leaveType, noOfDays);
		
		empLeaveRequestQ.add(leaveApplication);
		
	}
	
	public int checkLeaveBalance(Leave leaveType) {
		
		// Get the leave balance from leave balance class
		empLeaveBalance.viewLeaveBalance(leaveType);
		
		//Need to display this on the web page
	}
	
	
	public Status viewApplicationStatus(LeaveApplication leaveApplication) {
		
		// Fetch and return Leave Application Status
		return leaveApplication.getApplicationStatus();
	}
	
	public void cancelLeave() {
		
	}
	public void updateLeaveRequest() {
		
	}
	
	public int getManagerID() {
		
		return managerID;
	}
	
	public int getLeaveBalance() {
		
	}
	
	public Leave getLeaveType() {
		
	}
	
	public void setManagerID(int managerID) {
		
	}
	
	public void setLeaveType(Leave leaveType) {
		
	}
	
}
