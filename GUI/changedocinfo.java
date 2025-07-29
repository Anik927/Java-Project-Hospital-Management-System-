package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class changedocinfo extends JFrame implements MouseListener, ActionListener
{
	 JPanel panel;
    JLabel nameLabel, passwordLabel, genderLabel, dobLabel, bloodGroupLabel, emailLabel, roomLabel, educationLabel, feesLabel, timeLabel;
    JTextField nameField, passwordField, genderField, dobField, bloodGroupField, emailField, roomField, educationField, feesField, timeField;
    JButton addButton;
    Font myFont;
	doctor d = null;
	doctors ds = null;
    public changedocinfo(doctor d,doctors ds) {
        super("Change Doctor Info");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		this.d=d;
		this.ds=ds;
		
		
        myFont = new Font("Century", Font.PLAIN, 15);

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(30, 20, 150, 30);
        nameLabel.setFont(myFont);
        panel.add(nameLabel);

        nameField = new JTextField(d.getName());
        nameField.setBounds(200, 20, 200, 30);
        panel.add(nameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 150, 30);
        passwordLabel.setFont(myFont);
        // panel.add(passwordLabel);

        passwordField = new JTextField(d.getPassword());
        passwordField.setBounds(200, 70, 200, 30);
        // panel.add(passwordField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 120, 150, 30);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);

        genderField = new JTextField(d.getGender());
        genderField.setBounds(200, 120, 200, 30);
        panel.add(genderField);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 170, 150, 30);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobField = new JTextField(d.getDob());
        dobField.setBounds(200, 170, 200, 30);
        panel.add(dobField);

        bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(30, 220, 150, 30);
        bloodGroupLabel.setFont(myFont);
        panel.add(bloodGroupLabel);

        bloodGroupField = new JTextField(d.getBloodgrp());
        bloodGroupField.setBounds(200, 220, 200, 30);
        panel.add(bloodGroupField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 270, 150, 30);
        emailLabel.setFont(myFont);
        panel.add(emailLabel);

        emailField = new JTextField(d.getEmail());
        emailField.setBounds(200, 270, 200, 30);
        panel.add(emailField);

        roomLabel = new JLabel("Room no.:");
        roomLabel.setBounds(30, 320, 150, 30);
        roomLabel.setFont(myFont);
        panel.add(roomLabel);

        roomField = new JTextField(d.getRoom());
        roomField.setBounds(200, 320, 200, 30);
        panel.add(roomField);

        educationLabel = new JLabel("Education:");
        educationLabel.setBounds(30, 370, 150, 30);
        educationLabel.setFont(myFont);
        panel.add(educationLabel);

        educationField = new JTextField(d.getEducation());
        educationField.setBounds(200, 370, 200, 30);
        panel.add(educationField);


        timeLabel = new JLabel("Time: ");
        timeLabel.setBounds(450, 70, 150, 30);
        timeLabel.setFont(myFont);
        panel.add(timeLabel);

        timeField = new JTextField(d.getTime());
        timeField.setBounds(620, 70, 150, 30);
        panel.add(timeField);

        addButton = new JButton("Save Changes");
        addButton.setBounds(300, 420, 150, 30);
        addButton.addActionListener(this);
        panel.add(addButton);

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
			pass = d.getPassword();
			gender = genderField.getText();
			dob = dobField.getText();
			bloodgrp = bloodGroupField.getText();
			email = emailField.getText();
			room = roomField.getText();
			education = educationField.getText();
			fees = d.getFees();
			time = timeField.getText();
			
			if((!name.isEmpty()) && (!pass.isEmpty()) && (!gender.isEmpty()) 
				&&(!dob.isEmpty()) &&(!bloodgrp.isEmpty()) 
			&&(!email.isEmpty()) &&(!room.isEmpty()) &&(!education.isEmpty()) &&(!fees.isEmpty()) &&(!time.isEmpty()))
			{
				
				int dialog = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?", "Profile update?", dialog);
				
				if(result == 0){
					//keeping the old info to check in file which user to update
					String oldName = d.getName();
					String oldPass = d.getPassword();
					String oldGender = d.getGender();
					String oldDOB = d.getDob();
					String oldBloodgrp = d.getBloodgrp();
					String oldEmail = d.getEmail();
					String oldRoom = d.getRoom();
					String oldEducation = d.getEducation();
					String oldFees = d.getFees();
					String oldTime = d.getTime();
					doctor oldDoctor = new doctor(oldName,oldPass,oldGender,oldDOB,
													oldBloodgrp,oldEmail,oldRoom,oldEducation,oldFees,
													oldTime);
					
					//updating new info
					d.setName(name);
					d.setPassword(pass);
					d.setGender(gender);
					d.setDob(dob);
					d.setBloodgrp(bloodgrp);
					d.setEmail(email);
					d.setRoom(room);
					d.setEducation(education);
					d.setFees(fees);
					d.setTime(time);
					
					
					//olso updating in file
					ds.updateInfo(oldDoctor, d);
					
					dialog = JOptionPane.YES_NO_OPTION;
					result = JOptionPane.showConfirmDialog(this, "Information updated. Do you want to stay on this page?", "Stay on this page?", dialog);
					if(result == 0)
					{
						//do nothing
					}else{
						docdashboard db = new docdashboard(d,ds);
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
			
	}
	}
	
	



