package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class MasterEntery extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterEntery frame = new MasterEntery();
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
	public MasterEntery() {
		
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblMasterEntry = new JLabel("Master Entry");
		lblMasterEntry.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMasterEntry.setBounds(10, 11, 195, 27);
		panel.add(lblMasterEntry);
		
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
		panel_1.setBounds(0, 44, 1099, 697);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(22, 28, 237, 136);
		panel_1.add(panel_2);
		
		JButton btnCompanyLog = new JButton("COMPANY LOG");
		btnCompanyLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyInformation comi=new CompanyInformation();
				comi.setUndecorated(true);
				comi.setVisible(true);
				
			}
		});
		btnCompanyLog.setForeground(Color.WHITE);
		btnCompanyLog.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCompanyLog.setBackground(new Color(0, 139, 139));
		btnCompanyLog.setBounds(0, 102, 237, 36);
		panel_2.add(btnCompanyLog);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MasterEntery.class.getResource("/Image/imageall/CompanyLog.jpg")));
		label_1.setBounds(22, 0, 215, 102);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(269, 28, 237, 136);
		panel_1.add(panel_3);
		
		JButton btnAdmin = new JButton("ADMIN\r\n");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage admin=new AdminPage();
				admin.setUndecorated(true);
				admin.setVisible(true);
				
			}
		});
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdmin.setBackground(new Color(255, 165, 0));
		btnAdmin.setBounds(0, 102, 237, 36);
		panel_3.add(btnAdmin);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MasterEntery.class.getResource("/Image/imageall/1687-977791.png")));
		label_2.setBounds(22, 0, 215, 102);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(22, 175, 237, 136);
		panel_1.add(panel_4);
		
		JButton btnUser = new JButton("USER");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLoginPage ulp=new UserLoginPage();
				ulp.setUndecorated(true);
				ulp.setVisible(true);
				
			}
		});
		btnUser.setForeground(Color.WHITE);
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUser.setBackground(new Color(34, 139, 34));
		btnUser.setBounds(0, 102, 237, 36);
		panel_4.add(btnUser);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MasterEntery.class.getResource("/Image/imageall/list_add_user.png")));
		label_3.setBounds(22, 0, 215, 102);
		panel_4.add(label_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(269, 175, 237, 136);
		panel_1.add(panel_5);
		
		JButton btnDealer = new JButton("DEALER");
		btnDealer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelarPage dp=new DelarPage();
				dp.setUndecorated(true);
				dp.setVisible(true);
			}
		});
		btnDealer.setForeground(Color.WHITE);
		btnDealer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDealer.setBackground(new Color(250, 128, 114));
		btnDealer.setBounds(0, 102, 237, 36);
		panel_5.add(btnDealer);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MasterEntery.class.getResource("/Image/imageall/vendoradd.png")));
		label_4.setBounds(22, 0, 215, 102);
		panel_5.add(label_4);
	}

}
