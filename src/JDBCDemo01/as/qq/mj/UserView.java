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
		this.setTitle("ͼ�����ϵͳ");
		this.setBounds(600,150,500,150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		
		JMenu menu1=new JMenu("�鼮����");
		
		JMenu menu2=new JMenu("�鿴��Ϣ");
		JMenu menu3=new JMenu("ͼ��黹");
		
		JMenu menu4=new JMenu("����");
		
		
		JMenuItem item1=new JMenuItem("��������");//��ʵ��
		JMenuItem item2=new JMenuItem("ͼ������");//��ʵ��
		JMenuItem item3=new JMenuItem("������һ��");//��ʵ��
		//JMenuItem item4=new JMenuItem("��ʱ����");
		
		JMenuItem item5=new JMenuItem("�����Ϣ�鿴");//��ʵ��
		JMenuItem item6=new JMenuItem("�ܴ��鼮�鿴");//��ʵ��
		JMenuItem item7=new JMenuItem("���ļ�¼�鿴");//��ʵ��
		
		JMenuItem item8=new JMenuItem("��Ź黹");//��ʵ�֣�
		JMenuItem item9=new JMenuItem("ɨ��黹");//��ʵ��
		
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
		
		if("��������".equals(st1r)){
			BookLookingfor blf=new BookLookingfor(s);
		}
	
		if("������һ��".equals(st1r)){
			this.setVisible(false);
		}
		else if("ͼ������".equals(st1r)){
			BookSeriesBorrow bsb=new BookSeriesBorrow(s);
		}
		else if("�ܴ��鼮�鿴".equals(st1r)){
			
			AllBookInfo ss=new AllBookInfo();
			
			
		}
		else if("�����Ϣ�鿴".equals(st1r)){
			
			UserInfo ui=new UserInfo(this.s);
			
			
		}
		else if("��Ź黹".equals(st1r)){
			
			IdGive ig=new IdGive(s);
			
			
		}
		else if("���ļ�¼�鿴".equals(st1r)){
			PersonallyBorrowNote pbn=new PersonallyBorrowNote(s);
		}
		else if("ɨ��黹".equals(st1r)){
			JOptionPane.showMessageDialog(null, "���ˣ���û��ô�ߴ���!!!");
		}
	}
		
	
}
