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
<%	Manager man = (Manager)request.getAttribute("Manager");

	if (man == null)
	{
		man = (Manager)session.getAttribute("Manager");
	}
		

	//out.println("-----------------------");
	//out.println(man.getName());
	//emp.printUserDetails();
	//request.setAttribute("name", emp.getName());
	session.setAttribute("Manager", man);
%>
<h3>Manager</h3>
<a href="/LeaveManagement/JSP/ManagerLeaveApplications.jsp">View Leave Applications</a><br/>
<a href="/LeaveManagement/JSP/ManagerApproveDeny.jsp">Approve/Deny Applications</a><br/>

</body>
</html>