package GUI;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;
import Interfaces.*;

public class firstpage extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel;
	JButton docBtn,patBtn,adBtn,exitBtn;
	ImageIcon icon;
	Font myFont;
	patients ps = null;
	doctors ds = null;
	admins as = null;
	
	
	public firstpage()
	{
		super("Hospital Management System");
		this.setSize(800,500);
		icon = new ImageIcon("Image\\firstpageIcon.png");
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		patients.patientCount = 0; // Took me one hour to figure it out :)))
        doctors.doctorCount = 0;
		admins.adminCount=0;
		
		myFont = new Font("Century",Font.PLAIN, 17);
		
		introLabel = new JLabel("You are a/an ");
		introLabel.setBounds(330,100,190,20);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		docBtn = new JButton("DOCTOR");
		docBtn.setBounds(170,170,110,70);
		docBtn.addMouseListener(this);
		docBtn.addActionListener(this);
		panel.add(docBtn);
		
		patBtn = new JButton("PATIENT");
		patBtn.setBounds(470,170,110,70);
		patBtn.addMouseListener(this);
		patBtn.addActionListener(this);
		panel.add(patBtn);
		
		adBtn = new JButton("ADMIN");
		adBtn.setBounds(320,280,110,70);
		adBtn.addMouseListener(this);
		adBtn.addActionListener(this);
		panel.add(adBtn);
		
		icon = new ImageIcon("Image/exitInvs.png");
		exitBtn = new JButton(icon);
		exitBtn.setBounds(745,10,30,30);
		exitBtn.setContentAreaFilled(false);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		exitBtn.setBorder(null);
		
		panel.add(exitBtn);
		
		ImageIcon bgimg = new ImageIcon("Image\\fpbg.jpg");
		JLabel bgLabel = new JLabel(bgimg);
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
		if(exitBtn.getText().equals(command))
		{
			this.dispose();
		}
		
		else if(docBtn.getText().equals(command))
		{
			ds = new doctors();
			doclogin h = new doclogin(ds);
			h.setVisible(true);
			this.dispose();
		}
		
		else if(adBtn.getText().equals(command))
		{
			as = new admins();
			this.dispose();
			adlogin doc = new adlogin(as);
			doc.setVisible(true);
		}
		
		else if(patBtn.getText().equals(command))
		{
			ps = new patients();
			this.dispose();
			patlogin woc = new patlogin(ps);
			woc.setVisible(true);
		}
	}
}	