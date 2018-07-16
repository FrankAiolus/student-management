import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class xinxiliulan extends JFrame implements ActionListener
{
	
	public static void main(String[] args)
	{
		xinxiliulan frame=new xinxiliulan();
		
		
	}
	JButton bu1;
	JTextArea ta1;
	String pp="2号楼住宿花名册";
	public xinxiliulan()
	{
		setTitle("全校学生住宿花名册浏览");

		setSize(400,550);
		Container c=getContentPane();
		JPanel textPanel=new JPanel();
		JPanel p=new JPanel();
		ta1=new JTextArea("",25,35);
		JScrollPane scrollPane=new JScrollPane(ta1);
		bu1=new JButton("读取ODBC数据库");
		
	bu1.addActionListener(this);
		c.add(bu1);
		
		
		
		
		textPanel.add(scrollPane);
		
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
		
		c.add(p,BorderLayout.WEST);
		
		
		c.add(textPanel,BorderLayout.AFTER_LAST_LINE);
	
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bu1)
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
			ResultSet rs1=st1.executeQuery("select * from "+pp+"");
			while(rs1.next())
			{
				str1=str1+rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+
				rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7)+"\n";
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
	else
	{
                StringBuffer tempSeletedText=new StringBuffer("");
             	Object selectedJob=jobsBox.getSelectedItem();
             	String tt=(String)selectedJob;
             	tempSeletedText.append(tt);
             	pp=tempSeletedText.toString();
             	
            }
	
	}
	
	private JComboBox jobsBox;
	private String tt;
    
}				