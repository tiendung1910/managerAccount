package PackageView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainApp extends JFrame {
	private JPanel contentPane;
	private JTextField TimessTF;
	private JTextField YourMoneyTF;
	private JButton AddMoneyButton;
	private JButton WithdrawButton;
	private JButton DiaryButton;
	private JLabel DisplayDataTF;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TimessTF = new JTextField();
		TimessTF.setBounds(131, 60, 235, 20);
		panel.add(TimessTF);
		TimessTF.setColumns(10);
		
		YourMoneyTF = new JTextField();
		YourMoneyTF.setBounds(131, 102, 235, 20);
		panel.add(YourMoneyTF);
		YourMoneyTF.setColumns(10);
		
		DisplayDataTF = new JLabel();
		DisplayDataTF.setBounds(10, 169, 414, 25);
		panel.add(DisplayDataTF);
		
		JLabel lblNewLabel_1 = new JLabel("Input Time");
		lblNewLabel_1.setBounds(10, 60, 87, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Input Money");
		lblNewLabel_2.setBounds(10, 102, 87, 20);
		panel.add(lblNewLabel_2);
		
		AddMoneyButton = new JButton("ADD MONEY");
		AddMoneyButton.setBounds(4, 227, 100, 23);
		contentPane.add(AddMoneyButton);
		
		WithdrawButton = new JButton("WITHDRAW");
		WithdrawButton.setBounds(114, 227, 100, 23);
		contentPane.add(WithdrawButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(330, 227, 100, 23);
		contentPane.add(btnNewButton_1);
		
		DiaryButton = new JButton("DIARY");
		DiaryButton.setBounds(224, 227, 100, 23);
		contentPane.add(DiaryButton);
	}
	public JTextField getTimessTF() {
		return TimessTF;
	}
	public JTextField getYourMoneyTF() {
		return YourMoneyTF;
	}
	public JButton getAddMoneyButton() {
		return AddMoneyButton;
	}
	public JButton getWithdrawButton() {
		return WithdrawButton;
	}
	public JButton getDiaryButton() {
		return DiaryButton;
	}
	public JLabel getDisplayDataTF() {
		return DisplayDataTF;
	}
}