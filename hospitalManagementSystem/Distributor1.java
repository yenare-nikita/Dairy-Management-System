import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.*;
//import javax.swing.JInternalFrame ;
import java.text.*;
public class Distributor1 extends JFrame implements ActionListener,KeyListener
{
	JLabel  ltl,lid,lnm,ladd,lphno,l9,d,t,l0;
	JTextField tid,tnm,tadd,tphno,ln;
	JButton bsave,badd,bclr,bexit,bsrch,bupd;
	JFrame frm2;
	Connection con,con1;
	ResultSet rs=null;
	ResultSet rs1=null;
	PreparedStatement pstmt;
	Statement stmt,stmt1;
	int interval=100;
	javax.swing.Timer time;
	public Distributor1()
	{

		setContentPane(new JLabel(new ImageIcon("e://img/Distr.jpg")));
		setLayout(null);	
	
		
		this.setVisible(true);
		this.setTitle("     	Distributor Information");
		this.setLayout(null);
		this.setSize(1500,1500);
	
                        Font fl=new Font("Arial",Font.BOLD | Font.ITALIC,25);
                        l9=new JLabel("Dairy Management System");
     	      l9.setFont(new Font("Times New Roman",Font.BOLD,50));
     	      l9.setBounds(280,10,900,55);
	     l9.setForeground(Color.green);
                        add(l9);
 	     d=new JLabel("");
	    time=new javax.swing.Timer(interval,new ActionListener(){
           	    public void actionPerformed(ActionEvent e)
           	   {
           		java.util.Date date=new java.util.Date();
           		SimpleDateFormat sd=new SimpleDateFormat("hh:mm:ss");
            		String da = sd.format(date);
            		d.setText(da);
            		d.setForeground(Color.yellow);
         		d.setFont(new Font("Copper",Font.BOLD,36));     
                     }
     	 });time.start();
	t=new JLabel("Time :");
                  t.setFont(new Font("Times New Roman",Font.BOLD,36));
	t.setForeground(Color.pink);
	add(t);
	t.setBounds(950,10,200,200);
	add(d);
	d.setBounds(1080,10,200,200);
                	      
                       l0=new JLabel("DISTRIBUTOR DETAILS");
                       l0.setForeground(Color.blue);
             	     l0.setFont(new Font("Times New Roman",Font.BOLD,35));
              	     l0.setBounds(460,80,700,35);
            	     add(l0); 
   	ln=new  JTextField(10);
                  ln.setForeground(Color.blue);
                  ln.setBounds(05,130,1500,5);
                  add(ln);		

		//ltl=new JLabel("DISTRIBUTOR INFORMATION");
		//ltl.setFont(new Font("Times New Roman",Font.BOLD,40));
		//ltl.setBounds(350,50,600,50);
		//add(ltl);

		lid=new JLabel("Distributor ID");
		lid.setFont(new Font("Times New Roman",Font.BOLD,25));
		lid.setBounds(300,190,220,50);
		add(lid);
		
		tid=new JTextField(30);
		tid.setFont(new Font("Times New Roman",Font.BOLD,25));
		tid.setBounds(550,200,100,30);
		add(tid);		

		lnm=new JLabel("Distributor Name");
		lnm.setFont(new Font("Times New Roman",Font.BOLD,25));
		lnm.setBounds(300,240,220,60);
		add(lnm);
		
		tnm=new JTextField(30);
		tnm.setFont(new Font("Times New Roman",Font.BOLD,25));
		tnm.setBounds(550,250,450,30);
		add(tnm);

		ladd=new JLabel("Distributor Location");
		ladd.setFont(new Font("Times New Roman",Font.BOLD,25));
		ladd.setBounds(300,290,250,60);
		add(ladd);

		tadd=new JTextField(30);
		tadd.setFont(new Font("Times New Roman",Font.BOLD,25));
		tadd.setBounds(550,300,450,60);
		add(tadd);

		lphno=new JLabel("Contact No");
		lphno.setFont(new Font("Times New Roman",Font.BOLD,25));
		lphno.setBounds(300,365,250,60);
		add(lphno);

		tphno=new JTextField(30);
		tphno.setFont(new Font("Times New Roman",Font.BOLD,25));
		tphno.setBounds(550,390,450,30);
		add(tphno);

		
		badd=new JButton("NEW");
		badd.setFont(new Font("Times New Roman",Font.BOLD,30));
		badd.setBounds(150,540,135,45);
		add(badd);
		badd.addActionListener(this);

		bsave=new JButton("SAVE");
		bsave.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsave.setBounds(300,540,135,45);
		add(bsave);
		bsave.addActionListener(this);
				
		bclr=new JButton("DELETE");
		bclr.setFont(new Font("Times New Roman",Font.BOLD,30));
		bclr.setBounds(450,540,180,45);
		add(bclr);
		bclr.addActionListener(this);

		bupd=new JButton("UPDATE");
		bupd.setFont(new Font("Times New Roman",Font.BOLD,30));
		bupd.setBounds(640,540,200,45);
		add(bupd);
		bupd.addActionListener(this);
		
		bsrch=new JButton("SEARCH");
		bsrch.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsrch.setBounds(850,540,225,45);
		add(bsrch);
		bsrch.addActionListener(this);
		
		bexit=new JButton("EXIT");
		bexit.setFont(new Font("Times New Roman",Font.BOLD,30));
		bexit.setBounds(1085,540,200,45);
		add(bexit);
		bexit.addActionListener(this);
		this.getContentPane().setBackground(Color.white);


		tid.addKeyListener(this);
		tnm.addKeyListener(this);
		tphno.addKeyListener(this);
		
		badd.setToolTipText("add new Record");
		bsave.setToolTipText("save the record");
		bexit.setToolTipText(" exit");
		bclr.setToolTipText("delete all record");
		bsrch.setToolTipText("search all record");
		
	}	
	
public void keyTyped(KeyEvent e) 
 {
       if(e.getSource()==tid)
     {
	char c = e.getKeyChar();
      	if (!((c >= '0') && (c <= '9') ||  (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) 
      	{
      		  getToolkit().beep();
       		  e.consume();
      	}
     }

      if(e.getSource()==tnm)
     {
	      char c = e.getKeyChar();
      	if (((c >= '0') && (c <= '9') || (c == KeyEvent.VK_DELETE)) ) 
      	{
        		getToolkit().beep();
        		e.consume();
      	}
     }

       if(e.getSource()==tphno)
     {
	      char c = e.getKeyChar();
      	if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_DELETE))) 
      	{
        		getToolkit().beep();
        		e.consume();
      	}
     }
    }
