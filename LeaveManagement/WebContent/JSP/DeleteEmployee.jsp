<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.leave.model.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
<%
	HR hr = HR.getInstance();
	
	String eId = request.getParameter("empID");
	if (eId != null)
	{
		int empID =  Integer.parseInt(request.getParameter("empID"));
		
		if(hr.deleteEmployee(empID))
			response.sendRedirect("/LeaveManagement/JSP/DeleteEmpSuccess.jsp");
		else
			response.sendRedirect("/LeaveManagement/JSP/DeleteEmpFailure.jsp");
	}
	
%>

<form method = "post" action = "#">
empID <input type = "text" name = "empID">

<button type="submit">Submit</button>
</form>
</body>
</html>
