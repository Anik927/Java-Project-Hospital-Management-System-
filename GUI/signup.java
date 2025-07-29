package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class signup extends JFrame implements MouseListener, ActionListener

{
	JPanel panel;
	JLabel introLabel,bgLabel,nameLabel,usernameLabel,
		   dobLabel,genderLabel,martialLabel,bloodLabel,
		   phonenumLabel,emailLabel,passLabel,confirmpassLabel;
	Font myFont,myFont2;
	JTextField nameTF,usernameTF,phonenumTF,emailTF;
	JPasswordField passFF,confirmpassFF;
	JButton backBtn,signupBtn;
	JComboBox date,month,year,genderbox,bloodgrps,statusbox;
	JCheckBox c1,c2;
	ImageIcon icon,bgImg;
	// Color ;
	patients ps =null;
	public signup(patients ps)
	
	{
		super("Singup");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\49576_new_add_plus_user_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.ps=ps;
		
		myFont = new Font("Century", Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		introLabel = new JLabel("Enter Your Info");
		introLabel.setBounds(270,25,280,30);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(60,100,80,20);
		nameLabel.setFont(myFont2);
		panel.add(nameLabel);
		
		nameTF = new JTextField();
		nameTF.setBounds(122,98,200,25);
		nameTF.setFont(myFont2);
		panel.add(nameTF);
		
		usernameLabel = new JLabel("UserName: ");
		usernameLabel.setBounds(355,100,160,20);
		usernameLabel.setFont(myFont2);
		panel.add(usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(470,98,200,25);
		usernameTF.setFont(myFont2);
		panel.add(usernameTF);
		
		dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(60,150,170,30);
		dobLabel.setFont(myFont2);
		panel.add(dobLabel);
		
		String dates[]= {"1","2","3","4","5","6","7","8","9",
						"10","11","12","13","14","15","16","17",
						"18","19","20","21","22","23","24","25",
						"26","27","28","29","30","31"};
		date = new JComboBox(dates);
		date.setBounds(230,153,45,25);
		panel.add(date);
		
		String months[]= {"JAN","FEB","MAR","APR",
						"MAY","JUN","JUL","AUG",
						"SEP","OCT","NOV","DEC"};
		month = new JComboBox(months);
		month.setBounds(275,153,60,25);
		panel.add(month);
		
		String years[]= {"1990","1991","1992","1993","1994",
		                 "1995","1996","1997","1998","1999","2000",
						 "2001","2002","2003","2004","2005","2006",
						 "2007","2008","2009","2010","2011","2012",
						 "2013","2014","2015","2016","2017","2018",
						 "2019","2020","2021","2022","2023","2024"};
		year = new JComboBox(years);
		year.setBounds(335,153,60,25);
		panel.add(year);
		
		genderLabel = new JLabel("Gender: ");
		genderLabel.setBounds(420,150,96,30);
		genderLabel.setBackground(new Color(190,204,228));
		genderLabel.setOpaque(true);
		genderLabel.setFont(myFont2);
		
		String genders[]={"Male","Female","Others"};
		genderbox = new JComboBox(genders);
		genderbox.setBounds(505,150,70,30);
			
		panel.add(genderbox);
		panel.add(genderLabel);
		
		martialLabel = new JLabel("Martial Status: ");
		martialLabel.setBounds(60,200,200,30);
		martialLabel.setFont(myFont2);
		// martialLabel.setOpaque(true);
		// martialLabel.setBackground(new Color(190,204,228));
		
		String status[]={"Married","Unmarried"};
		
		statusbox = new JComboBox(status);
		statusbox.setBounds(247,203,100,27);
				
		panel.add(martialLabel);
		panel.add(statusbox);
		
		bloodLabel = new JLabel("Blood Group:");
		bloodLabel.setBounds(60,235,150,30);
		bloodLabel.setFont(myFont2);
		// bloodLabel.setOpaque(true);
		// bloodLabel.setBackground(new Color(190,204,228));
		// bloodLabel.setForeground(Color.RED);
		
		
		String grps[]={"A-","A+","B-","B+","AB","AB+","O+","O-"};
		bloodgrps = new JComboBox(grps); 
		bloodgrps.setBounds(207,239,50,25);
		
		panel.add(bloodLabel);
		panel.add(bloodgrps);
		
		phonenumLabel = new JLabel("Phone Number:");
		phonenumLabel.setBounds(60,280,180,30);
		phonenumLabel.setFont(myFont2);
		
		phonenumTF = new JTextField();
		phonenumTF.setBounds(220,280,170,30);
		phonenumTF.setFont(myFont2);
		
		panel.add(phonenumLabel);
		panel.add(phonenumTF);
	
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(400,280,80,30);
		emailLabel.setFont(myFont2);
		
		emailTF = new JTextField();
		emailTF.setBounds(475,280,220,30);
		emailTF.setFont(myFont2);
		
		
		panel.add(emailLabel);
		panel.add(emailTF);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(60,330,140,30);
		passLabel.setFont(myFont2);
		
		passFF = new JPasswordField();
		passFF.setBounds(170,330,170,30);
		passFF.setFont(myFont2);
		passFF.setEchoChar('*');
		
		confirmpassLabel = new JLabel("Confirm Password:");
		confirmpassLabel.setBounds(60,380,230,30);
		confirmpassLabel.setFont(myFont2);
		
		confirmpassFF = new JPasswordField();
		confirmpassFF.setBounds(270,380,180,30);
		confirmpassFF.setFont(myFont2);
		confirmpassFF.setEchoChar('*');
		
		panel.add(passLabel);
		panel.add(passFF);
		panel.add(confirmpassLabel);
		panel.add(confirmpassFF);
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(540,390,110,30);
		signupBtn.setBackground(new Color(158,179,221));
		signupBtn.addMouseListener(this);
		signupBtn.addActionListener(this);
		signupBtn.setFont(new Font("Courier New", Font.BOLD, 16));
		
		panel.add(signupBtn);
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
		// backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		bgImg = new ImageIcon("Image\\Long Couloir D'hôpital _ Photo Premium.jpg");
		bgLabel = new JLabel(bgImg);
		bgLabel.setBounds(0,0,800,500);
		panel.add(bgLabel);
		
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
		if(backBtn.getText().equals(command))
		{
			this.dispose();
			patlogin foc = new patlogin(ps);
			foc.setVisible(true);
		}
		
		else if(signupBtn.getText().equals(command))
		{
			String name="",username="",dt="",mnth="",yr="",dob="",gender="",martialstatus="",
					bloodgrp="",phone="",email="",pass="",confirmpass="",id="";
					
			name = nameTF.getText();
			username = usernameTF.getText();
			phone = phonenumTF.getText();
			email = emailTF.getText();
			pass = passFF.getText();
			confirmpass = confirmpassFF.getText();
			dob = date.getSelectedItem().toString()+"-"+month.getSelectedItem().toString()+"-"+year.getSelectedItem().toString();
			bloodgrp = bloodgrps.getSelectedItem().toString();
			gender = genderbox.getSelectedItem().toString();
			martialstatus = statusbox.getSelectedItem().toString();
			int patientCount = patients.patientCount;
			id = String.valueOf(patientCount);
			
			if(!name.isEmpty() && !username.isEmpty() && 
				!phone.isEmpty() && !email.isEmpty() && 
				!pass.isEmpty() && !confirmpass.isEmpty() && 
				!dob.isEmpty() && !bloodgrp.isEmpty() && 
				!gender.isEmpty() && !martialstatus.isEmpty()) 
				{
			
				if(pass.equals(confirmpass))
				{
					patient jk = new patient(name,pass,gender,dob,bloodgrp,email,username,id,martialstatus,phone);
					ps.addPatient(jk);
					
					JOptionPane.showMessageDialog(this, "Sign up successful. Please login to continue.");
					patlogin f = new patlogin(ps);
					f.setVisible(true);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Password missmatch");
				}
			}else
			{
				JOptionPane.showMessageDialog(this, "Information missing");
			}
		}
		
	}
}