package Classes;
import java.lang.*;
import Interfaces.*;
public class doctor extends person
{
	private String room;
	private String education;
	private String fees;
	private String time;
	
	public doctor(String name,String password,String gender,String dob,String bloodgrp,String email,String room,String education,String fees,String time)
	{
		super(name,password,gender,dob,bloodgrp,email);
		this.room=room;
		this.education=education;
		this.fees=fees;
		this.time=time;
	}
	
	public void setRoom(String room)
	{
		this.room=room;
	}
	public void setEducation(String education)
	{
		this.education=education;
	}
	public void setFees(String fees)
	{
		this.fees=fees;
	}
	public void setTime(String time)
	{
		this.time=time;
	}
	
	
	public String getRoom()
	{
		return room;
	}
	public String getEducation()
	{
		return education;
	}
	public String getFees()
	{
		return fees;
	}
	public String getTime()
	{
		return time;
	}
	
	
}