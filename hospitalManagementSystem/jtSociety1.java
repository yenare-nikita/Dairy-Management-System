 import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.JInternalFrame ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.JInternalFrame ;
public class jtSociety1  extends JFrame implements ActionListener
{
	String h[]={"Society Id","Society Name","Society Location","Contact No"};
	int cnt=0,i=0;
	JLabel l1,l,z,z1;
	JScrollPane jpane;
	JTable t1;
	JTextField t2,t8;
	Button b1;
	JLabel l3,l5;
	int k=0;
	javax.swing.Timer time;	

	public  jtSociety1()
	{
		this.setVisible(true);            
		this.setLayout(null);
		DateFormat d=new SimpleDateFormat ("dd/MM/yyyy");
		l=new JLabel("Dairy Report");
     		l.setFont(new Font("Times New Roman",Font.BOLD,30));
     		l.setForeground(Color.red);
       		l.setBounds(550,5,900,35);
		add(l); 
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection c=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			Statement st=c.createStatement();
			
			Statement st2=c.createStatement();
			ResultSet rs;
			
			String str="select * from Society";
			rs=st.executeQuery(str);
			while(rs.next())
			{
				cnt++;
			}
			rs.close(); 
			String record1[][]=new String[cnt][4];
                                                          Statement st1=c.createStatement();
			String s="select * from Society";
			rs=st1.executeQuery(s);
			int i=0;
			
			while(rs.next())
			{
				record1[i][0]=Integer.toString(rs.getInt(1));
				record1[i][1]=rs.getString(2);
				record1[i][2]=rs.getString(3);
				record1[i][3]=Integer.toString(rs.getInt(4));
                                                                         //  record1[i][4]=rs.getString(5);
                                                                             
                                                                             
				i++;
			} 
			
		 	l3=new JLabel ("Date");
			l3.setFont(new Font("Times New Roman",Font.BOLD,20));
			l3.setBounds(1190,5,180,50);
			add(l3);					           
                 			t2=new  JTextField(10);
                			t2.setFont(new Font("Times New Roman",Font.PLAIN,20));
                  	 		t2.setBounds(1250,20,100,30);
			add(t2); 

			l5=new JLabel ("Time");
			l5.setFont(new Font("Times New Roman",Font.BOLD,20));
			l5.setBounds(1190,40,180,50);
          		    	add(l5);					           
                  			t8=new  JTextField(10);
                			t8.setFont(new Font("Times New Roman",Font.PLAIN,20));
                   			t8.setBounds(1250,60,100,30);
                      		add(t8);              	
                 			java.util.Date date1=new java.util.Date();
	
			java.util.Date date=new java.util.Date();
			SimpleDateFormat sd=new SimpleDateFormat("hh:mm:ss");
			String da = sd.format(date1);
                   			t8.setText(da);
			t2.setText(d.format(date));

           			l1=new JLabel("Society Details");
                		 	l1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,20));
                		 	l1.setForeground(Color.red);
			b1=new Button("OK");
			b1.addActionListener(this); b1.setBackground(Color.gray);
			t1=new JTable(record1,h); t1.setBackground(Color.white);

			t1.setFont(new Font("Times New Roman",Font.PLAIN,18));
			TableColumn colm; 
			for (i = 0; i < t1.getColumnCount(); i++) 
			{
				colm= t1.getColumnModel().getColumn(i);
				colm.setMaxWidth(2000);
			}



		}catch(Exception e){ System.out.println("Main"+e); }
			
		jpane=new JScrollPane(t1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jpane.setBackground(Color.white);
		jpane.setEnabled(false);
			
					
		l1.setBounds(550,55,800,30);
                                     	jpane.setBounds(0,100,1350,490);
		b1.setBounds(250,230,80,30);
		add(l1);
		add(jpane,new BorderLayout().CENTER);
		add(b1,new BorderLayout().SOUTH);
                             
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)screenSize.getWidth(),(int)screenSize.getHeight());
		this.show(); 
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)	
		{
			this.setVisible(false);
			
		}
	}
	public static void main(String args[]) throws Exception
	{
		jtSociety1 cr=new jtSociety1();
	}
}
