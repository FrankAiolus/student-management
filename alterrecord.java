import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class alterrecord extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		alterrecord frame=new alterrecord();
	}
	JLabel lb;
	JLabel lb1[]=new JLabel[8];
	JTextField tf1[]=new JTextField[8];
	String fieldname[]={"房号","系别","专业","年级","班别","姓名","电话"};
	String fieldvalue[]={"103","体社系","体保","03","","郑晓强、张昱、邓炳南、陈荣亮","5243472"};
	JButton bu1;
	JTextArea ta1;
	Connection con1;
	ResultSet rs1;
	Statement st1;
	String str1="";
	String pp="2号楼住宿花名册";
	private JComboBox jobsBox;
	public alterrecord()
	{
		super("全校学生住宿花名册修改");
		
		Container c=getContentPane();
		JPanel p=new JPanel();
		c.setLayout(null);
		lb=new JLabel("修改数据操作");
		lb.setSize(200,20);
		lb.setLocation(10,20);
		c.add(lb);
		bu1=new JButton("修改记录");
		bu1.setSize(100,20);
		bu1.setLocation(260,20);
		bu1.addActionListener(this);
		c.add(bu1);
		jobsBox=new JComboBox();
		
		jobsBox.addItem("2号楼住宿花名册");
		jobsBox.addItem("3号楼住宿花名册");
		jobsBox.addItem("5号楼住宿花名册");
		jobsBox.addItem("7号楼住宿花名册");
		jobsBox.addItem("8号楼住宿花名册");
		jobsBox.addItem("13号楼住宿花名册");
		jobsBox.addItem("14号楼住宿花名册");
		jobsBox.addItem("明煌楼学生住宿花名册");
		jobsBox.addItem("学生公寓楼住宿花名册");
		jobsBox.addActionListener(this);
		p.add(jobsBox);
		p.setSize(200,40);
		p.setLocation(10,50);
		c.add(p);
		for(int i=0;i<7;i++)
		{
			lb1[i]=new JLabel(fieldname[i]);
			lb1[i].setSize(80,20);
			lb1[i].setLocation(10,120+i*30);
			c.add(lb1[i]);
			tf1[i]=new JTextField(fieldvalue[i]);
			tf1[i].setSize(90,20);
			tf1[i].setLocation(50,120+i*30);
			c.add(tf1[i]);
		}
	
		
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
			st1=con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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

	str1="update "+pp+" set xibie='"+std_xibie+"',zhuanye='"+std_zhuanye+"',grade='"+std_grade+"',class='"+std_class+"',name='"+std_name+"',dianhua='"+std_tel+"' where fanghao='"+std_fanghao+"'";		
 
			st1.executeUpdate(str1);
			
			JOptionPane.showMessageDialog(null,"修改成功！！");
		}
		
		else
		{
			
		}
		}
		catch(SQLException e2)
		{
		JOptionPane.showMessageDialog(null,"修改失败!");
		}
		
	}
	
}
		
		
	
	