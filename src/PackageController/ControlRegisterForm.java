package PackageController;
import PackageView.*;
import java.awt.*;
import java.awt.event.*;
import PackageModel.*;

import java.awt.event.WindowListener;
import java.sql.*;

import javax.swing.JFrame;
// su li form dang ki;
public class ControlRegisterForm {
	private ConnectDatabase connect;
	private RegisterForm rF;

	public ControlRegisterForm() {
		try {
			connect = new ConnectDatabase();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		rF = new RegisterForm();
		rF.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		rF.setVisible(true);
		
		try {
			Statement sttm = connect.getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = sttm.executeQuery("select count(id) as countId from tableuserpassword");
			rs.absolute(1);
			rF.getRegisterButton().addActionListener(e -> {
				String textFieldUser = rF.getRegisterUserTF().getText();
				String textFieldPass = String.valueOf(rF.getRegisterPassTF().getPassword());
				String textEnterFieldPass = String.valueOf(rF.getRegisterEnterPassTF().getPassword());
				
				try {
					/*
					if(rs.getInt(1) == 0) {
						PreparedStatement ps = connect.getCon().prepareStatement("insert into tableuserpassword(users,passwords) values(?,?)");
						ps.setString(1, textFieldUser);
						ps.setString(2, textFieldPass);
						ps.executeUpdate();
						new popUpRegisterSuccess();
					}
					*/
					boolean isExistUserPass = false;
					ResultSet exeQuery2 = sttm.executeQuery("select * from tableuserpassword");
					while(exeQuery2.next()) {
							
						if(exeQuery2.getString("users").equals(textFieldUser)) {
								isExistUserPass = true;
								break;
						}
					}
					if(isExistUserPass == false && textFieldPass.equals(textEnterFieldPass)) {
						PreparedStatement ps2 = connect.getCon().prepareStatement("insert into tableuserpassword(users,passwords) values(?,?)");
						ps2.setString(1, textFieldUser);
						ps2.setString(2, textFieldPass);
						ps2.executeUpdate();
					
						new popUpRegisterSuccess();
					}else{
						new popUpFailRegister();
					}
						
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			});
			
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	
}
