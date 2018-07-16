import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class threehaoliulan extends JFrame implements ActionListener
{
	public static void main(String[] args)
	{
		threehaoliulan frame=new threehaoliulan();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.show();
	}
	JButton bu1;
	JTextArea ta1;
	public threehaoliulan()
	{
		super("3号楼住宿花名册");
		setSize(550,550);
		Container c=getContentPane();
		JPanel textPanel=new JPanel();
		JPanel p=new JPanel();
		ta1=new JTextArea("",25,35);
		//ta1.setSize(500,400);
		JScrollPane scrollPane=new JScrollPane(ta1);
		//c.setLayout(null);
		bu1=new JButton("读取ODBC数据库");
		bu1.setSize(100,20);
		//bu1.setLocation(450,20);
		bu1.addActionListener(this);
		c.add(bu1);
		
		
		//ta1.setSize(450,380);
		//ta1.setLocation(20,50);
		//c.add(ta1);
		
		textPanel.add(scrollPane);
		//textPanel.setLocation(10,30);
		JComboBox jobsBox=new JComboBox();
		p.add(jobsBox);
		jobsBox.addItem("afsdfsdf");
		jobsBox.addItem("bfsdfsdfsd");
		c.add(p,BorderLayout.WEST);
		
		c.add(textPanel,BorderLayout.AFTER_LAST_LINE);
		//JScrollPane scrollPane=new JScrollPane(ta1);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String str1="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println("Driver not found!");
		}
			try{
			Connection con1=DriverManager.getConnection("jdbc:odbc:student");
			Statement st1=con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1=st1.executeQuery("select * from 2号楼住宿花名册");
			while(rs1.next())
			{
				str1=str1+rs1.getString(1)+"    "+rs1.getString(2)+"    "+rs1.getString(3)+"    "+
				rs1.getString(5)+"    "+rs1.getString(6)+"    "+rs1.getString(7)+"\n";
			}
			st1.close();
			con1.close();
			ta1.setText(str1);
			JOptionPane.showMessageDialog(null,"数据库加载成功！");
		}
		catch(SQLException e2)
		{
			System.out.println("table not found!");
		}
	}
}				