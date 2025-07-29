package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class patlogin extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel,userLabel,passLabel,extraLabel,extraLabel2;
	Font myFont,myFont3,myFont2;
	JTextField userTF;
	JPasswordField passTF;
	JButton loginBtn,backBtn,signupBtn,supportBtn;
	ImageIcon icon;
	Color myColor;
	patient p = null;
	patients ps = null;
	
	public patlogin(patients ps)
	{
		super("Patient Login Panel");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\5898998_bacteria_man_mask_patient_protection_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.ps = ps;
		
		myFont = new Font("Century",Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 20);
		
		myColor = new Color(204,208,214);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);
		
		introLabel = new JLabel("Hello Patient");
		introLabel.setBounds(270,90,200,30);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		userLabel = new JLabel("Username: ");
		userLabel.setBounds(190,190,150,20);
		// userLabel.setForeground(new Color(10,254,205));
		userLabel.setFont(myFont2);
		panel.add(userLabel);
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(190,253,120,20);
		passLabel.setFont(myFont2);
		panel.add(passLabel);
		
		userTF = new JTextField();
		userTF.setBounds(300,187,200,30);
		userTF.setFont(myFont2);
		panel.add(userTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(300,249,200,30);
		passTF.setFont(myFont2);
		passTF.setEchoChar('*');
		panel.add(passTF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(420,295,80,25);
		loginBtn.setBackground(new Color(158,179,221));
		loginBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		extraLabel = new JLabel("Don't have an Account?");
		extraLabel.setBounds(90,350,230,20);
		extraLabel.setForeground(Color.RED);
		extraLabel.setFont(new Font("Courier New", Font.BOLD, 17));
		panel.add(extraLabel);
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(318,345,70,30);
		signupBtn.setFont(new Font("Courier New", Font.PLAIN, 15));
		signupBtn.setBackground(Color.BLUE);
		signupBtn.setForeground(Color.GREEN);
		signupBtn.addMouseListener(this);
		signupBtn.addActionListener(this);
		signupBtn.setBorder(null);
		panel.add(signupBtn);
		
		extraLabel2 = new JLabel("Can't Login?");
		extraLabel2.setBounds(87,391,140,20);
		extraLabel2.setForeground(Color.YELLOW);
		extraLabel2.setFont(new Font("Courier New", Font.BOLD, 17));
		panel.add(extraLabel2);
		
		supportBtn = new JButton("Support");
		supportBtn.setBounds(213,388,70,27);
		supportBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		supportBtn.setBackground(Color.GREEN);
		supportBtn.addMouseListener(this);
		supportBtn.addActionListener(this);
		supportBtn.setBorder(null);
		panel.add(supportBtn);
		
		ImageIcon bgImg = new ImageIcon("Image\\patbg.jpg");
		JLabel bgLabel = new JLabel(bgImg);
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
		
		if(loginBtn.getText().equals(command))
		{
			String name = userTF.getText();
			String pass = passTF.getText();
			
			if(name.isEmpty() || pass.isEmpty())
			{
			JOptionPane.showMessageDialog(this, "Information missing");
			}
			else
			{
				int index = ps.patientExists(name);
				if(index == -1)
				{
				JOptionPane.showMessageDialog(this, "User doesn't exist!");
				}
				else
				{
					p = ps.checkCredentials(index,pass);
					
					if(p == null )
					{
						JOptionPane.showMessageDialog(this, "Password incorrect");
					}
					else
					{
						patdashboard aoc = new patdashboard(p,ps);
						aoc.setVisible(true);
						this.dispose();
					}
				}
			}
			
		}
		
		
		
		
		else if(backBtn.getText().equals(command))
		{
			this.dispose();
			firstpage foc = new firstpage();
			foc.setVisible(true);
		}
		
		else if(signupBtn.getText().equals(command))
		{
			this.dispose();
			signup a = new signup(ps);
			a.setVisible(true);
		}
		
		else if(supportBtn.getText().equals(command))
		{
			this.dispose();
			support a = new support();
			a.setVisible(true);
		}
	}
}	