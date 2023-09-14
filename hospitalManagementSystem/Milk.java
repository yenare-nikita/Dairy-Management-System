import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.*;
//import javax.swing.JInternalFrame ;
import java.text.*;
public class Milk extends JFrame implements ActionListener,KeyListener
{
	JLabel  lmr,lgm,lsn,lpr,lml,ltl,ltype,ltfat,lsnf,lpro,lmrate,l9,d,t,l0;
	JComboBox ttype,ttfat,tsnf,tmrate;
	JButton bsave,badd,bexit,bupd;
	JTextField tprot,ln,ln1;
	JFrame frm2;
	Connection con,con1;
	ResultSet rs=null;
	ResultSet rs1=null;
	PreparedStatement ps;
	Statement stmt,stmt1;
	int interval=100;
	javax.swing.Timer time;
	public Milk()
	{
		
		setContentPane(new JLabel(new ImageIcon("e://img/milk.jpg")));
		setLayout(null);	
	
		this.setVisible(true);
		this.setTitle("     	Milk Information");
		this.setLayout(null);
		this.setSize(1500,1500);
	
                        Font fl=new Font("Arial",Font.BOLD | Font.ITALIC,25);
                        l9=new JLabel("Dairy Management System");
     	      l9.setFont(new Font("Times New Roman",Font.BOLD,50));
     	      l9.setBounds(280,10,900,55);
	     l9.setForeground(Color.red);
                        add(l9);
 	     d=new JLabel("");
	    time=new javax.swing.Timer(interval,new ActionListener(){
           	    public void actionPerformed(ActionEvent e)
           	   {
           		java.util.Date date=new java.util.Date();
           		SimpleDateFormat sd=new SimpleDateFormat("hh:mm:ss");
            		String da = sd.format(date);
            		d.setText(da);
            		d.setForeground(Color.black);
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
                	      
                       l0=new JLabel("Milk DETAILS");
                       l0.setForeground(Color.green);
             	     l0.setFont(new Font("Times New Roman",Font.BOLD,35));
              	     l0.setBounds(460,80,700,35);
            	     add(l0); 
   		ln=new  JTextField(10);
                  ln.setForeground(Color.blue);
                  ln.setBounds(05,130,1500,5);
                  add(ln);		

		//ltl=new JLabel("Milk INFORMATION");
		//ltl.setFont(new Font("Times New Roman",Font.BOLD,40));
		//ltl.setBounds(350,50,600,50);
		//add(ltl);

		ltype=new JLabel("Milk Type");
		ltype.setFont(new Font("Times New Roman",Font.BOLD,25));
		ltype.setBounds(300,190,220,50);
		add(ltype);
		
		ttype=new JComboBox();
		ttype.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttype.setBounds(550,200,150,40);
		ttype.addItem("Cow");
		ttype.addItem("BuffalloW");
		add(ttype);
		

		

		ltfat=new JLabel("Total Fat");
		ltfat.setFont(new Font("Times New Roman",Font.BOLD,25));
		ltfat.setBounds(300,240,220,60);
		add(ltfat);

		ttfat=new JComboBox();
		ttfat.setFont(new Font("Times New Roman",Font.BOLD,25));
		ttfat.setBounds(550,250,200,30);
		ttfat.addItem(3.0);
		ttfat.addItem(3.2);
		ttfat.addItem(3.4);
		ttfat.addItem(3.6);
		ttfat.addItem(3.8);
		ttfat.addItem(4.0);
		add(ttfat);

		
		lsnf=new JLabel("SNF");
		lsnf.setFont(new Font("Times New Roman",Font.BOLD,25));
		lsnf.setBounds(300,290,250,60);
		add(lsnf);

		tsnf=new JComboBox();
		tsnf.setFont(new Font("Times New Roman",Font.BOLD,25));
		tsnf.setBounds(550,300,150,40);
		tsnf.addItem(8.0);
		tsnf.addItem(8.1);
		tsnf.addItem(8.2);
		tsnf.addItem(8.3);
		tsnf.addItem(8.4);
		tsnf.addItem(8.5);
		tsnf.addItem(8.6);
		add(tsnf);
	
		lsn=new JLabel("snf.");
		lsn.setFont(new Font("Times New Roman",Font.BOLD,15));
		lsn.setBounds(710,300,100,40);
		add(lsn);

		lpro=new JLabel("Protein");
		lpro.setFont(new Font("Times New Roman",Font.BOLD,25));
		lpro.setBounds(300,330,220,70);
		add(lpro);

		tprot=new JTextField(30);
		tprot.setFont(new Font("Times New Roman",Font.BOLD,25));
		tprot.setBounds(550,350,220,30);
		add(tprot);

		lpr=new JLabel("kg.");
		lpr.setFont(new Font("Times New Roman",Font.BOLD,15));
		lpr.setBounds(780,350,100,40);
		add(lpr);
		
		lmrate=new JLabel("Milk Rate");
		lmrate.setFont(new Font("Times New Roman",Font.BOLD,25));
		lmrate.setBounds(300,380,220,70);
		add(lmrate);
	
		tmrate=new JComboBox();
		tmrate.setFont(new Font("Times New Roman",Font.BOLD,25));
		tmrate.setBounds(550,400,100,30);
		tmrate.addItem(27.50);
		tmrate.addItem(28.30);
		tmrate.addItem(29.10);
		tmrate.addItem(29.80);
		tmrate.addItem(30.40);
		tmrate.addItem(40.00);
		add(tmrate);

		lmr=new JLabel("Rs.");
		lmr.setFont(new Font("Times New Roman",Font.BOLD,15));
		lmr.setBounds(660,400,100,40);
		add(lmr);
		
		badd=new JButton("NEW");
		badd.setFont(new Font("Times New Roman",Font.BOLD,30));
		badd.setBounds(300,540,135,45);
		add(badd);
		badd.addActionListener(this);
		
		ln1=new  JTextField(10);
                  		ln1.setForeground(Color.blue);
                  		ln1.setBounds(05,650,1500,5);
                  		add(ln1);		

		bsave=new JButton("SAVE");
		bsave.setFont(new Font("Times New Roman",Font.BOLD,30));
		bsave.setBounds(500,540,135,45);
		add(bsave);
		bsave.addActionListener(this);

		bexit=new JButton("Exit");
		bexit.setFont(new Font("Times New Roman",Font.BOLD,30));
		bexit.setBounds(700,540,200,45);
		add(bexit);
		bexit.addActionListener(this);
		
		this.getContentPane().setBackground(Color.white);
		badd.setToolTipText("add new Record");
		bsave.setToolTipText("save the record");
		bexit.setToolTipText("too exit");
	
		
		
	}	
	


	public void keyTyped(KeyEvent es1) 
 {
      
     }
	
    public void keyReleased(KeyEvent es2) 
 {
 }
public void keyPressed(KeyEvent es3) 
 {
 }
                             

public void cn1()
{
try
{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			stmt=con.createStatement();
}
catch(Exception e1) 
{ 
JOptionPane.showMessageDialog(null,e1);
 }
}
public void EnabledF()
{
ttype.setEnabled(false);
ttfat.setEnabled(false);
tsnf.setEnabled(false);
tmrate.setEnabled(false);
tprot.setEnabled(false);


bsave.setEnabled(false);
}
public void EnabledT()
{
 ttype.setEnabled(true);
ttfat.setEnabled(true);
tsnf.setEnabled(true);
tmrate.setEnabled(true);
tprot.setEnabled(true);


bsave.setEnabled(true);
}
public void actionPerformed(ActionEvent ae) 
  {

	
                 if(ae.getSource()==badd) 
	{
			
		EnabledT();
		tprot.setText("");	
		tprot.requestFocus();
	 	
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:project"," "," ");
			stmt=con.createStatement();
		
		}catch(Exception e2){}
                     		                                  		
	} 
        	
		
		
	
			
	
	if(ae.getSource()==bsave)
	{
	          try
			{
              
			cn1();
		                String s="insert into Milk values('" + ttype.getSelectedItem()  + "','" +ttfat.getSelectedItem() + "','" + tsnf.getSelectedItem()  +"','"+tprot.getText()+"',"+tmrate.getSelectedItem()+")";
                                                      int r=stmt.executeUpdate(s);
		                 JOptionPane.showMessageDialog(null,"1.Record Inserted Sucessfully");
		con.close();
			EnabledF();
                                                       }
		
			catch(SQLException se){
			JOptionPane.showMessageDialog(null,se);
					}
			catch(Exception e22){
			JOptionPane.showMessageDialog(null,e22);
			
		} 	
	}	
	

	

	

	
	if(ae.getSource()==bexit)
		{
		new MDI2();//this.setVisible(false);
		}

	
}
public static void main(String args[])
	{
		Milk m1=new Milk();
	}
}
	