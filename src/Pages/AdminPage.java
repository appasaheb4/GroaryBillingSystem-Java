package Pages;

import java.awt.BorderLayout;



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
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

import java.awt.TextArea;



import java.awt.Choice;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JTable;
import javax.swing.JToolBar;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldMobileNo;
	private JTextField textFieldEmailId;
	private JTextField textFieldUserName;
	private JPasswordField passwordFieldPassword_1;
	private JPasswordField passwordFieldAccessPassword;
	private JTextField textFieldType;

	public Connection conn = null;
	public PreparedStatement pre;
	public PreparedStatement update;
	public ResultSet rs;
	public Statement st;
	private JPasswordField passwordFieldConfirmpassword;
	private JTextField textFieldHint;
	private JTextField textFieldSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton buttonUpdate;
	public JButton buttonDelete;
	public JRadioButton rdbtnSerachname;
	public JRadioButton rdbtnSearchForMobile;
	private JTextField textFieldSrNo;
	public String val1;
	private JTextField textFielddate;
	public PreparedStatement ps=null;
	public DefaultTableModel mymodel;
	public TextArea textAreaAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void reset()
	{
		String fileArray = "";
		textFieldName.setText("");
		textAreaAddress.setText("");
		textAreaAddress.append(fileArray.toString());
		textFieldMobileNo.setText("");
		textFieldEmailId.setText("");
		textFieldUserName.setText("");
		passwordFieldPassword_1.setText("");
		passwordFieldPassword_1.setEnabled(true);
		passwordFieldAccessPassword.setText("");
		passwordFieldAccessPassword.setEnabled(true);
		textAreaAddress.setText("");
		
		passwordFieldConfirmpassword.setEnabled(true);
		textFieldHint.setEnabled(true);
	}
	
	public void tableshow() {
		try {
			conn = DBConnection.getConnection();
			String qery = "select * from groarybillingsystem.adminloginpage; ";
			ps = conn.prepareStatement(qery);
			rs = ps.executeQuery();
			while (rs.next()) {
				String type=rs.getString("ColumnTypeName");
				if(type.equals("Admin"))
				{
				
				String data0 = rs.getString("SrNo");
				String data1 = rs.getString("Name");
				String data2 = rs.getString("Address");
				String data3 = rs.getString("MobileNo");
				String data4 = rs.getString("EmailId");
				String data5 = rs.getString("Username");
				String data6 = rs.getString("Date");
				
				mymodel.addRow(
						new Object[] { data0, data1, data2, data3, data4, data5, data6});
				}

			}
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}

	}
	
	
	public void increment() {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn
					.prepareStatement("select max(SrNo) from groarybillingsystem.adminloginpage;");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int val = (rs.getInt(1) + 1);
				val1 = String.valueOf(val);

			}
			textFieldSrNo.setText(val1);

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblAdminPage = new JLabel("Admin Form");
		lblAdminPage.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAdminPage.setBounds(10, 11, 195, 27);
		panel.add(lblAdminPage);

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
		
		textFieldSrNo = new JTextField();
		textFieldSrNo.setEnabled(false);
		textFieldSrNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSrNo.setColumns(10);
		textFieldSrNo.setBounds(215, 10, 279, 28);
		textFieldSrNo.setVisible(false);
		increment();
		panel.add(textFieldSrNo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 56, 1099, 328);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"New Admin Acount Create", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 27, 45, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(434, 24, 61, 17);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblAddress);

		JLabel lblMobileNo = new JLabel("Mobile No:");
		lblMobileNo.setBounds(10, 69, 73, 17);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblMobileNo);

		JLabel lblEmailId = new JLabel("Email  Id:");
		lblEmailId.setBounds(10, 123, 65, 17);
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblEmailId);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(434, 123, 74, 17);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(434, 177, 72, 17);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblPassword);

		JLabel lblAccessPwd = new JLabel("Access Pwd:");
		lblAccessPwd.setBounds(10, 177, 85, 17);
		lblAccessPwd.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblAccessPwd);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 216, 37, 17);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblDate);

		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldName.getText();
				String[] parts = string.split(" ");
				String part1 = parts[0]; 
				textFieldUserName.setText(part1);
			
				
			}
		});
		textFieldName.setBounds(109, 22, 279, 28);
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldMobileNo = new JTextField();
		textFieldMobileNo.addKeyListener(new KeyAdapter() {
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
		textFieldMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldMobileNo.getText().length() == 10) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 10 digit mobile number.");
				
				}
			}
		});
		textFieldMobileNo.setBounds(109, 69, 279, 28);
		textFieldMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMobileNo.setColumns(10);
		panel_1.add(textFieldMobileNo);

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
		textFieldEmailId.setBounds(109, 123, 279, 28);
		textFieldEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailId.setColumns(10);
		panel_1.add(textFieldEmailId);

		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(533, 123, 279, 28);
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUserName.setColumns(10);
		panel_1.add(textFieldUserName);

		passwordFieldPassword_1 = new JPasswordField();
		passwordFieldPassword_1.setBounds(533, 173, 279, 28);
		passwordFieldPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(passwordFieldPassword_1);

		passwordFieldAccessPassword = new JPasswordField();
		passwordFieldAccessPassword.setBounds(109, 177, 279, 28);
		passwordFieldAccessPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(passwordFieldAccessPassword);

		textAreaAddress = new TextArea();
		textAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAddress.setBounds(533, 24, 279, 93);
		panel_1.add(textAreaAddress);

		textFieldType = new JTextField();
		textFieldType.setEditable(false);
		textFieldType.setEnabled(false);
		textFieldType.setText("Admin");
		textFieldType.setBounds(115, 270, 199, 28);
		textFieldType.setVisible(false);
		panel_1.add(textFieldType);
		textFieldType.setColumns(10);

		JLabel lblConfirmPwd = new JLabel("Confirm Pwd:");
		lblConfirmPwd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPwd.setBounds(434, 225, 100, 17);
		panel_1.add(lblConfirmPwd);

		passwordFieldConfirmpassword = new JPasswordField();
		passwordFieldConfirmpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pass=passwordFieldPassword_1.getText().toString();
				String conpass=passwordFieldConfirmpassword.getText().toString();
				if(pass.equals(conpass))
				{
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Plz enter new and confirm password are same.");
				}
			}
		});
		passwordFieldConfirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldConfirmpassword.setBounds(533, 221, 279, 28);
		panel_1.add(passwordFieldConfirmpassword);

		JLabel lblConfirmPassword = new JLabel("Hint:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmPassword.setBounds(434, 270, 100, 17);
		panel_1.add(lblConfirmPassword);

		textFieldHint = new JTextField();
		textFieldHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldHint.setColumns(10);
		textFieldHint.setBounds(533, 266, 279, 28);
		panel_1.add(textFieldHint);
		
		textFielddate = new JTextField();
		textFielddate.setEnabled(false);
		textFielddate.setBounds(109, 216, 279, 28);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		textFielddate.setText(date);
		panel_1.add(textFielddate);
		textFielddate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 395, 1099, 72);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnSave = new JButton("Save");
		btnSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnSave.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/Save.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pass=passwordFieldPassword_1.getText().toString();
					String conpass=passwordFieldConfirmpassword.getText().toString();
					if ( textFieldName.getText().length() != 0&& pass.equals(conpass)) {
						
				
					conn = DBConnection.getConnection();
					String query = "insert into groarybillingsystem.adminloginpage values(?,?,?,?,?,?,?,?,?,?,?)";
					pre = conn.prepareStatement(query);
					pre.setInt(1, Integer.parseInt(textFieldSrNo.getText()));
					pre.setString(2, textFieldName.getText());
					pre.setString(3, textAreaAddress.getText().toString());
					pre.setString(4, textFieldMobileNo.getText());
					pre.setString(5, textFieldEmailId.getText());
					pre.setString(6, textFieldUserName.getText());
					pre.setString(7, passwordFieldConfirmpassword.getText().toString());
					pre.setString(8, passwordFieldAccessPassword.getText()
							.toString());

				
					pre.setString(9, textFieldType.getText());
					pre.setString(10, textFieldHint.getText());
					pre.setString(11, textFielddate.getText());
					int i = pre.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Data are saved.");
					
						increment();
						pre.close();
						conn.close();
					} else {
						JOptionPane.showMessageDialog(null,
								"Data are not saved.");

					}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Plz  Delarname name enter.");
					}
					

				} catch (Exception adm) {
					System.out.println(adm.getMessage());
				}
				
				
				try {

					String data1 = textFieldSrNo.getText();
					int ii = Integer.parseInt(data1);
					int show = ii - 1;
					String dataa = String.valueOf(show);

					String data2 = textFieldName.getText();
				
					String data4 = textAreaAddress.getText();
					String data5 = textFieldMobileNo.getText();
					String data6 = textFieldEmailId.getText();
					String data7 = textFieldUserName.getText();
					String data8 = textFielddate.getText();
			
			

					mymodel.addRow(new Object[] { dataa, data2,  data4, data5, data6, data7, data8});
					reset();

				}

				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 11, 115, 35);
		panel_2.add(btnSave);

		buttonUpdate = new JButton("Update");
		buttonUpdate.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/update.png")));
		buttonUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnSerachname.isSelected()) {
					try {

						conn = DBConnection.getConnection();

						String query = "update groarybillingsystem.adminloginpage set MobileNo= ?,Address=?,EmailId=?,Username=? where Name=?";
						update = conn.prepareStatement(query);

						update.setString(1, textFieldMobileNo.getText());
						update.setString(2, textAreaAddress.getText());
						update.setString(3, textFieldEmailId.getText());
						update.setString(4, textFieldUserName.getText());
						update.setString(5, textFieldSearch.getText());
						// update.setString(6,
						// dateChooserAdmiJoinDate.getDate().toString());
						int ii = update.executeUpdate();
						if (ii > 0) {
							JOptionPane.showMessageDialog(null,
									"Recoard are Updated.");
							update.close();
							conn.close();

						} else {
							JOptionPane.showMessageDialog(null,
									"Recoard are not Updated.");
						}

					} catch (SQLException sq) {
						System.out.println(sq.getMessage());
					}
				
				
				}
				else if (rdbtnSearchForMobile.isSelected()) {

					try {

						conn = DBConnection.getConnection();

						String query = "update groarybillingsystem.adminloginpage set Name= ?,Address=?,EmailId=?,Username=? where MobileNo=?";
						update = conn.prepareStatement(query);

						update.setString(1, textFieldName.getText());
						update.setString(2, textAreaAddress.getText());
						update.setString(3, textFieldEmailId.getText());
						update.setString(4, textFieldUserName.getText());
						update.setString(5, textFieldSearch.getText());
						// update.setString(6,
						// dateChooserAdmiJoinDate.getDate().toString());
						int ii = update.executeUpdate();
						if (ii > 0) {
							JOptionPane.showMessageDialog(null,
									"Recoard are Updated.");
							update.close();
							conn.close();

						} else {
							JOptionPane.showMessageDialog(null,
									"Recoard are not Updated.");
						}

					} catch (SQLException sq) {
						System.out.println(sq.getMessage());
					}
					
				}
				else
				{
					JOptionPane
					.showMessageDialog(null,
							"plz enter name or mobile number and then serarch.");
					
				}
			}
		});
		buttonUpdate.setToolTipText("Plz first Search and then update");
		buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonUpdate.setEnabled(false);
		buttonUpdate.setBounds(135, 11, 115, 34);
		panel_2.add(buttonUpdate);

		 buttonDelete = new JButton("Delete");
		 buttonDelete.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/delete.jpg")));
		 buttonDelete.setHorizontalAlignment(SwingConstants.LEADING);
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSerachname.isSelected()) {
				try {

					conn = DBConnection.getConnection();

					String query = "delete from groarybillingsystem.adminloginpage  where Name=?";
					update = conn.prepareStatement(query);
					update.setString(1, textFieldSearch.getText());
					int iu = update.executeUpdate();
					if (iu > 0) {
						JOptionPane.showMessageDialog(null,
								"Recoard are deleted.");

					} else {
						JOptionPane.showMessageDialog(null,
								"Recoard are not deleted.");

					}

				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				}
				else if (rdbtnSearchForMobile.isSelected()) {
					try {

						conn = DBConnection.getConnection();

						String query = "delete from groarybillingsystem.adminloginpage  where MobileNo=?";
						update = conn.prepareStatement(query);
						update.setString(1, textFieldSearch.getText());
						int iu = update.executeUpdate();
						if (iu > 0) {
							JOptionPane.showMessageDialog(null,
									"Recoard are deleted.");

						} else {
							JOptionPane.showMessageDialog(null,
									"Recoard are not deleted.");

						}

					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
					
							
				}
				else
				{
					JOptionPane
					.showMessageDialog(null,
							"plz enter name or mobile number and then serarch.");
					
					
				}
			}
		});
		buttonDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonDelete.setEnabled(false);
		buttonDelete.setBounds(260, 11, 115, 34);
		panel_2.add(buttonDelete);

		JButton button_4 = new JButton("Reset");
		button_4.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		button_4.setHorizontalAlignment(SwingConstants.LEADING);
		button_4.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(385, 11, 115, 34);
		panel_2.add(button_4);

		JButton button_5 = new JButton("Exit");
		button_5.setHorizontalAlignment(SwingConstants.LEADING);
		button_5.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/Exit.png")));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(510, 11, 115, 34);
		panel_2.add(button_5);

		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(635, 15, 165, 25);
		panel_2.add(textFieldSearch);

		rdbtnSerachname = new JRadioButton("Search for Name");
		buttonGroup.add(rdbtnSerachname);
		rdbtnSerachname.setBounds(806, 11, 134, 23);
		panel_2.add(rdbtnSerachname);

		 rdbtnSearchForMobile = new JRadioButton(
				"Search for mobile no.");
		buttonGroup.add(rdbtnSearchForMobile);
		rdbtnSearchForMobile.setBounds(806, 30, 134, 23);
		panel_2.add(rdbtnSearchForMobile);

		JButton buttonSerach = new JButton("Search");
		buttonSerach.setVerticalAlignment(SwingConstants.TOP);
		buttonSerach.setIcon(new ImageIcon(AdminPage.class.getResource("/ImageButtonIcon/search_100379.jpg")));
		buttonSerach.setHorizontalAlignment(SwingConstants.LEADING);
		buttonSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSerachname.isSelected()) {
					try {

						conn = DBConnection.getConnection();
						String sql = "select * from groarybillingsystem.adminloginpage where Name= ?;";
						pre = conn.prepareStatement(sql);
						pre.setString(1, textFieldSearch.getText());
						rs = pre.executeQuery();
						while (rs.next()) {
							String mob = rs.getString("MobileNo");
							textFieldMobileNo.setText(mob);
							String address = rs.getString("Address");
							textAreaAddress.setText(address);
							String mobileno = rs.getString("MobileNo");
							textFieldMobileNo.setText(mobileno);
							String EmailId = rs.getString("EmailId");
							textFieldEmailId.setText(EmailId);
							String Username = rs.getString("Username");
							textFieldUserName.setText(Username);
							String Password = rs.getString("Password");
							passwordFieldPassword_1.setText(Password);
							String AccessPwd = rs.getString("AccessPwd");
							passwordFieldAccessPassword.setText(AccessPwd);
							String Date = rs.getString("Date");
							textFielddate.setText(Date);
							
							

							passwordFieldPassword_1.setText("");
							passwordFieldPassword_1.setEnabled(false);
							passwordFieldAccessPassword.setText("");
							passwordFieldAccessPassword.setEnabled(false);
						
							
							passwordFieldConfirmpassword.setEnabled(false);
							textFieldHint.setEnabled(false);
							buttonUpdate.setEnabled(true);
							buttonDelete.setEnabled(true);

						}

					} catch (Exception ee) {

					}
				} else if (rdbtnSearchForMobile.isSelected()) {

					try {

						conn = DBConnection.getConnection();
						String sql = "select * from groarybillingsystem.adminloginpage where MobileNo= ?;";
						pre = conn.prepareStatement(sql);
						pre.setString(1, textFieldSearch.getText());
						rs = pre.executeQuery();
						while (rs.next()) {
							String mob = rs.getString("Name");
							textFieldName.setText(mob);
							String address = rs.getString("Address");
							textAreaAddress.setText(address);
							String mobileno = rs.getString("MobileNo");
							textFieldMobileNo.setText(mobileno);
							String EmailId = rs.getString("EmailId");
							textFieldEmailId.setText(EmailId);
							String Username = rs.getString("Username");
							textFieldUserName.setText(Username);
							String Password = rs.getString("Password");
							passwordFieldPassword_1.setText(Password);
							String AccessPwd = rs.getString("AccessPwd");
							passwordFieldAccessPassword.setText(AccessPwd);
							String Date = rs.getString("Date");
							textFielddate.setText(Date);
						
							

							passwordFieldPassword_1.setText("");
							passwordFieldPassword_1.setEnabled(false);
							passwordFieldAccessPassword.setText("");
							passwordFieldAccessPassword.setEnabled(false);
							
							passwordFieldConfirmpassword.setEnabled(false);
							textFieldHint.setEnabled(false);
							buttonUpdate.setEnabled(true);
							buttonDelete.setEnabled(true);

						}

					} catch (Exception ee) {

					}

				} else {
					JOptionPane
							.showMessageDialog(null,
									"plz enter name or mobile number and then serarch.");
				}

			}
		});
		buttonSerach.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonSerach.setBounds(946, 11, 125, 35);
		panel_2.add(buttonSerach);

		String[] columnname = { "Sr NO", "Name", "Address", "MobileNo", "EmailId", "Username",
				"Date" };
		mymodel = new DefaultTableModel(columnname, 0);
		final JTable tableshow=new JTable(mymodel);
		
		JScrollPane scrollPane = new JScrollPane(tableshow);
		scrollPane.setBounds(10, 478, 1079, 252);
		tableshow();
		contentPane.add(scrollPane);
		
		
	}
}
