package JDBCDemo01.as.qq.mj;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserView extends JFrame implements ActionListener{
	
	/*public static void main(String[] args){
		UserView k=new UserView();
		k.init();
	}*/
	
	private String s;
	public void init(String s){
		this.s=s;
		this.setTitle("图书管理系统");
		this.setBounds(600,150,500,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		
		JMenu menu1=new JMenu("书籍借阅");
		
		JMenu menu2=new JMenu("查看信息");
		JMenu menu3=new JMenu("图书归还");
		
		JMenu menu4=new JMenu("返回");
		
		
		JMenuItem item1=new JMenuItem("书名借阅");//已实现
		JMenuItem item2=new JMenuItem("图书续借");//算实现
		JMenuItem item3=new JMenuItem("返回上一层");//已实现
		//JMenuItem item4=new JMenuItem("超时处理");
		
		JMenuItem item5=new JMenuItem("身份信息查看");//已实现
		JMenuItem item6=new JMenuItem("管存书籍查看");//已实现
		JMenuItem item7=new JMenuItem("借阅记录查看");//已实现
		
		JMenuItem item8=new JMenuItem("编号归还");//已实现，
		JMenuItem item9=new JMenuItem("扫码归还");//算实现
		
		menu1.add(item1);
		menu1.add(item2);
		//menu1.add(item4);
		
		menu2.add(item5);
		menu2.add(item6);
		menu2.add(item7);
		
		menu3.add(item8);
		menu3.add(item9);
		
		menu4.add(item3);
		
		jmb.add(menu1);
		jmb.add(menu2);
		jmb.add(menu3);
		jmb.add(menu4);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
		item9.addActionListener(this);
		
		this.setSize(700, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String st1r=e.getActionCommand();
		
		if("书名借阅".equals(st1r)){
			BookLookingfor blf=new BookLookingfor(s);
		}
	
		if("返回上一层".equals(st1r)){
			this.setVisible(false);
		}
		else if("图书续借".equals(st1r)){
			BookSeriesBorrow bsb=new BookSeriesBorrow(s);
		}
		else if("管存书籍查看".equals(st1r)){
			
			AllBookInfo ss=new AllBookInfo();
			
			
		}
		else if("身份信息查看".equals(st1r)){
			
			UserInfo ui=new UserInfo(this.s);
			
			
		}
		else if("编号归还".equals(st1r)){
			
			IdGive ig=new IdGive(s);
			
			
		}
		else if("借阅记录查看".equals(st1r)){
			PersonallyBorrowNote pbn=new PersonallyBorrowNote(s);
		}
		else if("扫码归还".equals(st1r)){
			JOptionPane.showMessageDialog(null, "行了，还没那么高大上!!!");
		}
	}
		
	
}
