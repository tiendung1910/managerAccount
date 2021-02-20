package PackageController;
import java.sql.*;

import PackageModel.*;
import PackageView.*;

public class MainAppControl {
	
	private ConnectDatabase connectedByMainApp;
	public MainAppControl() {
		MainApp app  = new MainApp();
		app.setVisible(true);
		app.getAddMoneyButton().addActionListener(e -> {
			
			String stringTimessTF = app.getTimessTF().getText();
			String arrDate[] = stringTimessTF.split("-");
			Dates date = new Dates(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
			
			
			String stringYourMoneyTF = app.getYourMoneyTF().getText();
			int YourMoney = Integer.parseInt(stringYourMoneyTF);
			
			String ShowdataInput = "Dates :"+stringTimessTF+" ,Added moneys :"+stringYourMoneyTF;
			app.getDisplayDataTF().setText(ShowdataInput);
			try {
				connectedByMainApp = new ConnectDatabase();
				
				PreparedStatement pSttm = connectedByMainApp.getCon().prepareStatement("select Money from tableappmain where AccountOfUser=?",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
				pSttm.setInt(1, ManagerAccount.getForeignkey());				
				ResultSet rs = pSttm.executeQuery();
				
				int index = 0;
				while(rs.next()) {
					index++;
				}
				int surplus;
				if(index!=0) {
					rs.absolute(index);
					surplus = rs.getInt(1);
				}else{
					surplus = 0;
				}
				
				PreparedStatement PreSttm = connectedByMainApp.getCon().prepareStatement("insert into tableappmain(dates,Money,AccountOfUser) values(?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
				PreSttm.setString(1, date.toString());
				PreSttm.setInt(2, YourMoney+surplus);
				PreSttm.setInt(3, ManagerAccount.getForeignkey());
				PreSttm.executeUpdate();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		});
		
		app.getWithdrawButton().addActionListener(e -> {
			String stringTimessTF = app.getTimessTF().getText();
			String arrDate[] = stringTimessTF.split("-");
			Dates date2 = new Dates(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
			
			String stringYourMoneyTF = app.getYourMoneyTF().getText();
			int YourMoney = Integer.parseInt(stringYourMoneyTF);
			
			String ShowdataInput = "Dates :"+stringTimessTF+" ,withdrew moneys :"+stringYourMoneyTF;
			app.getDisplayDataTF().setText(ShowdataInput);
			try {
				
				connectedByMainApp = new ConnectDatabase();
				PreparedStatement pSttm = connectedByMainApp.getCon().prepareStatement("select Money from tableappmain where AccountOfUser=?",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
			
				pSttm.setInt(1, ManagerAccount.getForeignkey());
				ResultSet rs = pSttm.executeQuery();
				
				int index = 0;
				while(rs.next()) {
					index++;
				}
				int surplus;
				PreparedStatement pSttm2 = connectedByMainApp.getCon().prepareStatement("select Money from tableappmain where AccountOfUser=?",ResultSet.TYPE_SCROLL_SENSITIVE, 
		                ResultSet.CONCUR_UPDATABLE);
				pSttm2.setInt(1,ManagerAccount.getForeignkey());		
				ResultSet rs2 = pSttm2.executeQuery();
				/*
				if(index != 0) {
					rs2.absolute(index);
					surplus = rs2.getInt(1);
				}else{
					surplus = 0;
				}
				*/
				PreparedStatement PreSttm = connectedByMainApp.getCon().prepareStatement("insert into tableappmain(dates,Money,AccountOfUser) values(?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
				PreSttm.setString(1, date2.toString());
				PreSttm.setInt(2, -YourMoney);
				PreSttm.setInt(3, ManagerAccount.getForeignkey());
				PreSttm.executeUpdate();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		app.getOtherButton().addActionListener(e -> {
			new controlList_moneys();
		});
	}
}
