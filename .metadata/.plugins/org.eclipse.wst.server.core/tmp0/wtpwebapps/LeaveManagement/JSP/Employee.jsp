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
<%Employee emp = (Employee)request.getAttribute("Employee");

	if (emp == null)
	{
		emp = (Employee)session.getAttribute("Employee");
	}
		

	out.println("-----------------------");
	out.println(emp.getName());
	//emp.printUserDetails();
	//request.setAttribute("name", emp.getName());
	session.setAttribute("Employee", emp);
%>



<a href="/LeaveManagement/JSP/ApplyLeave.jsp">Apply Leave</a><br/>
<a href="/LeaveManagement/JSP/ViewLeaveApplications.jsp">View Leave Applications</a><br/>
<a href="/LeaveManagement/JSP/DeleteLeaveApplication.jsp">Delete Leave Applications</a><br/>
</body>
</html>