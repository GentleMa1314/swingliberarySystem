package JDBCDemo01.as.qq.mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MangerView extends JFrame implements ActionListener{
	String s;
	public void initd(){
		
		this.setTitle("图书管理系统");
		this.setBounds(600,150,500,150);
		this.setSize(700,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar jm=new JMenuBar();
		this.setJMenuBar(jm);
		
		JMenu menu1=new JMenu("读者管理");
		JMenu menu2=new JMenu("书籍管理");
		JMenu menu3=new JMenu("返回");
		
		JMenuItem item1=new JMenuItem("添加读者");//已实现
		JMenuItem item0=new JMenuItem("删除读者");//已实现
		JMenuItem item2=new JMenuItem("变更读者信息");//已实现
		
		JMenuItem item3=new JMenuItem("指定人员借阅记录查看");//已实现,存储过程
		
		JMenuItem item4=new JMenuItem("书籍添加");//已实现
		//JMenuItem item5=new JMenuItem("删除书籍");
		
		JMenuItem item6=new JMenuItem("返回上一层");//已实现
		JMenuItem item7=new JMenuItem("退出系统");//已实现
		
		menu1.add(item1);
		menu1.add(item0);
		menu1.add(item2);
		
		menu1.add(item3);
		
		menu2.add(item4);
		//menu2.add(item5);
		
		menu3.add(item6);
		menu3.add(item7);
		
		jm.add(menu1);
		jm.add(menu2);
		jm.add(menu3);
		
		item1.addActionListener(this);
		item0.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		//item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ss=e.getActionCommand();
		if("添加读者".equals(ss)){//已完成
			AddReader ar=new AddReader();
		}
		else if("删除读者".equals(ss)){
			DeleteUserInfo dui=new DeleteUserInfo();
		}
		else if("变更读者信息".equals(ss)){//已完成
			
			ChangeUserInfo cui=new ChangeUserInfo();
			
		}
		else if("指定人员借阅记录查看".equals(ss)){//存储过程，已实现
			
			AllUserBorrowNote abn=new AllUserBorrowNote();
		}
		else if("书籍添加".equals(ss)){//已完成
			AddBook ab=new AddBook();
		}
		else if("返回上一层".equals(ss)){//已完成
			setVisible(false);
		}
		else if("退出系统".equals(ss)){//已完成
			System.exit(0);
		}
		
	}
	
	
	
}
