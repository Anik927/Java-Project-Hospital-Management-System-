package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class changeadinfo extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
    JLabel nameLabel, passwordLabel, genderLabel, dobLabel, bloodGroupLabel, emailLabel, positionLabel, typeLabel;
    JTextField nameField, passwordField, genderField, dobField, bloodGroupField, emailField, positionField, typeField;
    JButton addButton;
    Font myFont;
	admin a = null;
	admins as = null;

    public changeadinfo(admin a,admins as) {
        super("Change Info");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		this.a=a;
		this.as=as;
		
        myFont = new Font("Century", Font.PLAIN, 22);

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 20, 150, 30);
        nameLabel.setFont(myFont);
        panel.add(nameLabel);

        nameField = new JTextField(a.getName());
        nameField.setBounds(200, 20, 200, 30);
        panel.add(nameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 150, 30);
        passwordLabel.setFont(myFont);
        panel.add(passwordLabel);

        passwordField = new JTextField(a.getPassword());
        passwordField.setBounds(200, 70, 200, 30);
        panel.add(passwordField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 120, 150, 30);
        genderLabel.setFont(myFont);
        panel.add(genderLabel);

        genderField = new JTextField(a.getGender());
        genderField.setBounds(200, 120, 200, 30);
        panel.add(genderField);

        dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 170, 150, 30);
        dobLabel.setFont(myFont);
        panel.add(dobLabel);

        dobField = new JTextField(a.getDob());
        dobField.setBounds(200, 170, 200, 30);
        panel.add(dobField);

        bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(30, 220, 150, 30);
        bloodGroupLabel.setFont(myFont);
        panel.add(bloodGroupLabel);

        bloodGroupField = new JTextField(a.getBloodgrp());
        bloodGroupField.setBounds(200, 220, 200, 30);
        panel.add(bloodGroupField);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 270, 150, 30);
        emailLabel.setFont(myFont);
        panel.add(emailLabel);

        emailField = new JTextField(a.getEmail());
        emailField.setBounds(200, 270, 200, 30);
        panel.add(emailField);

        positionLabel = new JLabel("Position:");
        positionLabel.setBounds(30, 320, 150, 30);
        positionLabel.setFont(myFont);
        panel.add(positionLabel);

        positionField = new JTextField(a.getPosition());
        positionField.setBounds(200, 320, 200, 30);
        panel.add(positionField);

        typeLabel = new JLabel("Type:");
        typeLabel.setBounds(30, 370, 150, 30);
        typeLabel.setFont(myFont);
        panel.add(typeLabel);

        typeField = new JTextField(a.getType());
        typeField.setBounds(200, 370, 200, 30);
        panel.add(typeField);

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
			bloodgrp="",email="",position="",type="";
			
			name = nameField.getText();
			pass = passwordField.getText();
			gender = genderField.getText();
			dob = dobField.getText();
			bloodgrp = bloodGroupField.getText();
			email = emailField.getText();
			position = positionField.getText();
			type = typeField.getText();
			
			if((!name.isEmpty()) && (!pass.isEmpty()) && (!gender.isEmpty()) 
				&&(!dob.isEmpty()) &&(!bloodgrp.isEmpty()) 
			&&(!email.isEmpty()) &&(!position.isEmpty()) &&(!type.isEmpty()))
			{
				int dialog = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to update these informations?", "Profile update?", dialog);
				
				if(result == 0){
					//keeping the old info to check in file which user to update
					String oldName = a.getName();
					String oldPass = a.getPassword();
					String oldGender = a.getGender();
					String oldDOB = a.getDob();
					String oldBloodgrp = a.getBloodgrp();
					String oldEmail = a.getEmail();
					String oldPositin = a.getPosition();
					String oldType = a.getType();
					admin oldAdmin = new admin(oldName,oldPass,oldGender,oldDOB,
													oldBloodgrp,oldEmail,oldPositin,oldType);
					
					//updating new info
					a.setName(name);
					a.setPassword(pass);
					a.setGender(gender);
					a.setDob(dob);
					a.setBloodgrp(bloodgrp);
					a.setEmail(email);
					a.setPosition(position);
					a.setType(type);
					
					
					
					//olso updating in file
					as.updateAdmin(oldAdmin, a);
					
					dialog = JOptionPane.YES_NO_OPTION;
					result = JOptionPane.showConfirmDialog(this, "Information updated. Do you want to stay on this page?", "Stay on this page?", dialog);
					if(result == 0)
					{
						//do nothing
					}else{
						addashboard db = new addashboard(a,as);
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