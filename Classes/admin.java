package Classes;
import java.lang.*;
import Interfaces.*;
public class admin extends person
{
	private String position;
	private String type;
	
	public admin(String name,String password,String gender,String dob,String bloodgrp,String email,String position,String type)
	{
		super(name,password,gender,dob,bloodgrp,email);
		this.position=position;
		this.type=type;
	}
	
	public void setPosition(String position)
	{
		this.position=position;
	}
	
	public void setType(String type)
	{
		this.type=type;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public String getType()
	{
		return type;
	}
}