package Pages;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.TextArea;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import com.mysql.jdbc.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.JTable;
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

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import java.sql.Statement;

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

public class DelarPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldCompanyname;
	private JTextField textFieldCity;
	private JTextField textFieldState;
	private JTextField textFieldLandlinenumber;
	private JTextField textFieldPinCode;
	private JTextField textFieldEmailId;
	private JTextField textFieldMobileNumber;

	public Connection conn = null;
	public PreparedStatement pre;
	public PreparedStatement pre1;
	public PreparedStatement update;
	public ResultSet rs;
	public ResultSet rs1;
	public PreparedStatement ps;
	public Statement st;
	private JTextField textFieldSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rdbtnSerachname;
	public JRadioButton rdbtnSearchForMobile;
	private JTextField textFielddate;
	private JTextField textFieldSrno;

	public double vatrate, vat;
	public static String val1;
	private JTextField dateChooser;
	private JTable tabledelarInformation;

	public String s;
	public DefaultTableModel myModel;
	public TextArea textAreaAddress;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelarPage frame = new DelarPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void incrementautono() {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("select max(SerialNo) from groarybillingsystem.delarinfo;");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int val = (rs.getInt(1) + 1);
				val1 = String.valueOf(val);
			}
			textFieldSrno.setText(val1);

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	public void tableshow() {
		try {
			conn = DBConnection.getConnection();
			String qery = "select * from groarybillingsystem.delarinfo; ";
			ps = conn.prepareStatement(qery);
			rs = ps.executeQuery();
			while (rs.next()) {
				String data0 = rs.getString("SerialNo");
				String data1 = rs.getString("Name");
				String data2 = rs.getString("CompanyName");
				String data3 = rs.getString("Address");
				String data4 = rs.getString("City");
				String data5 = rs.getString("State");
				String data6 = rs.getString("Landline");
				String data7 = rs.getString("Pincode");
				String data8 = rs.getString("EmailId");
				String data9 = rs.getString("MobileNo");
				String data10 = rs.getString("Date");
				myModel.addRow(
						new Object[] { data0, data1, data2, data3, data4, data5, data6, data7, data8, data9, data10 });

			}
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}

	}

	public void reset() {
		String fileArray = "";
		textFieldName.setText("");
		textFieldCompanyname.setText("");
		textAreaAddress.setText("");
		textAreaAddress.append(fileArray.toString());
		textFieldCity.setText("");
		textFieldState.setText("");
		textFieldLandlinenumber.setText("");
		textFieldPinCode.setText("");
		textAreaAddress.setText("");
		textFieldEmailId.setText("");
		textFieldMobileNumber.setText("");
		textFielddate.setVisible(false);
		dateChooser.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public DelarPage() {

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblDelar = new JLabel("DEALER");
		lblDelar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDelar.setBounds(10, 11, 195, 27);
		panel.add(lblDelar);

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
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 47, 1099, 280);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(798, 12, 37, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 44, 45, 17);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(109, 41, 313, 23);
		textFieldName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(466, 44, 115, 17);
		lblCompanyName.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblCompanyName);

		textFieldCompanyname = new JTextField();
		textFieldCompanyname.setBounds(652, 44, 271, 23);
		textFieldCompanyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCompanyname.setColumns(10);
		panel_1.add(textFieldCompanyname);

		JLabel label = new JLabel("Address:");
		label.setBounds(10, 89, 61, 17);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(label);

		textAreaAddress = new TextArea();
		textAreaAddress.setBounds(109, 89, 313, 93);
		textAreaAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(textAreaAddress);

		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(466, 89, 115, 17);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblCity);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(652, 89, 271, 23);
		textFieldCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldCity.setColumns(10);
		panel_1.add(textFieldCity);

		JLabel lblState = new JLabel("State:");
		lblState.setBounds(466, 132, 115, 17);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblState);

		textFieldState = new JTextField();
		textFieldState.setBounds(652, 132, 271, 23);
		textFieldState.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldState.setColumns(10);
		panel_1.add(textFieldState);

		JLabel lblLandline = new JLabel("Landline:");
		lblLandline.setBounds(10, 203, 77, 17);
		lblLandline.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblLandline);

		textFieldLandlinenumber = new JTextField();
		textFieldLandlinenumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				 char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||(c=='-') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }
			}
		});

		textFieldLandlinenumber.setBounds(109, 200, 313, 23);
		textFieldLandlinenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldLandlinenumber.setColumns(10);
		panel_1.add(textFieldLandlinenumber);

		JLabel lblPincode = new JLabel("PinCode:");
		lblPincode.setBounds(466, 242, 115, 17);
		lblPincode.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblPincode);

		textFieldPinCode = new JTextField();
		textFieldPinCode.addKeyListener(new KeyAdapter() {
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
		textFieldPinCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldPinCode.getText().length() == 6) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 6 digit pin code.");
				}
			}
		});
		textFieldPinCode.setBounds(652, 242, 271, 23);
		textFieldPinCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPinCode.setColumns(10);
		panel_1.add(textFieldPinCode);

		JLabel lblEmailid = new JLabel("Email-Id:");
		lblEmailid.setBounds(10, 248, 115, 17);
		lblEmailid.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblEmailid);

		textFieldEmailId = new JTextField();
		textFieldEmailId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (textFieldEmailId.getText().length() != 0) {

					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					String email1 = textFieldEmailId.getText();
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
		textFieldEmailId.setBounds(109, 245, 313, 24);
		textFieldEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldEmailId.setColumns(10);
		panel_1.add(textFieldEmailId);

		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setBounds(466, 197, 115, 17);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblMobileNo);

		textFieldMobileNumber = new JTextField();
		textFieldMobileNumber.addKeyListener(new KeyAdapter() {
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
		textFieldMobileNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (textFieldMobileNumber.getText().length() == 10) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 10 digit mobile number.");
					textFieldMobileNumber.requestFocus();
				}
			}
		});

		textFieldMobileNumber.setBounds(652, 197, 271, 23);
		textFieldMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMobileNumber.setColumns(10);
		panel_1.add(textFieldMobileNumber);

		textFielddate = new JTextField();
		textFielddate.setEnabled(false);
		textFielddate.setBounds(489, 11, 283, 23);
		textFielddate.setVisible(false);
		panel_1.add(textFielddate);
		textFielddate.setColumns(10);

		textFieldSrno = new JTextField();
		textFieldSrno.setEnabled(false);
		textFieldSrno.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSrno.setColumns(10);
		textFieldSrno.setBounds(109, 11, 313, 23);
		incrementautono();
		// textFieldSrno.setVisible(false);
		panel_1.add(textFieldSrno);

		dateChooser = new JTextField();
		dateChooser.setEnabled(false);
		dateChooser.setFont(new Font("Tahoma", Font.BOLD, 18));
		dateChooser.setColumns(10);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		dateChooser.setText(date);
		dateChooser.setBounds(853, 12, 160, 28);
		panel_1.add(dateChooser);

		JLabel lblSrNo = new JLabel("Sr No.");
		lblSrNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSrNo.setBounds(10, 12, 45, 17);
		panel_1.add(lblSrNo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 332, 1099, 60);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdd = new JButton("Save");
		btnAdd.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/Save.png")));
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textFieldMobileNumber.getText().length() == 10 && textFieldName.getText().length() != 0) {

						conn = DBConnection.getConnection();
						String query = "insert into groarybillingsystem.delarinfo values(?,?,?,?,?,?,?,?,?,?,?)";
						pre = conn.prepareStatement(query);
						pre.setInt(1, Integer.parseInt(textFieldSrno.getText()));
						pre.setString(2, textFieldName.getText());
						pre.setString(3, textFieldCompanyname.getText());
						pre.setString(4, textAreaAddress.getText().toString());
						pre.setString(5, textFieldCity.getText());
						pre.setString(6, textFieldState.getText());
						pre.setString(7, textFieldLandlinenumber.getText());
						pre.setString(8, textFieldPinCode.getText());
						pre.setString(9, textFieldEmailId.getText());
						pre.setString(10, textFieldMobileNumber.getText());
						pre.setString(11, dateChooser.getText());
						int i = pre.executeUpdate();
						if (i > 0) {
							JOptionPane.showMessageDialog(null, "Data are saved.");
							myModel.fireTableDataChanged();
							incrementautono();
							reset();
							pre.close();
							conn.close();
						} else {
							JOptionPane.showMessageDialog(null, "Data are not saved.");

						}
					} else {
						JOptionPane.showMessageDialog(null, "Plz enter 10 digit number And Delarname name enter.");
					}

				} catch (Exception adm) {
					System.out.println(adm.getMessage());
				}

				try {

					String data1 = textFieldSrno.getText();
					int ii = Integer.parseInt(data1);
					int show = ii - 1;
					String dataa = String.valueOf(show);

					String data2 = textFieldName.getText();
					String data3 = textFieldCompanyname.getText();
					String data4 = textAreaAddress.getText();
					String data5 = textFieldCity.getText();
					String data6 = textFieldState.getText();
					String data7 = textFieldLandlinenumber.getText();
					String data8 = textFieldPinCode.getText();
					String data9 = textFieldEmailId.getText();
					String data10 = textFieldMobileNumber.getText();
					String data11 = textFielddate.getText();

					myModel.addRow(new Object[] { dataa, data2, data3, data4, data5, data6, data7, data8, data9, data10,
							data11 });

				}

				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(10, 11, 115, 38);
		panel_2.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/update.png")));
		btnUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdate.setToolTipText("Plz first Search and then update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnSerachname.isSelected()) {
					try {

						conn = DBConnection.getConnection();
						String query = "update groarybillingsystem.delarinfo set  CompanyName=?, Address=?,City=?,State=?,Landline=?,Pincode=?,EmailId=?,MobileNo=? where Name=?";
						update = conn.prepareStatement(query);
						update.setString(1, textFieldCompanyname.getText());
						update.setString(2, textAreaAddress.getText().toString());
						update.setString(3, textFieldCity.getText());
						update.setString(4, textFieldState.getText());
						update.setString(5, textFieldLandlinenumber.getText());
						update.setInt(6, Integer.parseInt(textFieldPinCode.getText()));
						update.setString(7, textFieldEmailId.getText());
						update.setString(8, textFieldMobileNumber.getText());
						update.setString(9, textFieldName.getText());
						// update.setString(6,
						// dateChooserAdmiJoinDate.getDate().toString());
						int ii = update.executeUpdate();
						if (ii > 0) {
							JOptionPane.showMessageDialog(null, "Recoard are Updated.");

						} else {
							JOptionPane.showMessageDialog(null, "Recoard are not Updated.");
						}

					} catch (SQLException sq) {
						System.out.println(sq.getMessage());
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(135, 11, 115, 38);
		panel_2.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/delete5.jpg")));
		btnDelete.setHorizontalAlignment(SwingConstants.LEADING);
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					conn = DBConnection.getConnection();

					String query = "delete from groarybillingsystem.delarinfo  where Name=? or MobileNo=?";
					update = conn.prepareStatement(query);
					update.setString(1, textFieldName.getText());
					update.setString(2, textFieldMobileNumber.getText());
					int iu = update.executeUpdate();
					if (iu > 0) {
						JOptionPane.showMessageDialog(null, "Recoard are deleted.");

					} else {
						JOptionPane.showMessageDialog(null, "Recoard are not deleted.");

					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(260, 11, 115, 38);
		panel_2.add(btnDelete);

		JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		btnReset.setHorizontalAlignment(SwingConstants.LEADING);
		btnReset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset();

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(385, 11, 115, 38);
		panel_2.add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(510, 11, 115, 38);
		panel_2.add(btnExit);

		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSearch.setBounds(631, 15, 165, 25);
		panel_2.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		rdbtnSerachname = new JRadioButton("Search for Name");
		buttonGroup.add(rdbtnSerachname);
		rdbtnSerachname.setBounds(802, 11, 134, 23);
		panel_2.add(rdbtnSerachname);

		rdbtnSearchForMobile = new JRadioButton("Search for mobile no.");
		buttonGroup.add(rdbtnSearchForMobile);
		rdbtnSearchForMobile.setBounds(802, 30, 148, 23);
		panel_2.add(rdbtnSearchForMobile);

		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(DelarPage.class.getResource("/ImageButtonIcon/Search2.jpg")));
		btnSearch.setHorizontalAlignment(SwingConstants.LEADING);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSerachname.isSelected()) {
					try {

						conn = DBConnection.getConnection();
						String sql = "select * from groarybillingsystem.delarinfo where Name= ?;";
						pre = conn.prepareStatement(sql);
						pre.setString(1, textFieldSearch.getText());
						rs = pre.executeQuery();
						while (rs.next()) {
							String name = rs.getString("CompanyName");
							textFieldCompanyname.setText(name);
							String address = rs.getString("Address");
							textAreaAddress.setText(address);
							String city = rs.getString("City");
							textFieldCity.setText(city);
							String state = rs.getString("State");
							textFieldState.setText(state);
							String landline = rs.getString("Landline");
							textFieldLandlinenumber.setText(landline);
							String pincode = rs.getString("Pincode");
							textFieldPinCode.setText(pincode);
							String email = rs.getString("EmailId");
							textFieldEmailId.setText(email);
							String mobile = rs.getString("MobileNo");
							textFieldMobileNumber.setText(mobile);
							String date = rs.getString("Date");
							textFielddate.setVisible(true);
							dateChooser.setVisible(false);
							textFielddate.setText(date);
							btnUpdate.setEnabled(true);
							btnDelete.setEnabled(true);
							dateChooser.setEnabled(false);
						}

					} catch (Exception ee) {

					}

				} else if (rdbtnSearchForMobile.isSelected()) {
					try {

						conn = DBConnection.getConnection();
						String sql1 = "select * from groarybillingsystem.dealerinformation where MobileNo= ?;";
						pre1 = conn.prepareStatement(sql1);
						pre1.setString(1, textFieldSearch.getText());
						rs1 = pre1.executeQuery();
						while (rs1.next()) {
							String mobile = rs1.getString("Name");
							textFieldName.setText(mobile);
							String name = rs1.getString("CompanyName");
							textFieldCompanyname.setText(name);
							String address = rs1.getString("Address").toString();
							textAreaAddress.setText(address);
							String city = rs1.getString("City");
							textFieldCity.setText(city);
							String state = rs1.getString("State");
							textFieldState.setText(state);
							String landline = rs1.getString("Landline");
							textFieldLandlinenumber.setText(landline);
							String pincode = rs1.getString("Pincode");
							textFieldPinCode.setText(pincode);
							String email = rs1.getString("EmailId");
							textFieldEmailId.setText(email);
							String date = rs1.getString("Date");
							textFielddate.setVisible(true);
							dateChooser.setVisible(false);
							textFielddate.setText(date);

							btnUpdate.setEnabled(true);
							btnDelete.setEnabled(true);
							dateChooser.setEnabled(false);

						}

					} catch (Exception ee) {

					}

				} else {
					JOptionPane.showMessageDialog(null, "plz enter name or mobile number and then serarch.");
				}

			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(952, 11, 137, 38);
		panel_2.add(btnSearch);
		tabledelarInformation = new JTable();
		// scrollPane.setColumnHeaderView(tabledelarInformation);
		String[] columnname = { "Sr NO", "Dealer Name", "Company Name", "Address", "City", "State", "LandLine No",
				"Pin-code", "Email-Id", "Mobile NO", "Date" };
		myModel = new DefaultTableModel(columnname, 0);
		tabledelarInformation = new JTable(myModel);
		tabledelarInformation.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col0 = tabledelarInformation.getColumnModel().getColumn(0);
		TableColumn col1 = tabledelarInformation.getColumnModel().getColumn(1);
		TableColumn col2 = tabledelarInformation.getColumnModel().getColumn(2);
		TableColumn col3 = tabledelarInformation.getColumnModel().getColumn(3);
		TableColumn col4 = tabledelarInformation.getColumnModel().getColumn(4);

		TableColumn col5 = tabledelarInformation.getColumnModel().getColumn(5);
		TableColumn col6 = tabledelarInformation.getColumnModel().getColumn(6);
		TableColumn col7 = tabledelarInformation.getColumnModel().getColumn(7);
		TableColumn col8 = tabledelarInformation.getColumnModel().getColumn(8);
		TableColumn col9 = tabledelarInformation.getColumnModel().getColumn(8);
		TableColumn col10 = tabledelarInformation.getColumnModel().getColumn(8);

		col0.setPreferredWidth(70);
		col1.setPreferredWidth(200);
		col2.setPreferredWidth(145);
		col3.setPreferredWidth(250);
		col4.setPreferredWidth(100);

		col5.setPreferredWidth(100);
		col6.setPreferredWidth(80);
		col7.setPreferredWidth(70);
		col8.setPreferredWidth(100);
		col9.setPreferredWidth(80);
		col10.setPreferredWidth(80);
		tableshow();

		JScrollPane scrollPane = new JScrollPane(tabledelarInformation, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 417, 1099, 324);
		contentPane.add(scrollPane);

	}
}
