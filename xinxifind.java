import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class xinxifind extends JFrame implements ActionListener

{
	public static void main(String[] args)
	{
		xinxifind frame=new xinxifind();
	}

	JTextArea ta1;

	JComboBox jobsBox;
	JLabel lb;
	JLabel lb1;
	JTextField tf1;
	JLabel lb2;
	JComboBox jobsBox1;
	JComboBox jobsBox2;
	JTextField tf2;
	JComboBox jobsBox3;
	JComboBox jobsBox4;
	JTextField tf3;
	Connection con1;
	ResultSet rs1;
	Statement st1;
	String str1="";
	String str2="";
	String pp="2��¥ס�޻�����";
	String pp1="����ϵ";
	String pp2="�������";
	String pp3="����ϵ";
	String pp4="�������";
	JButton bu11,bu12,bu13,bu14,bu15,bu16,bu17;
	public xinxifind()
	{
//��=================�������=============================================================		
		super("ȫУѧ��ס����Ϣ��ѯ");
		Container c=getContentPane();
	    c.setLayout(null);
		
	
		JPanel textPanel=new JPanel();
		JPanel p=new JPanel();
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
		ta1=new JTextArea("",25,35);
		JScrollPane scrollPane=new JScrollPane(ta1);
		textPanel.add(scrollPane);
		textPanel.setSize(400,500);
		textPanel.setLocation(0,0);
		lb1=new JLabel("��¥��ѯ");
        
		lb1.setSize(100,30);
		lb1.setLocation(450,20);

	    jobsBox=new JComboBox();
		
		jobsBox.addItem("2��¥ס�޻�����");
		jobsBox.addItem("3��¥ס�޻�����");
		jobsBox.addItem("5��¥ס�޻�����");
		jobsBox.addItem("7��¥ס�޻�����");
		jobsBox.addItem("8��¥ס�޻�����");
		jobsBox.addItem("13��¥ס�޻�����");
		jobsBox.addItem("14��¥ס�޻�����");
		jobsBox.addItem("����¥ѧ��ס�޻�����");
		jobsBox.addItem("ѧ����Ԣ¥ס�޻�����");
		p.add(jobsBox);
		p.setSize(200,40);
		p.setLocation(450,80);
		lb=new JLabel("¥��*");
        lb.setSize(40,40);
		lb.setLocation(420,80);
		bu11=new JButton("����");
		bu11.setSize(60,30);
		bu11.setLocation(405,120);
		tf1=new JTextField("");
		tf1.setSize(100,30);
		tf1.setLocation(470,120);
		jobsBox1=new JComboBox();
		jobsBox1.setEditable(true);
		jobsBox1.addItem("����ϵ");
		jobsBox1.addItem("����ϵ");
		p1.add(jobsBox1);
		p1.setSize(150,40);
		p1.setLocation(460,160);
		bu12=new JButton("ϵ��");
		bu12.setSize(60,30);
		bu12.setLocation(400,160);
		jobsBox2=new JComboBox();
	    jobsBox2.setEditable(true);
		jobsBox2.addItem("�������");
		jobsBox2.addItem("�屣");
		p2.add(jobsBox2);
		p2.setSize(150,40);
		p2.setLocation(462,200);
		bu13=new JButton("רҵ");
		bu13.setSize(60,30);
		bu13.setLocation(402,200);
		tf2=new JTextField("");
		tf2.setSize(150,30);
		tf2.setLocation(465,240);
		bu14=new JButton("����");
		bu14.setSize(60,30);
		bu14.setLocation(402,240);
		lb2=new JLabel("ȫУ��ѯ");
    
		lb2.setSize(100,30);
		lb2.setLocation(450,300);
		bu15=new JButton("ϵ��");
		bu15.setSize(60,30);
		bu15.setLocation(402,340);
		jobsBox3=new JComboBox();
		jobsBox3.setEditable(true);
		jobsBox3.addItem("����ϵ");
		jobsBox3.addItem("����ϵ");
	
		p3.add(jobsBox3);
		p3.setSize(150,40);
		p3.setLocation(455,340);
		bu16=new JButton("רҵ");
		bu16.setSize(60,30);
		bu16.setLocation(399,380);
		jobsBox4=new JComboBox();
		jobsBox4.setEditable(true);
		jobsBox4.addItem("�������");
		jobsBox4.addItem("�屣");
		p4.add(jobsBox4);
		p4.setSize(150,40);
		p4.setLocation(458,380);
		bu17=new JButton("����");
		bu17.setSize(60,30);
		bu17.setLocation(402,420);
		tf3=new JTextField("");
		tf3.setSize(150,30);
		tf3.setLocation(465,420);
		
		c.add(textPanel);
		c.add(p);
		c.add(lb1);
		c.add(lb);
		c.add(bu11);
		c.add(tf1);
		c.add(p1);
		c.add(bu12);
		c.add(p2);
		c.add(bu13);
		c.add(tf2);
		c.add(bu14);
		c.add(lb2);
		c.add(bu15);
		c.add(p3);
		c.add(p4);
		c.add(bu16);
		c.add(bu17);
		c.add(tf3);
		setSize(650,500);
		setVisible(true);
//========���ü���========================================================		
		
		jobsBox.addActionListener(this);
		jobsBox1.addActionListener(this);
		jobsBox2.addActionListener(this);
		jobsBox3.addActionListener(this);
		jobsBox4.addActionListener(this);
		bu11.addActionListener(this);
		bu12.addActionListener(this);
		bu13.addActionListener(this);
		bu14.addActionListener(this);
		bu15.addActionListener(this);
		bu16.addActionListener(this);
		bu17.addActionListener(this);
		connect_db();
		
//==============================================================��=========================		
	}
//========�������ݿ�======================================================================
	 public void connect_db()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println("Driver not found!");
		}
		try
		{
			con1=DriverManager.getConnection("jdbc:odbc:student");
			st1=con1.createStatement();
		}
		catch(SQLException e2)
		{
			System.out.println("table not found!");
		}
	}
