<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.leave.model.*" %>
     <%@ page import="java.util.*" %>
     <%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Employee emp = (Employee)session.getAttribute("Employee");
	//out.println("++++++++++");
	//out.println(emp.getName());
	//emp.printUserDetails();
	//request.setAttribute("Employee", emp);
	if (emp == null)
	{
		System.out.println("Employee object is null");
	}
	
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	String leaveType = request.getParameter("leaveType");
	if (startDate != null)
	{
		System.out.println("Hi.. Apply Leave JSP");
		emp.printUserDetails();
		emp.applyLeave(leaveType, startDate, endDate);
		session.setAttribute("Employee", emp);
		response.sendRedirect("/LeaveManagement/JSP/ApplyLeaveSuccess.jsp");
	}
	
	
%>

<h3>A demonstration of how to access a Date field</h3>
<form method = "post" action = "#">
<input type="text"  name="startDate" value="2014-02-04">
<input type="text"  name = "endDate" value="2014-02-10">
<select name="leaveType">
  <option value="Casual">Casual</option>
  <option value="Paid">Paid</option>
  <option value="Sick">Sick</option>
</select>
<button type="submit">Submit</button>
</form>




</body>
</html>