package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookSeriesBorrow extends JFrame implements ActionListener{

	JTextField jt=new JTextField();
	JTable js=null;
	
	Vector rowData,columnNames;
	String s;
	String k;
	
	public BookSeriesBorrow(String s){
		JFrame jf=new JFrame("图书管理系统");
		jf.setBounds(300,300,300,300);
		jf.setLayout(new FlowLayout());
	
		
		
		
		jt.setColumns(10);
		JButton ok=new JButton("开始");
		jf.add(jt);
		jf.add(ok);
		jf.setVisible(true);
		ok.addActionListener(this);
		this.s=s;
		
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
		columnNames.add("学生编号");
		columnNames.add("借书日期");
		columnNames.add("还书日期");
		columnNames.add("是否续借");
		columnNames.add("是否违章");
		columnNames.add("图书编号");
		
		
		rowData=new Vector();
try {
			
			rs=stmt.executeQuery("select * from BorrowNote where id=\'"+s+"\'and Bookindexs=\'"+msg+"\'");
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				
				
				rowData.add(hang);
				
				k=rs.getString(2);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
		//this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(false);
		//this.setVisible(false);
		JPopupMenu m_Menu=new JPopupMenu();
		JMenuItem Borrow=new JMenuItem();
		Borrow.setText("续借");
		Borrow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//操作需要做的事
				JDBCtch jdbc=new JDBCtch();
				Connection conn=jdbc.conn;
				Statement stmt=jdbc.stmt;
				
				try {
					//stmt.executeQuery("delete from BookInfo where name=\'"+msg+"\'");
					char c='是';
					String s3="2000-01-01";
					Date now=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					ResultSet rs2=stmt.executeQuery("update BorrowNote set BorrowDay=\'"+sdf.format(now)+"\',Bookseries=\'"+c+"\',GiveDay=\'"+s3+"\'where id=\'"+s+"\' and Bookindexs=\'"+msg+"\'");
					
					//ResultSet rs3=stmt.executeQuery("update BorrowNote set Bookseries=\'"+c+"\' where id=\'"+s+"\' and Bookindexs=\'"+msg+"\'");
				
					
						
			
					
					
				} 
				
						
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					
					JOptionPane.showMessageDialog(null, "续借成功！");
					
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
