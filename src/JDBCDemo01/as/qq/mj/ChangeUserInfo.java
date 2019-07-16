package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
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
import javax.swing.JTextField;

public class ChangeUserInfo extends JFrame implements ActionListener{
	
	JFrame jf=new JFrame();
	JLabel ja1=new JLabel("请输入读者ID");
	JTextField jt1=new JTextField();
	JButton jb1=new JButton("确认");
	ResultSet rs1=null;
	String s=null;
	
	public ChangeUserInfo(){
		jf.add(ja1);
		jf.add(jt1);
		jf.add(jb1);
		jt1.setColumns(10);
		jf.setBounds(200,300,300,200);
		
		jf.setSize(200, 250);
		jf.setVisible(true);
		jf.setLayout(new FlowLayout());
		jb1.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		s=new String(jt1.getText());
		String str1="select *from UserInfomation where id=\'"+s+"\'";
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		try {
			rs1=stmt.executeQuery(str1);
			if(rs1.next()){
				//AddReader ar=new AddReader(s);//如果存在，添加读者？
				UpDateUserInfo uu=new UpDateUserInfo(s);
				
			}else{
				JOptionPane.showMessageDialog(null, "此编号读者不存在!");
				jt1.setText(null);
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
	}
	

}
