package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class adddoc extends JFrame implements MouseListener, ActionListener
{
	 JPanel panel;
    JLabel nameLabel, passwordLabel, genderLabel, dobLabel, bloodGroupLabel, emailLabel, roomLabel, educationLabel, feesLabel, timeLabel;
    JTextField nameField, passwordField, genderField, dobField, bloodGroupField, emailField, roomField, educationField, feesField, timeField;
    JButton addButton,backBtn;
    Font myFont;
	ImageIcon icon;
	doctor d = null;
	doctors ds = null;
	admin a = null;
	admins as = null;
    public adddoc(doctors ds,admin a,admins as) {
        super("Create a Doctor");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		
		this.ds=ds;
		this.a=a;
		this.as=as;
		
        myFont = new Font("Century", Font.PLAIN, 15);

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 25, 150, 30);
        nameLabel.setFont(myFont);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 25, 200, 30);
        panel.add(nameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 150, 30);
        passwordLabel.setFont(myFont);
        panel.add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(200, 70, 200, 30);
        panel.add(passwordField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 120, 150, 30);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);

        genderField = new JTextField();
        genderField.setBounds(200, 120, 200, 30);
        panel.add(genderField);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 170, 150, 30);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(200, 170, 200, 30);
        panel.add(dobField);

        bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(30, 220, 150, 30);
        bloodGroupLabel.setFont(myFont);
        panel.add(bloodGroupLabel);

        bloodGroupField = new JTextField();
        bloodGroupField.setBounds(200, 220, 200, 30);
        panel.add(bloodGroupField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 270, 150, 30);
        emailLabel.setFont(myFont);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(200, 270, 200, 30);
        panel.add(emailField);

        roomLabel = new JLabel("Room no.:");
        roomLabel.setBounds(30, 320, 150, 30);
        roomLabel.setFont(myFont);
        panel.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(200, 320, 200, 30);
        panel.add(roomField);

        educationLabel = new JLabel("Education:");
        educationLabel.setBounds(30, 370, 150, 30);
        educationLabel.setFont(myFont);
        panel.add(educationLabel);

        educationField = new JTextField();
        educationField.setBounds(200, 370, 200, 30);
        panel.add(educationField);

		feesLabel = new JLabel("Fees:");
        feesLabel.setBounds(450, 20, 150, 30);
        feesLabel.setFont(myFont);
        panel.add(feesLabel);

        feesField = new JTextField();
        feesField.setBounds(620, 20, 150, 30);
        panel.add(feesField);


        timeLabel = new JLabel("Time: ");
        timeLabel.setBounds(450, 70, 150, 30);
        timeLabel.setFont(myFont);
        panel.add(timeLabel);

        timeField = new JTextField();
        timeField.setBounds(620, 70, 150, 30);
        panel.add(timeField);

        addButton = new JButton("Create Doctor");
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
		String name="",pass="",gender="",dob="",
			bloodgrp="",email="",room="",education="",fees="",time="";
			
			name = nameField.getText();
			pass = passwordField.getText();
			gender = genderField.getText();
			dob = dobField.getText();
			bloodgrp = bloodGroupField.getText();
			email = emailField.getText();
			room = roomField.getText();
			education = educationField.getText();
			fees = feesField.getText();
			time = timeField.getText();
			
			if((!name.isEmpty()) && (!pass.isEmpty()) && (!gender.isEmpty()) 
				&&(!dob.isEmpty()) &&(!bloodgrp.isEmpty()) 
			&&(!email.isEmpty()) &&(!room.isEmpty()) &&(!education.isEmpty()) &&(!fees.isEmpty()) &&(!time.isEmpty()))
			{
				doctor k = new doctor(name,pass,gender,dob,bloodgrp,email,room,education,fees,time);
				ds.addDoctor(k);
				JOptionPane.showMessageDialog(this, "Sign up successful. Please login to continue.");
				addashboard db = new addashboard(a,as);
				db.setVisible(true);
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "Information missing!");
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
	
	



