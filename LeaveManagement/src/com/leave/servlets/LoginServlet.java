package com.leave.servlets;
import com.leave.model.*;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserFactory userFactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uname = Integer.parseInt(request.getParameter("uname"));
		String password = request.getParameter("password");
		
		// get response writer
        PrintWriter writer = response.getWriter();
        String htmlRespone = "Dummy";
		
		//Check for the username and password
		try {

			// load and register JDBC driver for MySQL
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","aerospace");
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM employee.user");
			while(rs.next())
			{
				
				if (rs.getInt(1) == uname)
				{
					if (rs.getString(2).equals(password))
					{
						userFactory = new UserFactory();
						htmlRespone = "<html>";
				        htmlRespone += "<h2>Login Successful</h2>"; 
				        htmlRespone +=  rs.getInt(1) + rs.getString(2);
				        htmlRespone += "</html>";
				        System.out.println("Servlet, Login successful");
				        //If login is successful
				        
				        User user = userFactory.createUser(rs.getString(4),rs.getInt(1),rs.getString(2),rs.getString(3));
				        user.setAttributes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				        user.handleRequest(request, response);
					}
				}
				
				else
				{
					htmlRespone = "<html>";
			        htmlRespone += "<h2>Login Unsuccessful</h2>"; 
			        htmlRespone +=  rs.getInt(1) + rs.getString(2);
			        htmlRespone += "</html>";
				}
			}
				
		}
		catch (Exception exc) {
			System.out.print(exc);
		}
			
     // return response
        writer.println(htmlRespone);
	}
}
