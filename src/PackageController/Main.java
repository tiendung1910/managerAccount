package PackageController;
import java.sql.*;

import PackageModel.*;
import PackageView.*;
public class Main {
	public static void main(String args[]) { 
		
		try {
			/*
			ConnectDatabase connectedByMainApp = new ConnectDatabase();			
			PreparedStatement pSttm = connectedByMainApp.getCon().prepareStatement("select Money from tableappmain where AccountOfUser="+18);
			ResultSet rs = pSttm.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		 	*/
			new ManagerAccount();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
}
