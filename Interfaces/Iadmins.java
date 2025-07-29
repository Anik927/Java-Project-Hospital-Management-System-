package Interfaces;
import Classes.*;
public interface Iadmins
{
	void addAdmin(admin a);
	
	
	// void removeAdmin(admin a);
	
	
	admin getAdmin(int index);
	void updateAdmin(admin oldAdmin , admin newAdmin);
}