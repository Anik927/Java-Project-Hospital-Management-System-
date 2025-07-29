package Classes;
import java.lang.*;
import Interfaces.*;
public class patWait
{
	private String patientName;
	private String doctorName;
	
	
	public patWait(String patientName,String doctorName)
	{
		this.patientName=patientName;
		this.doctorName=doctorName;
	}
	
	public void setPatientName(String patientName)
	{
		this.patientName=patientName;
	}
	public void setDoctorName(String doctorName)
	{
		this.doctorName=doctorName;
	}
		
	
	public String getPatientName()
	{
		return patientName;
	}
	public String getDoctorName()
	{
		return doctorName;
	}
		
	
}