package PackageController;
import PackageView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	
	public controlList_moneys(){
		try {
			ArrayList<String> dataJList = new ArrayList<String>();
			
			con = new ConnectDatabase();
			Statement st = con.getCon().createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = st.executeQuery("select * from tableappmain where AccountOfUser = "+ManagerAccount.getForeignkey());;
			while(rs.next()) {
				if(rs.getInt(3)<0) {
					dataJList.add(rs.getString(2)+", withdraw:"+-rs.getInt(3));
					
				}else{
					dataJList.add(rs.getString(2)+", added:"+rs.getInt(3));
				}
			}
		list_moneys Oblist = new list_moneys(dataJList);
		Oblist.getList().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					Oblist.getList().setSelectedIndex(Oblist.getList().locationToIndex(e.getPoint()));
					JPopupMenu menu = new JPopupMenu();
					JMenuItem itemUpdate = new JMenuItem("Update");
					itemUpdate.addActionListener(a -> {
						try {
							Statement sttm2 = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//							ResultSet rs2 = sttm2.executeUpdate(null);
						
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					});
					
					JMenuItem itemRemove = new JMenuItem("Remove");
					itemRemove.addActionListener(a -> {
						try {
							Statement sttm2 = con.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//							ResultSet rs2 = sttm2.executeUpdate(null);
						
						
						
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

}