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
		
		this.setTitle("ͼ�����ϵͳ");
		this.setBounds(600,150,500,150);
		this.setSize(700,600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar jm=new JMenuBar();
		this.setJMenuBar(jm);
		
		JMenu menu1=new JMenu("���߹���");
		JMenu menu2=new JMenu("�鼮����");
		JMenu menu3=new JMenu("����");
		
		JMenuItem item1=new JMenuItem("��Ӷ���");//��ʵ��
		JMenuItem item0=new JMenuItem("ɾ������");//��ʵ��
		JMenuItem item2=new JMenuItem("���������Ϣ");//��ʵ��
		
		JMenuItem item3=new JMenuItem("ָ����Ա���ļ�¼�鿴");//��ʵ��,�洢����
		
		JMenuItem item4=new JMenuItem("�鼮���");//��ʵ��
		//JMenuItem item5=new JMenuItem("ɾ���鼮");
		
		JMenuItem item6=new JMenuItem("������һ��");//��ʵ��
		JMenuItem item7=new JMenuItem("�˳�ϵͳ");//��ʵ��
		
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
		if("��Ӷ���".equals(ss)){//�����
			AddReader ar=new AddReader();
		}
		else if("ɾ������".equals(ss)){
			DeleteUserInfo dui=new DeleteUserInfo();
		}
		else if("���������Ϣ".equals(ss)){//�����
			
			ChangeUserInfo cui=new ChangeUserInfo();
			
		}
		else if("ָ����Ա���ļ�¼�鿴".equals(ss)){//�洢���̣���ʵ��
			
			AllUserBorrowNote abn=new AllUserBorrowNote();
		}
		else if("�鼮���".equals(ss)){//�����
			AddBook ab=new AddBook();
		}
		else if("������һ��".equals(ss)){//�����
			setVisible(false);
		}
		else if("�˳�ϵͳ".equals(ss)){//�����
			System.exit(0);
		}
		
	}
	
	
	
}
