package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AllUserBorrowNote extends JFrame implements ActionListener{

	JTable js=null;
	
	Vector rowData,columnNames;
	JTextField jt=new JTextField();
	public AllUserBorrowNote(){
		JFrame jf=new JFrame("图书管理系统");
		
		jf.setBounds(300,300,300,300);
		jf.setLayout(new FlowLayout());
		
		
		
		
		jt.setColumns(10);
		JButton ok=new JButton("开始");
		jf.add(jt);
		jf.add(ok);
		jf.setVisible(true);
		ok.addActionListener(this);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String msg=jt.getText();
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		String sql1="{call bnt(?)}";
		JScrollPane jsp=null;
		
		try {
		
			CallableStatement ctmt=conn.prepareCall(sql1);
			ctmt.setString(1, msg);
			ResultSet rs=ctmt.executeQuery();
			columnNames=new Vector();
			columnNames.add("学生编号");
			columnNames.add("借书日期");
			columnNames.add("还书日期");
			columnNames.add("图书续借");
			columnNames.add("超期处理");
			columnNames.add("图书编号");
			rowData=new Vector();
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				rowData.add(hang);
			}
		}
		 catch (SQLException e1) {
			e1.printStackTrace();
		}
		js=new JTable(rowData,columnNames);
		
		jsp=new JScrollPane(js);
		this.add(jsp);
		this.setSize(400,300);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		
	}
}
