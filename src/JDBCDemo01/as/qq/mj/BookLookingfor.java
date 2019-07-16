package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookLookingfor extends JFrame implements ActionListener{
	
	JTextField jt=new JTextField();
	JTable js=null;
	
	Vector rowData,columnNames;
	String s;
	String k;
	
	public BookLookingfor(String s){
		JFrame jf=new JFrame("图书管理系统");
		jf.setBounds(300,300,300,300);
		jf.setLayout(new FlowLayout());
		this.s=s;
		
		
		
		jt.setColumns(10);
		JButton ok=new JButton("开始");
		jf.add(jt);
		jf.add(ok);
		jf.setVisible(true);
		ok.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=jt.getText();
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		
		ResultSet rs=null;
		
		
		
		JScrollPane jsp=null;
		
		

	

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
			
			rs=stmt.executeQuery("select * from BookInfo where name=\'"+msg+"\'");
			while(rs.next()){
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
				
				k=rs.getString(2);
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
					
				}
				
				
			}catch(SQLException e1){
				
				e1.printStackTrace();
			}
		}

		js=new JTable(rowData,columnNames);
		
		jsp=new JScrollPane(js);
		this.add(jsp);
		this.setSize(400,300);
		this.setVisible(false);
		JPopupMenu m_Menu=new JPopupMenu();
		JMenuItem Borrow=new JMenuItem();
		Borrow.setText("借书");
		Borrow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//操作需要做的事
				JDBCtch jdbc=new JDBCtch();
				Connection conn=jdbc.conn;
				Statement stmt=jdbc.stmt;
				
				try {
					
					int m = 0,n=0;
					ResultSet rs2=stmt.executeQuery("select *from BookInfo where name=\'"+msg+"\'");
					if(rs2.next()){
						m=rs2.getInt(7);
						n=rs2.getInt(8);
					}
					System.out.println(m+"    "+n);
					if(m<=0){
						JOptionPane.showMessageDialog(null, "失败!");
						return;
						
						
					}else{
						stmt.executeQuery("delete from BookInfo where name=\'"+msg+"\'");
					}
					
						
			
					
					
				} 
				
						
				catch (SQLException e1) {
					
					
					Date now=new Date();
					
					
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				
					char c1='否';
					char c2='否';
					
					
					sdf.format(now);
					
					
					String give="2000-01-01";
				
					String m="insert into BorrowNote(id,BorrowDay,GiveDay,BookSeries,BookDealWith,Bookindexs) values(\'"+s+"\',\'"+sdf.format(now)+"\',\'"+give+"\',\'"+c1+"\',\'"+c2+"\',\'"+k+"\')";
					try {
						ResultSet rs=stmt.executeQuery(m);
					} catch (SQLException e2) {
						
						
						JFrame f1=new JFrame("提示");
						f1.setSize(400, 300);
						JOptionPane.showMessageDialog(f1, "借书成功!");
					} 
					
					
				}
				
				
				
				
			}
			
		});
		m_Menu.add(Borrow);
		js.addMouseListener(new MouseAdapter(){
			
				public void mouseClicked(MouseEvent e){
					if(e.getButton()==MouseEvent.BUTTON3){
						int focusedRowIndex=js.rowAtPoint(e.getPoint());
						if(focusedRowIndex==-1){
							return;
						}
						js.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
						m_Menu.show(js, e.getX(), e.getY());
					}
				}
			});
	
		
		
		
		this.setVisible(true);
		
		
	}
	
	

	
	
	

	
	
}
