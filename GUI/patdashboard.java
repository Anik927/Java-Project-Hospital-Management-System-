package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class patdashboard extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel nameLabel,passwordLabel,genderLabel,dobLabel,bloodgrpLabel,emailLabel,usernameLabel,idLabel,martialstatusLabel,phonenumberLabel;
	JButton logoutBtn,showBtn,editBtn,changeBtn,deleteBtn,backBtn,docBtn;
	Font myFont,myFont2;
	patient p;
	patients ps;
	String pass="",hiddenPass="";
	ImageIcon icon,dp,icona;
	public static int pageno;
	public patdashboard(patient p , patients ps)
	{
		super("Patient DashBoard");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\5859955_cervical_collar_injury_medical_neck_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		pageno=0;
		
		this.p=p;
		this.ps=ps;
		
		myFont = new Font("Century", Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 18);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		if(p.getGender().trim().equalsIgnoreCase("Female")) 
		{
		dp = new ImageIcon("Image\\patdash.png");
		}
		
		else if(p.getGender().trim().equalsIgnoreCase("Male")) 
		{
		dp = new ImageIcon("Image\\patdash2.png");
		}
		
		
		JLabel dpLabel = new JLabel(dp);
		dpLabel.setBounds(-15,15,200,200);
		panel.add(dpLabel);
		
		
		nameLabel = new JLabel("Name: "+p.getName());
		nameLabel.setBounds(200,10,350,30);
		nameLabel.setFont(myFont2);
		panel.add(nameLabel);
		
		usernameLabel = new JLabel("Username: "+p.getUsername());
		usernameLabel.setBounds(200,40,300,30);
		usernameLabel.setFont(myFont2);
		panel.add(usernameLabel);
		
		pass = p.getPassword();
		int passLenghth = pass.length();
		for(int i =0;i<passLenghth;i++)
		{
			hiddenPass += '*';
		}
		
		passwordLabel = new JLabel("Password: "+hiddenPass);
		passwordLabel.setBounds(200,70,600,30);
		passwordLabel.setFont(myFont2);
		panel.add(passwordLabel);
		
		genderLabel = new JLabel("Gender: "+p.getGender());
		genderLabel.setBounds(200,100,300,30);
		genderLabel.setFont(myFont2);
		panel.add(genderLabel);
		
		dobLabel = new JLabel("Date of birth: "+p.getDob());
		dobLabel.setBounds(200,130,600,30);
		dobLabel.setFont(myFont2);
		panel.add(dobLabel);
		
		bloodgrpLabel = new JLabel("Blood Group: "+p.getBloodgrp());
		bloodgrpLabel.setBounds(200,160,300,30);
		bloodgrpLabel.setFont(myFont2);
		panel.add(bloodgrpLabel);
		
		emailLabel = new JLabel("Email: "+p.getEmail());
		emailLabel.setBounds(200,190,500,30);
		emailLabel.setFont(myFont2);
		panel.add(emailLabel);
		
		
		idLabel = new JLabel("ID: "+p.getId());
		idLabel.setBounds(200,220,300,30);
		idLabel.setFont(myFont2);
		panel.add(idLabel);
		
		martialstatusLabel = new JLabel("Martial Status: "+p.getMartialstatus());
		martialstatusLabel.setBounds(200,250,600,30);
		martialstatusLabel.setFont(myFont2);
		panel.add(martialstatusLabel);
		
		phonenumberLabel = new JLabel("Phone Number:"+p.getPhonenumber());
		phonenumberLabel.setBounds(200,280,320,30);
		phonenumberLabel.setFont(myFont2);
		panel.add(phonenumberLabel);
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(625,380,90,25);
		logoutBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		// logoutBtn.setForeground(Color.RED);
		logoutBtn.setBackground(new Color(204,208,214));
		logoutBtn.addActionListener(this);
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
		
		docBtn = new JButton("See Doctor List");
		docBtn.setBounds(40,380,155,30);
		docBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		docBtn.addActionListener(this);
		panel.add(docBtn);
		
		
		
		deleteBtn = new JButton("Delete profile");
		deleteBtn.setBounds(240,380,150,30);
		deleteBtn.setOpaque(true);
		deleteBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		icona = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icona);
		backBtn.setBounds(3,3,24,24);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		// panel.add(backBtn);
		
		this.add(panel);
			
	}
	
	public void mouseClicked(MouseEvent me){}
	
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
	
	public void mouseExited(MouseEvent me){
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
	
	public void mousePressed(MouseEvent me){
		if(me.getSource() == showBtn){
			showBtn.setForeground(Color.BLACK);
			passwordLabel.setText("Password: "+pass);
		}
	}
	
	public void mouseReleased(MouseEvent me){
		if(me.getSource() == showBtn){
			// showBtn.setBackground(Color.RED);
			showBtn.setForeground(Color.WHITE);
			passwordLabel.setText("Password: "+hiddenPass);
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(logoutBtn.getText().equals(command)){
			patlogin lg = new patlogin(ps);
			lg.setVisible(true);
			this.dispose();
		}
	else if(docBtn.getText().equals(command))
	{
		bookdoctor jk = new bookdoctor(p,ps,pageno);
		jk.setVisible(true);
		this.dispose();
	}
	else if(deleteBtn.getText().equals(command))
	{
		int dialog = JOptionPane.YES_NO_OPTION;
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your profile?", "Delete user?", dialog);
			
		if(result == 0){
			ps.deletePatient(p.getName());
				
			JOptionPane.showMessageDialog(this, "User deleted. Redirecting to login page.");
				
			patlogin lg = new patlogin(ps);
			lg.setVisible(true);
			this.dispose();
		}else{ 
			//no nothing 
		}
	}
		
	else if(changeBtn.getText().equals(command)){
			updatepass ups = new updatepass(p,ps,this);
			ups.setVisible(true);
			this.dispose();
		}
		
	else if(editBtn.getText().equals(command)){
			updatepatinfo upr = new updatepatinfo(p,ps);
			upr.setVisible(true);
	this.setVisible(false);}
	}
	
}