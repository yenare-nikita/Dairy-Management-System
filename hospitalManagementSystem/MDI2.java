import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MDI2 extends JFrame implements ActionListener
{
	Frame f;
	Label l;
	MenuBar mb;
	Menu mf,tf,r,e1;
	MenuItem c,b1,d1,c1,d2,m1,c2,r1,br1,dr1,cr1,dr2,mr1,cr2,rar1;
	public MDI2()
	{
		setContentPane(new JLabel(new ImageIcon("C://Users/Prachi/Downloads/bb.jpg")));
		setLayout(null);
		mb=new MenuBar();
		mf=new Menu("Master Form");
		mf.setFont(new Font("Times New Roman",Font.BOLD,15));
		tf=new Menu("Transaction Form");
		tf.setFont(new Font("Times New Roman",Font.BOLD,15));
		r=new Menu("Report");
		r.setFont(new Font("Times New Roman",Font.BOLD,15));

		e1=new Menu("exit");
		e1.setFont(new Font("Times New Roman",Font.BOLD,15));
		b1=new MenuItem("StaffDetail");
		d1=new MenuItem("SocietyDetail");
		c1=new MenuItem("DistributorDetail");
		d2=new MenuItem("MilkDetail");
		m1=new MenuItem("MilkCollectionDetail");
		c2=new MenuItem("DairyDistributionDetail");
		r1=new MenuItem("DairyBillsDetail");
	
		br1=new MenuItem("StaffDetailReport");
		dr1=new MenuItem("SocietyReport");
		cr1=new MenuItem("DistributorReport");
		dr2=new MenuItem("MilkReport");
		mr1=new MenuItem("MilkCollectionReport");
		cr2=new MenuItem("MilkDistributionReport");
		rar1=new MenuItem("DairyBillsReport");
		c=new MenuItem("close");


        //l.setBounds(0,0,500,500);
			mf.add(b1);
			mf.add(d1);
			mf.add(c1);
			mf.add(d2);
			//mf.add(m1);
			tf.add(c2);
			tf.add(r1);
			tf.add(m1);
			r.add(br1);
			r.add(dr1);
			r.add(cr1);
			r.add(dr2);
			r.add(mr1);
			r.add(cr2);
			r.add(rar1);
			e1.add(c);


			mb.add(mf);
			mb.add(tf);
			mb.add(r);
			mb.add(e1);
			//add(l);
		this.setMenuBar(mb);
		b1.addActionListener(this);
		d1.addActionListener(this);
		c1.addActionListener(this);
		d2.addActionListener(this);
		m1.addActionListener(this);	
		c2.addActionListener(this);	
		r1.addActionListener(this);
			
		br1.addActionListener(this);	
		dr1.addActionListener(this);	
		cr1.addActionListener(this);	
		dr2.addActionListener(this);	
		mr1.addActionListener(this);	
		cr2.addActionListener(this);	
		rar1.addActionListener(this);
		c.addActionListener(this);	

		this.setSize(1400,1000);
		this.setTitle("DAIRY MANAGEMENT SYSTEM");
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{ 
		if(e.getSource()==b1)
			new Staff();
		if(e.getSource()==d1)
			new Society();
		if(e.getSource()==c1)
			new Distributor1();
		if(e.getSource()==d2)
			new Milk();
		if(e.getSource()==m1)
			new MilkCollection1();
		if(e.getSource()==c2)
			new DairyDis();
		if(e.getSource()==r1)
			new DairyBills1();
			
		if(e.getSource()==br1)
			new jtStaff1();
		if(e.getSource()==dr1)
			new jtSociety1();
		if(e.getSource()==cr1)
			new jtDistributor1();
		if(e.getSource()==dr2)
			new jtMilk1();
		if(e.getSource()==mr1)
			new jtMilkCollection1();
		if(e.getSource()==cr2)
			new jtDairyDis1();
		if(e.getSource()==rar1)
			new jtDairyBills1();
		if(e.getSource()==c)
			System.exit(0);
		
	}

	public static void main(String args[])
	{
		MDI2 mm=new MDI2();
	}
}