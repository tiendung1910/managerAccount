package PackageController;
import PackageView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import PackageModel.*;

public class controlList_moneys {
	private ConnectDatabase con;
	private static int id;
	static list_moneys Oblist;
	private ArrayList<String> dataJList;
	public controlList_moneys(){
		try {
			dataJList = new ArrayList<String>();
			
			con = new ConnectDatabase();
			Statement st = con.getCon().createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = st.executeQuery("select * from tableappmain where AccountOfUser = "+ManagerAccount.getForeignkey());
			while(rs.next()) {
				if(rs.getInt(3)<0) {
					dataJList.add(rs.getString(2)+", withdraw:"+-rs.getInt(3));
			
				}else{
					dataJList.add(rs.getString(2)+", added:"+rs.getInt(3));
				}
			}
		Oblist = new list_moneys(dataJList);
		Oblist.getList().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					Oblist.getList().setSelectedIndex(Oblist.getList().locationToIndex(e.getPoint()));
					JPopupMenu menu = new JPopupMenu();
					JMenuItem itemUpdate = new JMenuItem("Update");
					itemUpdate.addActionListener(a -> {
						try {
							//Statement sttm2 = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							//ResultSet rs2 = sttm2.executeQuery(null);
							//System.out.println(Oblist.getList().getSelectedIndex());
							Statement newSttm = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet newRs = newSttm.executeQuery("select * from tableappmain where AccountOfUser="+ManagerAccount.getForeignkey());
							int count = 0;
							while(newRs.next()) {
								if(count == Oblist.getList().getSelectedIndex()) {
									id = newRs.getInt(1);
									System.out.println(id);
									break;
								}
								count++;
							}
							
							
							
							new controlUpdateForm();
							
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					});
					
					JMenuItem itemRemove = new JMenuItem("Remove");
					itemRemove.addActionListener(a -> {
						try {
							//Statement sttm2 = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//							ResultSet rs2 = sttm2.executeUpdate(null);
						
							Statement newSttm = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
							ResultSet newRs = newSttm.executeQuery("select * from tableappmain where AccountOfUser="+ManagerAccount.getForeignkey());
							int count = 0;
							while(newRs.next()) {
								if(count == Oblist.getList().getSelectedIndex()) {
									id = newRs.getInt(1);
									System.out.println(id);
									break;
								}
								count++;
							}
							ConnectDatabase connect;
							try {
								connect = new ConnectDatabase();
								PreparedStatement upStatement = connect.getCon().prepareStatement("delete from tableappmain where idApp = ?");
								upStatement.setInt(1, controlList_moneys.getId());
								int i = upStatement.executeUpdate();
								System.out.println(i+" record removed");
							
								controlList_moneys.Oblist.getF().dispose();
								//add count total
								
								ConnectDatabase connn;
								try {
									connn = new ConnectDatabase();
									String querySql = "select sum(Money) as tota from tableappmain where AccountOfUser = ?";
								PreparedStatement PreSttmm = connn.getCon().prepareStatement(querySql,ResultSet.TYPE_SCROLL_SENSITIVE, 
					                    ResultSet.CONCUR_UPDATABLE);
								PreSttmm.setInt(1, ManagerAccount.getForeignkey());
								ResultSet rss = PreSttmm.executeQuery();
								
								rss.absolute(1);
								
								int ahihi = rss.getInt(1);
								
								MainAppControl.getApp().getDisplayTotalTF().setText(String.valueOf("Total: "+ahihi));
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								new controlList_moneys();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					});
					menu.add(itemUpdate);
					menu.add(itemRemove);
					menu.show(Oblist.getList(), e.getPoint().x, e.getPoint().y);
					
				}
			}
			
		});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int getId() {
		return id;
	}
	public ArrayList<String> getDataJList() {
		return dataJList;
	}
}