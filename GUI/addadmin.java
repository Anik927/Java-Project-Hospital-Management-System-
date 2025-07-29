package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addadmin extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
    JLabel nameLabel, passwordLabel, genderLabel, dobLabel, bloodGroupLabel, emailLabel, positionLabel, typeLabel;
    JTextField nameField, passwordField, genderField, dobField, bloodGroupField, emailField, positionField, typeField;
    JButton addButton,backBtn;
    Font myFont;
	ImageIcon icon;
	admins as = null;
	admin a;
    public addadmin(admin a,admins as) {
        super("Add Admin");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		this.a=a;
		this.as=as;
		
        myFont = new Font("Century", Font.PLAIN, 22);

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 20, 150, 30);
        nameLabel.setFont(myFont);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(220, 20, 220, 30);
        panel.add(nameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 150, 30);
        passwordLabel.setFont(myFont);
        panel.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(220, 70, 220, 30);
        panel.add(passwordField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 120, 150, 30);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(220, 120, 220, 30);
        panel.add(genderField);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 170, 150, 30);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(220, 170, 220, 30);
        panel.add(dobField);

        bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(50, 220, 150, 30);
        bloodGroupLabel.setFont(myFont);
        panel.add(bloodGroupLabel);

        bloodGroupField = new JTextField();
        bloodGroupField.setBounds(220, 220, 220, 30);
        panel.add(bloodGroupField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 270, 150, 30);
        emailLabel.setFont(myFont);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(220, 270, 220, 30);
        panel.add(emailField);

        positionLabel = new JLabel("Position:");
        positionLabel.setBounds(50, 320, 150, 30);
        positionLabel.setFont(myFont);
        panel.add(positionLabel);

        positionField = new JTextField();
        positionField.setBounds(220, 320, 220, 30);
        panel.add(positionField);

        typeLabel = new JLabel("Type:");
        typeLabel.setBounds(50, 370, 150, 30);
        typeLabel.setFont(myFont);
        panel.add(typeLabel);

        typeField = new JTextField();
        typeField.setBounds(220, 370, 220, 30);
        panel.add(typeField);

        addButton = new JButton("Add Admin");
        addButton.setBounds(300, 420, 150, 30);
        addButton.addActionListener(this);
        panel.add(addButton);
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(10,3,24,24);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
        add(panel);
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
			
			String name="",pass="",dob="",gender="",bloodgrp="",
			email="",position="",type="";
			
			name = nameField.getText();
			pass = passwordField.getText();
			dob = dobField.getText();
			gender = genderField.getText();
			bloodgrp = bloodGroupField.getText();
			email = emailField.getText();
			position = positionField.getText();
			type = typeField.getText();
			
			if((!name.isEmpty()) && (!pass.isEmpty()) && (!gender.isEmpty()) 
				&&(!dob.isEmpty()) &&(!bloodgrp.isEmpty()) 
			&&(!email.isEmpty()) &&(!position.isEmpty()) &&(!type.isEmpty()))
			{
				admin k = new admin (name,pass,gender,dob,bloodgrp,email,position,type);
				as.addAdmin(k);
				JOptionPane.showMessageDialog(this, "Sign up successful. Please login to continue.");
				addashboard db = new addashboard(a,as);
				db.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Information missing");
			}
		}
		else if (backBtn.getText().equals(command))
		{
			addashboard db = new addashboard(a,as);
			db.setVisible(true);
			this.setVisible(false);
		}
	}
	
}