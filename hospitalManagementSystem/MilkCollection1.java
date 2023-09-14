import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.*;
//import javax.swing.JInternalFrame ;
import java.text.*;
public class MilkCollection1 extends JFrame implements ActionListener,KeyListener
{
	JLabel mci,si,sn,tm,f1,s1,p1,mr1,date,mt,f2,s2,p2,mr2,dl1,dl2,dl3,dl4,dl5,dl6,dl7,dl8,dl9,dl10,l0,l9,d,t,s,mt1,tmm;
	JTextField tmci,tsn,ttm,ttm1,tf1,ts1,tp1,td,tp2,ln;
	JComboBox idcmb1,f2cmb3,s2cmb3,s2cmb4,mtcmb2,f1cmb5,s1cmb6,tmt1,tmr3,tmr1,tmr2;
	JButton bcal,badd,bsave,bupd,bdel,bsrch,bexit;
	JFrame frm2;
	Connection cn,con1;
	ResultSet rs,rs1;
	PreparedStatement pstmt;
	Statement stmt,stmt1;
	int interval=100;
	javax.swing.Timer time;
	public  MilkCollection1()
	{
		//setContentPane(new JLabel(new ImageIcon("e://img/DairyDist.jpg")));
		//setLayout(null);	
	
		
	                   this.setVisible(true);
		this.setTitle("     	Milk Collection Information");
		this.setLayout(null);
		this.setSize(1500,1500);
	
                        Font fl=new Font("Arial",Font.BOLD | Font.ITALIC,25);
                        l9=new JLabel("Milk Collection System");
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
                	      
                       l0=new JLabel("MILK COLLETION DETAILS");
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

		mci=new JLabel("Milk Collection ID");
		mci.setFont(new Font("Times New Roman",Font.BOLD,25));
		mci.setBounds(200,190,300,50);
		add(mci);
		
		tmci=new JTextField(30);
		tmci.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmci.setBounds(460,200,100,30);
		add(tmci);		
		
		date=new JLabel("Date");
		date.setFont(new Font("Times New Roman",Font.BOLD,25));
		date.setBounds(900,190,220,50);
		add(date);
		
		td=new JTextField(30);
		td.setFont(new Font("Times New Roman",Font.BOLD,25));
		td.setBounds(970,200,100,30);
		add(td);		
		
		si=new JLabel("Society Id");
		si.setFont(new Font("Times New Roman",Font.BOLD,25));
		si.setBounds(200,220,220,60);
		add(si);
		
		idcmb1=new JComboBox();
		idcmb1.setFont(new Font("Times New Roman",Font.BOLD,25));
		idcmb1.setBounds(460,240,100,30);
		add(idcmb1);
		
		
		sn=new JLabel("Society Name");
		sn.setFont(new Font("Times New Roman",Font.BOLD,25));
		sn.setBounds(200,260,220,60);
		add(sn);

		tsn=new JTextField(30);
		tsn.setFont(new Font("Times New Roman",Font.BOLD,25));
		tsn.setBounds(460,280,370,30);
		add(tsn);

		tm=new JLabel(" Total Milk");
		tm.setFont(new Font("Times New Roman",Font.BOLD,25));
		tm.setBounds(200,350,150,30);
		add(tm);

		ttm=new JTextField(30);
		ttm.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttm.setBounds(460,350,100,30);
		add(ttm);

		dl1=new JLabel("ml.");
		dl1.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl1.setBounds(570,350,70,30);
		add(dl1);

		mt1=new JLabel("Milk Type");
		mt1.setFont(new Font("Times New Roman",Font.BOLD,25));
		mt1.setBounds(200,310,150,30);
		add(mt1);
		
		tmt1=new JComboBox();
		tmt1.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmt1.setBounds(460,310,150,30);
		tmt1.addItem("Cow");
		tmt1.addItem("BuffalloW");
		add(tmt1);
		

		
		f1=new JLabel("Fat");
		f1.setFont(new Font("Times New Roman",Font.BOLD,25));
		f1.setBounds(200,390,150,30);
		add(f1);

		f1cmb5=new JComboBox();
		f1cmb5.setFont(new Font("Times New Roman",Font.BOLD,25));
		f1cmb5.setBounds(460,390,150,30);
		f1cmb5.addItem(3.0);
		f1cmb5.addItem(3.2);
		f1cmb5.addItem(3.4);
		f1cmb5.addItem(3.6);
		f1cmb5.addItem(3.8);
		f1cmb5.addItem(4.0);
		add(f1cmb5);
			
		dl2=new JLabel("gm.");
		dl2.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl2.setBounds(610,390,70,30);
		add(dl2);

		s1=new JLabel("SNF");
		s1.setFont(new Font("Times New Roman",Font.BOLD,25));
		s1.setBounds(200,430,150,30);
		add(s1);
		
		s1cmb6=new JComboBox();
		s1cmb6.setFont(new Font("Times New Roman",Font.BOLD,25));
		s1cmb6.setBounds(460,430,100,30);
		s1cmb6.addItem(8.0);
		s1cmb6.addItem(8.1);
		s1cmb6.addItem(8.2);
		s1cmb6.addItem(8.3);
		s1cmb6.addItem(8.4);
		s1cmb6.addItem(8.5);
		s1cmb6.addItem(8.6);
		add(s1cmb6);
		

		
		dl3=new JLabel("snf.");
		dl3.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl3.setBounds(570,430,70,30);
		add(dl3);
	
		/*p1=new JLabel("Protein");
		p1.setFont(new Font("Times New Roman",Font.BOLD,25));
		p1.setBounds(200,470,150,30);
		add(p1);

		tp1=new JTextField(30);
		tp1.setFont(new Font("Times New Roman",Font.BOLD,25));
		tp1.setBounds(460,470,100,30);
		add(tp1);

		dl4=new JLabel("kg.");
		dl4.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl4.setBounds(570,470,70,30);
		add(dl4);*/

		mr1=new JLabel("Milk Rate");
		mr1.setFont(new Font("Times New Roman",Font.BOLD,25));
		mr1.setBounds(200,470,150,30);
		add(mr1);

		tmr1=new JComboBox();
		tmr1.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr1.setBounds(460,470,150,30);
		tmr1.addItem(27.50);
		tmr1.addItem(28.30);
		tmr1.addItem(29.10);
		tmr1.addItem(29.80);
		tmr1.addItem(30.40);
		tmr1.addItem(40.00);
		add(tmr1);

		dl5=new JLabel("Rs.");
		dl5.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl5.setBounds(640,470,70,30);
		add(dl5);
		
		mt=new JLabel("Milk Type");
		mt.setFont(new Font("Times New Roman",Font.BOLD,25));
		mt.setBounds(900,310,150,30);
		add(mt);

		tmr3=new JComboBox();
		tmr3.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr3.setBounds(1050,310,150,30);
		tmr3.addItem("Cow");
		tmr3.addItem("BuffalloW");
		add(tmr3);

		tmm=new JLabel(" Total Milk");
		tmm.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmm.setBounds(900,350,150,30);
		add(tmm);

		ttm1=new JTextField(30);
		ttm1.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttm1.setBounds(1050,350,100,30);
		add(ttm1);

		dl10=new JLabel("ml.");
		dl10.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl10.setBounds(1150,350,70,30);
		add(dl10);

		f2=new JLabel("Fat");
		f2.setFont(new Font("Times New Roman",Font.BOLD,25));
		f2.setBounds(900,390,150,30);
		add(f2);
		
		f2cmb3=new JComboBox();
		f2cmb3.setFont(new Font("Times New Roman",Font.BOLD,25));
		f2cmb3.setBounds(1050,390,100,30);
		f2cmb3.addItem(3.0);
		f2cmb3.addItem(3.2);
		f2cmb3.addItem(3.4);
		f2cmb3.addItem(3.6);
		f2cmb3.addItem(3.8);
		f2cmb3.addItem(4.0);
		add(f2cmb3);
		

		dl6=new JLabel("gm.");
		dl6.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl6.setBounds(1150,390,100,30);
		add(dl6);

		s2=new JLabel("SNF");
		s2.setFont(new Font("Times New Roman",Font.BOLD,25));
		s2.setBounds(900,430,150,30);
		add(s2);

		s2cmb4=new JComboBox();
		s2cmb4.setFont(new Font("Times New Roman",Font.BOLD,25));
		s2cmb4.setBounds(1050,430,100,30);
		s2cmb4.addItem(8.0);
		s2cmb4.addItem(8.1);
		s2cmb4.addItem(8.2);
		s2cmb4.addItem(8.3);
		s2cmb4.addItem(8.4);
		s2cmb4.addItem(8.5);
		s2cmb4.addItem(8.6);
		add(s2cmb4);

		dl7=new JLabel("snf.");
		dl7.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl7.setBounds(1150,430,100,30);
		add(dl7);

	

		/*p2=new JLabel("Protein");
		p2.setFont(new Font("Times New Roman",Font.BOLD,25));
		p2.setBounds(900,470,150,30);
		add(p2);

		tp2=new JTextField(30);
		tp2.setFont(new Font("Times New Roman",Font.BOLD,25));
		tp2.setBounds(1050,470,150,30);
		add(tp2);

		dl8=new JLabel("kg.");
		dl8.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl8.setBounds(1210,470,100,30);
		add(dl8);*/

		mr2=new JLabel("Milk Rate");
		mr2.setFont(new Font("Times New Roman",Font.BOLD,25));
		mr2.setBounds(900,470,150,30);
		add(mr2);

		tmr2=new JComboBox();
		tmr2.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr2.setBounds(1050,470,150,30);
		tmr2.addItem(27.50);
		tmr2.addItem(28.30);
		tmr2.addItem(29.10);
		tmr2.addItem(29.80);
		tmr2.addItem(30.40);
		tmr2.addItem(40.00);
		add(tmr2);

		dl9=new JLabel("Rs.");
		dl9.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl9.setBounds(1210,470,70,30);
		add(dl9);
		
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
		idcmb1.addActionListener(this);
		
		try
                                      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:project");
			stmt=cn.createStatement();
			System.out.println("GDFG");
			rs =stmt.executeQuery("select * from Society");
			while(rs.next())
			{
				int s = rs.getInt(1);  
				idcmb1.addItem(Integer.toString(s));
			}

			cn.close();
		}catch(Exception e2){}
	}
