package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Settingspage extends JFrame {

	private JPanel contentPane;
	
	public String usertype=LoginPage.textFieldType.getText();
	public String usertype1="User";
	
	public JButton btnAdminChangePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settingspage frame = new Settingspage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Settingspage() {
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);

		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSettings.setBounds(10, 11, 161, 27);
		panel.add(lblSettings);

		JButton button = new JButton("X");
		button.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setOpaque(false);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(990, -1, 69, 45);
		panel.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 45, 1099, 696);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(23, 26, 237, 136);
		panel_1.add(panel_2);

		 btnAdminChangePassword = new JButton(" ADMIN CHANGE PASSWORD");
		btnAdminChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminChangePassword acp=new AdminChangePassword();
				acp.setUndecorated(true);
				acp.setVisible(true);
			}
		});
		btnAdminChangePassword.setForeground(Color.WHITE);
		btnAdminChangePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdminChangePassword.setBackground(new Color(255, 165, 0));
		btnAdminChangePassword.setBounds(0, 102, 237, 36);
		panel_2.add(btnAdminChangePassword);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Settingspage.class
				.getResource("/Image/imageall/change-password.png")));
		label_1.setBounds(22, 0, 215, 102);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(23, 192, 237, 136);
		panel_1.add(panel_3);

		JButton btnSetMinimumStock = new JButton("SET MINIMUM STOCK");
		btnSetMinimumStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetMinimumStorck min=new SetMinimumStorck();
				min.setUndecorated(true);
				min.setVisible(true);
			}
		});
		btnSetMinimumStock.setForeground(Color.WHITE);
		btnSetMinimumStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSetMinimumStock.setBackground(new Color(184, 134, 11));
		btnSetMinimumStock.setBounds(0, 102, 237, 36);
		panel_3.add(btnSetMinimumStock);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Settingspage.class
				.getResource("/Image/imageall/setminstock.png")));
		label_2.setBounds(22, 0, 215, 102);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(270, 192, 237, 136);
		panel_1.add(panel_4);

		JButton btnBackup = new JButton("BACKUP");
		btnBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackUp bakcu=new BackUp();
				bakcu.setUndecorated(true);
				bakcu.setVisible(true);
				
			}
		});
		btnBackup.setForeground(Color.WHITE);
		btnBackup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBackup.setBackground(new Color(255, 105, 180));
		btnBackup.setBounds(0, 102, 237, 36);
		panel_4.add(btnBackup);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Settingspage.class
				.getResource("/Image/imageall/data-backup-icon.png")));
		label_3.setBounds(22, 0, 215, 102);
		panel_4.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(270, 26, 237, 136);
		panel_1.add(panel_5);
		
		JButton btnUserChangePassword = new JButton("USER CHANGE PASSWORD");
		btnUserChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserChangePassword ucp=new UserChangePassword();
				ucp.setUndecorated(true);
				ucp.setVisible(true);
			}
		});
		btnUserChangePassword.setForeground(Color.WHITE);
		btnUserChangePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUserChangePassword.setBackground(new Color(255, 165, 0));
		btnUserChangePassword.setBounds(0, 102, 237, 36);
		panel_5.add(btnUserChangePassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Settingspage.class.getResource("/Image/imageall/sett.png")));
		label.setBounds(22, 0, 215, 102);
		panel_5.add(label);
	}

}
