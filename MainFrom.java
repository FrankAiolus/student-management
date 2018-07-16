//���������
import java.awt.*;
import  java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;



public class MainFrom
{
	public static void main(String[] args)
	{
		MainFrame frame=new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
		frame.setLocation(200,150);
	}
}
class MainFrame extends JFrame
{
private	JMenuItem aboutItem;
private	JMenuBar menuBar;
private	JMenu liulanMenu;
private	JMenu FindMenu;
private	JMenu UpdateMenu;
private	JMenuItem addItem;
private	JMenuItem deleteItem;
private	JMenuItem alterItem;
private	JMenu helpMenu;
private	JMenuItem helpItem;
private	JMenuItem exitItem;
private	JMenuItem liulanItem;
private	JMenuItem FindItem;
	public MainFrame()
	{
		//������������������
		setTitle("ȫУѧ��ס�޻�����");
		setSize(500,500);
		
		Container c=getContentPane();
	

		//�����˵����������˵������뵽�����
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
	
		
		//�����˵����˵������ӿ�ݼ��ͼ�����
		//"��Ϣ���"�˵�
		liulanMenu=new JMenu("��Ϣ���(L)");
		liulanMenu.setMnemonic('L');
		menuBar.add(liulanMenu);
		liulanItem=liulanMenu.add(new JMenuItem("��Ϣ���(L)",'L'));
		//"��Ϣ��ѯ"�˵�
		FindMenu=new JMenu("��Ϣ��ѯ(F)");
		FindMenu.setMnemonic('F');
		menuBar.add(FindMenu);
		FindItem=FindMenu.add(new JMenuItem("��Ϣ��ѯ(F)",'F'));
		//"��Ϣ����"�˵�
		UpdateMenu=new JMenu("��Ϣ����(U)");
		UpdateMenu.setMnemonic('U');
		menuBar.add(UpdateMenu);
		//�����Ӳ˵�
	    addItem=UpdateMenu.add(new JMenuItem("��Ӽ�¼(A)",'A'));
	    deleteItem=UpdateMenu.add(new JMenuItem("ɾ����¼(D)",'D'));
	    alterItem=UpdateMenu.add(new JMenuItem("�޸ļ�¼(R)",'R'));
	    //"����"�˵�
		helpMenu=new JMenu("����(H)");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		//�����Ӳ˵�
	    helpItem=helpMenu.add(new JMenuItem("����(H)",'H'));
	    
	    aboutItem=helpMenu.add(new JMenuItem("����(A)",'A'));

	    helpMenu.addSeparator();
	    exitItem=helpMenu.add(new JMenuItem("�˳�(E)",'E'));
	    //���һͼ������������
	    ImagePanel panel=new ImagePanel();
	    c.add(panel);
        //���ò˵�����
        aboutItem.addActionListener(new AboutListener());
       exitItem.addActionListener(new AboutListener());
        helpItem.addActionListener(new AboutListener());
       addItem.addActionListener(new AboutListener());
        deleteItem.addActionListener(new AboutListener());
        alterItem.addActionListener(new AboutListener());
        
        liulanItem.addActionListener(new AboutListener());
        FindItem.addActionListener(new AboutListener());
    }
//=========================������������========================	    
      class AboutListener implements ActionListener
      {
      	
      	
          public void actionPerformed(ActionEvent e)
             {
             	if(e.getSource()==aboutItem)
             	{
             	
                aboutform ab=new aboutform();
                ab.setLocation(200,150);
            }
            if(e.getSource()==exitItem)
            {
            	System.exit(1);
            	
            }
            if(e.getSource()==addItem)
            {
            	addrecord ad=new addrecord();
            	ad.setLocation(200,150);
            }
                
                if(e.getSource()==deleteItem)
            {
            	deleterecord ad=new deleterecord();
            	ad.setLocation(200,150);
            }
               if(e.getSource()==alterItem)
            {
            	alterrecord ad=new alterrecord();
            	ad.setLocation(200,150);
            }
               if(e.getSource()==helpItem)
            {
            	help ad=new help();
            	ad.setLocation(200,150);
            	
            }
               if(e.getSource()==liulanItem)
            {
            	xinxiliulan ad=new xinxiliulan();
            	ad.setLocation(200,150);
            }
               if(e.getSource()==FindItem)
            {
            	xinxifind ad=new xinxifind();
            	ad.setLocation(200,150);
            }
            
                
            }
        }

//================================================================================		
}		
	
	
	

//����һͼ����
class ImagePanel extends JPanel
{
	public ImagePanel()
	{
		//�õ�ͼ��
		image=Toolkit.getDefaultToolkit().getImage("fengmian.jpg");
		MediaTracker tracker=new MediaTracker(this);
		tracker.addImage(image,1);
		try
		{
			tracker.waitForID(1);
		}
		catch(InterruptedException exception)
		{}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}
	private Image image;
}
	