public void keyTyped(KeyEvent e) 
 {}
public void keyReleased(KeyEvent e) 
 {
 }
public void EnabledF()
{
tmci.setEnabled(false);
td.setEnabled(false);
idcmb1.setEnabled(false);
tsn.setEnabled(false);
ttm.setEnabled(false);
tmt1.setEnabled(false);
f1cmb5.setEnabled(false);
s1cmb6.setEnabled(false);
tmr1.setEnabled(false);
tmr3.setEnabled(false);
ttm1.setEnabled(false);
f2cmb3.setEnabled(false);
s2cmb4.setEnabled(false);
tmr2.setEnabled(false);

bsave.setEnabled(false);
}
public void EnabledT()
{
tmci.setEnabled(true);
td.setEnabled(true);
idcmb1.setEnabled(true);
tsn.setEnabled(true);
ttm.setEnabled(true);
tmt1.setEnabled(true);
f1cmb5.setEnabled(true);
s1cmb6.setEnabled(true);
tmr1.setEnabled(true);
tmr3.setEnabled(true);
ttm1.setEnabled(true);
f2cmb3.setEnabled(true);
s2cmb4.setEnabled(true);
tmr2.setEnabled(true);

bsave.setEnabled(true);
}
public void cn1()
{
try
{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("jdbc:odbc:project","","");
			stmt1=con1.createStatement();
}
catch(Exception e) 
{ JOptionPane.showMessageDialog(null,e); }
}
public void keyPressed(KeyEvent e) 
 {
 }
	public void actionPerformed(ActionEvent ae) 
   {
	try
{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
                  			//stmt=cn.createStatement();
		  
		if(ae.getSource()==idcmb1)
		{
			int d=Integer.parseInt(idcmb1.getSelectedItem().toString());
			stmt1=con1.createStatement();
			rs1=stmt1.executeQuery("select * from Society where Society_id="+d);
			if(rs1.next())
			{
				tsn.setText(rs1.getString(2));
				
			}
		}



			if(ae.getSource()==badd)
			{	
				EnabledT();
				tmci.setText("");
				tsn.setText("");
				ttm.setText("");
				td.setText("");
				ttm1.setText("");
				ttm1.setText("");
				stmt1=con1.createStatement();
				
				int count=1;
				rs1=stmt1.executeQuery("select * from MilkCollection1");
			
				while(rs1.next())
				{
					count=rs1.getInt(1);
					count++;
					System.out.println("g"+count);
				}
				tmci.setText(String.valueOf(count));
				tmci.setEnabled(false);
			}
	if(ae.getSource()==bsave)
	{
              
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			stmt1=con1.createStatement();
		                 String s="insert into MilkCollection1 Values('"+tmci.getText()+"','"+ td.getText()+"','" + idcmb1.getSelectedItem() +"','"+tsn.getText()+"','"+tmt1.getSelectedItem()+"','"+ttm.getText()+"','"+f1cmb5.getSelectedItem()+"','"+s1cmb6.getSelectedItem()+"','"+tmr1.getSelectedItem()+"','"+tmr3.getSelectedItem()+"','"+ttm1.getText()+"','"+f2cmb3.getSelectedItem()+"','"+s2cmb4.getSelectedItem()+"','"+tmr2.getSelectedItem()+"')";
                                                       int r=stmt1.executeUpdate(s);
		                 JOptionPane.showMessageDialog(null,"1.Record Inserted Sucessfully!!!!!");
			EnabledF();
                                                      
	}
	

	if(ae.getSource()==bdel)
	{
	
		String bn=JOptionPane.showInputDialog(null,"Please Enter Your MilkColletion id To delete record from MilkCollection  ?","MilkCollection Message",JOptionPane.QUESTION_MESSAGE);
		int id=Integer.parseInt(bn);
		stmt1=con1.createStatement();
   		int r=stmt1.executeUpdate("delete * from MilkCollection1  where mc_id="+id);	 	
   		if(r>0)
   		JOptionPane.showMessageDialog(this,"Record Deleted SuessfullY!!!");
   		else
   		JOptionPane.showMessageDialog(this,"Can't  Deleted...!!!");		
	}	

		
	if(ae.getSource()==bsrch)
		{
			String bn=JOptionPane.showInputDialog(null,"Please Enter MilkCollection Id to Search Reords from MilkCollection!"," MilkCollection ",JOptionPane.QUESTION_MESSAGE);
			int sno=Integer.parseInt(bn);
			stmt1=con1.createStatement();
           			 rs1= stmt1.executeQuery("select * from MilkCollection1 where mc_id="+sno);  
          			  if(rs1.next()) 
			{  
             				   int s = rs1.getInt(1);  
				int d=rs1.getInt(2);
				int idcb=rs1.getInt(3);
                				String nm = rs1.getString(4);
				String mt = rs1.getString(5);
				int tm=rs1.getInt(6);   
                				int f = rs1.getInt(7);
				int snf=rs1.getInt(8);
				int mr1=rs1.getInt(9);
				String mt2=rs1.getString(10);
				int tmt=rs1.getInt(11);
				int ft=rs1.getInt(12);
				int sn=rs1.getInt(13);
				int mr2=rs1.getInt(14);  

                			//Sets Records in TextFields.  
              		 		tmci.setText(Integer.toString(s));
				td.setText(Integer.toString(d));
				idcmb1.setSelectedItem(idcb);
				tsn.setText(nm);
				tmt1.setSelectedItem(mt);
				ttm.setText(Integer.toString(tm));
				f1cmb5.setSelectedItem(f);
				s1cmb6.setSelectedItem(snf);
				tmr1.setSelectedItem(mr1);
				tmr3.setSelectedItem(mt2);
				ttm1.setText(Integer.toString(tmt));
				f2cmb3.setSelectedItem(ft);
				s2cmb4.setSelectedItem(sn);
				tmr2.setSelectedItem(mr2);
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
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
		stmt1=con1.createStatement();
		int mci=Integer.parseInt(tmci.getText());
		int d=Integer.parseInt(td.getText());
		int cid=(Integer)idcmb1.getSelectedItem();
		String snm=(String)tsn.getText();
		String mty=(String)tmt1.getSelectedItem();
		int tm=Integer.parseInt(ttm.getText());
		int cm=(Integer)f1cmb5.getSelectedItem();
		int scm=(Integer)s1cmb6.getSelectedItem();
		int mr=(Integer)tmr1.getSelectedItem();
		String mty1=(String)tmr3.getSelectedItem();
		int tmt=Integer.parseInt(ttm1.getText());
		int cm1=(Integer)f2cmb3.getSelectedItem();
		int scm1=(Integer)s2cmb4.getSelectedItem();
		int mr1=(Integer)tmr2.getSelectedItem();
				
		
		pstmt=con1.prepareStatement("UPDATE MilkCollection1 SET mdate=?and Society_id=?and Society_name=? and Milk_type1=?and total_milk1=?and fat1=?and snf1=?and Milk_rate1=?and milk_type2=?and total_milk2=?and fat2=? and snf2=? and Milk_rate2=?WHERE mc_id=?");
		pstmt.setInt(2,d);
		pstmt.setInt(3,cid);
		pstmt.setString(4,snm);
		pstmt.setString(5,mty);
		pstmt.setInt(6,tm);
		pstmt.setInt(7,cm);
		pstmt.setInt(8,scm);
		pstmt.setInt(9,mr);
		pstmt.setString(10,mty1);
		pstmt.setInt(11,tmt);
		pstmt.setInt(12,cm1);
		pstmt.setInt(13,scm1);
		pstmt.setInt(14,mr1);
		pstmt.setInt(1,mci);
		
		

		pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null,"Record  Updated SuccessFullY!.....");
		}catch(Exception e2){}

	 }  
	if(ae.getSource()==bexit)
		{
		new MDI2();//this.setVisible(false);
		}

	}catch(Exception e){}

}

	public static void main(String args[])
	{
		MilkCollection1 m1=new MilkCollection1();
	}
	
}