package Classes;
import java.lang.*;
// import Interfaces.*;

public class patient extends person
{
	private String username;
	private String id;
	private String martialstatus;
	private String phonenumber;
	
	public patient(String name,String password,String gender,String dob,String bloodgrp,String email,String username,String id,String martialstatus,String phonenumber)
	{
		super(name,password,gender,dob,bloodgrp,email);
		this.username=username;
		this.id=id;
		this.martialstatus=martialstatus;
		this.phonenumber=phonenumber;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setMartialstatus(String martialstatus)
	{
		this.martialstatus=martialstatus;
	}
	public void setPhonenumber(String phonenumber)
	{
		this.phonenumber=phonenumber;
	}
	
	public String getUsername()
	{
		return username;
	}
	public String getId()
	{
		return id;
	}
	public String getMartialstatus()
	{
		return martialstatus;
	}
	public String getPhonenumber()
	{
		return phonenumber;
	}
}