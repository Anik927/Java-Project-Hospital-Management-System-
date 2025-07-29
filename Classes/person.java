package Classes;
import java.lang.*;
// import Interfaces.*;
public abstract class person 
{
	private String name;
	private String gender;
	private String password;
	private String dob;
	private String bloodgrp;
	private String email;
	
	public person(String name,String password,String gender,String dob,String bloodgrp,String email)
	{
		this.name=name;
		this.password=password;
		this.gender=gender;
		this.dob=dob;
		this.bloodgrp=bloodgrp;
		this.email=email;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	public void setDob(String dob)
	{
		this.dob=dob;
	}
	
	public void setBloodgrp(String bloodgrp)
	{
		this.bloodgrp=bloodgrp;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	
	
	//Getter Methods
	
	public String getName()
	{
		return name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getDob()
	{
		return dob;
	}
	
	public String getBloodgrp()
	{
		return bloodgrp;
	}
	
	public String getEmail()
	{
		return email;
	}

}