package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addashboard extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel nameLabel,passwordLabel,genderLabel,dobLabel,bloodgrpLabel,emailLabel,positionLabel,typeLabel;
	Font myFont;
	JButton logoutBtn,showBtn,editBtn,changeBtn,deleteBtn,backBtn,addadminBtn,rmvadminBtn,rmvdocBtn,adddoc;
	admin a;
	admins as;
	String pass="",hiddenPass="";
	ImageIcon icon;
	doctors ds;
	// doctor d = new doctor();
	
	public addashboard (admin a,admins as)
	{
		super("Admin Dashboard");
		this.setSize(800,500);
		// icon = new ImageIcon("Image\\5859955_cervical_collar_injury_medical_neck_icon.png");
		// this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.a=a;
		this.as=as;
		
		myFont = new Font("Courier New", Font.BOLD, 18);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		icon  = new  ImageIcon("Image\\ad.png");
		JLabel dpLabel = new JLabel(icon);
		dpLabel.setBounds(-15,15,200,200);
		panel.add(dpLabel);
		
		nameLabel = new JLabel("Name: "+a.getName());
		nameLabel.setBounds(200,10,350,30);
		nameLabel.setFont(myFont);
		panel.add(nameLabel);
		
	
		pass = a.getPassword();
		int passLenghth = pass.length();
		for(int i =0;i<passLenghth;i++)
		{
			hiddenPass += '*';
		}
		
		passwordLabel = new JLabel("Password: "+hiddenPass);
		passwordLabel.setBounds(200,70,600,30);
		passwordLabel.setFont(myFont);
		panel.add(passwordLabel);
		
		genderLabel = new JLabel("Gender: "+a.getGender());
		genderLabel.setBounds(200,100,300,30);
		genderLabel.setFont(myFont);
		panel.add(genderLabel);
		
		dobLabel = new JLabel("Date of birth: "+a.getDob());
		dobLabel.setBounds(200,130,600,30);
		dobLabel.setFont(myFont);
		panel.add(dobLabel);
		
		bloodgrpLabel = new JLabel("Blood Group: "+a.getBloodgrp());
		bloodgrpLabel.setBounds(200,160,300,30);
		bloodgrpLabel.setFont(myFont);
		panel.add(bloodgrpLabel);
		
		emailLabel = new JLabel("Email: "+a.getEmail());
		emailLabel.setBounds(200,190,500,30);
		emailLabel.setFont(myFont);
		panel.add(emailLabel);
		
		positionLabel = new JLabel("Position: "+a.getPosition());
		positionLabel.setBounds(200,220,300,30);
		positionLabel.setFont(myFont);
		panel.add(positionLabel);
		
		typeLabel = new JLabel("Type: "+a.getType());
		typeLabel.setBounds(200,250,600,30);
		typeLabel.setFont(myFont);
		panel.add(typeLabel);
		
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
		
		deleteBtn = new JButton("Delete profile");
		deleteBtn.setBounds(25,300,150,30);
		deleteBtn.setOpaque(true);
		deleteBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		deleteBtn.addMouseListener(this);
		deleteBtn.addActionListener(this);
		panel.add(deleteBtn);
		
		addadminBtn = new JButton("Add Admin");
		addadminBtn.setBounds(577,250,150,30);
		addadminBtn.setOpaque(true);
		addadminBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		addadminBtn.addMouseListener(this);
		addadminBtn.addActionListener(this);
		panel.add(addadminBtn);
		
		adddoc = new JButton("Add Doctor");
		adddoc.setBounds(410,250,150,30);
		adddoc.setOpaque(true);
		adddoc.setFont(new Font("Courier New", Font.BOLD, 14));
		adddoc.addMouseListener(this);
		adddoc.addActionListener(this);
		panel.add(adddoc);
		
		rmvadminBtn = new JButton("Remove Admin");
		rmvadminBtn.setBounds(577,300,150,30);
		rmvadminBtn.setOpaque(true);
		rmvadminBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		rmvadminBtn.addMouseListener(this);
		rmvadminBtn.addActionListener(this);
		panel.add(rmvadminBtn);
		
		rmvdocBtn = new JButton("Remove Doctor");
		rmvdocBtn.setBounds(410,300,150,30);
		rmvdocBtn.setOpaque(true);
		rmvdocBtn.setFont(new Font("Courier New", Font.BOLD, 14));
		rmvdocBtn.addMouseListener(this);
		rmvdocBtn.addActionListener(this);
		panel.add(rmvdocBtn);
		
		
		
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
			adlogin lg = new adlogin(as);
			lg.setVisible(true);
			this.dispose();
		}
		
		else if(rmvadminBtn.getText().equals(command))
		{
			this.dispose();
			rmvadmin aa = new rmvadmin(a,as);
			aa.setVisible(true);
		}
		
		else if(rmvdocBtn.getText().equals(command))
		{
			doctors.doctorCount=0;
			ds = new doctors();
			this.dispose();
			rmvdoctor aa = new rmvdoctor(ds,a,as);
			aa.setVisible(true);
		}
		
		else if(adddoc.getText().equals(command))
		{
			this.dispose();
			doctors.doctorCount=0;
			ds=new doctors();
			adddoc d = new adddoc(ds,a,as);
			d.setVisible(true);
		}
		
		else if(addadminBtn.getText().equals(command))
		{
			this.dispose();
			addadmin e = new addadmin(a,as);
			e.setVisible(true);
		}
		
		else if(deleteBtn.getText().equals(command))
	{
		int dialog = JOptionPane.YES_NO_OPTION;
		int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your profile?", "Delete user?", dialog);
			
		if(result == 0){
			as.removeAdmin(a.getName());
				
			JOptionPane.showMessageDialog(this, "User deleted. Redirecting to login page.");
				
			adlogin lg = new adlogin(as);
			lg.setVisible(true);
			this.dispose();
		}else{ 
			// no nothing 
		}
	}
	
	
	
	else if(editBtn.getText().equals(command)){
			changeadinfo ups = new changeadinfo(a,as);
			ups.setVisible(true);
			this.dispose();
		}
		
		
		
		
	}
}
	
	
