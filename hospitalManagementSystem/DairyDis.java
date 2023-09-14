import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.*;
//import javax.swing.JInternalFrame ;
import java.text.*;
public class DairyDis extends JFrame implements ActionListener,KeyListener
{
	JLabel ddid,ddt,did,dnm,dtm,dl1,dmt,dmr1,dl2,dmr2,dl3,dcamt,dl4,dbamt,dl5,dtamt,dl6,l0,l9,d,t,s;
	JTextField tid,tdt,tdnm,ttm,tmr1,tmr2,tcamt,tbamt,ttamt,ln;
	JComboBox idcmb,tcmb;
	JButton bcal,badd,bsave,bupd,bdel,bsrch,bexit;
	JFrame frm2;
	Connection cn,cn1;
	ResultSet rs=null;
	ResultSet rs1=null;
	PreparedStatement pstmt;
	Statement stmt,stmt1;
	int interval=100;
	javax.swing.Timer time;
	public DairyDis()
	{
		setContentPane(new JLabel(new ImageIcon("e://img/DairyDist.jpg")));
		setLayout(null);	
	
		
	                   this.setVisible(true);
		this.setTitle("     	Dairy Distribution Information");
		this.setLayout(null);
		this.setSize(1500,1500);
	
                        Font fl=new Font("Arial",Font.BOLD | Font.ITALIC,25);
                        l9=new JLabel("Dairy Management System");
     	      l9.setFont(new Font("Times New Roman",Font.BOLD,50));
     	      l9.setBounds(280,10,900,55);
	     l9.setForeground(Color.pink);
                        add(l9);
 	     d=new JLabel("");
	    time=new javax.swing.Timer(interval,new ActionListener(){
           	    public void actionPerformed(ActionEvent e)
           	   {
           		java.util.Date date=new java.util.Date();
           		SimpleDateFormat sd=new SimpleDateFormat("hh:mm:ss");
            		String da = sd.format(date);
            		d.setText(da);
            		d.setForeground(Color.red);
         		d.setFont(new Font("Copper",Font.BOLD,36));     
                     }
     	 });time.start();
	t=new JLabel("Time :");
                  t.setFont(new Font("Times New Roman",Font.BOLD,36));
	t.setForeground(Color.blue);
	add(t);
	t.setBounds(950,10,200,200);
	add(d);
	d.setBounds(1080,10,200,200);
                	      
                       l0=new JLabel("DAIRY DISTRIBUTION DETAILS");
                       l0.setForeground(Color.green);
             	     l0.setFont(new Font("Times New Roman",Font.BOLD,35));
              	     l0.setBounds(410,80,700,35);
            	     add(l0); 
   	          ln=new  JTextField(10);
                 ln.setForeground(Color.blue);
                ln.setBounds(05,130,1500,5);
                  add(ln);		

		//ltl=new JLabel("DAIRYI DISTRIBUTOR INFORMATION");
		//ltl.setFont(new Font("Times New Roman",Font.BOLD,40));
		//ltl.setBounds(350,50,600,50);
		//add(ltl);

		ddid=new JLabel("Dairy Disrtribtutor ID");
		ddid.setFont(new Font("Times New Roman",Font.BOLD,25));
		ddid.setBounds(200,190,300,50);
		add(ddid);
		
		tid=new JTextField(30);
		tid.setFont(new Font("Times New Roman",Font.BOLD,25));
		tid.setBounds(460,200,100,30);
		add(tid);		
		
		ddt=new JLabel("Date");
		ddt.setFont(new Font("Times New Roman",Font.BOLD,25));
		ddt.setBounds(900,190,220,50);
		add(ddt);
		
		tdt=new JTextField(30);
		tdt.setFont(new Font("Times New Roman",Font.BOLD,25));
		tdt.setBounds(970,200,100,30);
		add(tdt);		
		
		did=new JLabel("Distributor Id");
		did.setFont(new Font("Times New Roman",Font.BOLD,25));
		did.setBounds(200,220,220,60);
		add(did);
		
		idcmb=new JComboBox();
		idcmb.setFont(new Font("Times New Roman",Font.BOLD,25));
		idcmb.setBounds(460,240,100,30);
		add(idcmb);
		
		
		did=new JLabel("Distributor Name");
		did.setFont(new Font("Times New Roman",Font.BOLD,25));
		did.setBounds(200,260,220,60);
		add(did);

		tdnm=new JTextField(30);
		tdnm.setFont(new Font("Times New Roman",Font.BOLD,25));
		tdnm.setBounds(460,280,370,30);
		add(tdnm);

		dtm=new JLabel("Outgoing Total Milk");
		dtm.setFont(new Font("Times New Roman",Font.BOLD,25));
		dtm.setBounds(200,310,250,30);
		add(dtm);

		ttm=new JTextField(30);
		ttm.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttm.setBounds(460,310,100,30);
		add(ttm);

		dl1=new JLabel("ml.");
		dl1.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl1.setBounds(570,310,70,30);
		add(dl1);

		dmt=new JLabel("Milk Type");
		dmt.setFont(new Font("Times New Roman",Font.BOLD,25));
		dmt.setBounds(200,340,150,30);
		add(dmt);

		tcmb=new JComboBox();
		tcmb.setFont(new Font("Times New Roman",Font.BOLD,25));
		tcmb.setBounds(460,350,100,30);
		tcmb.addItem("Cow");
		tcmb.addItem("BuffalloW");
		add(tcmb);

		dmr1=new JLabel("Milk Rate");
		dmr1.setFont(new Font("Times New Roman",Font.BOLD,25));
		dmr1.setBounds(200,380,150,30);
		add(dmr1);

		tmr1=new JTextField(30);
		tmr1.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr1.setBounds(460,390,150,30);
		add(tmr1);

		dl2=new JLabel("Rs.");
		dl2.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl2.setBounds(610,390,70,30);
		add(dl2);
		
		/*dmr2=new JLabel("Milk Rate");
		dmr2.setFont(new Font("Times New Roman",Font.BOLD,25));
		dmr2.setBounds(800,390,150,30);
		add(dmr2);

		tmr2=new JTextField(30);
		tmr2.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr2.setBounds(915,390,100,30);
		add(tmr2);

		dl3=new JLabel("Rs.");
		dl3.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl3.setBounds(1020,395,150,30);
		add(dl3);

		dcamt=new JLabel("Amount Of Cow");
		dcamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		dcamt.setBounds(200,430,250,30);
		add(dcamt);

		tcamt=new JTextField(30);
		tcamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		tcamt.setBounds(460,430,100,30);
		add(tcamt);

		dl4=new JLabel("Rs.");
		dl4.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl4.setBounds(570,430,150,30);
		add(dl4);

		dbamt=new JLabel("Amount Of Buffallow");
		dbamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		dbamt.setBounds(800,430,250,30);
		add(dbamt);

		tbamt=new JTextField(30);
		tbamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		tbamt.setBounds(1040,430,100,30);
		add(tbamt);

		dl5=new JLabel("Rs.");
		dl5.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl5.setBounds(1150,430,100,30);
		add(dl5);*/

		bcal=new JButton("Calulate Total Amount");
		bcal.setFont(new Font("Times New Roman",Font.BOLD,30));
		bcal.setBounds(500,470,350,30);
		add(bcal);
		bcal.addActionListener(this);

		dtamt=new JLabel("Total Amount");
		dtamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		dtamt.setBounds(200,520,250,30);
		add(dtamt);

		ttamt=new JTextField(30);
		ttamt.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttamt.setBounds(460,520,150,30);
		add(ttamt);

		dl6=new JLabel("Rs.");
		dl6.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl6.setBounds(610,520,100,30);
		add(dl6);
		
		badd=new JButton("ADD");
		badd.setFont(new Font("Times New Roman",Font.BOLD,30));
		badd.setBounds(150,590,135,45);
		add(badd);
		badd.addActionListener(this);

		bsave=new JButton("SAVE");
		bsave.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsave.setBounds(300,590,130,45);
		add(bsave);
		bsave.addActionListener(this);
				
		bupd=new JButton("UPDATE");
		bupd.setFont(new Font("Times New Roman",Font.BOLD,30));
		bupd.setBounds(450,590,180,45);
		add(bupd);
		bupd.addActionListener(this);

		bdel=new JButton("DELETE");
		bdel.setFont(new Font("Times New Roman",Font.BOLD,30));
		bdel.setBounds(650,590,160,45);
		add(bdel);
		bdel.addActionListener(this);
		
		bsrch=new JButton("SEARCH");
		bsrch.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsrch.setBounds(820,590,190,45);
		add(bsrch);
		bsrch.addActionListener(this);
		
		bexit=new JButton("EXIT");
		bexit.setFont(new Font("Times New Roman",Font.BOLD,30));
		bexit.setBounds(1020,590,200,45);
		add(bexit);
		bexit.addActionListener(this);
		this.getContentPane().setBackground(Color.white);

		badd.setToolTipText("add new Record");
		bsave.setToolTipText("save the record");
		bexit.setToolTipText(" exit");
		bdel.setToolTipText("delete all record");
		bsrch.setToolTipText("search all record");
		bupd.setToolTipText("update all record");
		idcmb.addActionListener(this);

		try
                                      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:project");
			stmt=cn.createStatement();
			rs =stmt.executeQuery("select * from Distributor1");
			while(rs.next())
			{
				int s = rs.getInt(1);  
				idcmb.addItem(Integer.toString(s));
			}

			cn.close();
		}catch(Exception e2){}
	
	}
	public void keyTyped(KeyEvent e) 
	{}
	
