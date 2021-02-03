package PackageController;
import java.sql.*;

import PackageModel.*;
import PackageView.*;

public class MainAppControl {
	private MainApp app;
	private ConnectDatabase connectedByMainApp;
	
	
	
	public MainAppControl() {
		app  = new MainApp();
		
		app.getAddMoneyButton().addActionListener(e -> {
			String stringTimessTF = app.getTimessTF().getText();
			String stringYourMoneyTF = app.getYourMoneyTF().getText();
			int YourMoney = Integer.parseInt(stringYourMoneyTF);
			
			String ShowdataInput = "Dates :"+stringTimessTF+" ,Added moneys :"+stringYourMoneyTF;
			app.getDisplayDataTF().setText(ShowdataInput);
			try {
				
				
				connectedByMainApp = new ConnectDatabase();
				Statement sttm = connectedByMainApp.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = sttm.executeQuery("select sum(Money) from tableappmain");
				rs.absolute(1);
				
				int totalMoney = rs.getInt(1);
				
				PreparedStatement PreSttm = connectedByMainApp.getCon().prepareStatement("insert into tableappmain(dates,Money,AccountOfUser) values(?,?,?)");
				PreSttm.setString(1, stringTimessTF);
				PreSttm.setInt(2, YourMoney+totalMoney);
				
				PreSttm.setInt(3, ManagerAccount.getForeignkey());
					
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		});
		
		app.getWithdrawButton().addActionListener(e -> {
			
		});
		
		app.getDiaryButton().addActionListener(e -> {
			
		});
	}
}
