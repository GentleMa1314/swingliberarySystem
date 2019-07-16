package JDBCDemo01.as.qq.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtch {
	
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LibrarySystem";
	private static String username="sa";
	private static String password="root";
	Connection conn=null;
	Statement stmt=null;
	
	public JDBCtch(){
		
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conn=DriverManager.getConnection(url,username,password);
				stmt=conn.createStatement();
			} catch (SQLException e) {
				System.out.println("«˝∂Øº”‘ÿ ß∞‹");
			}
	
		
	}
	
	
}
