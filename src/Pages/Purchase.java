package Pages;

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

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDealserName;
	private JTextField textFieldDelarMobileno;
	private JTextField textFieldDealarEmailId;
	private JTextField textFieldCategory;
	private JTextField textFieldBarnd;
	private JTextField textFieldProductName;
	private JTextField textFieldMRPPrice;
	private JTextField textFieldFreeItem;
	private JTextField textFieldFreeItemQty;
	private JTextField textFieldFreeItemAmount;
	private JTextField textFieldQty;
	private JTextField textFieldRateandUnit;
	private JTextField textFieldSchPer;
	private JTextField textFieldSchAmount;
	private JTextField textFieldVatPer;
	private JTextField textFieldVatAmount;
	private JTextField textFieldTranCharge;
	private JTextField textFieldGross;
	private JTextField textFieldSchAMOUTWW;
	private JTextField textFieldvatAMOUNTWW;
	private JTextField textFieldNetAMOUNTWW;

	public JButton butUpdate;
	public JButton butDelete;

	public Connection conn = null;
	public PreparedStatement pre;
	public PreparedStatement pre1;
	public PreparedStatement update;
	public ResultSet rs;
	public ResultSet rs1;
	public Statement st;
	public PreparedStatement ps;
	public Connection con = null;

	public Statement st1 = null;

	private JTextField textFieldFreeItemFirstprice;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JScrollPane scrollPaneTableDataShow;

	public String s;
	private JTextField textFieldNetAmount5;
	private JTextField textFieldContyIntoRate;
	public String val1 = null;
	public String val2 = null;
	public String val3 = null;
	public String val4 = null;
	Statement stmt = null;

	private JTextField dateChooserDate;

	public static DefaultTableModel myModeal;
	public JTable tableshow;
	public static JTextField textFieldSrnumberMaster;
	public static JTextField textFieldSrNumber;
	public JComboBox comboBoxQty;
	public JButton btnPay;

	public JList listDelaername;
	public JScrollPane scrollPane;
	private JTextField textFieldTotalAmountPay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void increment() {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn
					.prepareStatement("select max(Srnomaster) from groarybillingsystem.purchaseeinfomaster;");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int val = (rs.getInt(1) + 1);
				val1 = String.valueOf(val);

			}
			textFieldSrnumberMaster.setText(val1);

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	public void reset() {
		textFieldCategory.setText("");
		textFieldBarnd.setText("");
		textFieldProductName.setText("");
		textFieldMRPPrice.setText("");
		textFieldFreeItem.setText("");
		textFieldFreeItemFirstprice.setText("");
		textFieldFreeItemQty.setText("");
		textFieldFreeItemAmount.setText("");
		textFieldQty.setText("");
		comboBoxQty.setSelectedIndex(0);
		textFieldRateandUnit.setText("");
		textFieldSchPer.setText("");
		textFieldSchAmount.setText("");
		textFieldVatPer.setText("");
		textFieldVatAmount.setText("");

	}

	public double getnettotal() {
		int rowcount = tableshow.getRowCount();

		double nettoatl = 0;
		for (int i = 0; i < rowcount; i++) {
			nettoatl = nettoatl
					+ Double.valueOf(tableshow.getValueAt(i, 21).toString());
		}

		return nettoatl;
	}

	public double getvattotal() {
		int rowcount = tableshow.getRowCount();

		double vattotal = 0;
		for (int i = 0; i < rowcount; i++) {
			vattotal = vattotal
					+ Double.valueOf(tableshow.getValueAt(i, 20).toString());

		}

		return vattotal;

	}

	public double getgross() {
		int rowcount = tableshow.getRowCount();

		double gross = 0;
		for (int i = 0; i < rowcount; i++) {
			gross = gross
					+ Double.valueOf(tableshow.getValueAt(i, 16).toString())
					* Double.valueOf(tableshow.getValueAt(i, 14).toString());

		}

		return gross;
	}

	public Double getdiscount() {
		int rowcount = tableshow.getRowCount();
		double sum = 0;
		for (int i = 0; i < rowcount; i++) {
			sum = sum + Double.valueOf(tableshow.getValueAt(i, 18).toString());
		}

		return sum;
	}

	/**
	 * Create the frame.
	 */
	public Purchase() {
		
		
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPurchase = new JLabel("Purchase");
		lblPurchase.setBounds(10, 11, 195, 27);
		lblPurchase.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblPurchase);

		JButton button = new JButton("X");
		button.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setBounds(990, -1, 69, 45);
		button.setOpaque(false);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		panel.add(button);

		textFieldSrnumberMaster = new JTextField();
		textFieldSrnumberMaster.setEnabled(false);
		textFieldSrnumberMaster.setBounds(545, 19, 86, 20);
		//textFieldSrnumberMaster.setVisible(false);
		panel.add(textFieldSrnumberMaster);
		increment();
		textFieldSrnumberMaster.setColumns(10);

		textFieldSrNumber = new JTextField();
		textFieldSrNumber.setEnabled(false);
		textFieldSrNumber.setText("1");
		textFieldSrNumber.setColumns(10);
		textFieldSrNumber.setBounds(197, 19, 296, 20);
		textFieldSrNumber.setVisible(false);
		panel.add(textFieldSrNumber);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 56, 1099, 83);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDelarName = new JLabel("Dealer Name:");
		lblDelarName.setBounds(38, 14, 115, 17);
		lblDelarName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblDelarName);

		textFieldDealserName = new JTextField();

		textFieldDealserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldDealserName.getText().equals(""))
				{
					textFieldDealarEmailId.setVisible(false);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
//				DefaultListModel model = new DefaultListModel();
//
//				try {
//					String query = "select * from groarybillingsystem.delarinfo where Name like '%"
//							+ textFieldDealserName.getText() + "%'";
//					conn = DBConnection.getConnection();
//					ps = conn.prepareStatement(query);
//					rs = ps.executeQuery();
//					while (rs.next()) {
//						String name = rs.getString("Name");
//						model.addElement(name);
//
//					}
//					listDelaername.setModel(model);
//					scrollPane.setVisible(true);
//					listDelaername.setVisible(true);
//
//				} catch (SQLException eq) {
//					System.out.println("Message   : " + eq.getMessage());
//				}

			}
		});

		textFieldDealserName.setBounds(191, 11, 313, 23);
		textFieldDealserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDealserName.setColumns(10);
		textFieldDealserName.requestFocus();

		panel_1.add(textFieldDealserName);

		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setBounds(580, 11, 115, 17);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblMobileNo);

		textFieldDelarMobileno = new JTextField();
		textFieldDelarMobileno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldDelarMobileno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldDelarMobileno.getText().length() == 10) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 10 digit mobile number.");
				
				}
			}
		});
		textFieldDelarMobileno.setBounds(766, 11, 271, 23);
		textFieldDelarMobileno.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldDelarMobileno.setColumns(10);
		panel_1.add(textFieldDelarMobileno);

		textFieldDealarEmailId = new JTextField();
		textFieldDealarEmailId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldDealarEmailId.getText().length() != 0) {

					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					String email1 = textFieldDealarEmailId.getText();
					Boolean b = email1.matches(EMAIL_REGEX);
					if(b==false)
					{
					JOptionPane.showMessageDialog(null,"Plz enter correct email address.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter email id.");
				}
			}
		});

		textFieldDealarEmailId.setBounds(191, 45, 313, 24);
		textFieldDealarEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		//textFieldDealarEmailId.setVisible(false);
		textFieldDealarEmailId.setColumns(10);
		panel_1.add(textFieldDealarEmailId);

		JLabel label = new JLabel("Email-Id:");
		label.setBounds(38, 45, 115, 17);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(label);

		JLabel label_1 = new JLabel("Date:");
		label_1.setBounds(580, 45, 37, 17);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(label_1);

		dateChooserDate = new JTextField();
		dateChooserDate.setEnabled(false);
		dateChooserDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateChooserDate.setBounds(763, 45, 240, 28);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		dateChooserDate.setText(date);
		panel_1.add(dateChooserDate);
		dateChooserDate.setColumns(10);

		listDelaername = new JList();
		listDelaername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String name = String.valueOf(listDelaername
							.getSelectedValue());
					textFieldDealserName.setText(name);
					conn = DBConnection.getConnection();
					String query = "select * from groarybillingsystem.delarinfo  where Name='"
							+ name + "'";
					rs = ps.executeQuery(query);
					while(rs.next())
					{
						String mobileno=rs.getString("MobileNo");
						textFieldDelarMobileno.setText(mobileno);
						String emaild=rs.getString("EmailId");
						textFieldDealarEmailId.setText(emaild);
						textFieldDealarEmailId.setVisible(true);
					}
					
					
					listDelaername.setVisible(false);
					scrollPane.setVisible(false);
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		listDelaername.setBounds(191, 29, 313, 35);

		listDelaername.setVisible(false);

		scrollPane = new JScrollPane(listDelaername,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(191, 29, 313, 52);
		scrollPane.setOpaque(true);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 150, 1099, 196);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setBounds(38, 17, 115, 17);
		panel_2.add(lblCategory);

		textFieldCategory = new JTextField();
		textFieldCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCategory.setColumns(10);
		textFieldCategory.setBounds(191, 14, 313, 23);
		panel_2.add(textFieldCategory);

		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrand.setBounds(587, 17, 115, 17);
		panel_2.add(lblBrand);

		textFieldBarnd = new JTextField();
		textFieldBarnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldBarnd.setColumns(10);
		textFieldBarnd.setBounds(762, 14, 313, 23);
		panel_2.add(textFieldBarnd);

		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductName.setBounds(38, 48, 115, 17);
		panel_2.add(lblProductName);

		textFieldProductName = new JTextField();
		textFieldProductName.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldProductName.setColumns(10);
		textFieldProductName.setBounds(191, 45, 313, 23);
		panel_2.add(textFieldProductName);

		JLabel lblMrpPrice = new JLabel("MRP Price:");
		lblMrpPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMrpPrice.setBounds(587, 48, 115, 17);
		panel_2.add(lblMrpPrice);

		textFieldMRPPrice = new JTextField();
		textFieldMRPPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});

		textFieldMRPPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMRPPrice.setColumns(10);
		textFieldMRPPrice.setBounds(762, 45, 159, 23);
		panel_2.add(textFieldMRPPrice);

		JLabel lblFreeItem = new JLabel("Free Item:");
		lblFreeItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFreeItem.setBounds(38, 79, 115, 17);
		panel_2.add(lblFreeItem);

		textFieldFreeItem = new JTextField();
		textFieldFreeItem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldFreeItem.setText("");
			}
		});
		textFieldFreeItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldFreeItem.setText("");
			}
		});
		textFieldFreeItem.setText("name");
		textFieldFreeItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFreeItem.setColumns(10);
		textFieldFreeItem.setBounds(191, 76, 159, 23);
		panel_2.add(textFieldFreeItem);

		JLabel lblFreeItemQty = new JLabel("Free Item Qty:");
		lblFreeItemQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFreeItemQty.setBounds(587, 79, 115, 17);
		panel_2.add(lblFreeItemQty);

		textFieldFreeItemQty = new JTextField();
		textFieldFreeItemQty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String price = textFieldFreeItemFirstprice.getText();
				String freeqty = textFieldFreeItemQty.getText();
				double price1 = Double.valueOf(price);
				double frequty1 = Double.valueOf(freeqty);
				double toatalamount = price1 * frequty1;
				String show = String.valueOf(toatalamount);
				textFieldFreeItemAmount.setText(show);

			}
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldFreeItemQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFreeItemQty.setColumns(10);
		textFieldFreeItemQty.setBounds(762, 76, 159, 23);
		panel_2.add(textFieldFreeItemQty);

		JLabel lblFreeItemAmt = new JLabel("Rate/Unit:");
		lblFreeItemAmt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFreeItemAmt.setBounds(587, 110, 115, 17);
		panel_2.add(lblFreeItemAmt);

		textFieldFreeItemAmount = new JTextField();
		textFieldFreeItemAmount.setEnabled(false);
		textFieldFreeItemAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFreeItemAmount.setColumns(10);
		textFieldFreeItemAmount.setBounds(931, 76, 144, 23);
		panel_2.add(textFieldFreeItemAmount);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(38, 110, 115, 17);
		panel_2.add(lblQuantity);

		textFieldQty = new JTextField();
		textFieldQty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldQty.setColumns(10);
		textFieldQty.setBounds(191, 107, 159, 23);
		panel_2.add(textFieldQty);

		comboBoxQty = new JComboBox();
		comboBoxQty.setModel(new DefaultComboBoxModel(new String[] {"nos", "mgm", "gm", "kg", "ml", "lit"}));
		comboBoxQty.setBounds(360, 110, 144, 20);
		panel_2.add(comboBoxQty);

		textFieldRateandUnit = new JTextField();
		textFieldRateandUnit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qty = textFieldQty.getText();
				String rate = textFieldRateandUnit.getText();
				double qty1 = Double.valueOf(qty);
				double rate1 = Double.valueOf(rate);
				double totalrate = qty1 * rate1;
				String totalrate1 = String.valueOf(totalrate);
				textFieldContyIntoRate.setText(totalrate1);

			}
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldRateandUnit.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldRateandUnit.setColumns(10);
		textFieldRateandUnit.setBounds(762, 110, 144, 23);
		panel_2.add(textFieldRateandUnit);

		JLabel lblSch = new JLabel("Sch%:");
		lblSch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSch.setBounds(38, 141, 115, 17);
		panel_2.add(lblSch);

		textFieldSchPer = new JTextField();
		textFieldSchPer.setText("0");
		textFieldSchPer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qty = textFieldQty.getText();
				String rate = textFieldRateandUnit.getText();
				double quty2 = Double.valueOf(qty);
				double rate2 = Double.valueOf(rate);
				double toatalamout = quty2 * rate2;

				String vat = textFieldSchPer.getText();
				double vata = Double.valueOf(vat);

				double tatalprice = toatalamout * vata / 100.0;
				String showdata = String.valueOf(tatalprice);

				textFieldSchAmount.setText(showdata);

				double schtotalamount = toatalamout - tatalprice;

			}
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldSchPer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSchPer.setColumns(10);
		textFieldSchPer.setBounds(191, 138, 159, 23);
		panel_2.add(textFieldSchPer);

		textFieldSchAmount = new JTextField();
		textFieldSchAmount.setText("0");
		textFieldSchAmount.setEnabled(false);
		textFieldSchAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldSchAmount.setColumns(10);
		textFieldSchAmount.setBounds(762, 138, 144, 23);
		panel_2.add(textFieldSchAmount);

		JLabel lblSchAmt = new JLabel("Sch Amt:");
		lblSchAmt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchAmt.setBounds(587, 138, 115, 17);
		panel_2.add(lblSchAmt);

		JLabel lblVat = new JLabel("Vat%:");
		lblVat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVat.setBounds(38, 172, 115, 17);
		panel_2.add(lblVat);

		textFieldVatPer = new JTextField();
		textFieldVatPer.setText("0");
		textFieldVatPer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String qty = textFieldQty.getText();
				String rate = textFieldRateandUnit.getText();
				double quty2 = Double.valueOf(qty);
				double rate2 = Double.valueOf(rate);
				double toatalamout = quty2 * rate2;

				String vat = textFieldVatPer.getText();
				double vata = Double.valueOf(vat);

				double tatalprice = toatalamout * vata / 100.0;
				String showdata = String.valueOf(tatalprice);

				textFieldVatAmount.setText(showdata);

				double totals = toatalamout + tatalprice;

				String rates = textFieldContyIntoRate.getText();
				String schr = textFieldSchAmount.getText();
				String vats = textFieldVatAmount.getText();

				double rates1 = Double.valueOf(rates);
				double schr1 = Double.valueOf(schr);
				double vats1 = Double.valueOf(vats);

				double netamount = rates1 - schr1 + vats1;

				String netamount2 = String.valueOf(netamount);

				textFieldNetAmount5.setText(netamount2);

			}
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldVatPer.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldVatPer.setColumns(10);
		textFieldVatPer.setBounds(191, 169, 159, 23);
		panel_2.add(textFieldVatPer);

		JLabel lblVatAmt = new JLabel("Vat Amt:");
		lblVatAmt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVatAmt.setBounds(587, 166, 115, 17);
		panel_2.add(lblVatAmt);

		textFieldVatAmount = new JTextField();
		textFieldVatAmount.setText("0");
		textFieldVatAmount.setToolTipText("");
		textFieldVatAmount.setEnabled(false);
		textFieldVatAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldVatAmount.setColumns(10);
		textFieldVatAmount.setBounds(762, 166, 144, 23);
		panel_2.add(textFieldVatAmount);

		JLabel label_2 = new JLabel("Rs.");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(908, 166, 29, 17);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Rs.");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(908, 141, 29, 17);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("Rs.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(1081, 82, 29, 17);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Rs.");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(925, 48, 29, 17);
		panel_2.add(label_5);

		textFieldFreeItemFirstprice = new JTextField();
		textFieldFreeItemFirstprice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldFreeItemFirstprice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldFreeItemFirstprice.setText("");
			}
		});
		textFieldFreeItemFirstprice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldFreeItemFirstprice.setText("");
			}
		});
		textFieldFreeItemFirstprice.setText("price");
		textFieldFreeItemFirstprice.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldFreeItemFirstprice.setColumns(10);
		textFieldFreeItemFirstprice.setBounds(360, 76, 144, 23);
		panel_2.add(textFieldFreeItemFirstprice);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 355, 1099, 60);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_3);

		JButton butAdd = new JButton("Add");
		butAdd.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/add.png")));
		butAdd.setHorizontalAlignment(SwingConstants.LEADING);
		butAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					String data0 = textFieldSrnumberMaster.getText();
					String data1 = textFieldSrNumber.getText();
					String data2 = textFieldDealserName.getText();
					String data3 = textFieldDelarMobileno.getText();
					String data4 = textFieldDealarEmailId.getText();
					String data5 = dateChooserDate.getText();
					String data6 = textFieldCategory.getText();
					String data7 = textFieldBarnd.getText();
					String data8 = textFieldProductName.getText();
					String data9 = textFieldMRPPrice.getText();

					String data10 = textFieldFreeItem.getText();
					String data11 = textFieldFreeItemFirstprice.getText();
					String data12 = textFieldFreeItemQty.getText();
					String data13 = textFieldFreeItemAmount.getText();
					String data14 = textFieldQty.getText();
					String data15 = comboBoxQty.getSelectedItem().toString();
					String data16 = textFieldRateandUnit.getText();
					String data17 = textFieldSchPer.getText();
					String data18 = textFieldSchAmount.getText();
					String data19 = textFieldVatPer.getText();
					String data20 = textFieldVatAmount.getText();
					String data21 = textFieldContyIntoRate.getText();

					myModeal.addRow(new Object[] { data0, data1, data2, data3,
							data4, data5, data6, data7, data8, data9, data10,
							data11, data12, data13, data14, data15, data16,
							data17, data18, data19, data20, data21 });
					int ii = Integer.parseInt(textFieldSrNumber.getText());
					int iii = ii + 1;
					textFieldSrNumber.setText(String.valueOf(iii));
					textFieldDealserName.setEnabled(false);
					textFieldDelarMobileno.setEnabled(false);
					textFieldDealarEmailId.setEnabled(false);

					textFieldSchAMOUTWW.setText(Double.toString(getdiscount()));
					textFieldGross.setText(Double.toString(getgross()));
					textFieldvatAMOUNTWW.setText(Double.toString(getvattotal()));
					textFieldNetAMOUNTWW.setText(Double.toString(getnettotal()));
					double nettotal = Double.valueOf(textFieldContyIntoRate
							.getText());
					textFieldTotalAmountPay.setText(String.valueOf(nettotal));

					reset();

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});

		butAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		butAdd.setBounds(10, 11, 115, 38);
		panel_3.add(butAdd);

		butUpdate = new JButton("Update");
		butUpdate.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/update.png")));
		butUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		butUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = tableshow.getSelectedRow();

				if (i >= 0) {
					myModeal.setValueAt(textFieldSrnumberMaster.getText(), i, 0);
					myModeal.setValueAt(textFieldSrNumber.getText(), i, 1);
					myModeal.setValueAt(textFieldDealserName.getText(), i, 2);
					myModeal.setValueAt(textFieldDelarMobileno.getText(), i, 3);
					myModeal.setValueAt(textFieldDealarEmailId.getText(), i, 4);
					myModeal.setValueAt(dateChooserDate.getText(), i, 5);
					myModeal.setValueAt(textFieldCategory.getText(), i, 6);
					myModeal.setValueAt(textFieldBarnd.getText(), i, 7);
					myModeal.setValueAt(textFieldProductName.getText(), i, 8);
					myModeal.setValueAt(textFieldMRPPrice.getText(), i, 9);

					myModeal.setValueAt(textFieldFreeItem.getText(), i, 10);
					myModeal.setValueAt(textFieldFreeItemFirstprice.getText(),
							i, 11);
					myModeal.setValueAt(textFieldFreeItemQty.getText(), i, 12);
					myModeal.setValueAt(textFieldFreeItemAmount.getText(), i,
							13);
					myModeal.setValueAt(textFieldQty.getText(), i, 14);
					myModeal.setValueAt(comboBoxQty.getSelectedItem(), i, 15);
					myModeal.setValueAt(textFieldRateandUnit.getText(), i, 16);
					myModeal.setValueAt(textFieldSchPer.getText(), i, 17);
					myModeal.setValueAt(textFieldSchAmount.getText(), i, 18);
					myModeal.setValueAt(textFieldVatPer.getText(), i, 19);

					myModeal.setValueAt(textFieldVatAmount.getText(), i, 20);
					myModeal.setValueAt(textFieldContyIntoRate.getText(), i, 21);

					textFieldSchAMOUTWW.setText(Double.toString(getdiscount()));
					textFieldGross.setText(Double.toString(getgross()));
					textFieldvatAMOUNTWW.setText(Double.toString(getvattotal()));
					textFieldNetAMOUNTWW.setText(Double.toString(getnettotal()));

				} else {
					System.out.println("Update Error");
				}
			}
		});
		butUpdate.setToolTipText("Plz first Search and then update");
		butUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));

		butUpdate.setBounds(135, 11, 126, 38);
		panel_3.add(butUpdate);

		butDelete = new JButton("Delete");
		butDelete.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/delete.jpg")));
		butDelete.setHorizontalAlignment(SwingConstants.LEADING);

		butDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int[] rows = tableshow.getSelectedRows();
					TableModel tm = tableshow.getModel();

					while (rows.length > 0) {
						((DefaultTableModel) tm).removeRow(tableshow
								.convertRowIndexToModel(rows[0]));

						rows = tableshow.getSelectedRows();
					}

					for (int i = 0; i < tableshow.getRowCount(); i++) {
						tableshow.setValueAt(Integer.toString(i + 1), i, 1);
					}
					tableshow.clearSelection();
					textFieldSchAMOUTWW.setText(Double.toString(getdiscount()));
					textFieldGross.setText(Double.toString(getgross()));
					textFieldvatAMOUNTWW.setText(Double.toString(getvattotal()));
					textFieldNetAMOUNTWW.setText(Double.toString(getnettotal()));
					reset();
				} catch (Exception qe) {
					// TODO: handle exception
				}
			}
		});
		butDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		butDelete.setBounds(268, 11, 115, 38);
		panel_3.add(butDelete);

		JButton butResert = new JButton("Reset");
		butResert.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		butResert.setHorizontalAlignment(SwingConstants.LEADING);
		butResert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset();

			}
		});
		butResert.setFont(new Font("Tahoma", Font.BOLD, 14));
		butResert.setBounds(393, 11, 115, 38);
		panel_3.add(butResert);

		JButton butttExit = new JButton("Exit");
		butttExit.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/Exit.png")));
		butttExit.setHorizontalAlignment(SwingConstants.LEADING);
		butttExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		butttExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		butttExit.setBounds(518, 11, 115, 38);
		panel_3.add(butttExit);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(0, 419, 1099, 145);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		String[] columnname = { "SrNo_Master", "Sr NO", "Dealer name",
				"Mobile No", "Email-Id", "Date", "Category", "Barnd",
				"Product", "MRP", "Free Item", "Price", "Free I Qty",
				"Free I total Amt", "Qty", "Type", "Rate_Unit", "Sch%",
				"Sch Amt", "Vat%", "Vat Amt", "Net Amount" };
		myModeal = new DefaultTableModel(columnname, 0);
		tableshow = new JTable(myModeal);
		tableshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tableshow.getSelectedRow();
				myModeal = (DefaultTableModel) tableshow.getModel();
				textFieldSrnumberMaster.setText(myModeal.getValueAt(i, 0)
						.toString());
				textFieldSrNumber.setText(myModeal.getValueAt(i, 1).toString());
				textFieldDealserName.setText(myModeal.getValueAt(i, 2)
						.toString());
				textFieldDelarMobileno.setText(myModeal.getValueAt(i, 3)
						.toString());
				textFieldDealarEmailId.setText(myModeal.getValueAt(i, 4)
						.toString());
				dateChooserDate.setText(myModeal.getValueAt(i, 5).toString());
				textFieldCategory.setText(myModeal.getValueAt(i, 6).toString());
				textFieldBarnd.setText(myModeal.getValueAt(i, 7).toString());
				textFieldProductName.setText(myModeal.getValueAt(i, 8)
						.toString());
				textFieldMRPPrice.setText(myModeal.getValueAt(i, 9).toString());

				textFieldFreeItem
						.setText(myModeal.getValueAt(i, 10).toString());
				textFieldFreeItemFirstprice.setText(myModeal.getValueAt(i, 11)
						.toString());
				textFieldFreeItemQty.setText(myModeal.getValueAt(i, 12)
						.toString());
				textFieldFreeItemAmount.setText(myModeal.getValueAt(i, 13)
						.toString());
				textFieldQty.setText(myModeal.getValueAt(i, 14).toString());
				comboBoxQty.setSelectedItem(myModeal.getValueAt(i, 15)
						.toString());
				textFieldRateandUnit.setText(myModeal.getValueAt(i, 16)
						.toString());
				textFieldSchPer.setText(myModeal.getValueAt(i, 17).toString());
				textFieldSchAmount.setText(myModeal.getValueAt(i, 18)
						.toString());
				textFieldVatPer.setText(myModeal.getValueAt(i, 19).toString());
				textFieldVatAmount.setText(myModeal.getValueAt(i, 20)
						.toString());
				textFieldContyIntoRate.setText(myModeal.getValueAt(i, 21)
						.toString());

				textFieldDealserName.setEnabled(true);
				textFieldDelarMobileno.setEnabled(true);
				textFieldDealarEmailId.setEnabled(true);

			}
		});

		tableshow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn cols = tableshow.getColumnModel().getColumn(0);
		TableColumn col0 = tableshow.getColumnModel().getColumn(1);
		TableColumn col1 = tableshow.getColumnModel().getColumn(2);
		TableColumn col2 = tableshow.getColumnModel().getColumn(3);
		TableColumn col3 = tableshow.getColumnModel().getColumn(4);
		TableColumn col4 = tableshow.getColumnModel().getColumn(5);

		TableColumn col5 = tableshow.getColumnModel().getColumn(6);
		TableColumn col6 = tableshow.getColumnModel().getColumn(7);
		TableColumn col7 = tableshow.getColumnModel().getColumn(8);
		TableColumn col8 = tableshow.getColumnModel().getColumn(9);
		TableColumn col9 = tableshow.getColumnModel().getColumn(10);
		TableColumn col10 = tableshow.getColumnModel().getColumn(11);
		TableColumn col11 = tableshow.getColumnModel().getColumn(12);
		TableColumn col12 = tableshow.getColumnModel().getColumn(13);
		TableColumn col13 = tableshow.getColumnModel().getColumn(14);

		TableColumn col14 = tableshow.getColumnModel().getColumn(15);
		TableColumn col15 = tableshow.getColumnModel().getColumn(16);
		TableColumn col16 = tableshow.getColumnModel().getColumn(17);
		TableColumn col17 = tableshow.getColumnModel().getColumn(18);
		TableColumn col18 = tableshow.getColumnModel().getColumn(19);
		TableColumn col19 = tableshow.getColumnModel().getColumn(20);
		TableColumn col20 = tableshow.getColumnModel().getColumn(21);
		cols.setPreferredWidth(0);
		cols.setMaxWidth(0);
		cols.setWidth(0);

		col0.setPreferredWidth(70);
		col1.setPreferredWidth(250);
		col2.setPreferredWidth(145);
		col3.setPreferredWidth(150);
		col4.setPreferredWidth(70);

		col5.setPreferredWidth(50);
		col6.setPreferredWidth(70);
		col7.setPreferredWidth(80);

		col8.setPreferredWidth(70);
		col9.setPreferredWidth(100);
		col10.setPreferredWidth(145);
		col11.setPreferredWidth(150);
		col12.setPreferredWidth(70);

		col13.setPreferredWidth(50);
		col14.setPreferredWidth(70);
		col15.setPreferredWidth(80);

		col16.setPreferredWidth(50);
		col17.setPreferredWidth(70);
		col18.setPreferredWidth(80);

		col19.setPreferredWidth(50);
		col20.setPreferredWidth(100);

		scrollPaneTableDataShow = new JScrollPane(tableshow,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTableDataShow.setBounds(0, 0, 1099, 145);
		panel_4.add(scrollPaneTableDataShow);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(0, 575, 1099, 166);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblTransportCharges = new JLabel("Transport Charges:");
		lblTransportCharges.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransportCharges.setBounds(87, 14, 156, 17);
		panel_5.add(lblTransportCharges);

		textFieldTranCharge = new JTextField();
		textFieldTranCharge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					int i = tableshow.getSelectedRow();
					double nettotal = Double.valueOf(textFieldContyIntoRate
							.getText());
					textFieldTotalAmountPay.setText(String.valueOf(nettotal));
					
					double tasfval = Double.valueOf(textFieldTranCharge
							.getText());
					double totalchar = nettotal + tasfval;
					
					textFieldNetAMOUNTWW.setText(String.valueOf(totalchar));
					
					

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='.') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});
		textFieldTranCharge.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTranCharge.setColumns(10);
		textFieldTranCharge.setBounds(253, 11, 159, 23);
		panel_5.add(textFieldTranCharge);

		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s;
					s = "INSERT INTO groarybillingsystem.purchaseeinfomaster VALUES(?,?,?,?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(s);
					ps.setInt(1,
							Integer.parseInt(textFieldSrnumberMaster.getText()));
					ps.setString(2, textFieldDealserName.getText());
					ps.setString(3, textFieldDelarMobileno.getText());
					ps.setString(4, textFieldDealarEmailId.getText());
					ps.setString(5, dateChooserDate.getText());
					ps.setDouble(6, Double.valueOf(textFieldGross.getText()));
					ps.setDouble(7,
							Double.valueOf(textFieldvatAMOUNTWW.getText()));
					ps.setDouble(8,
							Double.valueOf(textFieldSchAMOUTWW.getText()));
					ps.setDouble(9,
							Double.valueOf(textFieldNetAMOUNTWW.getText()));
					ps.setDouble(10,Double.valueOf(textFieldTotalAmountPay.getText()));

					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Data are stored.");
						btnPay.setEnabled(true);
						
						increment();
						tablevalue();

					}

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}

			}

			public void tablevalue() {
				try {

					conn = DBConnection.getConnection();
					st = conn.createStatement();

					for (int i = 0; i <= tableshow.getRowCount(); i++) {
						String Srnomaster = tableshow.getValueAt(i, 0)
								.toString();
						String srno = tableshow.getValueAt(i, 1).toString();
						String delaername = tableshow.getValueAt(i, 2)
								.toString();
						String delaermobileno = tableshow.getValueAt(i, 3)
								.toString();
						String delaeremilid = tableshow.getValueAt(i, 4)
								.toString();
						String date = tableshow.getValueAt(i, 5).toString();
						String category = tableshow.getValueAt(i, 6).toString();
						String barnd = tableshow.getValueAt(i, 7).toString();
						String product = tableshow.getValueAt(i, 8).toString();
						String mrp = tableshow.getValueAt(i, 9).toString();

						String freeitem = tableshow.getValueAt(i, 10)
								.toString();
						String freeiprice = tableshow.getValueAt(i, 11)
								.toString();
						String freeiqty = tableshow.getValueAt(i, 12)
								.toString();
						String freeiamt = tableshow.getValueAt(i, 13)
								.toString();
						String qty = tableshow.getValueAt(i, 14).toString();
						String qtytype = tableshow.getValueAt(i, 15).toString();
						String rateunit = tableshow.getValueAt(i, 16)
								.toString();
						String schper = tableshow.getValueAt(i, 17).toString();
						String schamt = tableshow.getValueAt(i, 18).toString();
						String vatper = tableshow.getValueAt(i, 19).toString();
						String vatamt = tableshow.getValueAt(i, 20).toString();
						String netamt = tableshow.getValueAt(i, 21).toString();

						st.executeUpdate("INSERT INTO groarybillingsystem.purchaseinfo VALUES('"
								+ Srnomaster
								+ "','"
								+ srno
								+ "','"
								+ delaername
								+ "','"
								+ delaermobileno
								+ "','"
								+ delaeremilid
								+ "','"
								+ date
								+ "','"
								+ category
								+ "','"
								+ barnd
								+ "','"
								+ product
								+ "','"
								+ mrp
								+ "','"
								+ freeitem
								+ "','"
								+ freeiprice
								+ "','"
								+ freeiqty
								+ "','"
								+ freeiamt
								+ "','"
								+ qty
								+ "','"
								+ qtytype
								+ "','"
								+ rateunit
								+ "','"
								+ schper
								+ "','"
								+ schamt
								+ "','"
								+ vatper
								+ "','"
								+ vatamt
								+ "','" + netamt + "','"+0+"')");
						
						st.executeUpdate("INSERT INTO groarybillingsystem.stockmantained VALUES(null,'"+product+"-"+qtytype+"','"+barnd+"','"+qty+"','"+0+"','"+freeitem+"','"+freeiqty+"','"+date+"')");
						}
				} catch (SQLException sql) {
					System.out.println(sql.getMessage());
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 45, 104, 42);
		panel_5.add(btnSave);

		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 PurchasePay pa=new PurchasePay();
				 pa.setVisible(true);
				String name=textFieldDealserName.getText();
				String TotalAmt=textFieldTotalAmountPay.getText();
				PurchasePay.textFieldDealerName.setText(name);
				PurchasePay.textFieldTotalAmount.setText(TotalAmt);
				String rambal=PurchasePay.textFieldTotalAmount.getText();
				PurchasePay.textFieldRemainbal.setText(rambal);
				
				
				
			}
		});
		btnPay.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/Pay.png")));
		btnPay.setHorizontalAlignment(SwingConstants.LEADING);
		btnPay.setEnabled(false);
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPay.setBounds(124, 45, 104, 42);
		panel_5.add(btnPay);

		JButton btnNewPurchase = new JButton("New Purchase");
		btnNewPurchase.setIcon(new ImageIcon(Purchase.class.getResource("/ImageButtonIcon/new.jpg")));
		btnNewPurchase.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Purchase pur = new Purchase();
				pur.setVisible(true);

			}
		});
		btnNewPurchase.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewPurchase.setBounds(247, 47, 150, 42);
		panel_5.add(btnNewPurchase);

		JLabel lblGrossAwt = new JLabel("Gross Amt:");
		lblGrossAwt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGrossAwt.setBounds(635, 11, 104, 15);
		panel_5.add(lblGrossAwt);

		textFieldGross = new JTextField();
		textFieldGross.setEnabled(false);
		textFieldGross.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldGross.setColumns(10);
		textFieldGross.setBounds(701, 11, 136, 23);
		panel_5.add(textFieldGross);

		JLabel lblSchAmt_1 = new JLabel("Sch Amt:");
		lblSchAmt_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSchAmt_1.setBounds(635, 48, 104, 15);
		panel_5.add(lblSchAmt_1);

		textFieldSchAMOUTWW = new JTextField();
		textFieldSchAMOUTWW.setEnabled(false);
		textFieldSchAMOUTWW.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSchAMOUTWW.setColumns(10);
		textFieldSchAMOUTWW.setBounds(701, 42, 136, 23);
		panel_5.add(textFieldSchAMOUTWW);

		JLabel lblVatAmt_1 = new JLabel("Vat Amt:");
		lblVatAmt_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVatAmt_1.setBounds(861, 14, 63, 15);
		panel_5.add(lblVatAmt_1);

		textFieldvatAMOUNTWW = new JTextField();
		textFieldvatAMOUNTWW.setEnabled(false);
		textFieldvatAMOUNTWW.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldvatAMOUNTWW.setColumns(10);
		textFieldvatAMOUNTWW.setBounds(922, 14, 136, 23);
		panel_5.add(textFieldvatAMOUNTWW);

		JLabel lblNetAmt = new JLabel("Net Amt:");
		lblNetAmt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNetAmt.setBounds(861, 45, 77, 15);
		panel_5.add(lblNetAmt);

		textFieldNetAMOUNTWW = new JTextField();
		textFieldNetAMOUNTWW.setEnabled(false);
		textFieldNetAMOUNTWW.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldNetAMOUNTWW.setColumns(10);
		textFieldNetAMOUNTWW.setBounds(922, 45, 136, 23);
		panel_5.add(textFieldNetAMOUNTWW);

		JLabel lblNewLabel = new JLabel("Rs.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(839, 13, 23, 15);
		panel_5.add(lblNewLabel);

		JLabel lblRs_1 = new JLabel("Rs.");
		lblRs_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRs_1.setBounds(839, 47, 23, 15);
		panel_5.add(lblRs_1);

		JLabel lblRs_2 = new JLabel("Rs.");
		lblRs_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRs_2.setBounds(1074, 14, 25, 15);
		panel_5.add(lblRs_2);

		JLabel lblRs_3 = new JLabel("Rs.");
		lblRs_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRs_3.setBounds(1075, 49, 24, 15);
		panel_5.add(lblRs_3);

		JLabel lblRs = new JLabel("Rs.");
		lblRs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRs.setBounds(416, 15, 29, 17);
		panel_5.add(lblRs);

		textFieldNetAmount5 = new JTextField();
		textFieldNetAmount5.setEnabled(false);
		textFieldNetAmount5.setBounds(880, 105, 86, 20);
		textFieldNetAmount5.setVisible(false);
		panel_5.add(textFieldNetAmount5);
		textFieldNetAmount5.setColumns(10);

		textFieldContyIntoRate = new JTextField();

		textFieldContyIntoRate.setEnabled(false);
		textFieldContyIntoRate.setColumns(10);
		textFieldContyIntoRate.setBounds(623, 105, 86, 20);
		 textFieldContyIntoRate.setVisible(false);
		panel_5.add(textFieldContyIntoRate);
		
		textFieldTotalAmountPay = new JTextField();
		textFieldTotalAmountPay.setEnabled(false);
		textFieldTotalAmountPay.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTotalAmountPay.setColumns(10);
		textFieldTotalAmountPay.setBounds(416, 105, 159, 23);
		//textFieldTotalAmountPay.setEnabled(false);
		panel_5.add(textFieldTotalAmountPay);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				textFieldDealserName, textFieldDelarMobileno,
				textFieldDealarEmailId, textFieldCategory, textFieldBarnd,
				textFieldProductName, textFieldMRPPrice, textFieldFreeItem,
				textFieldFreeItemFirstprice, textFieldFreeItemQty,
				textFieldQty, comboBoxQty, textFieldRateandUnit,
				textFieldSchPer, textFieldVatPer, butAdd, butResert, butttExit,
				textFieldTranCharge, btnSave, btnPay, contentPane, panel,
				lblPurchase, button, panel_1, lblDelarName, lblMobileNo, label,
				label_1, panel_2, lblCategory, lblBrand, lblProductName,
				lblMrpPrice, lblFreeItem, lblFreeItemQty, lblFreeItemAmt,
				textFieldFreeItemAmount, lblQuantity, lblSch,
				textFieldSchAmount, lblSchAmt, lblVat, lblVatAmt,
				textFieldVatAmount, label_2, label_3, label_4, label_5,
				panel_3, butUpdate, butDelete, panel_4,
				scrollPaneTableDataShow, panel_5, lblTransportCharges,
				btnNewPurchase, lblGrossAwt, textFieldGross, lblSchAmt_1,
				textFieldSchAMOUTWW, lblVatAmt_1, textFieldvatAMOUNTWW,
				lblNetAmt, textFieldNetAMOUNTWW, lblNewLabel, lblRs_1, lblRs_2,
				lblRs_3, lblRs, textFieldNetAmount5, textFieldContyIntoRate }));
	}
}
