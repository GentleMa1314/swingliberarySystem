package JDBCDemo01.as.qq.mj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserInfo extends JFrame{
	

	ResultSet rs=null;
	
	Vector rowData,columnNames;
	JTable jt=null;
	JScrollPane jsp=null;
	String s=null;
	
	public UserInfo(String s){
		this.s=s;
		columnNames=new Vector();
		columnNames.add("账户名");
		columnNames.add("密码");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("联系电话");
		
		
		rowData=new Vector();
		try {
			JDBCtch jdbc=new JDBCtch();
			Connection conn=jdbc.conn;
			Statement stmt=jdbc.stmt;
			rs=stmt.executeQuery("select * from UserInfomation where id=\'"+this.s+"\'");
			System.out.println(this.s);
			while(rs.next()!=false){
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				
				
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
		this.setVisible(true);
	}
}
