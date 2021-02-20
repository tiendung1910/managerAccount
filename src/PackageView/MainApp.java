package PackageView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;

public class MainApp extends JFrame {

	private JPanel contentPane;
	private JTextField TimessTF;
	private JTextField YourMoneyTF;
	private JButton AddMoneyButton;
	private JButton WithdrawButton;
	private JButton OtherButton;
	private JButton btnNewButton_1;
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
		//setBounds(100, 100, 654, 399);
		setSize(654,399);
		setMinimumSize(new Dimension(654,399));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TimessTF = new JTextField();
		TimessTF.setBounds(272, 100, 230, 20);
		contentPane.add(TimessTF);
		TimessTF.setColumns(10);
		
		YourMoneyTF = new JTextField();
		YourMoneyTF.setBounds(272, 145, 230, 20);
		contentPane.add(YourMoneyTF);
		YourMoneyTF.setColumns(10);
		
		JLabel Timesslb = new JLabel("Input Date");
		Timesslb.setHorizontalAlignment(SwingConstants.CENTER);
		Timesslb.setBounds(99, 100, 121, 20);
		contentPane.add(Timesslb);
		
		JLabel Moneylb = new JLabel("Input Moneys");
		Moneylb.setHorizontalAlignment(SwingConstants.CENTER);
		Moneylb.setBounds(99, 145, 121, 20);
		contentPane.add(Moneylb);
		
		AddMoneyButton = new JButton("ADD");
		AddMoneyButton.setBounds(10, 270, 137, 23);
		contentPane.add(AddMoneyButton);
		
		WithdrawButton = new JButton("WITHDRAW");
		WithdrawButton.setBounds(172, 270, 137, 23);
		contentPane.add(WithdrawButton);
		
		OtherButton = new JButton("OTHER...");
		OtherButton.setBounds(330, 270, 137, 23);
		contentPane.add(OtherButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(491, 270, 137, 23);
		contentPane.add(btnNewButton_1);
		
		DisplayDataTF = new JLabel("");
		DisplayDataTF.setBounds(10, 217, 618, 30);
		contentPane.add(DisplayDataTF);
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
	public JButton getOtherButton() {
		return OtherButton;
	}
	public JLabel getDisplayDataTF() {
		return DisplayDataTF;
	}
}
