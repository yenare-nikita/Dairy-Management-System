import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.*;
//import javax.swing.JInternalFrame ;
import java.text.*;
public class DairyBills1 extends JFrame implements ActionListener,KeyListener
{
	JLabel brn,mci,sn,sl,mt,tmq,f,s,p,mr,bd,mcd,ba,dl1,dl2,dl3,dl4,dl5,dl6,l0,l9,d,t;
	JTextField tbrn,tmci,tsn,ts1,ttmq,tf,ts,tp,tmr,tbd,tmcd,tba,ln;
	JComboBox tcmb1,tcmb2;
	JButton bcal,badd,bsave,bexit,bdel;
	JFrame frm2;
	Connection cn,cn1;
	ResultSet rs=null;
	ResultSet rs1=null;
	PreparedStatement pstmt;
	Statement stmt,stmt1;
	int interval=100;
	javax.swing.Timer time;
	public DairyBills1()
	{
		setContentPane(new JLabel(new ImageIcon("e://img/dairybill1.jpg")));
		setLayout(null);	
	
		
	                   this.setVisible(true);
		this.setTitle("     	Dairy Bills Information");
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
                	      
                       l0=new JLabel("DAIRY BILL DETAILS");
                       l0.setForeground(Color.green);
             	     l0.setFont(new Font("Times New Roman",Font.BOLD,35));
              	     l0.setBounds(410,80,700,35);
            	     add(l0); 
   	          ln=new  JTextField(10);
                 ln.setForeground(Color.blue);
                ln.setBounds(05,130,1500,5);
                  add(ln);		

		//ltl=new JLabel("DAIRY DISTRIBUTOR INFORMATION");
		//ltl.setFont(new Font("Times New Roman",Font.BOLD,40));
		//ltl.setBounds(350,50,600,50);
		//add(ltl);

		brn=new JLabel("Bill Receipt ID");
		brn.setFont(new Font("Times New Roman",Font.BOLD,25));
		brn.setBounds(200,190,300,50);
		add(brn);
		
		tbrn=new JTextField(30);
		tbrn.setFont(new Font("Times New Roman",Font.BOLD,25));
		tbrn.setBounds(460,200,100,30);
		add(tbrn);		
		
		bd=new JLabel("Bill Date");
		bd.setFont(new Font("Times New Roman",Font.BOLD,25));
		bd.setBounds(900,190,150,50);
		add(bd);
		
		tbd=new JTextField(30);
		tbd.setFont(new Font("Times New Roman",Font.BOLD,25));
		tbd.setBounds(1150,200,100,30);
		add(tbd);		
		

		mcd=new JLabel("Milk Collection Date");
		mcd.setFont(new Font("Times New Roman",Font.BOLD,25));
		mcd.setBounds(900,240,250,30);
		add(mcd);
		
		tmcd=new JTextField(30);
		tmcd.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmcd.setBounds(1150,240,100,30);
		add(tmcd);
		
		mci=new JLabel("Milk Collection Id");
		mci.setFont(new Font("Times New Roman",Font.BOLD,25));
		mci.setBounds(200,240,220,60);
		add(mci);
		
		tcmb1=new JComboBox();
		tcmb1.setFont(new Font("Times New Roman",Font.BOLD,25));
		tcmb1.setBounds(460,260,100,30);
		add(tcmb1);
		
		
		sn=new JLabel("Society Name");
		sn.setFont(new Font("Times New Roman",Font.BOLD,25));
		sn.setBounds(200,290,220,60);
		add(sn);

		tsn=new JTextField(30);
		tsn.setFont(new Font("Times New Roman",Font.BOLD,25));
		tsn.setBounds(460,310,370,30);
		add(tsn);

		/*sl=new JLabel("Society Loation");
		sl.setFont(new Font("Times New Roman",Font.BOLD,25));
		sl.setBounds(200,310,250,30);
		add(sl);

		ts1=new JTextField(30);
		ts1.setFont(new Font("Times New Roman",Font.BOLD,25));
		ts1.setBounds(460,310,100,30);
		add(ts1);*/

		//mt=new JLabel("ml.");
		//dl1.setFont(new Font("Times New Roman",Font.BOLD,25));
		//dl1.setBounds(570,310,70,30);
		//add(dl1);

		mt=new JLabel("Milk Type");
		mt.setFont(new Font("Times New Roman",Font.BOLD,25));
		mt.setBounds(200,340,150,30);
		add(mt);

		ts1=new JTextField();
		ts1.setFont(new Font("Times New Roman",Font.BOLD,25));
		ts1.setBounds(460,350,100,30);
		add(ts1);

		tmq=new JLabel("Total Milk Quantity");
		tmq.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmq.setBounds(200,390,250,30);
		add(tmq);

		ttmq=new JTextField(30);
		ttmq.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttmq.setBounds(460,390,150,30);
		add(ttmq);

		dl1=new JLabel("ml.");
		dl1.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl1.setBounds(610,390,70,30);
		add(dl1);
		
		f=new JLabel("Fat");
		f.setFont(new Font("Times New Roman",Font.BOLD,25));
		f.setBounds(200,430,150,30);
		add(f);

		tf=new JTextField(30);
		tf.setFont(new Font("Times New Roman",Font.BOLD,25));
		tf.setBounds(460,430,150,30);
		add(tf);

		dl2=new JLabel("gm.");
		dl2.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl2.setBounds(610,430,150,30);
		add(dl2);

		s=new JLabel("SNF");
		s.setFont(new Font("Times New Roman",Font.BOLD,25));
		s.setBounds(200,470,150,30);
		add(s);

		ts=new JTextField(30);
		ts.setFont(new Font("Times New Roman",Font.BOLD,25));
		ts.setBounds(460,470,100,30);
		add(ts);

		dl3=new JLabel("snf.");
		dl3.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl3.setBounds(580,470,150,30);
		add(dl3);

		/*p=new JLabel("Protein");
		p.setFont(new Font("Times New Roman",Font.BOLD,25));
		p.setBounds(200,500,150,30);
		add(p);

		tp=new JTextField(30);
		tp.setFont(new Font("Times New Roman",Font.BOLD,25));
		tp.setBounds(460,500,100,30);
		add(tp);

		dl4=new JLabel("kg.");
		dl4.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl4.setBounds(580,500,100,30);
		add(dl4);*/

		

		mr=new JLabel("Milk Rate");
		mr.setFont(new Font("Times New Roman",Font.BOLD,25));
		mr.setBounds(200,540,150,30);
		add(mr);

		tmr=new JTextField(30);
		tmr.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmr.setBounds(460,540,150,30);
		add(tmr);

		dl5=new JLabel("Rs.");
		dl5.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl5.setBounds(630,540,100,30);
		add(dl5);

		ba=new JLabel("Bill Amount");
		ba.setFont(new Font("Times New Roman",Font.BOLD,25));
		ba.setBounds(900,420,250,30);
		add(ba);

		tba=new JTextField(30);
		tba.setFont(new Font("Times New Roman",Font.BOLD,25));
		tba.setBounds(1150,420,150,30);
		add(tba);

		dl6=new JLabel("Rs.");
		dl6.setFont(new Font("Times New Roman",Font.BOLD,25));
		dl6.setBounds(1300,420,100,30);
		add(dl6);

		bcal=new JButton("Calculate Bill");
		bcal.setFont(new Font("Times New Roman",Font.BOLD,30));
		bcal.setBounds(900,470,350,30);
		add(bcal);
		bcal.addActionListener(this);
		
		badd=new JButton("NEW");
		badd.setFont(new Font("Times New Roman",Font.BOLD,30));
		badd.setBounds(400,590,135,45);
		add(badd);
		badd.addActionListener(this);

		bsave=new JButton("SAVE");
		bsave.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsave.setBounds(700,590,130,45);
		add(bsave);
		bsave.addActionListener(this);
				
				
		bexit=new JButton("EXIT");
		bexit.setFont(new Font("Times New Roman",Font.BOLD,30));
		bexit.setBounds(950,590,200,45);
		add(bexit);
		bexit.addActionListener(this);
		this.getContentPane().setBackground(Color.white);

		badd.setToolTipText("add new Record");
		bsave.setToolTipText("save the record");
		bexit.setToolTipText(" exit");
		tcmb1.addActionListener(this);
		
		try
                                      {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:project");
			stmt=cn.createStatement();
			rs =stmt.executeQuery("select * from MilkCollection1");
			while(rs.next())
			{
				int s = rs.getInt(1);  
				tcmb1.addItem(Integer.toString(s));
			}

			cn.close();
		}catch(Exception e2){}
	
	}
	public void keyTyped(KeyEvent e) 
	{}
	
public void keyReleased(KeyEvent e) 
 {
 }
public void EnabledT()
{
	tbrn.setEnabled(true);
	tbd.setEnabled(true);
	tmcd.setEnabled(true);
	tsn.setEnabled(true);
	ts1.setEnabled(true);
	ttmq.setEnabled(true);
	tf.setEnabled(true);
	ts.setEnabled(true);
	tmr.setEnabled(true);
	tba.setEnabled(true);
	
	}
public void EnabledF()
{
	tbrn.setEnabled(false);
	tbd.setEnabled(false);
	tmcd.setEnabled(false);
	tsn.setEnabled(false);
	ts1.setEnabled(false);
	ttmq.setEnabled(false);
	tf.setEnabled(false);
	ts.setEnabled(false);
	tmr.setEnabled(false);
	tba.setEnabled(false);
	
	}
public void keyPressed(KeyEvent e) 
 {
 }
public void actionPerformed(ActionEvent ae) 
   {
	  try
{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
                  			//stmt=cn.createStatement();

		if(ae.getSource()==tcmb1)
		{
			int d=Integer.parseInt(tcmb1.getSelectedItem().toString());
			stmt1=cn1.createStatement();
			rs1=stmt1.executeQuery("select * from MilkCollection1 where mc_id="+d);
			if(rs1.next())
			{
				tmcd.setText(rs1.getString(2));
				tsn.setText(rs1.getString(4));
				 ts1.setText(rs1.getString(5));
				ttmq.setText(rs1.getString(6));
				tf.setText(rs1.getString(7));
				ts.setText(rs1.getString(8));
				tmr.setText(rs1.getString(9));
				//int dt=rs1.getInt(2);
			
				
			}
		}


                  
}catch(Exception e1){}
	if(ae.getSource()==bcal)
   	{
		int t=Integer.parseInt(ttmq.getText());
		int m=Integer.parseInt(tmr.getText());	
		int res=t*m;
		tba.setText(Integer.toString(res));
	}

	
	
	if(ae.getSource()==badd) 
	{
		try{
		EnabledT();
		
	tbrn.setText("");
	tbd.setText("");
	tmcd.setText("");
	tsn.setText("");
	ts1.setText("");
	ttmq.setText("");
	tf.setText("");
	ts.setText("");
	tmr.setText("");
	tba.setText("");
		tsn.requestFocus();
	 	 	
		
		int count=1;
		stmt1=cn1.createStatement();
				
				
				rs1=stmt1.executeQuery("select * from DairyBills1");
			//System.out.println("jhdh");
				while(rs1.next())
				{
					count=rs1.getInt(1);
					count++;
					System.out.println("g"+count);
				}
				tbrn.setText(String.valueOf(count));
	 	                            	tbrn.setEnabled(false);
 			                          	 
		
	}catch(Exception e2){}
			
	}
	if(ae.getSource()==bsave)
	{
              
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn1=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			stmt1=cn1.createStatement();
		                 String s="insert into DairyBills1 Values('"+tbrn.getText()+"','"+ tbd.getText()+"','"+tcmb1.getSelectedItem()+"','" + tmcd.getText() +"','"+tsn.getText()+"','"+ts1.getText()+"','"+ttmq.getText()+"','"+tf.getText()+"','"+ts.getText()+"','"+tmr.getText()+"','"+tba.getText()+"')";
                                                       int r=stmt1.executeUpdate(s);
		                 JOptionPane.showMessageDialog(null,"1.Record Inserted Sucessfully!!!!!");
			EnabledF();
                                                      }catch(Exception e3){}
	}
		

	if(ae.getSource()==bexit)
		{
		new MDI2(); //this.setVisible(false);
		}
	}
	public static void main(String args[])
	{
		DairyBills1 d1=new DairyBills1();
	}
	
}