package LeaveMan;
import java.util.*;
public class HR extends User{

private static HR HR=null;
private ArrayList<LeaveApplication> hrLeaveAprrovalQ;
private ArrayList<LeaveApplication> empList;

private HR() {
	
}

public static HR getHR() {
	if (HR == null)
		HR = new HR();
	return HR;
	
}

public ArrayList<LeaveApplication> viewLeaveApproval() {
	return empList;
	
}

public void updateleaveBalance() {

}

public ArrayList<Employee>  addEmployeeDetails() {
	return null;
	
}
public Employee addEmployee() {
	return null;
	
}
public void deleteEmployee(int employeeID ) {
	
}
}