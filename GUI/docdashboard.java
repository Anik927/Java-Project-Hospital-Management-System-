package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class docdashboard extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel nameLabel,passwordLabel,genderLabel,dobLabel,bloodgrpLabel,emailLabel,roomLabel,eduLabel,feesLabel,timeLabel;
	JButton logoutBtn,showBtn,editBtn,changeBtn,deleteBtn,backBtn,checkPatList;
	Font myFont,myFont2;
	doctor d;
	doctors ds;
	String pass="",hiddenPass="";
	ImageIcon icon,dp,icona;
	
	public docdashboard(doctor d,doctors ds)
	{
		super("Doctor DashBoard");
		this.setSize(800,500);
		ImageIcon icon = new ImageIcon("Image\\5929159_avatar_doctor_health_hospital_medical_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.d=d;
		this.ds=ds;
		
		myFont = new Font("Century",Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 20);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		dp = new  ImageIcon("Image\\docdash.png");
		JLabel dpLabel = new JLabel(dp);
		dpLabel.setBounds(-15,15,200,200);
		panel.add(dpLabel);
		
		nameLabel = new JLabel("Name: "+d.getName());
		nameLabel.setBounds(200,10,350,30);
		nameLabel.setFont(myFont2);
		panel.add(nameLabel);
		
		roomLabel = new JLabel("Room No: "+d.getRoom());
		roomLabel.setBounds(200,40,350,30);
		roomLabel.setFont(myFont2);
		panel.add(roomLabel);
		
		
		pass = d.getPassword();
		int passLenghth = pass.length();
		for(int i =0;i<passLenghth;i++)
		{
			hiddenPass += '*';
		}
		
		passwordLabel = new JLabel("Password: "+hiddenPass);
		passwordLabel.setBounds(200,70,600,30);
		passwordLabel.setFont(myFont2);
		panel.add(passwordLabel);
		
		genderLabel = new JLabel("Gender: "+d.getGender());
		genderLabel.setBounds(200,100,300,30);
		genderLabel.setFont(myFont2);
		panel.add(genderLabel);
		
		dobLabel = new JLabel("Date of birth: "+d.getDob());
		dobLabel.setBounds(200,130,600,30);
		dobLabel.setFont(myFont2);
		panel.add(dobLabel);
		
		bloodgrpLabel = new JLabel("Blood Group: "+d.getBloodgrp());
		bloodgrpLabel.setBounds(200,160,300,30);
		bloodgrpLabel.setFont(myFont2);
		panel.add(bloodgrpLabel);
		
		emailLabel = new JLabel("Email: "+d.getEmail());
		emailLabel.setBounds(200,190,500,30);
		emailLabel.setFont(myFont2);
		panel.add(emailLabel);
		
		eduLabel = new JLabel("Education: "+d.getEducation());
		eduLabel.setBounds(200,220,500,30);
		eduLabel.setFont(myFont2);
		panel.add(eduLabel);
		
		feesLabel = new JLabel("Fees: "+d.getFees());
		feesLabel.setBounds(200,250,500,30);
		feesLabel.setFont(myFont2);
		panel.add(feesLabel);
		
		timeLabel = new JLabel("Time: "+d.getTime());
		timeLabel.setBounds(380,40,500,30);
		timeLabel.setFont(myFont2);
		panel.add(timeLabel);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(625,380,90,25);
		logoutBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		// logoutBtn.setForeground(Color.RED);
		logoutBtn.setBackground(new Color(204,208,214));
		logoutBtn.addActionListener(this);
		// logoutBtn.setBorder(null);
		logoutBtn.addMouseListener(this);
		panel.add(logoutBtn);
		
		showBtn = new JButton("Show");
		showBtn.setBounds(570,70,80,25);
		showBtn.setBorder(null);
		// showBtn.setContentAreaFilled(false);
		showBtn.setBackground(Color.RED);
		showBtn.setForeground(Color.WHITE);
		showBtn.addMouseListener(this);
		showBtn.addActionListener(this);
		panel.add(showBtn);
		
		editBtn =  new JButton("Edit Information");
		editBtn.setBounds(25,250,150,30);
		editBtn.addActionListener(this);
		panel.add(editBtn);
		
		changeBtn = new JButton("Change password");
		changeBtn.setBounds(440,380,160,30);
		changeBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		deleteBtn = new JButton("Delete profile");
		deleteBtn.setBounds(250,380,150,30);
		deleteBtn.setOpaque(true);
		deleteBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		checkPatList = new JButton("Check Patient List");
		checkPatList.setBounds(30,380,180,30);
		checkPatList.setOpaque(true);
		checkPatList.setFont(new Font("Courier New", Font.BOLD, 14));
		checkPatList.addMouseListener(this);
		checkPatList.addActionListener(this);
		panel.add(checkPatList);
		
		
		
		
		
		this.add(panel);
		
	}
	
	public void mouseEntered(MouseEvent me){
		if(me.getSource() == deleteBtn){
			deleteBtn.setForeground(Color.RED);
			
		}
		
		else if(me.getSource() == logoutBtn)
		{
			logoutBtn.setBackground(Color.RED);
			logoutBtn.setForeground(Color.WHITE);
		}
		else{}
	}  
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource() == deleteBtn){
			deleteBtn.setForeground(Color.RED);
			
		}
		
		else if(me.getSource() == logoutBtn)
		{
			logoutBtn.setBackground(Color.RED);
			logoutBtn.setForeground(Color.WHITE);
		}
		else{}
	}  
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == deleteBtn){
			
			deleteBtn.setForeground(Color.BLACK);
			
		}
		
		else if(me.getSource() == logoutBtn)
		{
			logoutBtn.setBackground(new Color(204,208,214));
			logoutBtn.setForeground(Color.BLACK);
		}
		
		else{}
	}  
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource() == showBtn){
			showBtn.setForeground(Color.BLACK);
			passwordLabel.setText("Password: "+pass);
		}
	}  
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource() == showBtn){
			// showBtn.setBackground(Color.RED);
			showBtn.setForeground(Color.WHITE);
			passwordLabel.setText("Password: "+hiddenPass);
		}
	} 
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(logoutBtn.getText().equals(command)){
			doclogin lg = new doclogin(ds);
			lg.setVisible(true);
			this.dispose();
		}
		
		else if(checkPatList.getText().equals(command))
	{
		patWaitGUI lg = new patWaitGUI(d,ds);
		lg.setVisible(true);
		this.dispose();
	}
		
		else if(deleteBtn.getText().equals(command))
	{
		int dialog = JOptionPane.YES_NO_OPTION;
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your profile?", "Delete user?", dialog);
			
		if(result == 0){
			ds.deleteDoctor(d.getName());
				
			JOptionPane.showMessageDialog(this, "User deleted. Redirecting to login page.");
				
			doclogin lg = new doclogin(ds);
			lg.setVisible(true);
			this.dispose();
		}else{ 
			//no nothing 
		}
	}
	
	else if(changeBtn.getText().equals(command)){
			updatedocpass ups = new updatedocpass(d,ds,this);
			ups.setVisible(true);
			this.dispose();
		}
		
		else if(editBtn.getText().equals(command)){
			changedocinfo upr = new changedocinfo(d,ds);
			upr.setVisible(true);
			this.setVisible(false);}
		
	}
}