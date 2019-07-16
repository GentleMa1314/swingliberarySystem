package JDBCDemo01.as.qq.mj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PersonallyBorrowNote extends JFrame {
	
	JFrame jf=new JFrame("图书管理系统");
	
	
	JTable js=null;
	
	Vector rowData,columnNames;
	String s;	
	
	public PersonallyBorrowNote(String s){
		
		
		this.s=s;
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		
		ResultSet rs=null;
		
		
		
		JScrollPane jsp=null;

		columnNames=new Vector();
		
		columnNames.add("学生编号");
		columnNames.add("借书日期");
		columnNames.add("还书日期");
		columnNames.add("是否续借");
		columnNames.add("超期处理");
		columnNames.add("图书编号");
		rowData=new Vector();
		String m="select * from BorrowNote where id=\'"+s+"\'";
		try {
			rs=stmt.executeQuery(m);
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
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		js=new JTable(rowData,columnNames);
		jsp=new JScrollPane(js);
		this.add(jsp);
		this.setSize(400,300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	

}
