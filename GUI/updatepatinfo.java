package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class updatepatinfo extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	 JLabel nameLabel, passwordLabel, genderLabel, 
	 dobLabel, bloodGroupLabel, emailLabel, 
	 usernameLabel, idLabel, maritalStatusLabel, phoneLabel;
    JTextField nameField, passwordField, genderField, dobField, bloodGroupField, emailField, usernameField, idField, maritalStatusField, phoneField;
    JButton addButton,backBtn;
    Font myFont;
	ImageIcon icon;
	patient p=null;
	patients ps=null;

    public updatepatinfo(patient p,patients ps) {
        super("Add Patient");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        myFont = new Font("Century", Font.PLAIN, 15);
		
		this.p=p;
		this.ps=ps;
		
        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(40, 20, 150, 30);
        nameLabel.setFont(myFont);
        panel.add(nameLabel);

        nameField = new JTextField(p.getName());
        nameField.setBounds(200, 20, 200, 30);
        panel.add(nameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 150, 30);
        passwordLabel.setFont(myFont);
        // panel.add(passwordLabel);

        passwordField = new JTextField(p.getPassword());
        passwordField.setBounds(200, 70, 200, 30);
        // panel.add(passwordField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 120, 150, 30);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);

        genderField = new JTextField(p.getGender());
        genderField.setBounds(200, 120, 200, 30);
        panel.add(genderField);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 170, 150, 30);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobField = new JTextField(p.getDob());
        dobField.setBounds(200, 170, 200, 30);
        panel.add(dobField);

        bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(30, 220, 150, 30);
        bloodGroupLabel.setFont(myFont);
        panel.add(bloodGroupLabel);

        bloodGroupField = new JTextField(p.getBloodgrp());
        bloodGroupField.setBounds(200, 220, 200, 30);
        panel.add(bloodGroupField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 270, 150, 30);
        emailLabel.setFont(myFont);
        panel.add(emailLabel);

        emailField = new JTextField(p.getEmail());
        emailField.setBounds(200, 270, 200, 30);
        panel.add(emailField);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 320, 150, 30);
        usernameLabel.setFont(myFont);
        panel.add(usernameLabel);

        usernameField = new JTextField(p.getUsername());
        usernameField.setBounds(200, 320, 200, 30);
        panel.add(usernameField);

        idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 370, 150, 30);
        idLabel.setFont(myFont);
        panel.add(idLabel);

        idField = new JTextField(p.getId());
        idField.setBounds(200, 370, 200, 30);
        panel.add(idField);

        maritalStatusLabel = new JLabel("Marital Status:");
        maritalStatusLabel.setBounds(450, 20, 150, 30);
        maritalStatusLabel.setFont(myFont);
        panel.add(maritalStatusLabel);

        maritalStatusField = new JTextField(p.getMartialstatus());
        maritalStatusField.setBounds(620, 20, 150, 30);
        panel.add(maritalStatusField);

        phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(450, 70, 150, 30);
        phoneLabel.setFont(myFont);
        panel.add(phoneLabel);

        phoneField = new JTextField(p.getPhonenumber());
        phoneField.setBounds(620, 70, 150, 30);
        panel.add(phoneField);

        addButton = new JButton("Save Changes");
        addButton.setBounds(300, 420, 150, 30);
        addButton.addActionListener(this);
        panel.add(addButton);
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
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
		if(addButton.getText().equals(command))
		{
			String name="",pass="",gender="",dob="",
			bloodgrp="",email="",username="",id="",
			maritalStatus="",phone="";
			
			name = nameField.getText();
			pass = p.getPassword();
			gender = genderField.getText();
			dob = dobField.getText();
			bloodgrp = bloodGroupField.getText();
			email = emailField.getText();
			username = usernameField.getText();
			id = idField.getText();
			maritalStatus = maritalStatusField.getText();
			phone = phoneField.getText();
			
			if((!name.isEmpty()) && (!pass.isEmpty()) && (!gender.isEmpty()) 
				&&(!dob.isEmpty()) &&(!bloodgrp.isEmpty()) 
			&&(!email.isEmpty()) &&(!username.isEmpty()) 
			&&(!id.isEmpty()) &&(!maritalStatus.isEmpty()) 
			&&(!phone.isEmpty())){
				int dialog = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?", "Profile update?", dialog);
				if(result == 0){
					//keeping the old info to check in file which user to update
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
					
					//updating new info
					p.setName(name);
					p.setPassword(pass);
					p.setGender(gender);
					p.setDob(dob);
					p.setBloodgrp(bloodgrp);
					p.setEmail(email);
					p.setUsername(username);
					p.setId(id);
					p.setMartialstatus(maritalStatus);
					p.setPhonenumber(phone);
					
					
					//olso updating in file
					ps.updatePatient(oldPatient, p);
					
					dialog = JOptionPane.YES_NO_OPTION;
					result = JOptionPane.showConfirmDialog(this, "Information updated. Do you want to stay on this page?", "Stay on this page?", dialog);
					if(result == 0){
						//do nothing
					}else{
						patdashboard db = new patdashboard(p,ps);
						db.setVisible(true);
						this.setVisible(false);
					}
				}else{
					//do nothing
				}
			}else{
				JOptionPane.showMessageDialog(this, "Can't update, information missing!");
			}
			
		}
		
		else if (backBtn.getText().equals(command))
		{
			patdashboard db = new patdashboard(p,ps);
						db.setVisible(true);
						this.setVisible(false);
		}
		
	}
}