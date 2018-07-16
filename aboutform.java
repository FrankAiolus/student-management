import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class aboutform extends JFrame implements ActionListener
 {
  private Container c;
  private JButton okBtn;
  private JLabel lb1;
  private JLabel lb2;
  private JLabel lb3;
  private JLabel lb4;
  private JLabel lb5;
  public aboutform()
  {
   super("关于");
   c=getContentPane();
   c.setLayout(null);
   okBtn=new JButton("确定");
   okBtn.setSize(60,20);
   okBtn.setLocation(120,200);
   okBtn.setVisible(true);
   okBtn.addActionListener(this);
   c.add(okBtn);
   lb1=new JLabel("全校学生住宿花名册管理系统");
   lb1.setSize(200,20);
   lb1.setLocation(60,5);
   c.add(lb1);
   lb2=new JLabel("数学与计算机科学系");
   lb2.setSize(150,30);
   lb2.setLocation(80,40);
   c.add(lb2);
   lb3=new JLabel("计算机应用与维护");
   lb3.setSize(120,30);
   lb3.setLocation(80,70);
   c.add(lb3);
   lb4=new JLabel("座号：  18号");
   lb4.setSize(100,30);
   lb4.setLocation(80,100);
   c.add(lb4);
   lb5=new JLabel("作者：  黄朝明");
   lb5.setSize(100,30);
   lb5.setLocation(80,130);
   c.add(lb5);
   setSize(300,250);
   setResizable(false);//设置Frame的大小不可变
   show();
  }
  public static void main(String args[])
  {
   aboutform ab=new aboutform();
  
  }
 public void actionPerformed(ActionEvent e)
 {
  dispose();
 }
 }