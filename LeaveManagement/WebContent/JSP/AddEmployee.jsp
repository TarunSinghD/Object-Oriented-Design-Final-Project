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

<%
	HR hr = HR.getInstance();
	
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String roleType = request.getParameter("roleType");
	if (password != null)
	{
		int empID =  Integer.parseInt(request.getParameter("empID"));
		Employee emp = new Employee();
		emp.setAttributes(empID, password, name, roleType);
		hr.addEmployee(emp);
		response.sendRedirect("/LeaveManagement/JSP/AddEmpSuccess.jsp");
	}
	
%>


<form method = "post" action = "#">
empID <input type = "text" name = "empID">
password <input type = "text" name = "password">
name <input type = "text" name = "name">
roleType <input type = "text" name = "roleType">
<button type="submit">Submit</button>
</form>
</body>
</html>
