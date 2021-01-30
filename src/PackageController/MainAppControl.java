package PackageController;
import PackageModel.*;
import PackageView.*;

public class MainAppControl {
	private MainApp app;
	
	public MainAppControl() {
		app  = new MainApp();
		
		app.getAddMoneyButton().addActionListener(e -> {
			String stringTimessTF = app.getTimessTF().getText();
			String stringYourMoneyTF = app.getYourMoneyTF().getText();
			
			String ShowdataInput = "dates :"+stringTimessTF+" ,moneys :"+stringYourMoneyTF;
			app.getDisplayDataTF().setText(ShowdataInput);
			
		
		
		});
		
		app.getWithdrawButton().addActionListener(e -> {
			
		});
		
		app.getDiaryButton().addActionListener(e -> {
			
		});
	}
}