public void keyReleased(KeyEvent e) 
 {
 }
public void keyPressed(KeyEvent e) 
 {
 }
public void EnabledF()
{
tid.setEnabled(false);
tdt.setEnabled(false);
idcmb.setEnabled(false);
tdnm.setEnabled(false);
ttm.setEnabled(false);
tcmb.setEnabled(false);
tmr1.setEnabled(false);
ttamt.setEnabled(false);
bsave.setEnabled(false);
}
public void cn1()
{
try
{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn1=DriverManager.getConnection("jdbc:odbc:project","","");
			stmt1=cn1.createStatement();
}
catch(Exception e) 
{ JOptionPane.showMessageDialog(null,e); }
}
public void actionPerformed(ActionEvent ae) 
   {
	
                  try
{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
                  			//stmt=cn.createStatement();
		  
		if(ae.getSource()==idcmb)
		{
			int d=Integer.parseInt(idcmb.getSelectedItem().toString());
			stmt1=cn1.createStatement();
			rs1=stmt1.executeQuery("select * from Distributor1 where Distributor_id="+d);
			if(rs1.next())
			{
				tdnm.setText(rs1.getString(2));
				
			}
		}


		if(ae.getSource()==bcal)
   	{
		int t=Integer.parseInt(ttm.getText());
		int m=Integer.parseInt(tmr1.getText());	
		int res=t*m;
		ttamt.setText(Integer.toString(res));
	}



		
	if(ae.getSource()==badd) 
	{
		tid.setText(" ");
		tdt.setText("");
		tdnm.setText("");
		ttm.setText("");
		tmr1.setText("");
		ttamt.setText("");	
		tdnm.requestFocus();
		int count=1;
		stmt1=cn1.createStatement();
				
				
				rs1=stmt1.executeQuery("select * from DairyDis");
			//System.out.println("jhdh");
				while(rs1.next())
				{
					count=rs1.getInt(1);
					count++;
					System.out.println("g"+count);
				}
				tid.setText(String.valueOf(count));
	 	                            	tid.setEnabled(false);
 			                          	 
        	
		
		
	
			
	}
	if(ae.getSource()==bsave)
	{
	          try
			{
              
			//cn1();
			stmt1=cn1.createStatement();
		               String s="insert into DairyDis values('" + tid.getText()  + "','" + tdt.getText() + "','" +idcmb.getSelectedItem() + "','" +tdnm.getText()  +"','"+ttm.getText()+"','"+tcmb.getSelectedItem()+"','"+tmr1.getText()+"','"+ttamt.getText()+"')";
                                                       int r=stmt1.executeUpdate(s);
		                JOptionPane.showMessageDialog(null,"1.Record Inserted Sucessfully!!!!!");
			
			EnabledF();
                                                        }
		
			catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			
		} 	
	}
	if(ae.getSource()==bdel)
	{
	
		String bn=JOptionPane.showInputDialog(null,"Please Enter Your Dairy Distributor id To delete record from Dairy Distribution  ?","Dairy Distribution Message",JOptionPane.QUESTION_MESSAGE);
		int id=Integer.parseInt(bn);
		stmt1=cn1.createStatement();
   		int r=stmt1.executeUpdate("delete * from DairyDis  where DairyDis_id="+id);	 	
   		if(r>0)
   		JOptionPane.showMessageDialog(this,"Record Deleted SuessfullY!!!");
   		else
   		JOptionPane.showMessageDialog(this,"Can't  Deleted...!!!");		
	}	
	
	if(ae.getSource()==bsrch)
		{
			String bn=JOptionPane.showInputDialog(null,"Please Enter Dairy Distribution to Search Reords from Dairy Distribution!"," Dairy Distribution ",JOptionPane.QUESTION_MESSAGE);
			int sno=Integer.parseInt(bn);
			stmt1=cn1.createStatement();
           			 rs1= stmt1.executeQuery("select * from DairyDis where DairyDis_id="+sno);  
          			  if(rs1.next()) 
			{  
             				   int did = rs1.getInt(1);  
				int d=rs1.getInt(2);
				int dd=rs1.getInt(3);
				String dnm = rs1.getString(4);
				int tm=rs1.getInt(5);   
				String mt = rs1.getString(6);
                				int mr = rs1.getInt(7);
				int tamt=rs1.getInt(8);
								  

                			//Sets Records in TextFields.  
              		 		tid.setText(Integer.toString(did));
				tdt.setText(Integer.toString(d));
				idcmb.setSelectedItem(dd);
				tdnm.setText(dnm);
				ttm.setText(Integer.toString(tm));
				tcmb.setSelectedItem(mt);
				tmr1.setText(Integer.toString(mr));
				ttamt.setText(Integer.toString(tamt));
				JOptionPane.showMessageDialog(null, ".........Record Found SucessFullYY!!!");
			}
         		   	else
			{
                			JOptionPane.showMessageDialog(null, "Not Found");
			
			}//search


		}	
		if(ae.getSource()==bupd)
		{
		try
		{	
		//cn1();
		//pstmt=con.prepareStatement("UPDATE Society SET Society_location=?,Society_name=?, WHERE Society_id=?");  
		
		//pstmt.setString(1,tcamt);
		//pstmt.setString(2,tdnm);
		//pstmt.setInt(3,ttm);
		//pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Record is updated...");  
      //  pstmt.close();  
       // cn.close();  
		//Update
		}  
		//catch(SQLException se){
			//JOptionPane.showMessageDialog(null,se);
					//}
			catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			
		} 	

		}					

	if(ae.getSource()==bexit)
		{
		new MDI2();//this.setVisible(false);
		}
	}catch(Exception e2){}
	}
	public static void main(String args[])
	{
		DairyDis d1=new DairyDis();
	}
	
}