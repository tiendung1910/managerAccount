package PackageView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class UpdateForm {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField UpdateDateField;
	private JTextField UpdateMoneyField;
	private JButton UpdateButton;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateForm frame = new UpdateForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdateForm() {
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
//		frame.setBounds(100, 100, 450, 300);
		
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JFrame("Update Form");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UpdateDateField = new JTextField();
		UpdateDateField.setBounds(171, 70, 185, 20);
		contentPane.add(UpdateDateField);
		UpdateDateField.setColumns(10);
		
		UpdateMoneyField = new JTextField();
		UpdateMoneyField.setBounds(171, 120, 185, 20);
		contentPane.add(UpdateMoneyField);
		UpdateMoneyField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Update Date");
		lblNewLabel.setBounds(43, 70, 83, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Money");
		lblNewLabel_1.setBounds(43, 120, 83, 20);
		contentPane.add(lblNewLabel_1);
		
		UpdateButton = new JButton("Update");
		UpdateButton.setBounds(171, 200, 89, 23);
		contentPane.add(UpdateButton);
		frame.setContentPane(contentPane);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}
	public JTextField getUpdateDateField() {
		return UpdateDateField;
	}
	public JTextField getUpdateMoneyField() {
		return UpdateMoneyField;
	}
	public JButton getUpdateButton() {
		return UpdateButton;
	}
	public JFrame getFrame() {
		return frame;
	}
}
