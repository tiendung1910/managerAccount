package PackageController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import PackageModel.*;
import PackageView.*;

public class MainAppControl {
//	String keyF;
//	int i;
	
	private static MainApp app;
	private ConnectDatabase connectedByMainApp;
	public MainAppControl() {
		app  = new MainApp();
		app.setVisible(true);
		try {
			ConnectDatabase connn = new ConnectDatabase();
			String querySql = "select sum(Money) as tota from tableappmain where AccountOfUser = ?";
			PreparedStatement PreSttmm = connn.getCon().prepareStatement(querySql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			PreSttmm.setInt(1, ManagerAccount.getForeignkey());
			ResultSet rss = PreSttmm.executeQuery();
			
			rss.absolute(1);
			
			int ahihi = rss.getInt(1);
			
			app.getDisplayTotalTF().setText(String.valueOf("Total: "+ahihi));
		
		
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
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
			
				PreparedStatement PreSttm = connectedByMainApp.getCon().prepareStatement("insert into tableappmain(dates,Money,AccountOfUser) values(?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
				PreSttm.setString(1, date.toString());
				PreSttm.setInt(2, YourMoney);
				PreSttm.setInt(3, ManagerAccount.getForeignkey());
				PreSttm.executeUpdate();
			
				
				//add total label
				ConnectDatabase connn = new ConnectDatabase();
				String querySql = "select sum(Money) as tota from tableappmain where AccountOfUser = ?";
				PreparedStatement PreSttmm = connn.getCon().prepareStatement(querySql,ResultSet.TYPE_SCROLL_SENSITIVE, 
	                    ResultSet.CONCUR_UPDATABLE);
				PreSttmm.setInt(1, ManagerAccount.getForeignkey());
				ResultSet rss = PreSttmm.executeQuery();
				rss.absolute(1);
				int ahihi = rss.getInt(1);
				app.getDisplayTotalTF().setText(String.valueOf("Total: "+ahihi));
				//add total label
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(ManagerAccount.getForeignkey());
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
				
				PreparedStatement PreSttm = connectedByMainApp.getCon().prepareStatement("insert into tableappmain(dates,Money,AccountOfUser) values(?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
				PreSttm.setString(1, date2.toString());
				PreSttm.setInt(2, -YourMoney);
				PreSttm.setInt(3, ManagerAccount.getForeignkey());
				PreSttm.executeUpdate();
				
				
				ConnectDatabase connn = new ConnectDatabase();
				String querySql = "select sum(Money) as tota from tableappmain where AccountOfUser = ?";
				PreparedStatement PreSttmm = connn.getCon().prepareStatement(querySql,ResultSet.TYPE_SCROLL_SENSITIVE, 
	                    ResultSet.CONCUR_UPDATABLE);
				PreSttmm.setInt(1, ManagerAccount.getForeignkey());
				ResultSet rss = PreSttmm.executeQuery();
				
				rss.absolute(1);
				
				int ahihi = rss.getInt(1);
				
				app.getDisplayTotalTF().setText(String.valueOf("Total: "+ahihi));
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	
		app.getOtherButton().addActionListener(e -> {
			new controlList_moneys();
		});
		
		app.getChartButton().addActionListener(e -> {
				new FileData();
				
//				FileReader fr2;
//				
//				try {
//					fr2 = new FileReader("C:\\Users\\Administrator\\eclipse-workspace\\projectCharMoneys\\data.txt");
//					BufferedReader br2 = new BufferedReader(fr2);
//					ArrayList<Character> a = new ArrayList<Character>();
//					
//					try {
//						while((i=br2.read())!=-1) {
//							a.add((char)i);
//						}
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					if(a.size()==1) {
//						
//						keyF =String.valueOf(a.get(0)) ;
//					
//					}else {
//						keyF = "";
//						for(char i : a) {
//							keyF +=i; 
//						}
//						
//					}
//					
//					System.out.println(keyF);
//				
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
		});
	}
	public static MainApp getApp() {
		return app;
	}
	
}
