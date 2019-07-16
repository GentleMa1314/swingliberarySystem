package JDBCDemo01.as.qq.mj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainViews extends JFrame implements ActionListener{

	String s=null;
	public static void main(String[] args){
		
		MainViews demo=new MainViews();
		demo.init();
		
	}
	public void init(){
		JFrame jf=new JFrame();
		Container con=jf.getContentPane();
		
		jf.setTitle("图书管理系统");
		jf.setBounds(600,150,500,150);
		jf.setSize(700, 600);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		JMenuBar jmb=new JMenuBar();
		jf.setJMenuBar(jmb);
		
		JMenu menu1=new JMenu("图书借阅与归还");
		
		JMenu menu2=new JMenu("管理员登录");
		JMenu menu3=new JMenu("退出");
		
	
		
		JMenuItem item1=new JMenuItem("用户登录");
		JMenuItem item2=new JMenuItem("退出系统");
		JMenuItem item3=new JMenuItem("账户登录");
		JMenuItem item4=new JMenuItem("其他登录");
		
		
		;
		con.add(jmb);
		JLabel j=new JLabel("欢迎来到图书管理系统");
		j.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		con.add(j);
		con.setBackground(Color.gray);
		
		
	
		
		menu1.add(item1);
		
		
		menu2.add(item3);
		menu2.add(item4);
		menu3.add(item2);
		/*menu2.add(item5);
		menu2.add(item6);*/
		
		jmb.add(menu1);
		jmb.add(menu2);
		jmb.add(menu3);
		//jmb.add(menu4);
		//jmb.add(menu5);
		
		//item1.addActionListener(this);
		//item2.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
	//	item5.addActionListener(this);
	//	item6.addActionListener(this);
	
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str=e.getActionCommand();
		if("账户登录".equals(str)){
			
			MangerLogin lv=new MangerLogin();
			lv.inits();
			
			
		}
		else if("其他登录".equals(str)){
			JFrame f1=new JFrame("提示");
			f1.setSize(400, 300);
			JOptionPane.showMessageDialog(f1, "此功能暂未开通!");	
			
		}
		else if("用户登录".equals(str)){
			LoginView lv1=new LoginView();
			lv1.inits();
		
			
			
		
			
		}
		else if("退出系统".equals(str)){
			System.exit(0);
		}
			
		
		
	}

	
}

