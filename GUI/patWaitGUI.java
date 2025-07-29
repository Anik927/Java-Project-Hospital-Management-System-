package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class patWaitGUI extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	// JLabel test;
	
	
	
	doctor d = null;
	doctors ds = null;
	patients ps = new patients();
	patWaitLists pwl;
	
	Font myFont,myFont2;
	
	JComboBox waitingBox;
	JButton selectBtn,backBtn;
	
	
	
	public patWaitGUI(doctor d,doctors ds)
	{
		super("Patirnt List");
		patWaitLists.patWaitCount=0;
		// doctors.doctorCount=0;
		// patients.patientCount=0;
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		myFont = new Font("Century",Font.PLAIN, 26);
		myFont2 = new Font("Courier New", Font.BOLD, 24);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,208,214));
		
		this.d=d;
		this.ds=ds;
		pwl = new patWaitLists();
		
		JLabel intro = new JLabel("Patient's Waiting List");
		intro.setBounds(60,20,400,30);
		intro.setFont(myFont);
		panel.add(intro);
		
		
		
		int y=0;
		int num = 1;
		
		for (int i = 0; i < patWaitLists.patWaitCount; i++) 
		{
            if (pwl.patWaitList[i].getDoctorName().equals(d.getName())) 
			{
                JLabel testi = new JLabel(num+"."+pwl.patWaitList[i].getPatientName());
                testi.setBounds(80, 60 + y, 200, 40);
                y += 35;
				num++;
                testi.setFont(myFont2);
                panel.add(testi);
            }
        }
		
		String[] waitList = new String[patWaitLists.patWaitCount];
		String[] waitList2;
		
		int jkl=0;
		for(int i=0;i<patWaitLists.patWaitCount;i++)
		{
			
			if (pwl.patWaitList[i].getDoctorName().equals(d.getName()))
			{
				waitList[jkl]=pwl.patWaitList[i].getPatientName();
				jkl++;
			}
			
		}
		
		waitList2 = new String[jkl];
		
		for(int i=0;i<jkl;i++)
		{
			waitList2[i]=waitList[i];
		}
		
		waitingBox = new JComboBox(waitList2);
		waitingBox.setBounds(460,180,130,30);
		panel.add(waitingBox);
		
		JLabel intro2 = new JLabel("Check Patient");
		intro2.setBounds(480,70,200,30);
		intro2.setFont(myFont);
		panel.add(intro2);
		
		JLabel intro3 = new JLabel("Information");
		intro3.setBounds(492,105,400,30);
		intro3.setFont(myFont);
		panel.add(intro3);
		
		selectBtn = new JButton("Select");
		selectBtn.setBounds(600,180,70,30);
		// selectBtn.setFont(myFont);
		selectBtn.addMouseListener(this);
		selectBtn.addActionListener(this);
		panel.add(selectBtn);
		
		ImageIcon icona = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icona);
		backBtn.setBounds(3,3,24,24);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		this.add(panel);
	
	}
	
	public void mouseEntered(MouseEvent me){}  
	public void mouseClicked(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if (ae.getSource() == backBtn)
		{
			this.dispose();
			patients.patientCount=0;
			docdashboard foc = new docdashboard(d,ds);
			foc.setVisible(true);
		}
		
		else if(selectBtn.getText().equals(command))
		{
			String name ="";
			name = waitingBox.getSelectedItem().toString();
			patient p = ps.getPatient(name);
			patWaitLists.patWaitCount=0;
			showPatInfo df = new showPatInfo(d,ds,p);
			df.setVisible(true);
			this.dispose();
		
		}
		
	}
}
	