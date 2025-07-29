package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class adlogin extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel,userLabel,passLabel;
	Font myFont,myFont3,myFont2,myFont4;
	JTextField userTF;
	JPasswordField passTF;
	JButton loginBtn,backBtn;
	ImageIcon icon;
	Color myColor;
	admin a;
	admins as=null;
	public adlogin(admins as)
	{
		super("Admin Login Panel");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\5027870_admin_man_person_user_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.as=as;
		
		myFont = new Font("Century",Font.BOLD, 30);
		myFont2 = new Font("Courier New", Font.PLAIN, 20);
		myFont3 = new Font("Courier New", Font.BOLD, 16);
		myFont4 = new Font("Courier New", Font.BOLD, 20);
		
		myColor = new Color(204,208,214);
		panel = new JPanel();
		panel.setLayout(null);
		// panel.setBackground(myColor); 
		
		introLabel = new JLabel("Hello Admin");
		introLabel.setForeground(Color.WHITE);
		introLabel.setBounds(300,110,200,30);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		userLabel = new JLabel("Username: ");
		userLabel.setForeground(new Color(10,254,205));
		userLabel.setBounds(200,180,120,25);
		userLabel.setFont(myFont4);
		panel.add(userLabel);
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(200,230,120,25);
		passLabel.setForeground(new Color(10,254,205));
		passLabel.setFont(myFont4);
		panel.add(passLabel);
		
		userTF = new JTextField();
		userTF.setBounds(310,178,190,30);
		userTF.setFont(myFont2);
		panel.add(userTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(310,228,190,30);
		passTF.setFont(myFont2);
		passTF.setEchoChar('*');
		panel.add(passTF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(460,280,85,30);
		// loginBtn.setForeground(Color.WHITE);
		// loginBtn.setBackground(new Color(158,179,221));
		loginBtn.setFont(myFont3);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		icon = new ImageIcon ("Image\\backInvs.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
		backBtn.setBackground(myColor);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		ImageIcon bgImg = new ImageIcon("Image\\adbg.jpg");
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
		if(backBtn.getText().equals(command))
		{
			this.dispose();
			firstpage foc = new firstpage();
			foc.setVisible(true);
		}
		else if(loginBtn.getText().equals(command))
		{
			String name = userTF.getText();
			String pass = passTF.getText();
			
			if(name.isEmpty() || pass.isEmpty())
			{
			JOptionPane.showMessageDialog(this, "Information missing");
			}
			else
			{
				int index = as.adminExists(name);
				if(index == -1)
				{
				JOptionPane.showMessageDialog(this, "User doesn't exist!");
				}
				else
				{
					a = as.checkCredentials(index,pass);
					
					if(a == null )
					{
						JOptionPane.showMessageDialog(this, "Password incorrect");
					}
					else
					{
						addashboard aoc = new addashboard(a,as);
						aoc.setVisible(true);
						this.dispose();
					}
				}
			}
			
		}
	}
}	