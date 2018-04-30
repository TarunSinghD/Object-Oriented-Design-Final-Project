package com.leave.model;



public class UserFactory {
	
	public User createUser(String roleType)
	{
		System.out.println("Creating User");
		User user = new Employee();;
		
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
			System.out.println("Creating HR");
			user = HR.getInstance();
		}
		
		return user;
	}

}
