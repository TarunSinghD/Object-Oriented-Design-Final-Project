<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
     <%@ page import="com.leave.model.*" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Leave Records
 <TABLE BORDER="1">
                <TR>
                    <TH>employeeID</TH>
                    <TH>applicationID</TH>
                    <TH>startDate</TH>
                    <TH>endDate</TH>
                    <TH>leaveType</TH>
                    <TH>noOfDays</TH>
                    <TH>status</TH>
                </TR>
<%
	Employee emp = (Employee)session.getAttribute("Employee");
                
    if (emp == null)
    {
    	System.out.println("Emp is null");
    }
                
    ArrayList<LeaveApplication> empLeaveReq = new ArrayList<LeaveApplication>();
    empLeaveReq = emp.viewApplications();
    
    if (empLeaveReq == null)
    {
    	System.out.println("Emp Leave Request is null");
    }
	
	for(LeaveApplication l: empLeaveReq)
	{
%>

                <TR>
                    <TD> <%=l.getEmployeeID()  %> </TD>
                    <TD> <%= l.getApplicationID() %> </TD>
                     <TD> <%= l.getStartDate() %> </TD>
                      <TD> <%= l.getEndDate() %> </TD>
                      <TD> <%= l.getLeaveType() %> </TD>
                      <TD> <%= l.getNoOfDays() %> </TD>
                      <TD> <%= l.getApplicationStatus() %> </TD>
                </TR>
            
            <%
            session.setAttribute("Employee", emp);
	}
            %>
            </TABLE>
            <button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>