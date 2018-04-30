<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ page import="com.leave.model.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Manager</h3>
<a href="/LeaveManagement/JSP/ViewLeaveApplications.jsp">View Leave Applications</a><br/>
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
Manager man = new Manager();
//Manager man = (Manager)session.getAttribute("Manager");
            String applicationID = request.getParameter("applicationID");
            String status = request.getParameter("status");
            //System.out.println("status");
            //System.out.println(status);
        	if (applicationID != null)
        	{
        		int appID =  Integer.parseInt(request.getParameter("applicationID"));
        		session.setAttribute("Manager", man);
        		if(man.approveLeaveRequest(appID,status))
        			response.sendRedirect("/LeaveManagement/JSP/ApproveSuccess.jsp");
        		else if(man.denyLeaveRequest(appID,status))
        			response.sendRedirect("/LeaveManagement/JSP/Denyed.jsp");
        	}
	
                
    //if (man == null)
    //{
    	//System.out.println("Emp is null");
    //}
                
    ArrayList<LeaveApplication> manLeaveReq = new ArrayList<LeaveApplication>();
    manLeaveReq = man.viewLeaveRequest();
    
    if (manLeaveReq == null)
    {
    	System.out.println("Man Leave Request is null");
    }
	
	for(LeaveApplication l: manLeaveReq)
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
            session.setAttribute("Manager", man);
	}
            %>
            </TABLE>
            
            <form method = "post" action = "#">
Application ID <input type = "text" name = "applicationID">

<select name="status">
  <option value="Approve">Approve</option>
  <option value="Deny">Deny</option>
</select>

<button type="submit">Submit</button>
            <button type="button" name="back" onclick="history.back()">back</button>
            </form>
</body>
</html>