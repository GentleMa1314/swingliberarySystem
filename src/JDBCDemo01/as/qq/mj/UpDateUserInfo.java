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

public class UpDateUserInfo extends JFrame implements ActionListener{

	
	
	JFrame jf = new JFrame("更改读者信息");
	Label id,pw,nm,gen,ph;
	JTextField text1,text2,text3,text4,text5;
	String s;
	
	public UpDateUserInfo(String s){

		jf.setSize(300, 400);
	    //设置居中
	    jf.setLocationRelativeTo(null);
	    //设置布局
	    jf.setLayout(new FlowLayout());
	    //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    id = new Label("账户名");
        jf.add(id);
        
        text1 = new JTextField(s,20);
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
        JButton jt=new JButton("修改");
        jf.add(jt);
        jf.setVisible(true);
        text1.setEditable(false);
        jt.addActionListener(this);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String ps=new String(text1.getText());
		String pm=text2.getText();
		String pn=new String(text3.getText());
		String pk=new String(text4.getText());
		String pl=new String(text5.getText());
		String g="update UserInfomation set id=\'"+ps+"\',password=\'"+pm+"\'"
				+ ",username=\'"+pn+"\',gender=\'"+pk+"\',phone=\'"+pl+"\' where id=\'"+ps+"\'";
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		System.out.println(pm+"test");
		
		if(pm.equals("")||pn.equals("")||pk.equals("")||pl.equals("")){
			
			JOptionPane.showMessageDialog(null, "您输入的有误!");
			
		}

		else{
			try {
				ResultSet rs=stmt.executeQuery(g);
			} catch (SQLException e1) {
				
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "更改成功!");
				
			}
		}
	
	}

}
