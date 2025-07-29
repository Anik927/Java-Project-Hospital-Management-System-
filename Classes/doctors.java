package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class doctors implements Idoctors 
{
	public doctor doctorList[]= new doctor[100];
	public static int doctorCount = 0;
	
	public doctors()
	{
		try
		{
			File file = new File("Files/doctorList.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNext())
			{
				// Reading the Infos
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
				
				// Printing the Infos
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
				
				doctor d = new doctor(line1,line2,line3,line4,line5,line6,line7,line8,line9,line10);
				doctorList[doctorCount]= d; doctorCount++;
				System.out.println(doctorCount+"----------------------------");
				
			}
			sc.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			System.out.println("File not found.");
			return;
		}
	}
	
	public int doctorExists(String name)
	{
		int index = -1; //setting index value -1
		for(int i=0;i<doctorCount;i++)
		{
			if(doctorList[i].getName().equals(name))
			{
				index = i; //if any user exists with this name then, he/she must in one of the indexes of userList array
				break;
			}
		}
		return index; //if user exists then the index that the user is in, that index will be returned
		              //otherwise -1 will be returned
	}
	
	public doctor checkCredentials(int index, String pass)
	{
		if((doctorList[index].getPassword().equals(pass)))
		{
			return doctorList[index]; //if the user exists, we will check the password, if matches return the user object which resides in userList array in given index
		}
		else
		{
			return null;
		}         //otherwise return null, meaning password incorrect
	}
	
	public doctor getDoctor(int index)
	{
		return doctorList[index];
	}
	
	public void addDoctor(doctor p)
	{
		doctorList[doctorCount]=p;
		doctorCount++;
		
		String doctorDetails= p.getName() + "\n" + p.getPassword() + "\n" +
							p.getGender() + "\n" + p.getDob() + "\n" +
							p.getBloodgrp() + "\n" + p.getEmail() + "\n" + p.getRoom() + "\n" + p.getEducation() + "\n" + p.getFees() + "\n" + p.getTime()+ "\n" + "\n";
		
		try
		{
			FileWriter fw = new FileWriter("Files/doctorList.txt",true);
			fw.write(doctorDetails);
			fw.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	public void deleteDoctor(String name)
	{
		//deleting them from array
		doctor p = null;
		for(int i = 0; i<doctorCount; i++){
			if(doctorList[i].getName().equals(name)){
				p = doctorList[i];
				for(int j = i; j< doctorCount; j++){
					doctorList[j] = doctorList[j+1];
				}
				doctorCount--;
				doctorList[doctorCount] = null;
				break;
			}
		}
		
		//also deleting from file
		String doctorDetails = p.getName() + "\n" + p.getPassword() + "\n" +
							p.getGender() + "\n" + p.getDob() + "\n" +
							p.getBloodgrp() + "\n" + p.getEmail() + "\n" + p.getRoom() + "\n" + p.getEducation() + "\n" + p.getFees() + "\n" + p.getTime()+ "\n";
		
		try{
			String filepath = "Files/doctorList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readDoctor = sc.nextLine() + "\n";
					   readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() + "\n";
				       readDoctor += sc.nextLine() +"\n";
				       readDoctor += sc.nextLine() +"\n";
				       readDoctor += sc.nextLine();
				
				System.out.println(readDoctor);
				System.out.println(doctorDetails);
				
				if(readDoctor.equals(doctorDetails)){
					System.out.println("Equal, so deleting");
					continue;
				}
				System.out.println("Writing");
				newDetails += readDoctor + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void updateInfo(doctor oldInfo, doctor newInfo)
	{
		String oldDoctorInfo = oldInfo.getName() + "\n" + 
								oldInfo.getPassword() + "\n"+
								oldInfo.getGender() + "\n"+ 
								oldInfo.getDob() + "\n" +
								oldInfo.getBloodgrp() + "\n" +
								oldInfo.getEmail() + "\n" +
								oldInfo.getRoom() + "\n" +
								oldInfo.getEducation() + "\n" +
								oldInfo.getFees() + "\n" +
								oldInfo.getTime() + "\n" ;
								
		String newDoctorInfo = newInfo.getName() + "\n" + 
								newInfo.getPassword() + "\n"+
								newInfo.getGender() + "\n"+ 
								newInfo.getDob() + "\n" +
								newInfo.getBloodgrp() + "\n" +
								newInfo.getEmail() + "\n" +
								newInfo.getRoom() + "\n" +
								newInfo.getEducation() + "\n" +
								newInfo.getFees() + "\n" +
								newInfo.getTime() + "\n";
	
		try
		{
			File ogFile = new File("Files/doctorList.txt");
			
			String newDetails = "";				
			Scanner sc = new Scanner(ogFile);
			
			while(sc.hasNext())
			{
				String readDoctor = sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine() + "\n";
				readDoctor += sc.nextLine();
				
				if(readDoctor.equals(oldDoctorInfo))
				{
					System.out.println("Updated Doctor Info");
					newDetails += newDoctorInfo + "\n";
				}
				
				else
				{
					System.out.println("Writing...");
					newDetails += readDoctor + "\n";
				}
				
			}
			
			sc.close();
			
			FileWriter fw = new FileWriter("Files/doctorList.txt");
				fw.write(newDetails);
				fw.close();
		}
		
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
		
	
	
}
