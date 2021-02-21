package PackageView;
import PackageController.*;
import PackageModel.*;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class list_moneys {
	JFrame f;
	JPanel p;
	JList<String> list;
	
	public list_moneys(ArrayList<String> data) {	
		f = new JFrame("ahihi");
		p = new JPanel(new BorderLayout());
		DefaultListModel<String> myList = new DefaultListModel<String>();
		for(String d : data) {
			myList.addElement(d);
			
		}
		/*
		try {
			ConnectDatabase con = new ConnectDatabase();
			Statement st = con.getCon().createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
			ResultSet rs = st.executeQuery("select * from tableappmain where AccountOfUser = "+ManagerAccount.getForeignkey());;
			while(rs.next()) {
				if(rs.getInt(3)<0) {
					myList.add(rs.getString(2)+", withdraw:"+rs.getInt(3));
				}else {
					myList.add(rs.getString(2)+", added:"+rs.getInt(3));
				}
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		list = new JList<String>(myList/*.toArray(new String[myList.size()])*/);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		
		p.add(scrollPane);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.add(p);
		f.setSize(500,250);
		f.setVisible(true);
		
	}
	public JList<String> getList(){
		return list;
	}
	
}
