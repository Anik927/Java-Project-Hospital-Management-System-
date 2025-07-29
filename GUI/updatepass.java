package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updatepass extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	
	JLabel passLabel,confirmpassLabel;
	JTextField passTF,confirmpassTF;
	JButton save,cancelBtn;
	Font myFont;
	patient p = null;
	patients ps = null;
	patdashboard db;
	
	public updatepass(patient p, patients ps,patdashboard db)
	{
		super("Change Password");
		this.setSize(800,500);
		// icon = new ImageIcon("Image\\5898998_bacteria_man_mask_patient_protection_icon.png");
		// this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.p = p;
		this.ps = ps;
		this.db=db;
		
		myFont = new Font("Century",Font.PLAIN, 22);
		
		panel = new JPanel();
		panel.setLayout(null);
		// panel.setBackground(myColor);
		
		passLabel = new JLabel("New Password: ");
		passLabel.setBounds(160,150,180,25);
		passLabel.setFont(myFont);
		panel.add(passLabel);
		
		confirmpassLabel = new JLabel("Confirm Password: ");
		confirmpassLabel.setBounds(158,200,200,25);
		confirmpassLabel.setFont(myFont);
		panel.add(confirmpassLabel);
		
		passTF =  new JTextField();
		passTF.setBounds(370,150,190,30);
		panel.add(passTF);
		
		confirmpassTF = new JTextField();
		confirmpassTF.setBounds(370,200,190,30);
		panel.add(confirmpassTF);
		
		save = new JButton("Save Password");
		save.setBounds(370,370,150,25);
		save.addMouseListener(this);
		save.addActionListener(this);
		panel.add(save);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(220,370,90,25);
		// cancelBtn.setFont(myFont);
		// cancelBtn.setBackground(myColor1);
		cancelBtn.setForeground(Color.RED);
		cancelBtn.addMouseListener(this);
		cancelBtn.addActionListener(this);
		cancelBtn.setBorder(null);
		panel.add(cancelBtn);
		
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
		if(save.getText().equals(command)){
			String pass = passTF.getText();
			String confirmPass = confirmpassTF.getText();
			if(!pass.isEmpty() && !confirmPass.isEmpty()){
				if(pass.equals(confirmPass)){
					String oldName = p.getName();
					String oldPass = p.getPassword();
					String oldGender = p.getGender();
					String oldDOB = p.getDob();
					String oldBloodgrp = p.getBloodgrp();
					String oldEmail = p.getEmail();
					String oldUsername = p.getUsername();
					String oldId = p.getId();
					String oldMartialstatus = p.getMartialstatus();
					String oldPhonenumber = p.getPhonenumber();
					patient oldPatient = new patient(oldName,oldPass,oldGender,oldDOB,
													oldBloodgrp,oldEmail,oldUsername,
													oldId,oldMartialstatus,oldPhonenumber);
					
					//updating password in object
					p.setPassword(pass);
					
					//olso updating in file
					ps.updatePatient(oldPatient, p);
					
					JOptionPane.showMessageDialog(this, "Password updated. Please login again.");
					patlogin lg = new patlogin(ps);
					lg.setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(this, "Password missmatch");
				}
			}
			else{
				JOptionPane.showMessageDialog(this, "All field is required");
			}
			
			}
		
		else if(cancelBtn.getText().equals(command))
		{
			db.setVisible(true);
			this.dispose();
		}
	}
}