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

public class AddBook extends JFrame implements ActionListener{

	JFrame jf=new JFrame("图书管理系统");
	JLabel je=new JLabel("ID");
	JTextField jt=new JTextField();
	JButton jb=new JButton("确认");
	public AddBook(){
		
		jf.add(je);
		jf.add(jt);
		jf.add(jb);
		jf.setSize(200, 300);
		jf.setLayout(new FlowLayout());
		jt.setColumns(10);
		jf.setVisible(true);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jb.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s1=new String(jt.getText());
		
		String r="select * from BookInfo where indexs=\'"+s1+"\'";
		//String r1="update BookInfo set amount=amount+1,allInfo=allInfo+1 where indexs=\'"+s1+"\'";
		
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		try {
			ResultSet rs=stmt.executeQuery(r);
			
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "此编号书已存在并且已经足够!");
				jt.setText(null);
			}else{
				jf.setVisible(false);
				AddBookSecond abs=new AddBookSecond(s1);
			}
		} catch (SQLException e1) {
			
			JOptionPane.showMessageDialog(null, "操作有误!");
		}
		
	}

}
