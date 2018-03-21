/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vennela
 */

    
public class User {
    
    private String username;
    private String password;
    private String name;
    private Role roletype;
    private int employeeID;
    
    //Methods
    
    public boolean login (String username, String password){
        return false;
        
    
}

public String getUsername(){
        return null;
    
}

public String getPassword(){
        return null;
    
}

public String getName(){
        return null;
    
}


public Role getRoleType(){
        return null;
       // return null;
    
}


public int getEmployeeID(){
        return 0;

}

public void setUsername( String username){
    this.username=username;
}

public void setPassword( String password){
    this.password=password;
}

public void setName( String name){
    this.name=name;
}

public void setRoleType( Role roletype){
    this.roletype=roletype;
}
public void employeeID( int employeeID){
    this.employeeID=employeeID;
}
}