//===================��Ӧ�����¼�================================================
		public void actionPerformed(ActionEvent e)
	{
		String str11;
		String str12;
		String str13;
		String str2;
		String std_id;
		String str3;
	    String str4;
	    pp=jobsBox.getSelectedItem().toString();
             	
        pp1=jobsBox1.getSelectedItem().toString();
             	
             	
        pp2=jobsBox2.getSelectedItem().toString();
        pp3=jobsBox3.getSelectedItem().toString();
             	
             	
        pp4=jobsBox4.getSelectedItem().toString();
		try
		{
			str2=tf2.getText();
			str3=tf1.getText();
			str4=tf3.getText();
			if(e.getSource()==bu14)
			{
			rs1=st1.executeQuery("select * from "+pp+" WHERE (name LIKE '%"+str2+"%' OR name LIKE '%"+str2+"' OR name LIKE '"+str2+"%') OR (fanghao='����')");
			str11="";
			while(rs1.next())
			{
				str11=str11+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}
		
			ta1.setText(str11);
		}
		if(e.getSource()==bu11)
		{
			rs1=st1.executeQuery("select * from "+pp+" WHERE  (fanghao='"+str3+"') OR (fanghao='����')");
			str12="";
			while(rs1.next())
			{
				str12=str12+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}
		
			ta1.setText(str12);
		}
		if(e.getSource()==bu12)
		{
			rs1=st1.executeQuery("select * from "+pp+" WHERE (xibie='"+pp1+"') OR (fanghao='����')");
			str13="";
			while(rs1.next())
			{
				str13=str13+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}
		
			ta1.setText(str13);
		}
		if(e.getSource()==bu13)
		{
			rs1=st1.executeQuery("select * from "+pp+" WHERE (zhuanye='"+pp2+"') OR (fanghao='����')");
			str13="";
			while(rs1.next())
			{
				str13=str13+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}
		
			ta1.setText(str13);
		}
        if(e.getSource()==bu15)
		{
			rs1=st1.executeQuery("select * from 2��¥ס�޻����� WHERE xibie='"+pp3+"' OR fanghao='����'");			
//			rs1=st1.executeQuery("select * from 2��¥ס�޻�����,3��¥ס�޻�����,5��¥ס�޻�����,7��¥ס�޻�����,8��¥ס�޻�����,13��¥ס�޻�����,14��¥ס�޻�����,����¥ѧ��ס�޻�����,ѧ����Ԣ¥ס�޻����� WHERE zhuanye='"+pp4+"' OR fanghao='����'");
			str13="";
			while(rs1.next())
			{
				str13=str13+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}	
			ta1.setText(str13);
			
			ResultSet rs2=st1.executeQuery("select * from 3��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs2.next())
			{
				str13=str13+rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+
				rs2.getString(5)+"\t"+rs2.getString(6)+"\t"+rs2.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs3=st1.executeQuery("select * from 5��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs3.next())
			{
				str13=str13+rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3)+"\t"+
				rs3.getString(5)+"\t"+rs3.getString(6)+"\t"+rs3.getString(7)+"\n";
			}	
			ta1.append(str13);								
			
			ResultSet rs4=st1.executeQuery("select * from 7��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs4.next())
			{
				str13=str13+rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getString(3)+"\t"+
				rs4.getString(5)+"\t"+rs4.getString(6)+"\t"+rs4.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs5=st1.executeQuery("select * from 8��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs5.next())
			{
				str13=str13+rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getString(3)+"\t"+
				rs5.getString(5)+"\t"+rs5.getString(6)+"\t"+rs5.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs6=st1.executeQuery("select * from 13��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs6.next())
			{
				str13=str13+rs6.getString(1)+"\t"+rs6.getString(2)+"\t"+rs6.getString(3)+"\t"+
				rs6.getString(5)+"\t"+rs6.getString(6)+"\t"+rs6.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs7=st1.executeQuery("select * from 14��¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs7.next())
			{
				str13=str13+rs7.getString(1)+"\t"+rs7.getString(2)+"\t"+rs7.getString(3)+"\t"+
				rs7.getString(5)+"\t"+rs7.getString(6)+"\t"+rs7.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs8=st1.executeQuery("select * from ����¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs8.next())
			{
				str13=str13+rs8.getString(1)+"\t"+rs8.getString(2)+"\t"+rs8.getString(3)+"\t"+
				rs8.getString(5)+"\t"+rs8.getString(6)+"\t"+rs8.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs9=st1.executeQuery("select * from ѧ����Ԣ¥ס�޻����� WHERE xibie='"+pp3+"'");			
			str13="";
			while(rs9.next())
			{
				str13=str13+rs9.getString(1)+"\t"+rs9.getString(2)+"\t"+rs9.getString(3)+"\t"+
				rs9.getString(5)+"\t"+rs9.getString(6)+"\t"+rs9.getString(7)+"\n";
			}	
			ta1.append(str13);					
			
		}
		if(e.getSource()==bu16)
		{
			rs1=st1.executeQuery("select * from 2��¥ס�޻����� WHERE zhuanye='"+pp4+"' OR fanghao='����'");			
//			rs1=st1.executeQuery("select * from 2��¥ס�޻�����,3��¥ס�޻�����,5��¥ס�޻�����,7��¥ס�޻�����,8��¥ס�޻�����,13��¥ס�޻�����,14��¥ס�޻�����,����¥ѧ��ס�޻�����,ѧ����Ԣ¥ס�޻����� WHERE zhuanye='"+pp4+"' OR fanghao='����'");
			str13="";
			while(rs1.next())
			{
				str13=str13+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}	
			ta1.setText(str13);
			
			ResultSet rs2=st1.executeQuery("select * from 3��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs2.next())
			{
				str13=str13+rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+
				rs2.getString(5)+"\t"+rs2.getString(6)+"\t"+rs2.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs3=st1.executeQuery("select * from 5��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs3.next())
			{
				str13=str13+rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3)+"\t"+
				rs3.getString(5)+"\t"+rs3.getString(6)+"\t"+rs3.getString(7)+"\n";
			}	
			ta1.append(str13);								
			
			ResultSet rs4=st1.executeQuery("select * from 7��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs4.next())
			{
				str13=str13+rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getString(3)+"\t"+
				rs4.getString(5)+"\t"+rs4.getString(6)+"\t"+rs4.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs5=st1.executeQuery("select * from 8��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs5.next())
			{
				str13=str13+rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getString(3)+"\t"+
				rs5.getString(5)+"\t"+rs5.getString(6)+"\t"+rs5.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs6=st1.executeQuery("select * from 13��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs6.next())
			{
				str13=str13+rs6.getString(1)+"\t"+rs6.getString(2)+"\t"+rs6.getString(3)+"\t"+
				rs6.getString(5)+"\t"+rs6.getString(6)+"\t"+rs6.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs7=st1.executeQuery("select * from 14��¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs7.next())
			{
				str13=str13+rs7.getString(1)+"\t"+rs7.getString(2)+"\t"+rs7.getString(3)+"\t"+
				rs7.getString(5)+"\t"+rs7.getString(6)+"\t"+rs7.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs8=st1.executeQuery("select * from ����¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs8.next())
			{
				str13=str13+rs8.getString(1)+"\t"+rs8.getString(2)+"\t"+rs8.getString(3)+"\t"+
				rs8.getString(5)+"\t"+rs8.getString(6)+"\t"+rs8.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs9=st1.executeQuery("select * from ѧ����Ԣ¥ס�޻����� WHERE zhuanye='"+pp4+"'");			
			str13="";
			while(rs9.next())
			{
				str13=str13+rs9.getString(1)+"\t"+rs9.getString(2)+"\t"+rs9.getString(3)+"\t"+
				rs9.getString(5)+"\t"+rs9.getString(6)+"\t"+rs9.getString(7)+"\n";
			}	
			ta1.append(str13);					
			
			
		}		
        if(e.getSource()==bu17)
		{
		rs1=st1.executeQuery("select * from 2��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%') OR fanghao='����'");			
//			rs1=st1.executeQuery("select * from 2��¥ס�޻�����,3��¥ס�޻�����,5��¥ס�޻�����,7��¥ס�޻�����,8��¥ס�޻�����,13��¥ס�޻�����,14��¥ס�޻�����,����¥ѧ��ס�޻�����,ѧ����Ԣ¥ס�޻����� WHERE zhuanye='"+pp4+"' OR fanghao='����'");
			str13="";
			while(rs1.next())
			{
				str13=str13+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
			}	
			ta1.setText(str13);
			
			ResultSet rs2=st1.executeQuery("select * from 3��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs2.next())
			{
				str13=str13+rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+
				rs2.getString(5)+"\t"+rs2.getString(6)+"\t"+rs2.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs3=st1.executeQuery("select * from 5��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs3.next())
			{
				str13=str13+rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3)+"\t"+
				rs3.getString(5)+"\t"+rs3.getString(6)+"\t"+rs3.getString(7)+"\n";
			}	
			ta1.append(str13);								
			
			ResultSet rs4=st1.executeQuery("select * from 7��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs4.next())
			{
				str13=str13+rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getString(3)+"\t"+
				rs4.getString(5)+"\t"+rs4.getString(6)+"\t"+rs4.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs5=st1.executeQuery("select * from 8��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs5.next())
			{
				str13=str13+rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getString(3)+"\t"+
				rs5.getString(5)+"\t"+rs5.getString(6)+"\t"+rs5.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs6=st1.executeQuery("select * from 13��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs6.next())
			{
				str13=str13+rs6.getString(1)+"\t"+rs6.getString(2)+"\t"+rs6.getString(3)+"\t"+
				rs6.getString(5)+"\t"+rs6.getString(6)+"\t"+rs6.getString(7)+"\n";
			}	
			ta1.append(str13);
			
			ResultSet rs7=st1.executeQuery("select * from 14��¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs7.next())
			{
				str13=str13+rs7.getString(1)+"\t"+rs7.getString(2)+"\t"+rs7.getString(3)+"\t"+
				rs7.getString(5)+"\t"+rs7.getString(6)+"\t"+rs7.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs8=st1.executeQuery("select * from ����¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs8.next())
			{
				str13=str13+rs8.getString(1)+"\t"+rs8.getString(2)+"\t"+rs8.getString(3)+"\t"+
				rs8.getString(5)+"\t"+rs8.getString(6)+"\t"+rs8.getString(7)+"\n";
			}	
			ta1.append(str13);	
			
			ResultSet rs9=st1.executeQuery("select * from ѧ����Ԣ¥ס�޻����� WHERE (name LIKE '%"+str4+"%' OR name LIKE '%"+str4+"' OR name LIKE '"+str4+"%')");			
			str13="";
			while(rs9.next())
			{
				str13=str13+rs9.getString(1)+"\t"+rs9.getString(2)+"\t"+rs9.getString(3)+"\t"+
				rs9.getString(5)+"\t"+rs9.getString(6)+"\t"+rs9.getString(7)+"\n";
			}	
			ta1.append(str13);					
				
		}			
            			
         //System.out.println("�ɹ�����");     
             	
		}
		catch(SQLException e2)
		{
			//System.out.println("error");
		}
            	
             }
             	
//======================================================================================
}