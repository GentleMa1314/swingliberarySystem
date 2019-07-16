package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddReader extends JFrame implements ActionListener{
	
	JFrame jf = new JFrame("添加读者");
	Label id,pw,nm,gen,ph;
	JTextField text1,text2,text3,text4,text5;
	
	public AddReader(){
		
		jf.setSize(300, 400);
	    //设置居中
	    jf.setLocationRelativeTo(null);
	    //设置布局
	    jf.setLayout(new FlowLayout());
	   // jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    id = new Label("账户名");
        jf.add(id);
        
        text1 = new JTextField(20);
        jf.add(text1);
        pw = new Label("密码");
        text2 = new JTextField(20);
        nm = new Label("姓名");
        text3 = new JTextField(20);
        gen= new Label("性别");
        text4 = new JTextField(20);
        ph = new Label("联系电话");
        text5 = new JTextField(20);
        jf.add(pw);
        jf.add(text2);
        jf.add(nm);
        jf.add(text3);
        
        jf.add(gen);
        jf.add(text4);
        jf.add(ph);
        jf.add(text5);
        JButton jt=new JButton("添加");
        jf.add(jt);
        jf.setVisible(true);
        jt.addActionListener(this);  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ps=new String(text1.getText());
		String pm=new String(text2.getText());
		String pn=new String(text3.getText());
		String pk=new String(text4.getText());
		String pl=new String(text5.getText());
		String s="select * from UserInfomation where id=\'"+ps+"\'";
		String sql="insert into UserInfomation( id,password,Username,gender,phone) values(\'"+ps+
				"\',\'"+pm+"\',\'"+pn+"\',\'"+pk+"\',\'"+pl+"\')";
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		try {
			if(ps.equals("")||pm.equals("")||pn.equals("")||pk.equals("")||pl.equals("")){
				JOptionPane.showMessageDialog(null, "您输入的有误!");
				text1.setText(null);
			}else{
				ResultSet rs=stmt.executeQuery(s);
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "此编号已存在!");
					text1.setText(null);
				}else{
					ResultSet rs2=stmt.executeQuery(sql);
				}
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "添加成功!");
			this.setVisible(false);
		}
		
	}

	
		
}
