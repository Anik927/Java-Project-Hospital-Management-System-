package GUI;
import Classes.*;
import Interfaces.*;
import java.lang.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class bookdoctor extends JFrame implements MouseListener, ActionListener
{
	String waiting="";
	String waiting2="";
	JPanel panel;
	Font myFont;
	JLabel doc1,doc2,doc3,doc4,doc5,doc6,doc7,doc8
		,	edu1,edu2,edu3,edu4,edu5,edu6,edu7,edu8,
			dpLabel1,dpLabel2,dpLabel3,dpLabel4,dpLabel5,dpLabel6,dpLabel7,dpLabel8;
	JButton Btn1,Btn2,Btn3,Btn4,Btn5,Btn6,Btn7,nextBtn,Btn8,backBtn;
	ImageIcon dp,icon,next;
	patient p = null;
	patients ps = null;
	doctors ds;
	
	int a;
	public bookdoctor(patient p,patients ps, int a)
	{
		super("Doctor List");
		doctors.doctorCount=0;
		this.setSize(800,500);
		// icon = new ImageIcon("Image\\5898998_bacteria_man_mask_patient_protection_icon.png");
		// this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		myFont = new Font("Courier New", Font.BOLD, 16);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(204,208,214));
		
		this.p=p;
		this.ps=ps;
		this.a=a;
		ds = new doctors();
		
		Btn1 = new JButton("Book");
		Btn2 = new JButton("Book ");
		Btn3 = new JButton("Book  ");
		Btn4 = new JButton(" Book");
		Btn5 = new JButton("  Book");
		Btn6 = new JButton(" Book ");
		Btn7 = new JButton("  Book ");
		Btn8 = new JButton("  Book  ");
		
		Btn1.addActionListener(this);
		Btn2.addActionListener(this);
		Btn3.addActionListener(this);
		Btn4.addActionListener(this);
		Btn5.addActionListener(this);
		Btn6.addActionListener(this);
		Btn7.addActionListener(this);
		Btn8.addActionListener(this);
		
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a] != null)
		{
		doc1 = new JLabel((ds.doctorList[a]).getName());
		edu1 = new JLabel((ds.doctorList[a]).getEducation());
		edu1.setBounds(60,170,140,30);
		Btn1.setBounds(56,200,80,25);
		edu1.setFont(myFont);
		panel.add(edu1);
		panel.add(Btn1);
		}
		else 
		{
		doc1 = new JLabel("Not Available");
		}
		doc1.setBounds(60,150,140,30);
		doc1.setFont(myFont);
		
		
		
		panel.add(doc1);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+1] != null)
		{
		doc2 = new JLabel((ds.doctorList[a+1]).getName());
		edu2 = new JLabel((ds.doctorList[a+1]).getEducation());
		edu2.setBounds(210,170,140,30);
		Btn2.setBounds(210,200,80,25);
		edu2.setFont(myFont);
		panel.add(edu2);
		panel.add(Btn2);
		}
		else 
		{
		doc2 = new JLabel("Not Available");
		}
		doc2.setBounds(210,150,140,30);
		doc2.setFont(myFont);
		
		
		panel.add(doc2);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+2] != null)
		{
		doc3 = new JLabel((ds.doctorList[a+2]).getName());
		edu3 = new JLabel((ds.doctorList[a+2]).getEducation());
		edu3.setBounds(390,170,140,30);
		Btn3.setBounds(390,200,80,25);
		edu3.setFont(myFont);
		panel.add(Btn3);
		panel.add(edu3);
		}
		else 
		{
		doc3 = new JLabel("Not Available");
		}
		doc3.setBounds(390,150,140,30);
		doc3.setFont(myFont);
		
		
		panel.add(doc3);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+3] != null)
		{
		doc4 = new JLabel((ds.doctorList[a+3]).getName());
		edu4 = new JLabel((ds.doctorList[a+3]).getEducation());
		edu4.setBounds(590,170,250,30);
		Btn4.setBounds(590,200,80,25);
		edu4.setFont(myFont);
		panel.add(Btn4);
		panel.add(edu4);
		}
		else 
		{
		doc4 = new JLabel("Not Available");
		}
		doc4.setBounds(590,150,250,30);
		doc4.setFont(myFont);
		
		
		panel.add(doc4);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+4] != null)
		{
		doc5 = new JLabel((ds.doctorList[a+4]).getName());
		edu5 = new JLabel((ds.doctorList[a+4]).getEducation());
		edu5.setBounds(30,400,140,30);
		Btn5.setBounds(30,430,80,25);
		edu5.setFont(myFont);
		panel.add(Btn5);
		panel.add(edu5);
		}
		else 
		{
		doc5 = new JLabel("Not Available");
		}
		doc5.setBounds(30,380,140,30);
		doc5.setFont(myFont);
		
		
		panel.add(doc5);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+5] != null)
		{
		doc6 = new JLabel((ds.doctorList[a+5]).getName());
		edu6 = new JLabel((ds.doctorList[a+5]).getEducation());
		edu6.setBounds(210,400,140,30);
		Btn6.setBounds(210,430,80,25);
		edu6.setFont(myFont);
		panel.add(Btn6);
		panel.add(edu6);
		}
		else 
		{
		doc6 = new JLabel("Not Available");
		}
		doc6.setBounds(210,380,140,30);
		doc6.setFont(myFont);
		
		
		panel.add(doc6);
		
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+6] != null)
		{
		doc7 = new JLabel((ds.doctorList[a+6]).getName());
		edu7 = new JLabel((ds.doctorList[a+6]).getEducation());
		edu7.setBounds(390,400,140,30);
		Btn7.setBounds(390,430,80,25);
		edu7.setFont(myFont);
		
		panel.add(Btn7);
		panel.add(edu7);
		}
		else 
		{
		doc7 = new JLabel("Not Available");
		}
		doc7.setBounds(390,380,140,30);
		doc7.setFont(myFont);
		
		
		panel.add(doc7);
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+7] != null)
		{
		doc8 = new JLabel((ds.doctorList[a+7]).getName());
		edu8 = new JLabel((ds.doctorList[a+7]).getEducation());
		edu8.setBounds(590,400,250,30);
		Btn8.setBounds(590,430,80,25);
		edu8.setFont(myFont);
		panel.add(Btn8);
		panel.add(edu8);
		}
		else 
		{
		doc8 = new JLabel("Not Available");
		}
		
		if(doctors.doctorCount > 0 && ds.doctorList[a+8] != null)
		{
		next = new ImageIcon ("Image\\next.png");
		nextBtn = new JButton(next);
		nextBtn.setBounds(720,210,48,48);
		// backBtn.setBackground(myColor);
		nextBtn.setContentAreaFilled(false);
		nextBtn.addMouseListener(this);
		nextBtn.addActionListener(this);
		nextBtn.setBorder(null);
		panel.add(nextBtn);
		patdashboard.pageno+=8;
		}
		doc8.setBounds(590,380,250,30);
		doc8.setFont(myFont);
		
		
		dp = new  ImageIcon("Image\\Doc.png");
		 dpLabel1 = new JLabel(dp);
		dpLabel1.setBounds(13,-8,160,160);
		panel.add(dpLabel1);
		
		
		 dpLabel2 = new JLabel(dp);
		dpLabel2.setBounds(180,-8,160,160);
		panel.add(dpLabel2);
		
		dpLabel3 = new JLabel(dp);
		dpLabel3.setBounds(370,-8,160,160);
		panel.add(dpLabel3);
		
		dpLabel4 = new JLabel(dp);
		dpLabel4.setBounds(580,-8,160,160);
		panel.add(dpLabel4);
		
		dpLabel5 = new JLabel(dp);
		dpLabel5.setBounds(0,230,160,160);
		panel.add(dpLabel5);
		
		dpLabel6 = new JLabel(dp);
		dpLabel6.setBounds(190,230,160,160);
		panel.add(dpLabel6);
		
		dpLabel7 = new JLabel(dp);
		dpLabel7.setBounds(380,230,160,160);
		panel.add(dpLabel7);
		
		dpLabel8 = new JLabel(dp);
		dpLabel8.setBounds(570,230,160,160);
		panel.add(dpLabel8);
		
		panel.add(doc8);
		
		
		
		
		
		icon = new ImageIcon ("Image\\back.png");
		backBtn = new JButton(icon);
		backBtn.setBounds(12,10,24,24);
		// backBtn.setBackground(myColor);
		backBtn.setContentAreaFilled(false);
		backBtn.addMouseListener(this);
		backBtn.addActionListener(this);
		backBtn.setBorder(null);
		panel.add(backBtn);
		
		
		this.add(panel);
		
		
	}
	
	public void mouseEntered(MouseEvent me){}  
	public void mouseClicked(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 
	
	int dialog = JOptionPane.YES_NO_OPTION;
	int result ;
				
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(ae.getSource() == nextBtn)
		{
			this.dispose();
			bookdoctor j = new bookdoctor(p,ps,patdashboard.pageno);	
			// doctors.doctorCount=0;
			j.setVisible(true);
		}
		
		if (ae.getSource() == backBtn)
		{
			this.dispose();
			patdashboard foc = new patdashboard(p,ps);
			foc.setVisible(true);
			doctors.doctorCount=0;
		}
		
		if(Btn1.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+0].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0)
			{
				waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+0]).getName()) + "\n";
				waiting2=p.getName()+"\n"+((ds.doctorList[a+0]).getName())+ "\n"+ "\n";
				try
				{
					FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
					fw.write(waiting2);
					fw.close();
					System.out.println(waiting);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				JOptionPane.showMessageDialog(this, "The Appointment is booked.");
				this.dispose();
				doctors.doctorCount=0;
				patdashboard k = new patdashboard(p,ps);
				k.setVisible(true);
			}
			else
						
				{
					this.dispose();
					patdashboard foc = new patdashboard(p,ps);
					foc.setVisible(true);
					doctors.doctorCount=0;
				}						
			
		}
		
		if(Btn2.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+1].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+1]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+1]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}
					else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn3.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+2].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+2]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+2]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn4.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+3].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+3]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+3]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn5.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+4].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+4]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+4]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn6.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+5].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+5]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+5]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn7.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+6].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+6]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+6]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		if(Btn8.getText().equals(command))
		{
			dialog = JOptionPane.YES_NO_OPTION;
			result = JOptionPane.showConfirmDialog(this, "Visiting Fees is "+ ds.doctorList[a+7].getFees(), "Do you want to book an appointment?", dialog);
			if(result == 0){
						waiting = p.getName()+" got an appointment with Dr. "+((ds.doctorList[a+7]).getName()) + "\n";
						waiting2=p.getName()+"\n"+((ds.doctorList[a+7]).getName())+ "\n"+ "\n";
		try
		{
			FileWriter fw = new FileWriter("Files/patWaitList.txt",true);
			fw.write(waiting2);
			fw.close();
			System.out.println(waiting);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JOptionPane.showMessageDialog(this, "The Appointment is booked.");
		this.dispose();
		doctors.doctorCount=0;
		patdashboard k = new patdashboard(p,ps);
		k.setVisible(true);
					}else
					{
						this.dispose();
						patdashboard foc = new patdashboard(p,ps);
						foc.setVisible(true);
						doctors.doctorCount=0;
					}
			
		}
		
		
	}
	
	
}