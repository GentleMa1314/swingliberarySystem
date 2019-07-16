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

public class AddBookSecond extends JFrame implements ActionListener{

	JFrame jf = new JFrame("添加书籍");
	Label name,indexs,writer,pub,pubtime,types,amount,allInfo;
	JTextField text1,text2,text3,text4,text5,text6,text7,text8;
	String s;
public AddBookSecond(String s){
	
		this.s=s;
		
		jf.setSize(600, 650);
	    //设置居中
	    jf.setLocationRelativeTo(null);
	    //设置布局
	    jf.setLayout(new FlowLayout());
	 //   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    name = new Label("书名");
        jf.add(name);
        
        text1 = new JTextField(20);
        jf.add(text1);
        
        
        indexs = new Label("编号");
        text2 = new JTextField(s,20);
        writer = new Label("作者");
        text3 = new JTextField(20);
        pub = new Label("出版社");
        text4 = new JTextField(20);
        pubtime = new Label("出版日期");
        text5 = new JTextField(20);
        types = new Label("类型");
        text6 = new JTextField(20);
        amount = new Label("在册数");
        text7 = new JTextField(20);
        allInfo = new Label("总数");
        text8 = new JTextField(20);
        jf.add(indexs);
        jf.add(text2);
        
        text2.setEditable(false);
        jf.add(writer);
        jf.add(text3);
        
        jf.add(pub);
        jf.add(text4);
        jf.add(pubtime);
        jf.add(text5);
        jf.add(types);
        jf.add(text6);
        jf.add(amount);
        jf.add(text7);
        jf.add(allInfo);
        jf.add(text8);
        JButton jt=new JButton("添加");
        jf.add(jt);
        jf.setVisible(true);
        jt.addActionListener(this);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String r1=text1.getText();
		String r2=text2.getText();
		String r3=text3.getText();
		String r4=text4.getText();
		String r5=text5.getText();
		String r6=text6.getText();
		String r7=text7.getText();
		String r8=text8.getText();
		
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		String s1="insert into BookInfo(name,indexs,writer,pub,pubtime,class,amount,allInfo) values(\'"+r1+"\',\'"+r2+"\',\'"+r3+"\',\'"+r4+"\',\'"+r5+"\',\'"+r6+"\',\'"+r7+"\',\'"+r8+"\')";
		try {
			
			if(r1.equals("")||r2.equals("")||r3.equals("")||r4.equals("")||r5.equals("")||r6.equals("")||r7.equals("")||r8.equals("")){
				JOptionPane.showMessageDialog(null, "不能有空值!");
			}else{
				ResultSet rs=stmt.executeQuery(s1);
			}
			
			
			
		} catch (SQLException e1) {
			jf.setVisible(false);
			JOptionPane.showMessageDialog(null, "添加成功!");
		}
		
		}
		
	}


