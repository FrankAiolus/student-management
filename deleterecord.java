import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class deleterecord extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		deleterecord frame=new deleterecord();
	}
	JLabel lb,lb2;
	JLabel lb1[]=new JLabel[8];
	TextField tf1[]=new TextField[8];
	String fieldname[]={"����*","ϵ��","רҵ","�꼶","���","����","�绰"};
	String fieldvalue[]={"103","����ϵ","�屣","03","","֣��ǿ�����š��˱��ϡ�������","5243472"};
	JButton bu1;
	JTextArea ta1;
	Connection con1;
	ResultSet rs1;
	Statement st1;
	String str1="";
	String pp="2��¥ס�޻�����";
	private JComboBox jobsBox;
	
	public deleterecord()
	{
		setTitle("ȫУѧ��ס�޻��������");
		
		Container c=getContentPane();
		JPanel p=new JPanel();
		c.setLayout(null);
		lb=new JLabel("������ɾ������");
		lb.setForeground(new Color(200,20,2));
		Font f=new Font("����",Font.BOLD,20);
		lb.setFont(f);
		lb.setSize(200,50);
		lb.setLocation(280,70);
		c.add(lb);
		lb2=new JLabel("��ѡ��¥��*");
		lb2.setForeground(new Color(102,34,140));
		Font f1=new Font("����",Font.BOLD,20);
		lb2.setFont(f1);
		lb2.setSize(200,50);
		lb2.setLocation(100,60);
		c.add(lb2);
		bu1=new JButton("ɾ����¼");
		bu1.setSize(100,30);
		bu1.setLocation(260,30);
		bu1.addActionListener(this);
		c.add(bu1);
		
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
		jobsBox.addActionListener(this);
		p.add(jobsBox);
		p.setSize(200,40);
		p.setLocation(50,120);
		c.add(p);
		for(int i=0;i<7;i++)
		{
			lb1[i]=new JLabel(fieldname[i]);
			lb1[i].setSize(80,20);
			lb1[i].setLocation(250,120+i*30);
			c.add(lb1[i]);
			tf1[i]=new TextField(fieldvalue[i]);
			tf1[i].setSize(90,20);
			tf1[i].setLocation(300,120+i*30);
			c.add(tf1[i]);
		}
		lb1[0].setForeground(new Color(200,50,120));
		lb1[0].setFont(new Font("����",Font.BOLD,15));
		tf1[0].addTextListener(new text());
		setSize(500,400);
		setVisible(true);
		connect_db();
	}
	public void connect_db()
	{
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e1)
		{System.out.println("Driver not found!");}
		try{
			con1=DriverManager.getConnection("jdbc:odbc:student");
			st1=con1.createStatement();
		}
		catch(SQLException e2)
		{System.out.println("table not found!");}
	}

	public void actionPerformed(ActionEvent e)
	{

	    String std_fanghao=tf1[0].getText();
		String std_xibie=tf1[1].getText();
		String std_zhuanye=tf1[2].getText();
		String std_grade=tf1[3].getText();
		String std_class=tf1[4].getText();
		String std_name=tf1[5].getText();
		String std_tel=tf1[6].getText();
		pp=jobsBox.getSelectedItem().toString();
		
		
		try
		{
	      if(e.getSource()==bu1)
	      {
		
			str1="DELETE FROM "+pp+" WHERE fanghao='"+std_fanghao+"'";
		
		
			st1.executeUpdate(str1);
			JOptionPane.showMessageDialog(null,"ɾ���ɹ���");
		}
		else
		{
		}
		}
		catch(SQLException e2)
		{JOptionPane.showMessageDialog(null,"ɾ��ʧ�ܣ�");}
		
		
	}
	class text implements TextListener
	{
	
      public void textValueChanged(TextEvent tevent)
        {
        String tf=tf1[0].getText();
	    String	pp=jobsBox.getSelectedItem().toString();
    	String string="select * from "+pp+" where fanghao='"+tf+"'";
        connect_db();
    	try
    	{
    	rs1=st1.executeQuery(string);
        if(rs1.next())
        {
    	String xibie=rs1.getString("xibie");
    	String zhuany=rs1.getString("zhuanye");
    	String grad=rs1.getString("grade");
    	String clas=rs1.getString("class");
    	String name=rs1.getString("name");
    	String dianhua=rs1.getString("dianhua");
    	tf1[1].setText(xibie);
    	tf1[2].setText(zhuany);
    	tf1[3].setText(grad);
    	tf1[4].setText(clas);
    	tf1[5].setText(name);
    	tf1[6].setText(dianhua);
    	}
    	else
    	{
    	tf1[1].setText("");
    	tf1[2].setText("");
    	tf1[3].setText("");
    	tf1[4].setText("");
    	tf1[5].setText("");
    	tf1[6].setText("");    		
    	}
        }
        catch(Exception sqlexception)
        {
        	System.out.println("error");
        	return;
        }
        }
    }
}

		
		
	
	