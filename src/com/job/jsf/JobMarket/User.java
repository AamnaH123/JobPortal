package com.job.jsf.JobMarket;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.PreparedStatement; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;  


@ReferencedBean  

@ManagedBean(name="User")
public class User {
	
	private String firstName;
	private String lastName;
	private String jobRole;
	
	//list of roles from the dropdown list
	List<String> jobRoleOptions;
	
	//create no-arg constructor
	public User() {
		//define getter/setter methods
		//populate the list of role
		jobRoleOptions=new ArrayList<>();
		jobRoleOptions.add("Job Provider");
		jobRoleOptions.add("Freelancer");
	
		
	}

	
	public List<String> getJobRoleOptions() {
		return jobRoleOptions;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public boolean save(){  
		int result = 0;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");     
		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/my_database","root","aamna123");  
		System.out.println(con);
		PreparedStatement stmt = con.prepareStatement("insert into user(firstname,lastname,jobrole) values(?,?,?)");  
		stmt.setString(1, this.getFirstName());  
		stmt.setString(2, this.getLastName());  
		stmt.setString(3, this.getJobRole()); 
		result = stmt.executeUpdate();  
System.out.println(result);
		}catch(Exception e){  
		System.out.println(e);  
		}  
		if(result == 1){  
		return true;  
		}else return false;  
		}  
		  
		public String submit(){  
		if(this.save()){  
		return "myresponse.xhtml";  
		}else return "Job-Provider.xhtml";  
		}     
		} 


