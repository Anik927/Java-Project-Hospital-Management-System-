package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class showPatInfo extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel nameLabel,passwordLabel,genderLabel,dobLabel,bloodgrpLabel,emailLabel,usernameLabel,idLabel,martialstatusLabel,phonenumberLabel;
	JButton logoutBtn,showBtn,editBtn,changeBtn,deleteBtn,backBtn,docBtn;
	Font myFont,myFont2;
	patient p;
	patients ps;
	doctor d;
	doctors ds;
	// int a;
	String pass="",hiddenPass="";
	ImageIcon icon,dp,icona;
	public static int pageno;
	public showPatInfo(doctor d,doctors ds,patient p)
	{
		super("Patient DashBoard");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\5859955_cervical_collar_injury_medical_neck_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		patWaitLists.patWaitCount=0;
		
		pageno=0;
		
		this.d=d;
		// this.a=a;
		this.p=p;
		this.ps=ps;
		this.ds=ds;
		
		myFont = new Font("Century", Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 18);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		if (p.getGender().equalsIgnoreCase("Female")) 
		{
			dp = new ImageIcon("Image\\patdash.png");
		}
		else 
		{
			dp = new ImageIcon("Image\\patdash2.png");
		}
		
		JLabel dpLabel = new JLabel(dp);
		dpLabel.setBounds(-15,15,220,200);
		panel.add(dpLabel);
		
		
		nameLabel = new JLabel("Name: "+p.getName());
		nameLabel.setBounds(220,60,350,30);
		nameLabel.setFont(myFont2);
		panel.add(nameLabel);
		
		usernameLabel = new JLabel("Username: "+p.getUsername());
		usernameLabel.setBounds(220,90,300,30);
		usernameLabel.setFont(myFont2);
		panel.add(usernameLabel);
		
		JLabel intro3 = new JLabel("Patient Information");
		intro3.setBounds(190,0,300,30);
		intro3.setFont(myFont);
		panel.add(intro3);
		
		
		
		genderLabel = new JLabel("Gender: "+p.getGender());
		genderLabel.setBounds(220,120,300,30);
		genderLabel.setFont(myFont2);
		panel.add(genderLabel);
		
		dobLabel = new JLabel("Date of birth: "+p.getDob());
		dobLabel.setBounds(220,150,600,30);
		dobLabel.setFont(myFont2);
		panel.add(dobLabel);
		
		bloodgrpLabel = new JLabel("Blood Group: "+p.getBloodgrp());
		bloodgrpLabel.setBounds(220,180,300,30);
		bloodgrpLabel.setFont(myFont2);
		panel.add(bloodgrpLabel);
		
		emailLabel = new JLabel("Email: "+p.getEmail());
		emailLabel.setBounds(220,210,500,30);
		emailLabel.setFont(myFont2);
		panel.add(emailLabel);
		
		
		idLabel = new JLabel("ID: "+p.getId());
		idLabel.setBounds(220,240,300,30);
		idLabel.setFont(myFont2);
		panel.add(idLabel);
		
		martialstatusLabel = new JLabel("Martial Status: "+p.getMartialstatus());
		martialstatusLabel.setBounds(220,270,600,30);
		martialstatusLabel.setFont(myFont2);
		panel.add(martialstatusLabel);
		
		phonenumberLabel = new JLabel("Phone Number:"+p.getPhonenumber());
		phonenumberLabel.setBounds(220,300,320,30);
		phonenumberLabel.setFont(myFont2);
		panel.add(phonenumberLabel);
		
		
		
		icona = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icona);
		backBtn.setBounds(3,3,24,24);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		this.add(panel);
			
	}
	
	public void mouseClicked(MouseEvent me){}
	
	public void mouseEntered(MouseEvent me){} 
	
	public void mouseExited(MouseEvent me){}
	
	public void mousePressed(MouseEvent me){}
	
	public void mouseReleased(MouseEvent me){}
	
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == backBtn)
		{
			this.dispose();
			patients.patientCount=0;
			patWaitGUI foc = new patWaitGUI(d,ds);
			foc.setVisible(true);
			
		}
	}
}