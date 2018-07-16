//主窗体界面
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
		//设置主窗体名及属性
		setTitle("全校学生住宿花明册");
		setSize(500,500);
		
		Container c=getContentPane();
	

		//创建菜单栏，并将菜单栏加入到框架中
		menuBar=new JMenuBar();
		setJMenuBar(menuBar);
	
		
		//创建菜单及菜单项，并添加快捷键和加速器
		//"信息浏览"菜单
		liulanMenu=new JMenu("信息浏览(L)");
		liulanMenu.setMnemonic('L');
		menuBar.add(liulanMenu);
		liulanItem=liulanMenu.add(new JMenuItem("信息浏览(L)",'L'));
		//"信息查询"菜单
		FindMenu=new JMenu("信息查询(F)");
		FindMenu.setMnemonic('F');
		menuBar.add(FindMenu);
		FindItem=FindMenu.add(new JMenuItem("信息查询(F)",'F'));
		//"信息更新"菜单
		UpdateMenu=new JMenu("信息更新(U)");
		UpdateMenu.setMnemonic('U');
		menuBar.add(UpdateMenu);
		//创建子菜单
	    addItem=UpdateMenu.add(new JMenuItem("添加记录(A)",'A'));
	    deleteItem=UpdateMenu.add(new JMenuItem("删除记录(D)",'D'));
	    alterItem=UpdateMenu.add(new JMenuItem("修改记录(R)",'R'));
	    //"帮助"菜单
		helpMenu=new JMenu("帮助(H)");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		//创建子菜单
	    helpItem=helpMenu.add(new JMenuItem("帮助(H)",'H'));
	    
	    aboutItem=helpMenu.add(new JMenuItem("关于(A)",'A'));

	    helpMenu.addSeparator();
	    exitItem=helpMenu.add(new JMenuItem("退出(E)",'E'));
	    //添加一图象于主界面中
	    ImagePanel panel=new ImagePanel();
	    c.add(panel);
        //设置菜单监听
        aboutItem.addActionListener(new AboutListener());
       exitItem.addActionListener(new AboutListener());
        helpItem.addActionListener(new AboutListener());
       addItem.addActionListener(new AboutListener());
        deleteItem.addActionListener(new AboutListener());
        alterItem.addActionListener(new AboutListener());
        
        liulanItem.addActionListener(new AboutListener());
        FindItem.addActionListener(new AboutListener());
    }
//=========================调用其他窗体========================	    
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
	
	
	

//创建一图象类
class ImagePanel extends JPanel
{
	public ImagePanel()
	{
		//得到图象
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
	