public void keyReleased(KeyEvent e) 
 {
 }
public void keyPressed(KeyEvent e) 
 {
 }
public void clrscr()
{
                                       tid.setText("");
		tnm.setText("");
		tadd.setText("");	
		tphno.setText("");
                                  
}
public void cn1()
{
try
{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			stmt1=con.createStatement();
}
catch(Exception e) 
{ JOptionPane.showMessageDialog(null,e); }
}
public void EnabledF()
{
 tid.setEnabled(false);
 tnm.setEnabled(false);
tadd.setEnabled(false);
tphno.setEnabled(false);


bsave.setEnabled(false);
}
public void EnabledT()
{
 tid.setEnabled(true);
 tnm.setEnabled(true);
tadd.setEnabled(true);
tphno.setEnabled(true);


bsave.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) 
   {
	
                  
	if(ae.getSource()==bclr)
   	{
		//this.setVisible(false);
		//clrscr();		
	}

	
	
	if(ae.getSource()==badd) 
	{
		try
		{
		tid.setText(" ");
		tnm.setText("");
		tadd.setText("");
		tphno.setText("");	
		EnabledT();	
		tnm.requestFocus();
		cn1();
	 	  int count=1;
                                  	                    rs=stmt1.executeQuery("Select * from Distributor1");
                                                        while(rs.next())
				{
					count=rs.getInt(1);
					count++;
					System.out.println(" "+count);
				}
				tid.setText(String.valueOf(count));
				tid.setEnabled(false);	
		}catch(Exception ee2){}	
			
	}
	if(ae.getSource()==bsave)
	{
	          try
			{
              
			cn1();
		                 String s="insert into Distributor1 values('" + tid.getText()  + "','" + tnm.getText() + "','" + tadd.getText() + "'," + tphno.getText()  +")";
                                                       int r=stmt1.executeUpdate(s);
		                 JOptionPane.showMessageDialog(null,"1.Record Inserted Sucessfully");
			
			EnabledF();
                                                        }
		
			catch(SQLException se){
			JOptionPane.showMessageDialog(null,se);
					}
			catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			
		} 	
	}	
	if(ae.getSource()==bclr)
	{
	
	try
		{
		String bn=JOptionPane.showInputDialog(null,"Please Enter Your Distributor-id To Delete Record from Distributor ?","Enter Distributor id",JOptionPane.QUESTION_MESSAGE);
		int id=Integer.parseInt(bn);
		cn1();
   		int r=stmt1.executeUpdate("delete * from Distributor1 where Distributor_id="+id);	 	
   		if(r>0)
   		JOptionPane.showMessageDialog(this,"Record Deleted SuessfullY!!!");
   		else
   		JOptionPane.showMessageDialog(this,"Can't  Deleted...!!!");
   		con.close();
		}	
		catch(SQLException se){
			JOptionPane.showMessageDialog(null,se);
					}
			catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			
		} 	

		
	}	
	
	if(ae.getSource()==bsrch)
		{
			try
			{
			String bn=JOptionPane.showInputDialog(null,"Please Enter Distributor Id to Search Reords from Distributor!!"," Distributor ",JOptionPane.QUESTION_MESSAGE);
			int sno=Integer.parseInt(bn);
			cn1(); 
           			 rs = stmt1.executeQuery("select * from Distributor1 where Distributor_id="+sno);  
          			 if(rs.next()) 
			{  
             				   int s = rs.getInt(1);  
                				String s1 = rs.getString(2);
               				String s2 = rs.getString(3);    
                				int s3 = rs.getInt(4);  
                			//Sets Records in TextFields.  
              		 		tid.setText(Integer.toString(s));
				tnm.setText(s1);
				tadd.setText(s2);
				tphno.setText(Integer.toString(s3));
				JOptionPane.showMessageDialog(null, ".........Record Found SucessFullYY!!!");
							}
         		   	else
			{
                			JOptionPane.showMessageDialog(null, "Not Found");
			
			}//search
			}catch(Exception e){}
			}	

		
		if(ae.getSource()==bupd)
	{
		try
		{
		cn1();
		int sid=Integer.parseInt(tid.getText());
		String snm=(String)tnm.getText();
		String sadr=(String)tadd.getText();
		int sph=Integer.parseInt(tphno.getText());
				
		
		pstmt=con.prepareStatement("UPDATE Distributor1 SET Distributor_name=?,Distributor_location=?,Contact_no=? WHERE Distributor_id=?");
		pstmt.setInt(4,sid);
		pstmt.setString(1,snm);
		pstmt.setString(2,sadr);
		pstmt.setInt(3,sph);
		
		

		pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null,"Record  Updated SuccessFullY!.....");
		}catch(Exception e2){}

	 }  
      		
	if(ae.getSource()==bexit)
		{
		new MDI2();//this.setVisible(false);
		}
	}

	public static void main(String args[])
	{
		Distributor1 d1=new Distributor1();
	}
}
		
		


		
		