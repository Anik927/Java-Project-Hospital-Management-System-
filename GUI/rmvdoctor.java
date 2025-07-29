package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class rmvdoctor extends JFrame implements MouseListener, ActionListener
{
	JPanel panel;
	JLabel introLabel;
	JButton rmvBtn,backBtn;
	Font myFont,myFont2;
	JComboBox doctorBoc;
	doctor d;
	doctors ds;
	ImageIcon back;
	admin a;
	admins as;
	
	public rmvdoctor (doctors ds,admin a,admins as)
	{
		super("Remove Doctor");
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		this.ds=ds;
		this.a=a;
		this.as=as;
		
		
		myFont = new Font("Courier New", Font.BOLD, 18);
		myFont2 = new Font("Courier New", Font.BOLD, 14);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		introLabel = new JLabel("Choose a Doctor To remove: ");
		introLabel.setBounds(80,130,350,30);
		introLabel.setFont(myFont);
		panel.add(introLabel);
		
		
		
		String[] doctorsList = new String[doctors.doctorCount];
		
		for(int i=0;i<doctors.doctorCount;i++)
		{
			doctorsList[i]=ds.doctorList[i].getName();
		}
		
		doctorBoc = new JComboBox(doctorsList);
		doctorBoc.setBounds(370,130,130,30);
		panel.add(doctorBoc);
		
		rmvBtn = new JButton("Remove Doctor");
		rmvBtn.setBounds(230,200,140,30);
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
			name = doctorBoc.getSelectedItem().toString();
			int dialog = JOptionPane.YES_NO_OPTION;
			int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this doctor?", "Remove Doctor?", dialog);
			if(result == 0){	
			ds.deleteDoctor(name);
			System.out.println("\n"+"Doctor Removed");
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Doctor Removed. Do you want to stay on this page?", "Stay on this page?", dialog);
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
	
	
