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
   super("����");
   c=getContentPane();
   c.setLayout(null);
   okBtn=new JButton("ȷ��");
   okBtn.setSize(60,20);
   okBtn.setLocation(120,200);
   okBtn.setVisible(true);
   okBtn.addActionListener(this);
   c.add(okBtn);
   lb1=new JLabel("ȫУѧ��ס�޻��������ϵͳ");
   lb1.setSize(200,20);
   lb1.setLocation(60,5);
   c.add(lb1);
   lb2=new JLabel("��ѧ��������ѧϵ");
   lb2.setSize(150,30);
   lb2.setLocation(80,40);
   c.add(lb2);
   lb3=new JLabel("�����Ӧ����ά��");
   lb3.setSize(120,30);
   lb3.setLocation(80,70);
   c.add(lb3);
   lb4=new JLabel("���ţ�  18��");
   lb4.setSize(100,30);
   lb4.setLocation(80,100);
   c.add(lb4);
   lb5=new JLabel("���ߣ�  �Ƴ���");
   lb5.setSize(100,30);
   lb5.setLocation(80,130);
   c.add(lb5);
   setSize(300,250);
   setResizable(false);//����Frame�Ĵ�С���ɱ�
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