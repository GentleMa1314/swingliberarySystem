package JDBCDemo01.as.qq.mj;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 按id归还书本
 */
public class IdGive extends JFrame implements ActionListener{
	
	JFrame jf=new JFrame("ͼ�����ϵͳ");
	JTextField jt=new JTextField();
	Label lb=new Label("������ͼ����");
	String s;
	public IdGive(String s){

		this.s=s;
		jf.setBounds(300,300,300,300);
		
		jf.setLayout(new FlowLayout());
		
		JButton ok=new JButton("��ʼ");
		jf.add(lb);
		jf.add(jt);
		
		jf.add(ok);
		jt.setColumns(10);
		jf.setVisible(true);
		ok.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s2=new String(jt.getText());
		String m=new String("select * from BookInfo where indexs=\'"+s2+"\'");
		String r=new String("update BookInfo set amount=amount+1 where indexs=\'"+s2+"\'");
		JDBCtch jdbc=new JDBCtch();
		Connection conn=jdbc.conn;
		Statement stmt=jdbc.stmt;
		ResultSet rs=null;
		ResultSet rs4=null;
		
		try {
			 rs=stmt.executeQuery(m);
			 if(rs.next()==false){
					JOptionPane.showMessageDialog(null, "�޴˱���鼮������������!");
					jt.setText(null);
				}
			 else{
				 	rs4=stmt.executeQuery("select * from BorrowNote where id=\'"+s+"\' and Bookindexs=\'"+s2+"\'");
				 	System.out.println("�ҵķ���û������");
				 if(rs4.next()){
						ResultSet rs3=stmt.executeQuery("select *from BookInfo where indexs=\'"+s2+"\'");
						int k=0,n=0;
					 	if(rs3.next()){
					 		k=rs3.getInt(7);
					 		n=rs3.getInt(8);
					 	}
					 	if(k<n){
					 		rs=stmt.executeQuery(r);
					 		
					 	}
					 	else{
					 		JOptionPane.showMessageDialog(null, "���Ѿ����ˣ��㻹ʲô����!");
					 	}
					}
					else{
						JOptionPane.showMessageDialog(null, "��û���Ȿ�黹ʲô����!");
						return;
					}
				 	
				 
				 	//
				 
					 
				 
				 
			 }
		}catch(SQLException e1){
			JOptionPane.showMessageDialog(null, "����ɹ�!");
			jt.setText(null);
			Date now=new Date();
			 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			 
			 ResultSet rs2;
			try {
				System.out.println(s+"   "+s2);
				rs2 = stmt.executeQuery("update BorrowNote set GiveDay=\'"+sdf.format(now)+"\' where id=\'"+s+"\' and Bookindexs=\'"+s2+"\'");
				
				
			} catch (SQLException e2) {
				System.out.println("ȫ������ĭŶ��");
				ResultSet rs3;
				try {
					rs3 = stmt.executeQuery("select * from BorrowNote where id=\'"+s+"\' and Bookindexs=\'"+s2+"\'");
					
					char k='��';
					String a = null;
					String b = null;
					
					if(rs3.next()){
						a=rs3.getString(2);
						b=rs3.getString(3);
						
					}
					String yyear=a.substring(0,4);
					int y=Integer.parseInt(yyear);	//�����
					String yyea2=b.substring(0,4);
					int y2=Integer.parseInt(yyea2);//�����ֵ
					String dmoon=a.substring(5, 7);
					int t=Integer.parseInt(dmoon);//���·�
					String dday=a.substring(8,10);
					int d=Integer.parseInt(dday);//������
					System.out.println(t+"     "+d);
					String dmoon2=b.substring(5,7);
					int t2=Integer.parseInt(dmoon2);//���·�
					String dday2=b.substring(8,10);
					int d2=Integer.parseInt(dday2);//������
					System.out.println(y+" "+t+"  "+d+"  ����"+y2+" "+t2+" "+d2);
					
					if(y==y2){
						if(t==t2){
							return;
						}
						else if(t2-t==1){
							if(d<d2){
								ResultSet rs6=stmt.executeQuery("update BorrowNote set BookDealWith=\'"+k+"\' where id=\'"+s+"\' and Bookindexs=\'"+s2+"\'");
							}
						}
					}
					else {
						if(y2-y==1){
							if(t-t2==11){
								if(d<d2){
									ResultSet rs7=stmt.executeQuery("update BorrowNote set BookDealWith=\'"+k+"\' where id=\'"+s+"\' and Bookindexs=\'"+s2+"\'");
									
								}
							}
						}
					}
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					//e3.printStackTrace();
					//JOptionPane.showMessageDialog(null, "����ɹ�!");
					//jt.setText(null);
					
					System.out.println("�Ѿ�������");
			 		JOptionPane.showMessageDialog(null, "���Ѿ�������ڲ����Ѿ����˼�¼!");
					jt.setText(null);
				}
				
				
				
				
				
				
			}
			//JOptionPane.showMessageDialog(null, "����ɹ�!");
			//jt.setText(null);
			
			//e1.getStackTrace();
			
		}
		
		
		
	}


	
	
	
}
