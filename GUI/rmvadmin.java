package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rmvadmin extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel;
	JButton rmvBtn,backBtn;
	Font myFont,myFont2;
	JComboBox adminBox;
	// JButton;
	admin a;
	admins as;
	ImageIcon back;
	
	
	public rmvadmin (admin a,admins as)
	{
		super("Remove Admin");
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.a=a;
		this.as=as;
		
		
		myFont = new Font("Courier New", Font.BOLD, 18);
		myFont2 = new Font("Courier New", Font.BOLD, 14);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		introLabel = new JLabel("Choose a Admin To remove: ");
		introLabel.setBounds(80,130,350,30);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		
		
		String[] adminsList = new String[admins.adminCount];
		
		for(int i=0;i<admins.adminCount;i++)
		{
			adminsList[i]=as.adminList[i].getName();
		}
		
		adminBox = new JComboBox(adminsList);
		adminBox.setBounds(360,130,130,30);
		panel.add(adminBox);
		
		rmvBtn = new JButton("Remove Admin");
		rmvBtn.setBounds(230,200,130,30);
		rmvBtn.setFont(myFont2);
		rmvBtn.addMouseListener(this);
		rmvBtn.addActionListener(this);
		panel.add(rmvBtn);
				
		
		
		
		back = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(back);
		backBtn.setBounds(12,10,24,24);
		// backBtn.setOpaque(false);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		this.add(panel);
		
		
		
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == rmvBtn)
		{
			rmvBtn.setBackground(Color.RED);
			rmvBtn.setForeground(Color.WHITE);
		}
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == rmvBtn)
		{
			rmvBtn.setBackground(new Color(204,208,214));
			rmvBtn.setForeground(Color.BLACK);
		}
	}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(backBtn.getText().equals(command))
		{
			this.dispose();
			addashboard foc = new addashboard(a,as);
			foc.setVisible(true);
		}
		
		else if (rmvBtn.getText().equals(command))
		{
			String name ="";
			name = adminBox.getSelectedItem().toString();
			int dialog = JOptionPane.YES_NO_OPTION;
			int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this Admin?", "Remove Admin?", dialog);
			if(result == 0){
			as.removeAdmin(name);
			System.out.println("\n"+"Admin Removed");
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Admin Removed. Do you want to stay on this page?", "Stay on this page?", dialog);
			if(result == 0){
						//do nothing
					}else{
						this.dispose();
						addashboard jj = new addashboard(a,as);
						jj.setVisible(true);
					}
			}
			else
			{
					//do nothing
				}
			
		}
		
		
	}
	
	
	}
	
	
