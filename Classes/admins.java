package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class admins implements Iadmins 
{
	public admin adminList[]= new admin[100];
	public static int adminCount = 0;
	patients ps = new patients();
	doctors ds= new doctors();
	public admins()
	{
		try
		{
			File file = new File("Files/adminList.txt");
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
				
				// Printing the Infos
				System.out.println(line1);
				System.out.println(line2);
				System.out.println(line3);
				System.out.println(line4);
				System.out.println(line5);
				System.out.println(line6);
				System.out.println(line7);
				System.out.println(line8);
			
				
				admin d = new admin(line1,line2,line3,line4,line5,line6,line7,line8);
				adminList[adminCount]= d; adminCount++;
				System.out.println(adminCount+"----------------------------");
				
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
	
	
	
	public int adminExists(String name)
	{
		int index = -1; //setting index value -1
		for(int i=0;i<adminCount;i++)
		{
			if(adminList[i].getName().equals(name))
			{
				index = i; //if any admin exists with this name then, he/she must in one of the indexes of adminList array
				break;
			}
		}
		return index; //if admin exists then the index that the admin is in, that index will be returned
		              //otherwise -1 will be returned
	}
	
	public admin checkCredentials(int index, String pass)
	{
		if((adminList[index].getPassword().equals(pass)))
		{
			return adminList[index]; //if the admin exists, we will check the password, if matches return the admin object which resides in adminList array in given index
		}
		else
		{
			return null;
		}         //otherwise return null, meaning password incorrect
	}
	
	public admin getAdmin(int index)
	{
		return adminList[index];
	}
	
	public void addAdmin(admin a)
	{
		adminList[adminCount] = a;
		adminCount++;
		
		String adminDetails= a.getName() + "\n" + a.getPassword() + "\n" +
							a.getGender() + "\n" + a.getDob() + "\n" +
							a.getBloodgrp() + "\n" + a.getEmail() + "\n" + a.getPosition() + "\n" + a.getType()+ "\n"  + "\n";
		
		try
		{
			FileWriter fw = new FileWriter("Files/adminList.txt",true);
			fw.write(adminDetails);
			fw.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}	
	
	public void removeAdmin(String name)
	{
		
		//deleting them from array
		admin a = null;
		for(int i = 0; i<adminCount; i++){
			if(adminList[i].getName().equals(name)){
				a = adminList[i];
				for(int j = i; j< adminCount; j++){
					adminList[j] = adminList[j+1];
				}
				adminCount--;
				adminList[adminCount] = null;
				break;
			}
		}
		
		//also deleting from file
		String adminDetails= a.getName() + "\n" + a.getPassword() + "\n" +
							a.getGender() + "\n" + a.getDob() + "\n" +
							a.getBloodgrp() + "\n" + a.getEmail() + "\n" + a.getPosition() + "\n" + a.getType()+ "\n" ;
		
		try{
			String filepath = "Files/adminList.txt";
			File originalFile = new File(filepath);
				
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readadmin = sc.nextLine() + "\n";
					   readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine() + "\n";
				       readadmin += sc.nextLine();
				      
				
				System.out.println(readadmin);
				System.out.println(adminDetails);
				
				if(readadmin.equals(adminDetails)){
					System.out.println("Equal, so deleting");
					continue;
				}
				System.out.println("Writing");
				newDetails += readadmin + "\n";
			} sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	
	}
	
	public void updateAdmin(admin oldAdmin , admin newAdmin)
	{
		String oldAdminDetails = oldAdmin.getName() + "\n" + oldAdmin.getPassword() + "\n" +
							oldAdmin.getGender() + "\n" + oldAdmin.getDob() + "\n" +
							oldAdmin.getBloodgrp() + "\n" + oldAdmin.getEmail() + "\n" + oldAdmin.getPosition() + "\n" + oldAdmin.getType()+ "\n" ;
								
		String updatedAdminDetails = newAdmin.getName() + "\n" + newAdmin.getPassword() + "\n" +
							newAdmin.getGender() + "\n" + newAdmin.getDob() + "\n" +
							newAdmin.getBloodgrp() + "\n" + newAdmin.getEmail() + "\n" + newAdmin.getPosition() + "\n" + newAdmin.getType()+ "\n" ;
								
		//updating in file
		try
		{
			String filepath = "Files/adminList.txt";
			File originalFile = new File(filepath);
			
			String newDetails = "";				
			Scanner sc = new Scanner(originalFile);
			while(sc.hasNext()){
				String readAdmin = sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() + "\n";
				readAdmin += sc.nextLine() +"\n";
				readAdmin += sc.nextLine();
				
				System.out.println(readAdmin);
				System.out.println(oldAdminDetails);
				
				if(readAdmin.equals(oldAdminDetails))
				{
					System.out.println("Updated");
					newDetails += updatedAdminDetails + "\n";
				}
				else
				{
					System.out.println("Writing");
					newDetails += readAdmin + "\n";
				}
			} 
			sc.close(); 
			FileWriter fw = new FileWriter(filepath);
			fw.write(newDetails);
			fw.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	
	
	
}