package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
// import Interfaces.*;

public class patients 
{
	patient patientList[] = new patient[100];
	public static int patientCount = 0;
	
	public patient getPatient(String name)
	{
		int fg = patientExists(name);
		patient p = patientList[fg];
		return p;
			
	}
	
	public patients()
	{
		
		//reading the file and creating user objects to add them to the userList array
		try{
			File file = new File("Files/patientList.txt"); //location must be the path where the file is saved
			Scanner sc = new Scanner(file);
				while(sc.hasNext()){
					String line1 = sc.nextLine(); 
					String line2 = sc.nextLine();  
					String line3 = sc.nextLine();  
					String line4 = sc.nextLine();  
					String line5 = sc.nextLine();  
					String line6 = sc.nextLine(); 
					String line7 = sc.nextLine();  
					String line8 = sc.nextLine();  
					String line9 = sc.nextLine();  
					String line10 = sc.nextLine(); 
					String line11 = sc.nextLine(); 
					
					//printing them to cmd just to see if they are getting added to the list or not
				 	System.out.println(line1);
					System.out.println(line2);
					System.out.println(line3);
					System.out.println(line4);
					System.out.println(line5);
					System.out.println(line6);
					System.out.println(line7);
					System.out.println(line8);
					System.out.println(line9);
					System.out.println(line10);
					
					
					patient u = new patient(line1,line2,line3,line4,line5,line6,line7,line8,line9,line10);
					patientList[patientCount] = u; patientCount++;
					System.out.println(patientCount+"------------------------------");
				}
			sc.close();   //closing the file 		
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			// System.out.println("File not found.");
			return;
		}
	
	}
	
	public int patientExists(String name)
	{
		int index = -1; 
		for(int i=0;i<patientCount;i++)
		{
			if(patientList[i].getUsername().equals(name)){
				index = i; 
				break;
			}
		}
		return index; 
		              
	}
	
	public patient checkCredentials(int index, String pass)
	{
		if((patientList[index].getPassword().equals(pass)))
		{
			return patientList[index]; 
		}
		else
		{
			return null;
		}       
	}
	
	public void addPatient(patient p)
	{
		patientList[patientCount]=p;
		patientCount++;
		
		String patientDetails= p.getName() + "\n" + p.getPassword() + "\n" +
							p.getGender() + "\n" + p.getDob() + "\n" +
							p.getBloodgrp() + "\n" + p.getEmail() + "\n" + p.getUsername() + "\n" + p.getId() + "\n" + p.getMartialstatus() + "\n" + p.getPhonenumber()+ "\n" + "\n";
		
		try
		{
			FileWriter fw = new FileWriter("Files/patientList.txt",true);
			fw.write(patientDetails);
			fw.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public void deletePatient(String name)
	{
		//deleting them from array
		patient u = null;
		for(int i = 0; i<patientCount; i++){
			if(patientList[i].getName().equals(name)){
				u = patientList[i];
				for(int j = i; j< patientCount; j++){
					patientList[j] = patientList[j+1];
				}
				patientCount--;
				patientList[patientCount] = null;
				break;
			}
		}
		
		//also deleting from file
		String patientDetails = u.getName() + "\n" + u.getPassword() + "\n" +
							u.getGender() + "\n" + u.getDob() + "\n" +
							u.getBloodgrp() + "\n" + u.getEmail() + "\n" + u.getUsername() + "\n" + u.getId() + "\n" + u.getMartialstatus() + "\n" + u.getPhonenumber() + "\n";
		
		try{
			String filepath = "Files/patientList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readPatient = sc.nextLine() + "\n";
					   readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() + "\n";
				       readPatient += sc.nextLine() +"\n";
				       readPatient += sc.nextLine() +"\n";
				       readPatient += sc.nextLine();
				
				System.out.println(readPatient);
				System.out.println(patientDetails);
				
				if(readPatient.equals(patientDetails)){
					System.out.println("Equal, so deleting");
					continue;
				}
				System.out.println("Writing");
				newDetails += readPatient + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void updatePatient(patient oldPatient, patient updatedPatient){
		String oldPatientDetails = oldPatient.getName() 
					+ "\n" + oldPatient.getPassword() 
					+ "\n" +oldPatient.getGender() 
					+ "\n" + oldPatient.getDob() 
					+ "\n" + oldPatient.getBloodgrp() 
					+ "\n" + oldPatient.getEmail() 
					+ "\n" + oldPatient.getUsername() 
					+ "\n" + oldPatient.getId() 
					+ "\n" + oldPatient.getMartialstatus()
					+ "\n" + oldPatient.getPhonenumber()+
					"\n";
		
		String updatedDetails = updatedPatient.getName() + "\n" + updatedPatient.getPassword() + "\n" +
							updatedPatient.getGender() + "\n" + updatedPatient.getDob() + "\n" +
							updatedPatient.getBloodgrp() + "\n" + updatedPatient.getEmail() + "\n" + updatedPatient.getUsername() + "\n" + updatedPatient.getId() + "\n" + updatedPatient.getMartialstatus() + "\n" + updatedPatient.getPhonenumber()+ "\n";
		//updating in file
		try{
			String filepath = "Files/patientList.txt";
			File originalFile = new File(filepath);
			
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readPatient = sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() + "\n";
				readPatient += sc.nextLine() +"\n";
				readPatient += sc.nextLine();
				
				System.out.println(readPatient);
				System.out.println(oldPatientDetails);
				
				if(readPatient.equals(oldPatientDetails)){
					System.out.println("Updated");
					newDetails += updatedDetails + "\n";
				}else{
					System.out.println("Writing");
					newDetails += readPatient + "\n";
				}
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
}