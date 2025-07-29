package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
public class doclogin extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel,userLabel,passLabel,extraLabel,bgLabel;
	Font myFont,myFont3,myFont2;
	JTextField userTF;
	JPasswordField passTF;
	JButton loginBtn,backBtn,supportBtn;
	ImageIcon icon,bgImg;
	Color myColor;
	doctor d = null;
	doctors ds = null;
	public doclogin(doctors ds)
	{
		super("Doctor Login Panel");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\5929159_avatar_doctor_health_hospital_medical_icon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.ds=ds;
		
		myFont = new Font("Century",Font.PLAIN, 30);
		myFont2 = new Font("Courier New", Font.BOLD, 20);
		
		// myColor = new Color(204,208,214);
		panel = new JPanel();
		panel.setLayout(null);
		// panel.setBackground(myColor);
		
		introLabel = new JLabel("Hello Doctor");
		introLabel.setBounds(110,90,200,30);
		introLabel.setFont(myFont);
		// introLabel.setForeground(Color.YELLOW);
		panel.add(introLabel);
		
		userLabel = new JLabel("Name: ");
		userLabel.setBounds(30,200,150,20);
		userLabel.setFont(myFont2);
		// userLabel.setForeground(Color.WHITE);
		
		panel.add(userLabel);
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(30,243,120,20);
		passLabel.setFont(myFont2);
		// passLabel.setForeground(Color.WHITE);
		panel.add(passLabel);
		
		userTF = new JTextField();
		userTF.setBounds(145,196,180,30);
		userTF.setFont(myFont2);
		panel.add(userTF);
		
		passTF = new JPasswordField();
		passTF.setBounds(145,240,180,30);
		passTF.setFont(myFont2);
		passTF.setEchoChar('*');
		panel.add(passTF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(290,283,85,30);
		// loginBtn.setContentAreaFilled(false);
		// loginBtn.setForeground(Color.WHITE);
		loginBtn.addMouseListener(this);
		loginBtn.addActionListener(this);
		loginBtn.setBackground(new Color(158,179,221));
		loginBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		panel.add(loginBtn);
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
		backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		extraLabel = new JLabel("Can't login?");
		extraLabel.setBounds(30,380,160,20);
		extraLabel.setFont(myFont2);
		// extraLabel.setForeground(Color.WHITE);
		panel.add(extraLabel);
		
		supportBtn = new JButton("Support");
		supportBtn.setBounds(178,379,77,23);
		supportBtn.setBackground(Color.GREEN);
		supportBtn.setFont(new Font("Courier New", Font.BOLD, 16));
		supportBtn.addMouseListener(this);
		supportBtn.addActionListener(this);
		supportBtn.setBorder(null);
		panel.add(supportBtn);
		
		bgImg = new ImageIcon("Image\\docbg.jpg");
		bgLabel = new JLabel(bgImg);
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
		
		else if(supportBtn.getText().equals(command))
		{
			this.dispose();
			support a = new support();
			a.setVisible(true);
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
				int index = ds.doctorExists(name);
				if(index == -1)
				{
				JOptionPane.showMessageDialog(this, "User doesn't exist!");
				}
				else
				{
					d = ds.checkCredentials(index,pass);
					
					if(d == null )
					{
						JOptionPane.showMessageDialog(this, "Password incorrect");
					}
					else
					{
						docdashboard aoc = new docdashboard(d,ds);
						aoc.setVisible(true);
						this.dispose();
					}
				}
			}
			
		}
	}
}	