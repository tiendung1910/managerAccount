package PackageView;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class popUpFailInput {
	private JFrame failInput;
	public popUpFailInput(){
		failInput = new JFrame();
		JOptionPane.showMessageDialog(failInput, "Input Failure","Warning",JOptionPane.WARNING_MESSAGE);
	}
	
}
