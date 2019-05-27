package Pages;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.jws.Oneway;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

import org.hibernate.engine.transaction.Isolater.JtaDelegate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.table.TableModel;
import javax.swing.JList;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.http.conn.params.ConnConnectionParamBean;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.TextArea;

public class PurchasePay extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldDealerName;
	public static JTextField textFieldTotalAmount;
	private JTextField textFieldAmtPaid;
	private JTextField textFieldChequeNo;
	private JTextField textFieldChequDate;
	private JTextField textFieldBankName;
	public static JTextField textFieldRemainbal;
	private JTextField textFieldDate;

	private JTextField textFieldInWord;
	private String na;
	public Connection conn;
	public PreparedStatement ps;
	private JTextField textFieldSrno;
	public String val1;
	public static JRadioButton rdbtnCahs;
	public static JRadioButton rdbtnCheque;
	public String gender;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textRadioButton;
	public DefaultTableModel model;
	public 	JButton buttonReport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchasePay frame = new PurchasePay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset() {
		textFieldChequeNo.setText("");
		textFieldBankName.setText("");
		textFieldAmtPaid.setText("");
		textFieldInWord.setText("");
	}

	public void rem() {
		String Golbal = textFieldRemainbal.getText();

		double totlapaid = Double.valueOf(textFieldAmtPaid.getText());
		double remain = Double.valueOf(textFieldRemainbal.getText());
		double totalamt = remain - totlapaid;
		textFieldRemainbal.setText(String.valueOf(totalamt));

	}

	public void pw(int n, String ch) {
		String one[] = { " ", " one", " two", " three", " four", " five", " six", " seven", " eight", " Nine", " ten",
				" eleven", " twelve", " thirteen", " fourteen", "fifteen", " sixteen", " seventeen", " eighteen",
				" nineteen" };

		String ten[] = { " ", " ", " twenty", " thirty", " forty", " fifty", " sixty", "seventy", " eighty",
				" ninety" };
		if (n > 19) {
			// System.out.print(ten[n / 10] + " " + one[n % 10]);
			String no = String.valueOf(ten[n / 10] + "" + one[n % 10]);
			textFieldInWord.setText(no);

		} else {
			// System.out.print(one[n]);

			String no1 = String.valueOf(one[n].toString());
			String[] strArray = new String[] { (one[n]) };

			for (int j = 0; j < strArray.length; j++) {
				textFieldInWord.setText(strArray[j]);

			}

		}

		// if (n > 0)
		// {
		//
		// System.out.println(ch);
		// textFieldInWord.setText(ch);
		// }

	}

	/**
	 * Create the frame.
	 */
	public PurchasePay() {

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);

		JLabel lblDelarPay = new JLabel("Dealer Payment");
		lblDelarPay.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDelarPay.setBounds(10, 11, 216, 27);
		panel.add(lblDelarPay);

		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setOpaque(false);
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(990, -1, 69, 45);
		panel.add(button);

		textFieldSrno = new JTextField();
		textFieldSrno.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldSrno.setEnabled(false);
		textFieldSrno.setColumns(10);
		textFieldSrno.setBounds(273, 11, 184, 32);
		 textFieldSrno.setVisible(false);
		int no =Integer.parseInt(Purchase.textFieldSrnumberMaster.getText());
		int n=no-1;
		textFieldSrno.setText(String.valueOf(n));
		panel.add(textFieldSrno);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 56, 612, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dealer Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 120, 17);
		panel_1.add(lblNewLabel);

		textFieldDealerName = new JTextField();
		textFieldDealerName.setEnabled(false);
		textFieldDealerName.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldDealerName.setBounds(152, 11, 184, 32);
		panel_1.add(textFieldDealerName);
		textFieldDealerName.setColumns(10);

		JLabel lblTotalAmount = new JLabel("Total Amount:");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalAmount.setBounds(10, 39, 120, 17);
		panel_1.add(lblTotalAmount);

		textFieldTotalAmount = new JTextField();
		textFieldTotalAmount.setEnabled(false);
		textFieldTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldTotalAmount.setColumns(10);
		textFieldTotalAmount.setBounds(152, 45, 184, 32);
		panel_1.add(textFieldTotalAmount);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 135, 780, 339);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPaymentMode = new JLabel("Payment Mode:");
		lblPaymentMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentMode.setBounds(10, 23, 120, 17);
		panel_2.add(lblPaymentMode);

		rdbtnCahs = new JRadioButton("Cash");
		rdbtnCahs.setSelected(true);
		buttonGroup.add(rdbtnCahs);

		rdbtnCahs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCheque.isSelected()) {
					textFieldChequeNo.setEnabled(true);
					textFieldBankName.setEnabled(true);
				} else {
					textFieldChequeNo.setEnabled(false);
					textFieldBankName.setEnabled(false);

				}
				if (rdbtnCahs.isSelected())

				{
					textRadioButton.setText("Cash");
				} else if (rdbtnCheque.isSelected())
					textRadioButton.setText("Cheque");

			}
		});

		rdbtnCahs.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCahs.setBounds(79, 47, 70, 23);
		panel_2.add(rdbtnCahs);

		rdbtnCheque = new JRadioButton("Cheque");
		buttonGroup.add(rdbtnCheque);

		rdbtnCheque.setActionCommand("Cheque");
		rdbtnCheque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnCheque.isSelected()) {
					textFieldChequeNo.setEnabled(true);
					textFieldBankName.setEnabled(true);
				} else {
					textFieldChequeNo.setEnabled(false);
					textFieldBankName.setEnabled(false);

				}
				if (rdbtnCahs.isSelected())

				{
					textRadioButton.setText("Cash");
				} else if (rdbtnCheque.isSelected())
					textRadioButton.setText("Cheque");

			}
		});

		rdbtnCheque.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCheque.setBounds(172, 47, 109, 23);

		panel_2.add(rdbtnCheque);

		JLabel lblAmountPaid = new JLabel("Amount Paid:");
		lblAmountPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountPaid.setBounds(486, 26, 120, 17);
		panel_2.add(lblAmountPaid);

		textFieldAmtPaid = new JTextField();
		textFieldAmtPaid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				textFieldRemainbal.setText(textFieldTotalAmount.getText());
			}

			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == '.') || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE))) {
					textFieldRemainbal.setText(textFieldTotalAmount.getText());
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldAmtPaid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					Double number = Double.valueOf(textFieldAmtPaid.getText());
					if (number <= 0) {
						System.out.println("Enter numbers greater than 0");
					} else {
						pw((int) (number / 1000000000), " Hundred");
						pw((int) ((number / 10000000) % 100), " crore");
						pw((int) ((number / 100000) % 100), " lakh");
						pw((int) ((number / 1000) % 100), " thousand");
						pw((int) ((number / 100) % 10), " hundred");
						pw((int) (number % 100), " ");
						rem();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		});

		textFieldAmtPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldAmtPaid.setColumns(10);
		textFieldAmtPaid.setBounds(459, 54, 253, 23);
		panel_2.add(textFieldAmtPaid);

		JLabel lblInWord = new JLabel("In Word:");
		lblInWord.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInWord.setBounds(486, 101, 120, 17);
		panel_2.add(lblInWord);

		JLabel lblChequeNo = new JLabel("Cheque No:");
		lblChequeNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChequeNo.setBounds(10, 121, 120, 17);
		panel_2.add(lblChequeNo);

		textFieldChequeNo = new JTextField();
		textFieldChequeNo.setEnabled(false);
		textFieldChequeNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldChequeNo.setColumns(10);
		textFieldChequeNo.setBounds(152, 121, 184, 23);
		panel_2.add(textFieldChequeNo);

		textFieldChequDate = new JTextField();
		textFieldChequDate.setEnabled(false);
		textFieldChequDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldChequDate.setColumns(10);
		textFieldChequDate.setBounds(152, 155, 184, 23);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		textFieldChequDate.setText(date);
		panel_2.add(textFieldChequDate);

		JLabel lblChequeDate = new JLabel("Cheque Date:");
		lblChequeDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChequeDate.setBounds(10, 155, 120, 17);
		panel_2.add(lblChequeDate);

		JLabel lblBankName = new JLabel("Bank Name:");
		lblBankName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBankName.setBounds(10, 202, 120, 17);
		panel_2.add(lblBankName);

		textFieldBankName = new JTextField();
		textFieldBankName.setEnabled(false);
		textFieldBankName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBankName.setColumns(10);
		textFieldBankName.setBounds(152, 202, 184, 23);
		panel_2.add(textFieldBankName);

		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBalance.setBounds(486, 216, 120, 17);
		panel_2.add(lblBalance);

		textFieldRemainbal = new JTextField();
		textFieldRemainbal.setEnabled(false);
		textFieldRemainbal.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldRemainbal.setColumns(10);
		textFieldRemainbal.setBounds(459, 244, 253, 34);
		panel_2.add(textFieldRemainbal);

		JButton buttonPay = new JButton("Pay");
		buttonPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conn = DBConnection.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(
							"INSERT INTO groarybillingsystem.purchasepay VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					ps.setInt(1, Integer.parseInt(textFieldSrno.getText()));
					ps.setString(2, textFieldDealerName.getText());
					ps.setDouble(3, Double.valueOf(textFieldTotalAmount.getText()));
					ps.setString(4, textRadioButton.getText());
					ps.setDouble(5, Double.valueOf(textFieldAmtPaid.getText()));
					ps.setString(6, textFieldInWord.getText());
					ps.setString(7, textFieldChequeNo.getText());
					ps.setString(8, textFieldChequDate.getText());
					ps.setString(9, textFieldBankName.getText());
					ps.setDouble(10, Double.parseDouble(textFieldRemainbal.getText()));
					ps.setString(11, textFieldDate.getText());
					int ii = ps.executeUpdate();
					if (ii > 0) {
						JOptionPane.showMessageDialog(null, "Data are stored");
						buttonReport.setEnabled(true);
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				try {
					String data00 = textFieldSrno.getText();
					String data0 = textFieldDealerName.getText();
					String data1 = textFieldTotalAmount.getText();
					String data2 = textRadioButton.getText();
					String data3 = textFieldAmtPaid.getText();
					String data4 = textFieldChequeNo.getText();
					String data5 = textFieldChequDate.getText();
					String data6 = textFieldBankName.getText();
					String data7 = textFieldRemainbal.getText();
					String data8 = textFieldDate.getText();

					model.addRow(
							new Object[] { data00, data0, data1, data2, data3, data4, data5, data6, data7, data8 });
				} catch (Exception ee) {
					ee.printStackTrace();
				}

			}
		});
		buttonPay.setIcon(new ImageIcon(PurchasePay.class.getResource("/ImageButtonIcon/Pay.png")));
		buttonPay.setHorizontalAlignment(SwingConstants.LEADING);
		buttonPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonPay.setBounds(66, 284, 104, 49);
		panel_2.add(buttonPay);

		JButton buttonExit = new JButton("Exit");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonExit.setHorizontalAlignment(SwingConstants.LEADING);
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonExit.setBounds(608, 286, 104, 47);
		panel_2.add(buttonExit);

		textFieldInWord = new JTextField();
		textFieldInWord.setEnabled(false);
		textFieldInWord.setBounds(459, 129, 253, 65);
		panel_2.add(textFieldInWord);
		textFieldInWord.setColumns(10);

		textRadioButton = new JTextField();
		textRadioButton.setText("Cash");
		textRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		textRadioButton.setEnabled(false);
		textRadioButton.setColumns(10);
		textRadioButton.setBounds(256, 50, 184, 32);
		textRadioButton.setVisible(false);
		panel_2.add(textRadioButton);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		btnReset.setHorizontalAlignment(SwingConstants.LEADING);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(438, 284, 104, 49);
		panel_2.add(btnReset);

		 buttonReport = new JButton("Report");
		buttonReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					int paravalue=Integer.parseInt(textFieldSrno.getText());
					HashMap para=new HashMap();
					para.put("SrMaster", paravalue);
						Reports r = new Reports("Comapany Information",
								"src/Reports/PurchaseReports.jasper",para);
						r.setBounds(270, 80, 1100, 700);
						r.setVisible(true);
					
			}
				catch(Exception ew)
				{
					ew.printStackTrace();
				}
			}
		});
		buttonReport.setIcon(new ImageIcon(PurchasePay.class.getResource("/ImageButtonIcon/Report4d.png")));
		buttonReport.setHorizontalAlignment(SwingConstants.LEADING);
		buttonReport.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonReport.setEnabled(false);
		buttonReport.setBounds(236, 284, 136, 49);
		panel_2.add(buttonReport);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 485, 1079, 237);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		String[] column = { "Sr NO", "Dealer Name", "Total Amount", "Payment Mode", "Amount Paid", "Cheque No",
				"Cheque Date", "Bank Name", "Remainder Amount", "Date" };
		model = new DefaultTableModel(column, 0);
		final JTable tableshow = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(tableshow);
		scrollPane.setBounds(10, 11, 1059, 215);
		panel_3.add(scrollPane);

		textFieldDate = new JTextField();
		textFieldDate.setEnabled(false);
		textFieldDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(836, 56, 136, 23);
		String date1 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		textFieldDate.setText(date1);
		contentPane.add(textFieldDate);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(768, 56, 58, 17);
		contentPane.add(lblDate);
	}
}
