package JDBCDemo01.as.qq.mj;

import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllBookInfo extends JFrame{
	

	ResultSet rs=null;
	
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	
	public AllBookInfo(){
		
		columnNames=new Vector();
		columnNames.add("书名");
		columnNames.add("编号");
		columnNames.add("作者");
		columnNames.add("出版社");
		columnNames.add("出版日期");
		columnNames.add("类别");
		columnNames.add("在册数");
		columnNames.add("总数");
		
		rowData=new Vector();
		try {
			JDBCtch jdbc=new JDBCtch();
			Connection conn=jdbc.conn;
			Statement stmt=jdbc.stmt;
			rs=stmt.executeQuery("select * from BookInfo");
			while(rs.next()!=false){
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				
				rowData.add(hang);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
					
				}
				
				
			}catch(SQLException e){
				
				e.printStackTrace();
			}
		}
	
		jt=new JTable(rowData,columnNames);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.setSize(400,300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	
	
	
	

	}
}
