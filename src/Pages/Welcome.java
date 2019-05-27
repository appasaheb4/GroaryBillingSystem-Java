package Pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.xml.ws.Dispatch;

import org.apache.tools.ant.types.Assertions.DisabledAssertion;
import org.hibernate.cfg.Settings;

import com.google.zxing.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.DriverManager;
import java.sql.SQLException;

import jxl.format.Border;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;

public class Welcome {

	private JFrame frame;

	public String usertype = LoginPage.textFieldType.getText();
	public String usertype1 = "User";
	public JButton btnMasterentry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void call() {
		try {
			Welcome window = new Welcome();
			window.frame.setVisible(true);
		} catch (Exception ca) {
			System.out.println(ca.getMessage());
		}
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		

		frame.setBounds(100, 100, 1378, 740);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 96, 267, 686);
		panel.setBackground(Color.BLACK);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnDashBoard = new JButton("DASHBOARD");
		btnDashBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDashBoard.setBorderPainted(true);
				Welcome.call();

			}
		});
		btnDashBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDashBoard.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDashBoard.setForeground(Color.WHITE);
				btnDashBoard.setBorderPainted(false);
			}
		});
		btnDashBoard.setForeground(Color.WHITE);
		btnDashBoard.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDashBoard.setOpaque(false);
		btnDashBoard.setContentAreaFilled(false);
		btnDashBoard.setBorderPainted(false);
		btnDashBoard.requestFocus();
		btnDashBoard.setBounds(0, 35, 267, 33);
		panel.add(btnDashBoard);

		JButton btnPurchase = new JButton("PURCHASE");
		btnPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPurchase.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPurchase.setForeground(Color.WHITE);
				btnPurchase.setBorderPainted(false);

			}
		});
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPurchase.setBorderPainted(true);
				Purchase pur = new Purchase();
				pur.setUndecorated(true);
				pur.setVisible(true);

			}
		});
		btnPurchase.setForeground(Color.WHITE);
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPurchase.setBounds(0, 95, 267, 33);
		btnPurchase.setOpaque(false);
		btnPurchase.setContentAreaFilled(false);
		btnPurchase.setBorderPainted(false);
		panel.add(btnPurchase);

		JButton btnBillDesk = new JButton("BILLDESK");
		btnBillDesk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBillDesk.setBorderPainted(true);
				BillDesk pur = new BillDesk();
				pur.setUndecorated(true);
				pur.setVisible(true);
			}
		});
		btnBillDesk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBillDesk.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBillDesk.setForeground(Color.WHITE);
				btnBillDesk.setBorderPainted(false);

			}
		});
		btnBillDesk.setForeground(Color.WHITE);
		btnBillDesk.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBillDesk.setBounds(0, 155, 267, 33);
		btnBillDesk.setOpaque(false);
		btnBillDesk.setContentAreaFilled(false);
		btnBillDesk.setBorderPainted(false);
		panel.add(btnBillDesk);

		JButton btnExpenditure = new JButton("EXPENDITURE");
		btnExpenditure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExpenditure.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExpenditure.setForeground(Color.WHITE);
				btnExpenditure.setBorderPainted(false);

			}
		});
		btnExpenditure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExpenditure.setBorderPainted(true);
				ExpenditurePage exp = new ExpenditurePage();
				exp.setUndecorated(true);
				exp.setVisible(true);
			}
		});
		btnExpenditure.setForeground(Color.WHITE);
		btnExpenditure.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExpenditure.setBounds(0, 215, 267, 33);
		btnExpenditure.setOpaque(false);
		btnExpenditure.setContentAreaFilled(false);
		btnExpenditure.setBorderPainted(false);
		panel.add(btnExpenditure);

		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPayment.setForeground(Color.green);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPayment.setForeground(Color.WHITE);
				btnPayment.setBorderPainted(false);

			}
		});
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPayment.setBorderPainted(true);
				Payment pay = new Payment();
				pay.setUndecorated(true);
				pay.setVisible(true);
			}
		});
		btnPayment.setForeground(Color.WHITE);
		btnPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPayment.setBounds(0, 275, 267, 33);
		btnPayment.setOpaque(false);
		btnPayment.setContentAreaFilled(false);
		btnPayment.setBorderPainted(false);
		panel.add(btnPayment);

		JButton btnReports = new JButton("REPORTS");
		btnReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReports.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnReports.setForeground(Color.WHITE);
				btnReports.setBorderPainted(false);

			}
		});
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReports.setBorderPainted(true);
				Reports re = new Reports();
				re.setUndecorated(true);
				re.setVisible(true);

			}
		});
		btnReports.setForeground(Color.WHITE);
		btnReports.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReports.setBounds(0, 335, 267, 33);
		btnReports.setOpaque(false);
		btnReports.setContentAreaFilled(false);
		btnReports.setBorderPainted(false);
		panel.add(btnReports);

		JButton btnSetting = new JButton("SETTING");
		btnSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSetting.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSetting.setForeground(Color.WHITE);
				btnSetting.setBorderPainted(false);

			}
		});
		btnSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSetting.setBorderPainted(true);
				Settingspage setpa = new Settingspage();
				setpa.setUndecorated(true);
				setpa.setVisible(true);
			}
		});

		btnSetting.setForeground(Color.WHITE);
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSetting.setBounds(0, 395, 267, 33);
		btnSetting.setOpaque(false);
		btnSetting.setContentAreaFilled(false);
		btnSetting.setBorderPainted(false);
		panel.add(btnSetting);

		btnMasterentry = new JButton("MASTERENTRY");
		btnMasterentry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMasterentry.setForeground(Color.green);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMasterentry.setForeground(Color.WHITE);
				btnMasterentry.setBorderPainted(false);
			}
		});
		btnMasterentry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMasterentry.setBorderPainted(true);
				MasterEntery me = new MasterEntery();
				me.setUndecorated(true);
				me.setVisible(true);

			}
		});
		btnMasterentry.setForeground(Color.WHITE);
		btnMasterentry.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMasterentry.setBounds(0, 455, 267, 33);
		btnMasterentry.setOpaque(false);
		btnMasterentry.setContentAreaFilled(false);
		btnMasterentry.setBorderPainted(false);
		panel.add(btnMasterentry);

		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setForeground(Color.WHITE);

			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackupDiagog bd = new BackupDiagog();

				bd.setVisible(true);

			}
		});
		btnExit.setForeground(Color.WHITE);

		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(0, 515, 267, 33);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		panel.add(btnExit);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 267, 97);
		panel_1.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Groary \r\nBilling System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 234, 75);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {

				if (usertype.equals(usertype1)) {

					btnMasterentry.setEnabled(false);
				}

			}
		});

		panel_2.setBounds(287, 96, 1065, 644);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Welcome,");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 11, 110, 27);
		panel_2.add(lblNewLabel_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 61, 142, 222);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/purchase.png")));
		lblNewLabel_2.setBounds(0, 0, 142, 169);
		panel_3.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("PURCHASE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase pur = new Purchase();
				pur.setUndecorated(true);
				pur.setVisible(true);

			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(139, 0, 0));

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(0, 170, 142, 52);
		panel_3.add(btnNewButton_1);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(219, 61, 142, 222);
		panel_2.add(panel_4);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/sales.png")));
		label.setBounds(0, 0, 142, 169);
		panel_4.add(label);

		JButton btnBilldesk = new JButton("BILLDESK");
		btnBilldesk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillDesk pur = new BillDesk();
				pur.setUndecorated(true);
				pur.setVisible(true);
			}
		});
		btnBilldesk.setBackground(new Color(0, 128, 128));
		btnBilldesk.setForeground(Color.WHITE);
		btnBilldesk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBilldesk.setBounds(0, 170, 142, 52);
		panel_4.add(btnBilldesk);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(628, 61, 142, 222);
		panel_2.add(panel_5);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/Payment.png")));
		label_1.setBounds(0, 0, 142, 169);
		panel_5.add(label_1);

		JButton btnPayment_1 = new JButton("PAYMENT");
		btnPayment_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Payment pay = new Payment();
				pay.setUndecorated(true);
				pay.setVisible(true);
			}
		});
		btnPayment_1.setForeground(Color.WHITE);
		btnPayment_1.setBackground(new Color(178, 34, 34));
		btnPayment_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPayment_1.setBounds(0, 170, 142, 52);
		panel_5.add(btnPayment_1);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(10, 330, 142, 222);
		panel_2.add(panel_6);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/Reports.png")));
		label_2.setBounds(0, 0, 142, 169);
		panel_6.add(label_2);

		JButton btnReports_1 = new JButton("REPORTS");
		btnReports_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reports re = new Reports();
				re.setUndecorated(true);
				re.setVisible(true);
			}
		});
		btnReports_1.setBackground(new Color(139, 0, 0));
		btnReports_1.setForeground(Color.WHITE);
		btnReports_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReports_1.setBounds(0, 170, 142, 52);
		panel_6.add(btnReports_1);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(219, 330, 142, 222);
		panel_2.add(panel_7);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/hammer-wrench-icon.jpg")));
		label_3.setBounds(10, 0, 132, 169);
		panel_7.add(label_3);

		JButton btnSettings = new JButton("SETTINGS\r\n");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settingspage setpa = new Settingspage();
				setpa.setUndecorated(true);
				setpa.setVisible(true);

			}
		});
		btnSettings.setForeground(Color.WHITE);
		btnSettings.setBackground(new Color(255, 69, 0));
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSettings.setBounds(0, 170, 142, 52);
		panel_7.add(btnSettings);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(428, 61, 142, 222);
		panel_2.add(panel_8);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/expe.png")));
		label_4.setBounds(0, 0, 142, 169);
		panel_8.add(label_4);

		JButton btnExpenditure_1 = new JButton("EXPENDITURE");
		btnExpenditure_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpenditurePage exp = new ExpenditurePage();
				exp.setUndecorated(true);
				exp.setVisible(true);
			}
		});
		btnExpenditure_1.setBackground(new Color(0, 100, 0));
		btnExpenditure_1.setForeground(Color.WHITE);
		btnExpenditure_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExpenditure_1.setBounds(0, 170, 142, 52);
		panel_8.add(btnExpenditure_1);

		JButton btnExit_1 = new JButton("X");
		btnExit_1.setForeground(Color.RED);
		btnExit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit_1.setForeground(Color.black);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit_1.setForeground(Color.red);
			}
		});
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnExit_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExit_1.setBounds(968, 0, 71, 69);
		btnExit_1.setOpaque(false);
		btnExit_1.setContentAreaFilled(false);
		btnExit_1.setBorderPainted(false);
		panel_2.add(btnExit_1);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(428, 330, 142, 222);
		panel_2.add(panel_9);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Welcome.class.getResource("/Image/imageall/1687-977791.png")));
		label_5.setBounds(10, 0, 132, 169);
		panel_9.add(label_5);

		JButton btnMasterentry_1 = new JButton("MASTERENTRY");
		btnMasterentry_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MasterEntery me = new MasterEntery();
				me.setUndecorated(true);
				me.setVisible(true);

			}
		});
		btnMasterentry_1.setForeground(Color.WHITE);
		btnMasterentry_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMasterentry_1.setBackground(Color.ORANGE);
		btnMasterentry_1.setBounds(0, 170, 142, 52);
		panel_9.add(btnMasterentry_1);

		JButton btnSTOCKDECREASED = new JButton("STOCK DECREASED");
		btnSTOCKDECREASED.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSTOCKDECREASED.setBounds(1132, 11, 220, 50);
		btnSTOCKDECREASED.setOpaque(false);
		btnSTOCKDECREASED.setContentAreaFilled(false);
		btnSTOCKDECREASED.setBorderPainted(false);
		frame.getContentPane().add(btnSTOCKDECREASED);

		JLabel lblAccessUserName = new JLabel();
		lblAccessUserName.setForeground(new Color(0, 0, 255));
		lblAccessUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccessUserName.setBounds(294, 11, 165, 35);
		String loginname = LoginPage.textFieldUserName.getText();
		String usertype5 = LoginPage.textFieldType.getText();
		lblAccessUserName.setText("Hi: " + loginname);
		frame.getContentPane().add(lblAccessUserName);
	}
}
