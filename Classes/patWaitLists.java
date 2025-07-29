package Classes;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import Interfaces.*;

public class patWaitLists 
{
	public patWait patWaitList[]= new patWait[100];
	public static int patWaitCount = 0;
	
	public patWaitLists()
	{
		try
		{
			File file = new File("Files/patWaitList.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNext())
			{
				// Reading the Infos
				String line1 = sc.nextLine();
				String line2 = sc.nextLine();
				String line3 = sc.nextLine();
				
				
				// Printing the Infos
				System.out.println(line1);
				System.out.println(line2);
				
				
				patWait pw = new patWait(line1,line2);
				patWaitList[patWaitCount]= pw; patWaitCount++;
				System.out.println(patWaitCount+"----------------------------");
				
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
	
	
		
	
	
}
