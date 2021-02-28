package PackageController;
import PackageView.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import PackageModel.*;

public class controlUpdateForm {

	public controlUpdateForm() {
		UpdateForm formUpdate = new UpdateForm();
		formUpdate.getUpdateButton().addActionListener(e -> {
			String StringUpdateDate = formUpdate.getUpdateDateField().getText();
			String arrStringUpdate[] = StringUpdateDate.split("-");
			Dates UpdateDate = new Dates(Integer.parseInt(arrStringUpdate[0]),Integer.parseInt(arrStringUpdate[1]),Integer.parseInt(arrStringUpdate[2]));
			
			String StringUpdateMoney = formUpdate.getUpdateMoneyField().getText();
			int yourUpdateMoney = Integer.parseInt(StringUpdateMoney);
			System.out.println(UpdateDate.toString());
			System.out.println(yourUpdateMoney);
			System.out.println(controlList_moneys.getId());
			try {
				ConnectDatabase connect = new ConnectDatabase();
				PreparedStatement upStatement = connect.getCon().prepareStatement("update tableappmain set dates = ?, Money = ? where idApp = ?");
				upStatement.setString(1, UpdateDate.toString());
				upStatement.setInt(2, yourUpdateMoney);
				upStatement.setInt(3, controlList_moneys.getId());
				int i = upStatement.executeUpdate();
				System.out.println(i+" record updated");
				
//				int upRs = upStatement.executeUpdate("update tableappmain set dates = "+UpdateDate.toString()+", Money = "+yourUpdateMoney+" where idApp = "+controlList_moneys.getId());
				
				
//				controlList_moneys newOblist = new controlList_moneys(); 
				
				int indexRemove = controlList_moneys.Oblist.getList().getSelectedIndex();
				System.out.println(indexRemove);
				//controlList_moneys.Oblist.getList()
				
				controlList_moneys.Oblist.getF().dispose();
				new controlList_moneys();
				formUpdate.getFrame().dispose();
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
}
