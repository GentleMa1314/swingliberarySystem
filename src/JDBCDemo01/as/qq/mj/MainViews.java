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
		
		jf.setTitle("ͼ�����ϵͳ");
		jf.setBounds(600,150,500,150);
		jf.setSize(700, 600);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		
		JMenuBar jmb=new JMenuBar();
		jf.setJMenuBar(jmb);
		
		JMenu menu1=new JMenu("ͼ�������黹");
		
		JMenu menu2=new JMenu("����Ա��¼");
		JMenu menu3=new JMenu("�˳�");
		
	
		
		JMenuItem item1=new JMenuItem("�û���¼");
		JMenuItem item2=new JMenuItem("�˳�ϵͳ");
		JMenuItem item3=new JMenuItem("�˻���¼");
		JMenuItem item4=new JMenuItem("������¼");
		
		
		;
		con.add(jmb);
		JLabel j=new JLabel("��ӭ����ͼ�����ϵͳ");
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
		if("�˻���¼".equals(str)){
			
			MangerLogin lv=new MangerLogin();
			lv.inits();
			
			
		}
		else if("������¼".equals(str)){
			JFrame f1=new JFrame("��ʾ");
			f1.setSize(400, 300);
			JOptionPane.showMessageDialog(f1, "�˹�����δ��ͨ!");	
			
		}
		else if("�û���¼".equals(str)){
			LoginView lv1=new LoginView();
			lv1.inits();
		
			
			
		
			
		}
		else if("�˳�ϵͳ".equals(str)){
			System.exit(0);
		}
			
		
		
	}

	
}

