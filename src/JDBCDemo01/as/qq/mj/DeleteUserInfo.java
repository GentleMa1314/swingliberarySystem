package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
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

public class DeleteUserInfo extends JFrame implements ActionListener{

	
	JTextField jt=new JTextField();
	JTable js=null;
	
	Vector rowData,columnNames;

	
	public DeleteUserInfo(){
		JFrame jf=new JFrame("ͼ�����ϵͳ");
		jf.setBounds(300,300,300,300);
		jf.setLayout(new FlowLayout());
	
		
		
		
		jt.setColumns(10);
		JButton ok=new JButton("��ʼ");
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
		
		

	

		
		
		
		rowData=new Vector();
		try {
			
			rs=stmt.executeQuery("select * from UserInfomation where id=\'"+msg+"\'");
			
				columnNames=new Vector();
				columnNames.add("ѧ�����");
				columnNames.add("��¼����");
				columnNames.add("ѧ������");
				columnNames.add("�Ա�");
				columnNames.add("��ϵ�绰");
				while(rs.next()){
					
					Vector hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					hang.add(rs.getString(5));
					
					
					rowData.add(hang);
					
				}
				js=new JTable(rowData,columnNames);
				
				jsp=new JScrollPane(js);
				this.add(jsp);
				this.setSize(400,300);
			//	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setVisible(true);
				
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "��������!");
		}
		

		
		//this.setVisible(false);
		String m="delete from UserInfomation where id=\'"+msg+"\'";
		JPopupMenu m_Menu=new JPopupMenu();
		JMenuItem Deleted=new JMenuItem();
		Deleted.setText("ɾ��");
		Deleted.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//������Ҫ������
				JDBCtch jdbc=new JDBCtch();
				Connection conn=jdbc.conn;
				Statement stmt=jdbc.stmt;
				
		
				
						
					try {
							ResultSet rs=stmt.executeQuery(m);
							
						}	 catch (SQLException e2) {
						// TODO Auto-generated catch block
							try {
								ResultSet rs2=stmt.executeQuery("delete from BorrowNote where id=\'"+msg+"\'");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
							
							JFrame f1=new JFrame("��ʾ");
							f1.setSize(400, 300);
							JOptionPane.showMessageDialog(f1, "ɾ���ɹ�!");
						} 	
					
					
					}
				
				
				
				
				
			
			});
		m_Menu.add(Deleted);
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
	
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	


	
		
	}


