package com.leave.model;

public class UserFactory {
	
	public User createUser(String roleType)
	{
		User user = new User();
		
		if (roleType.equals("Employee"))
		{
			user = new Employee();
		}
		
		else if (roleType.equals("Manager"))
		{
			user = new Manager();
		}
		
		else if (roleType.equals("HR"))
		{
			user = new HR();
		}
		
		return user;
	}

}
