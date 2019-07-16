package JDBCDemo01.as.qq.mj;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import JDBCDemo01.as.qq.mj.LoginView.jt1Listener;

public class MangerLogin extends JFrame{
	

	JPanel jp1,jp2,jp3;
	JLabel jb1,jb2;
	JButton jt1,jt2;
	JTextField jtf1;
	JPasswordField jpf1;
	jt1Listener jts=new jt1Listener();
	public MangerLogin(){
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		}
	public void inits(){
		jb1=new JLabel("用户名");
		jb2=new JLabel("密码");
		jt1=new JButton("登录");
		jt2=new JButton("取消");
		jt1.addActionListener(jts);
		
		jtf1=new JTextField(10);
		jpf1=new JPasswordField(10);
		this.setLayout(new GridLayout(3,1));
		this.setLocationRelativeTo(null);
		
		this.setBounds(300, 300, 300, 300);
		jp1.add(jb1);
		jp1.add(jtf1);
		
		jp2.add(jb2);
		jp2.add(jpf1);
		
		jp3.add(jt1);
		jp3.add(jt2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,250);
		this.setTitle("管理员登录");
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	class jt1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * 要写登录上去后要显示的
			 */
			jt1Choice(e);
		
		}
	
}
	void jt1Choice (ActionEvent e){
		String ps=new String(jtf1.getText());
		String pw=new String(jpf1.getPassword());
		
		String sql="select *from MangerInfo";
		boolean isMatch=false;
		
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		try {
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String name=rs.getString("id");
				if(name.equals(ps)){
					String p=rs.getString("password");
					if(p.equals(pw)){
						isMatch=true;
						
						break;
					}
					
				}
			}
			
			if(isMatch){
				JOptionPane.showMessageDialog(null, "管理员登录成功！");
				this.setVisible(false);
				MangerView m=new MangerView();
				m.initd();
				
			}else{
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				jtf1.setText(null);
				jpf1.setText(null);
			}
		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
}
	

	}
