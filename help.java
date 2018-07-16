import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
public class help extends JFrame implements ActionListener
{
	
	
	JButton bu1;
	JTextArea ta1;
	public help()
	{
		setTitle("全校学生住宿花名册浏览");

		
		Container c=getContentPane();
		c.setLayout(null);
		JPanel textPanel=new JPanel();
		ta1=new JTextArea("",30,40);
		JScrollPane scrollPane=new JScrollPane(ta1);
		
	
		
		
		
		
		textPanel.add(scrollPane);
		
		textPanel.setSize(400,450);
		textPanel.setLocation(0,0);
		c.add(textPanel);
		bu1=new JButton("ok");
		bu1.setSize(80,30);
		bu1.setLocation(170,470);
		bu1.addActionListener(this);
		c.add(bu1);
	    setSize(400,550);
		setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		help frame=new help();
		
		
	}
public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
		
    
}				