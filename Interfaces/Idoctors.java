package Interfaces;
import Classes.*;
public interface Idoctors
{
	doctor getDoctor(int index);
	void updateInfo(doctor oldInfo, doctor newInfo);
}