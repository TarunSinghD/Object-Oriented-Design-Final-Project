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
Employee Records
 <TABLE BORDER="1">
                <TR>
                    <TH>employeeID</TH>
                    <TH>password</TH>
                    <TH>name</TH>
                    <TH>roleType</TH>
                </TR>
<%
	HR hr = new HR();
	ArrayList<Employee> empList = hr.viewEmployeeDetails();
	
	for(Employee e: empList)
	{
%>

                <TR>
                    <TD> <%=e.getEmployeeID()  %> </TD>
                    <TD> <%= e.getPassword() %> </TD>
                     <TD> <%= e.getName() %> </TD>
                      <TD> <%= e.getRoleType() %> </TD>
                </TR>
            
            <%
	}
            %>
            </TABLE>
            <button type="button" name="back" onclick="history.back()">back</button>
</body>
</html>