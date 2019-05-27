package Pages;

import java.awt.Dimension;


import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.jws.Oneway;
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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.SimpleTimeZone;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;

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

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class BillDesk extends JFrame {

	private JPanel contentPane;
	public Connection conn = null;

	public static DefaultTableModel myModeal;
	public Connection con = null;
	public Statement st = null;
	public Statement st1 = null;
	public static JButton btnNew;

	public ResultSet rs = null;
	public PreparedStatement ps1 = null;
	public String s;
	public static JTextField textFieldCustomeSrno;
	private JTextField textFieldItemName;
	private static JTextField textFieldTotalAmount;
	private JTextField textFieldBarcode;
	private static JTextField textFieldQty;
	private static JTextField textFieldVaPer;
	private static JTextField textFieldVatAmt;
	private static JTextField textFieldDiscount;
	private static JTextField textFieldNetAmt;
	public String val1;
	private static JTextField textFieldQtyTotalAmount;
	public double totalprice1;
	public double vatrate, vat;
	public PreparedStatement ps;

	public PreparedStatement pre;
	public PreparedStatement pre1;
	public PreparedStatement update;
	public JButton btnReport_1;

	public JComboBox comboBoxQtyType ;
	public ResultSet rs1;
	public String[] data11;
	public static JTable tableshow;
	public JScrollPane scrollPane;
	public static JTextField textFieldDiscounttotal;
	public static JTextField textFieldGrorssAmt;
	public static JTextField textFieldNetAmtTotal;
	public static JTextField textFieldvVatAmtTotal;
	public static JTextField textFieldCustomername;
	public static JTextField textFieldSrNumber;
	public static String customername;
	public static int Srnomaster;
	public int sa;
	
	public static JTextField tfcusmname;
	public static JTextField textFieldBarcodecall;
	public static JTextField textFieldsssssr;
	private JTextField textFieldDate;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillDesk frame = new BillDesk();

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
					.prepareStatement("select max(Srnomaster) from groarybillingsystem.billdiskmaster;");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int val = (rs.getInt(1) + 1);
				val1 = String.valueOf(val);

			}
			textFieldSrNumber.setText(val1);
			String topn = textFieldSrNumber.getText();
			textFieldCustomeSrno.setText("1");

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	public void calculation() {
		Double totalamount = Double.valueOf(textFieldTotalAmount.getText());
		Double qty = Double.valueOf(textFieldQty.getText());
		Double vat = Double.valueOf(textFieldVaPer.getText());
		Double discount = Double.valueOf(textFieldDiscount.getText());

		double totalamountsum = totalamount * qty;
		textFieldQtyTotalAmount.setText(String.valueOf(totalamountsum));

		double vatsum = totalamountsum * vat / 100.0;

		textFieldVatAmt.setText(String.valueOf(vatsum));

		double nettotalsum = totalamountsum + vatsum - discount;

		textFieldNetAmt.setText(String.valueOf(nettotalsum));

	}

	public double getnettotal() {
		int rowcount = tableshow.getRowCount();

		double nettoatl = 0;
		for (int i = 0; i < rowcount; i++) {
			nettoatl = nettoatl + Double.valueOf(tableshow.getValueAt(i, 10).toString());
		}

		return nettoatl;
	}

	public double getvattotal() {
		int rowcount = tableshow.getRowCount();

		double vattotal = 0;
		for (int i = 0; i < rowcount; i++) {
			vattotal = vattotal + Double.valueOf(tableshow.getValueAt(i, 8).toString());

		}

		return vattotal;

	}

	public double getgross() {
		int rowcount = tableshow.getRowCount();

		double gross = 0;
		for (int i = 0; i < rowcount; i++) {
			gross = gross + Double.valueOf(tableshow.getValueAt(i, 3).toString())
					* Double.valueOf(tableshow.getValueAt(i, 5).toString());

		}

		return gross;
	}

	public Double getdiscount() {
		int rowcount = tableshow.getRowCount();
		double sum = 0;
		for (int i = 0; i < rowcount; i++) {
			sum = sum + Double.valueOf(tableshow.getValueAt(i, 9).toString());
		}

		return sum;
	}

	/**
	 * Create the frame.
	 */
	public BillDesk() {
		
		

		setBounds(0, 0, 1378, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1362, 45);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblPurchase = new JLabel("BillDesk");
		lblPurchase.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPurchase.setBounds(10, 11, 195, 27);
		panel.add(lblPurchase);

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
		button.setBounds(1283, -1, 69, 45);
		panel.add(button);
		
		textFieldDate = new JTextField();
		textFieldDate.setEnabled(false);
		textFieldDate.setBounds(1086, 19, 140, 20);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		textFieldDate.setText(date);
		textFieldDate.setVisible(false);
		panel.add(textFieldDate);
		textFieldDate.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1008, 45, 354, 696);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/add.png")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String data0 = textFieldSrNumber.getText();
					String data1 = textFieldCustomeSrno.getText();
					String data2 = textFieldItemName.getText();
					String data3 = textFieldTotalAmount.getText();
					String data4 = textFieldBarcode.getText();
					String data5 = textFieldQty.getText();
					String data6=comboBoxQtyType.getSelectedItem().toString();
					String data7 = textFieldVaPer.getText();
					String data8 = textFieldVatAmt.getText();
					String data9 = textFieldDiscount.getText();
					String data10 = textFieldNetAmt.getText();
					String data11=textFieldDate.getText();

					myModeal.addRow(
							new Object[] { data0, data1, data2, data3, data4, data5, data6, data7, data8, data9,data10,data11});

					textFieldDiscounttotal.setText(Double.toString(getdiscount()));
					textFieldGrorssAmt.setText(Double.toString(getgross()));
					textFieldvVatAmtTotal.setText(Double.toString(getvattotal()));
					textFieldNetAmtTotal.setText(Double.toString(getnettotal()));
					textFieldCustomername.setEnabled(false);
					int ia = Integer.parseInt(textFieldCustomeSrno.getText());
					ia = ia + 1;
					String srcousmerr = String.valueOf(ia);
					textFieldCustomeSrno.setText(srcousmerr);
					reset();
				}

				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}

		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(10, 340, 143, 35);
		panel_1.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdate.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/update.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = tableshow.getSelectedRow();

				if (i >= 0) {
					myModeal.setValueAt(textFieldSrNumber.getText(), i, 0);
					myModeal.setValueAt(textFieldCustomeSrno.getText(), i, 1);
					myModeal.setValueAt(textFieldItemName.getText(), i, 2);
					myModeal.setValueAt(textFieldTotalAmount.getText(), i, 3);
					myModeal.setValueAt(textFieldBarcode.getText(), i, 4);
					myModeal.setValueAt(textFieldQty.getText(), i, 5);
					myModeal.setValueAt(textFieldVaPer.getText(), i, 6);
					myModeal.setValueAt(textFieldVatAmt.getText(), i, 7);
					myModeal.setValueAt(textFieldDiscount.getText(), i, 8);
					myModeal.setValueAt(textFieldNetAmt.getText(), i, 9);

					textFieldDiscounttotal.setText(Double.toString(getdiscount()));
					textFieldGrorssAmt.setText(Double.toString(getgross()));
					textFieldvVatAmtTotal.setText(Double.toString(getvattotal()));
					textFieldNetAmtTotal.setText(Double.toString(getnettotal()));

				} else {
					System.out.println("Update Error");
				}

			}
		});

		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(195, 340, 149, 35);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/delete.jpg")));
		btnDelete.setHorizontalAlignment(SwingConstants.LEADING);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int[] rows = tableshow.getSelectedRows();
					TableModel tm = tableshow.getModel();

					while (rows.length > 0) {
						((DefaultTableModel) tm).removeRow(tableshow.convertRowIndexToModel(rows[0]));

						rows = tableshow.getSelectedRows();
					}

					for (int i = 0; i < tableshow.getRowCount(); i++) {
						tableshow.setValueAt(Integer.toString(i + 1), i, 1);
					}
					tableshow.clearSelection();
					textFieldDiscounttotal.setText(Double.toString(getdiscount()));
					textFieldGrorssAmt.setText(Double.toString(getgross()));
					textFieldvVatAmtTotal.setText(Double.toString(getvattotal()));
					textFieldNetAmtTotal.setText(Double.toString(getnettotal()));
					reset();
				} catch (Exception qe) {
					// TODO: handle exception
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(195, 397, 149, 35);
		panel_1.add(btnDelete);

		JButton btnPayvoacher = new JButton("PayVoucher");
		btnPayvoacher.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/PayVoacher3.jpg")));
		btnPayvoacher.setHorizontalAlignment(SwingConstants.LEADING);
		btnPayvoacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPayvoacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayVoucher pv = new PayVoucher();
				pv.setVisible(true);
			}
		});
		btnPayvoacher.setBounds(10, 443, 143, 35);
		panel_1.add(btnPayvoacher);

		JButton btnPayDebitcriditCard = new JButton("Pay Debit/Cridit Card");
		btnPayDebitcriditCard.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/PayCard.jpg")));
		btnPayDebitcriditCard.setHorizontalAlignment(SwingConstants.LEADING);
		btnPayDebitcriditCard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPayDebitcriditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayCridit_DibitCardDialog pcd = new PayCridit_DibitCardDialog();
				pcd.setVisible(true);
			}
		});
		btnPayDebitcriditCard.setBounds(195, 443, 149, 35);
		panel_1.add(btnPayDebitcriditCard);

		JButton btnPaybycopan = new JButton("PayByCopan");
		btnPaybycopan.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/PayVoacher.png")));
		btnPaybycopan.setHorizontalAlignment(SwingConstants.LEADING);
		btnPaybycopan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPaybycopan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayByCoupan pbc = new PayByCoupan();
				pbc.setVisible(true);
			}
		});
		btnPaybycopan.setBounds(10, 489, 143, 35);
		panel_1.add(btnPaybycopan);

		JButton btnPaybycopan_1 = new JButton("Gift Copan");
		btnPaybycopan_1.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/PayVoacher4.png")));
		btnPaybycopan_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnPaybycopan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPaybycopan_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GifitVoucher gv = new GifitVoucher();
				gv.setVisible(true);
			}
		});
		btnPaybycopan_1.setBounds(195, 489, 149, 35);
		panel_1.add(btnPaybycopan_1);

		JButton btnBarcodeScan = new JButton("Barcode Scan");
		btnBarcodeScan.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/BarcodeScan3.jpg")));
		btnBarcodeScan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBarcodeScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcall=BillDesk.textFieldBarcodecall.getText();
				String one="1";

				if (barcall.equals(one)) {
					ItemNamewithBarcode ib = new ItemNamewithBarcode();
					ib.setVisible(true);
					String nameee=BillDesk.tfcusmname.getText();
					ItemNamewithBarcode.textFieldCustomername.setText(nameee);
					
				
				} else {
					
					
					
					
					ItemNamewithBarcode ib = new ItemNamewithBarcode();
					ib.setVisible(true);

				}
			}
		});
		btnBarcodeScan.setBounds(10, 535, 334, 75);
		panel_1.add(btnBarcodeScan);

		textFieldCustomeSrno = new JTextField();
		textFieldCustomeSrno.setEnabled(false);
		textFieldCustomeSrno.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldCustomeSrno.setBounds(131, 45, 183, 20);
		panel_1.add(textFieldCustomeSrno);
		textFieldCustomeSrno.setColumns(10);

		JLabel lblNewLabel = new JLabel("Sr No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 45, 89, 17);
		panel_1.add(lblNewLabel);

		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemName.setBounds(10, 101, 89, 17);
		panel_1.add(lblItemName);

		JLabel lblTotalAmt = new JLabel("Total Amt:");
		lblTotalAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalAmt.setBounds(10, 126, 89, 17);
		panel_1.add(lblTotalAmt);

		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBarcode.setBounds(10, 154, 89, 17);
		panel_1.add(lblBarcode);

		JLabel lblQty = new JLabel("Qty:");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQty.setBounds(10, 182, 89, 17);
		panel_1.add(lblQty);

		JLabel lblVat = new JLabel("Vat %:");
		lblVat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVat.setBounds(10, 238, 89, 17);
		panel_1.add(lblVat);

		JLabel lblVatAmt = new JLabel("Vat Amt:");
		lblVatAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVatAmt.setBounds(10, 266, 89, 17);
		panel_1.add(lblVatAmt);

		JLabel lblNetAmtt = new JLabel("Net Amtt:");
		lblNetAmtt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNetAmtt.setBounds(10, 294, 89, 17);
		panel_1.add(lblNetAmtt);

		JLabel lblDiscount = new JLabel("Discount:");
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiscount.setBounds(10, 210, 89, 17);
		panel_1.add(lblDiscount);

		textFieldItemName = new JTextField();
		textFieldItemName.setColumns(10);
		textFieldItemName.setBounds(131, 104, 183, 20);
		panel_1.add(textFieldItemName);

		textFieldTotalAmount = new JTextField();
		textFieldTotalAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calculation();
			}
		});
		textFieldTotalAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calculation();
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
		textFieldTotalAmount.setColumns(10);
		textFieldTotalAmount.setBounds(131, 129, 183, 20);
		panel_1.add(textFieldTotalAmount);

		textFieldBarcode = new JTextField();
		textFieldBarcode.setColumns(10);
		textFieldBarcode.setBounds(131, 157, 183, 20);
		panel_1.add(textFieldBarcode);

		textFieldQty = new JTextField();
		textFieldQty.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calculation();
			}
		});
		textFieldQty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calculation();
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
		textFieldQty.setText("1");

		textFieldQty.setColumns(10);
		textFieldQty.setBounds(131, 185, 70, 20);
		panel_1.add(textFieldQty);

		textFieldVaPer = new JTextField();
		textFieldVaPer.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calculation();
			}
		});
		textFieldVaPer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calculation();
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
		textFieldVaPer.setText("0");

		textFieldVaPer.setColumns(10);
		textFieldVaPer.setBounds(131, 241, 183, 20);
		panel_1.add(textFieldVaPer);

		textFieldVatAmt = new JTextField();
		textFieldVatAmt.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldVatAmt.setEnabled(false);
		textFieldVatAmt.setColumns(10);
		textFieldVatAmt.setBounds(131, 269, 183, 20);
		panel_1.add(textFieldVatAmt);

		textFieldDiscount = new JTextField();
		textFieldDiscount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				calculation();
			}
		});
		textFieldDiscount.setText("0");
		textFieldDiscount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				calculation();

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
		textFieldDiscount.setColumns(10);
		textFieldDiscount.setBounds(131, 213, 183, 20);
		panel_1.add(textFieldDiscount);

		textFieldNetAmt = new JTextField();
		textFieldNetAmt.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldNetAmt.setEnabled(false);
		textFieldNetAmt.setColumns(10);
		textFieldNetAmt.setBounds(131, 297, 183, 20);
		panel_1.add(textFieldNetAmt);

		textFieldQtyTotalAmount = new JTextField();
		textFieldQtyTotalAmount.setText((String) null);
		textFieldQtyTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldQtyTotalAmount.setEnabled(false);
		textFieldQtyTotalAmount.setColumns(10);
		textFieldQtyTotalAmount.setBounds(10, 11, 183, 20);
		textFieldQtyTotalAmount.setVisible(false);
		panel_1.add(textFieldQtyTotalAmount);

		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		btnReset.setHorizontalAlignment(SwingConstants.LEADING);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(10, 397, 143, 35);
		panel_1.add(btnReset);

		JLabel lblCustmor = new JLabel("Customer Name:");
		lblCustmor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustmor.setBounds(10, 73, 104, 17);
		panel_1.add(lblCustmor);

		textFieldCustomername = new JTextField();
		textFieldCustomername.setColumns(10);
		textFieldCustomername.setBounds(131, 76, 183, 20);
		textFieldCustomername.requestFocus();
		panel_1.add(textFieldCustomername);

		textFieldSrNumber = new JTextField();
		textFieldSrNumber.setEnabled(false);
		textFieldSrNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldSrNumber.setColumns(10);
		textFieldSrNumber.setBounds(161, 11, 183, 20);
		textFieldSrNumber.setVisible(false);
		increment();
		panel_1.add(textFieldSrNumber);

		
		
		tfcusmname = new JTextField();
		tfcusmname.setEnabled(false);
		tfcusmname.setColumns(10);
		tfcusmname.setBounds(107, 640, 86, 20);
		tfcusmname.setVisible(false);
		panel_1.add(tfcusmname);
		
		textFieldBarcodecall = new JTextField();
		textFieldBarcodecall.setEnabled(false);
		textFieldBarcodecall.setBounds(228, 640, 86, 20);
		textFieldBarcodecall.setVisible(false);
		panel_1.add(textFieldBarcodecall);
		textFieldBarcodecall.setColumns(10);
		
		textFieldsssssr = new JTextField();
		textFieldsssssr.setEnabled(false);
		textFieldsssssr.setBounds(161, 665, 86, 20);
		textFieldsssssr.setVisible(false);
		panel_1.add(textFieldsssssr);
		textFieldsssssr.setColumns(10);
		
	 comboBoxQtyType = new JComboBox();
		comboBoxQtyType.setModel(new DefaultComboBoxModel(new String[] {"nos", "mgm", "gm", "kg", "ml", "lit"}));
		comboBoxQtyType.setBounds(210, 185, 104, 20);
		panel_1.add(comboBoxQtyType);

		JPanel panelTableShow = new JPanel();
		panelTableShow.setBounds(0, 45, 998, 696);
		contentPane.add(panelTableShow);

		panelTableShow.setLayout(null);
		String[] columnname = { "SrNo_Master", "Sr NO", "Item Name", "Total Amt", "Barcode", "Qty","Qty Type", "Vat%", "Vat Amt",
				"Discount", "Net Amt","Date" };
		myModeal = new DefaultTableModel(columnname, 0);
		tableshow = new JTable(myModeal);
		tableshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tableshow.getSelectedRow();
				myModeal = (DefaultTableModel) tableshow.getModel();
				textFieldSrNumber.setText(myModeal.getValueAt(i, 0).toString());
				textFieldCustomeSrno.setText(myModeal.getValueAt(i, 1).toString());
				textFieldItemName.setText(myModeal.getValueAt(i, 2).toString());
				textFieldTotalAmount.setText(myModeal.getValueAt(i, 3).toString());
				textFieldBarcode.setText(myModeal.getValueAt(i, 4).toString());
				textFieldQty.setText(myModeal.getValueAt(i, 5).toString());
				comboBoxQtyType.setSelectedItem(myModeal.getValueAt(i, 6));
				textFieldVaPer.setText(myModeal.getValueAt(i, 7).toString());
				textFieldVatAmt.setText(myModeal.getValueAt(i, 8).toString());
				textFieldDiscount.setText(myModeal.getValueAt(i, 9).toString());
				textFieldNetAmt.setText(myModeal.getValueAt(i, 10).toString());
				
				textFieldCustomername.setText("This name");
				textFieldCustomername.setEnabled(false);
				
				

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

		cols.setPreferredWidth(0);
		cols.setMaxWidth(0);
		cols.setWidth(0);
		cols.setMinWidth(0);

		col0.setPreferredWidth(70);
		col1.setPreferredWidth(250);
		col2.setPreferredWidth(145);
		col3.setPreferredWidth(150);
		col4.setPreferredWidth(70);

		col5.setPreferredWidth(50);
		col6.setPreferredWidth(70);
		col7.setPreferredWidth(80);
		col8.setPreferredWidth(100);
		scrollPane = new JScrollPane(tableshow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scrollPane.setBounds(10, 0, 988, 449);
		panelTableShow.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 460, 988, 225);
		panelTableShow.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Gross Amt:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(514, 11, 104, 15);
		panel_2.add(label);

		JLabel lblDiscountAmt = new JLabel("Discount Amt:");
		lblDiscountAmt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDiscountAmt.setBounds(514, 48, 104, 15);
		panel_2.add(lblDiscountAmt);

		textFieldDiscounttotal = new JTextField();
		textFieldDiscounttotal.setForeground(Color.BLUE);
		textFieldDiscounttotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldDiscounttotal.setEnabled(false);
		textFieldDiscounttotal.setColumns(10);
		textFieldDiscounttotal.setBounds(590, 42, 147, 28);
		panel_2.add(textFieldDiscounttotal);

		textFieldGrorssAmt = new JTextField();
		textFieldGrorssAmt.setForeground(Color.BLUE);
		textFieldGrorssAmt.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldGrorssAmt.setEnabled(false);
		textFieldGrorssAmt.setColumns(10);
		textFieldGrorssAmt.setBounds(590, 11, 147, 28);
		panel_2.add(textFieldGrorssAmt);

		JLabel label_2 = new JLabel("Vat Amt:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(740, 14, 63, 15);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("Net Amt:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(740, 45, 77, 15);
		panel_2.add(label_3);

		textFieldNetAmtTotal = new JTextField();
		textFieldNetAmtTotal.setForeground(Color.BLUE);
		textFieldNetAmtTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldNetAmtTotal.setEnabled(false);
		textFieldNetAmtTotal.setColumns(10);
		textFieldNetAmtTotal.setBounds(801, 45, 141, 28);
		panel_2.add(textFieldNetAmtTotal);

		textFieldvVatAmtTotal = new JTextField();
		textFieldvVatAmtTotal.setForeground(Color.BLUE);
		textFieldvVatAmtTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		textFieldvVatAmtTotal.setEnabled(false);
		textFieldvVatAmtTotal.setColumns(10);
		textFieldvVatAmtTotal.setBounds(801, 14, 141, 28);
		panel_2.add(textFieldvVatAmtTotal);

		JLabel label_4 = new JLabel("Rs.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(718, 13, 23, 15);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel("Rs.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(718, 47, 23, 15);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel("Rs.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(953, 14, 25, 15);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel("Rs.");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_7.setBounds(954, 49, 24, 15);
		panel_2.add(label_7);

		JButton button_1 = new JButton("Save");
		button_1.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/Save.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEADING);
		button_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					String s;
					s = "INSERT INTO groarybillingsystem.billdiskmaster VALUES(?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(s);
					ps.setInt(1, Integer.parseInt(textFieldSrNumber.getText()));
					ps.setString(2, textFieldCustomername.getText());
					ps.setDouble(3, Double.valueOf(textFieldGrorssAmt.getText()));
					;
					ps.setDouble(4, Double.valueOf(textFieldvVatAmtTotal.getText()));
					ps.setDouble(5, Double.valueOf(textFieldDiscounttotal.getText()));
					ps.setDouble(6, Double.valueOf(textFieldNetAmtTotal.getText()));
					ps.setString(7, textFieldDate.getText());
					int i = ps.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Data are stored.");
						textFieldBarcodecall.setText("");
						textFieldsssssr.setText("");
						tfcusmname.setText("");
						btnReport_1.setEnabled(true);
						tablevalue();
					
						reset();
						increment();

					}

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
			}

			private void tablevalue() {
				try {

					customername = textFieldCustomername.getText();
					conn = DBConnection.getConnection();
					st = conn.createStatement();

					for (int i = 1; i <= tableshow.getRowCount(); i++) {
						String Srnomaster = tableshow.getValueAt(i, 0).toString();
						String CusmSrno = tableshow.getValueAt(i, 1).toString();
						String ItemName = tableshow.getValueAt(i, 2).toString();
						String TotalAmount = tableshow.getValueAt(i, 3).toString();
						String Barcode = tableshow.getValueAt(i, 4).toString();
						String Quantity = tableshow.getValueAt(i, 5).toString();
						String qtytype=tableshow.getValueAt(i, 6).toString();
						String Vat = tableshow.getValueAt(i, 7).toString();
						String VatAmount = tableshow.getValueAt(i, 8).toString();
						String Discount = tableshow.getValueAt(i, 9).toString();
						String NetAmount = tableshow.getValueAt(i, 10).toString();
						String date=tableshow.getValueAt(i, 11).toString();
						

						st.executeUpdate("INSERT INTO groarybillingsystem.billldesk VALUES('" + Srnomaster + "','"
								+ CusmSrno + "','" + customername + "','" + ItemName + "','" + TotalAmount + "','"
								+ Barcode + "','" + Quantity + "','" + Vat + "','" + VatAmount + "','" + Discount
								+ "','" + NetAmount + "','"+qtytype+"','"+date+"')");
					}
				} catch (SQLException sql) {
					System.out.println(sql.getMessage());
				}

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(166, 28, 105, 42);
		panel_2.add(button_1);

		btnReport_1 = new JButton("Report");
		btnReport_1.setEnabled(false);
		btnReport_1.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/Report4d.png")));
		btnReport_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
					int paravalue=Integer.parseInt(textFieldSrNumber.getText());
					HashMap para=new HashMap();
					para.put("SrMaster", paravalue);
						Reports r = new Reports("TAX INVOICE",
								"src/Reports/CustomerBillTaxInvoice.jasper",para);
						r.setBounds(2,2, 1360, 800);
						r.setVisible(true);
					
			}
				catch(Exception ew)
				{
					ew.printStackTrace();
				}
			}
		});
		btnReport_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport_1.setBounds(297, 28, 126, 42);
		panel_2.add(btnReport_1);

		btnNew = new JButton("New");
		btnNew.setIcon(new ImageIcon(BillDesk.class.getResource("/ImageButtonIcon/new.jpg")));
		btnNew.setHorizontalAlignment(SwingConstants.LEADING);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCustomername.setText("");
				textFieldCustomername.setEnabled(true);
				textFieldGrorssAmt.setText("");
				textFieldDiscounttotal.setText("");
				textFieldNetAmtTotal.setText("");
				textFieldvVatAmtTotal.setText("");
				textFieldBarcodecall.setText("");
				textFieldsssssr.setText("");
				tfcusmname.setText("");
				increment();
				myModeal.setRowCount(0);
				reset();
			}
		});
		btnNew.setBounds(35, 30, 104, 40);
		panel_2.add(btnNew);

	}

	public void reset() {

		textFieldItemName.setText("");
		textFieldTotalAmount.setText("0");
		textFieldBarcode.setText("");
		textFieldQty.setText("1");
		textFieldVaPer.setText("0");
		textFieldVatAmt.setText("");
		textFieldDiscount.setText("0");
		textFieldNetAmt.setText("");
	}
}
