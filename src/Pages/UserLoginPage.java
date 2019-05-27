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
import javax.swing.JTextField;

import java.awt.TextArea;

import javax.swing.JPasswordField;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.ButtonGroup;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class UserLoginPage extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldName;
	private JTextField textFieldMobileNo;
	private JTextField textFieldEmailId;
	private JTextField textFieldUserName;
	public static JPasswordField passwordFieldPassword1;
	private JTextField textFieldType;
	private JTextField dateChooserAdmiJoinDate;
	public Connection conn = null;
	public PreparedStatement pre;
	public PreparedStatement update;
	public ResultSet rs;
	public Statement st;
	public static JPasswordField passwordFieldPasswordConfirm;
	private JTextField textFieldHint;
	private JTextField textFieldSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldSrno;
	public String val1;
	public TextArea textAreaAddress;
	public DefaultTableModel mymodel;
	public PreparedStatement ps;



	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginPage frame = new UserLoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void tableshow() {
		try {
			conn = DBConnection.getConnection();
			String qery = "select * from groarybillingsystem.userloginpage; ";
			ps = conn.prepareStatement(qery);
			rs = ps.executeQuery();
			while (rs.next()) {
				String type=rs.getString("ColumnTypeName");
				if(type.equals("User"))
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
					.prepareStatement("select max(Srno) from groarybillingsystem.userloginpage;");
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
	public void reset()
	{
		String fileArray="";
		textFieldName.setText("");
		textAreaAddress.setText("");
		textAreaAddress.append(fileArray.toString());
		textFieldMobileNo.setText("");
		textFieldEmailId.setText("");
		textFieldUserName.setText("");
		passwordFieldPassword1.setText("");
		passwordFieldPassword1.setEnabled(true);

		textAreaAddress.setText("");
	
		passwordFieldPasswordConfirm.setText("");
		textFieldHint.setText("");
		passwordFieldPasswordConfirm.setEnabled(true);
		textFieldHint.setEnabled(true);
	}

	/**
	 * Create the frame.
	 */
	public UserLoginPage() {
		
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);
		

		JLabel lblUserForm = new JLabel("User Form");
		lblUserForm.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserForm.setBounds(10, 11, 195, 27);
		panel.add(lblUserForm);

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
		
		textFieldSrno = new JTextField();
		textFieldSrno.setEnabled(false);
		textFieldSrno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSrno.setColumns(10);
		textFieldSrno.setBounds(177, 11, 279, 28);
		textFieldSrno.setVisible(false);
		increment();
		panel.add(textFieldSrno);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 51, 1099, 324);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"New User Acount Create", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 37, 45, 17);
		panel_1.add(label);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldName.setColumns(10);
		textFieldName.setBounds(109, 32, 279, 28);
		panel_1.add(textFieldName);

		JLabel label_1 = new JLabel("Address:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(506, 32, 61, 17);
		panel_1.add(label_1);

	 textAreaAddress = new TextArea();
		textAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAddress.setBounds(605, 33, 279, 93);
		panel_1.add(textAreaAddress);

		JLabel label_2 = new JLabel("Mobile No:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 91, 73, 17);
		panel_1.add(label_2);

		textFieldMobileNo = new JTextField();
		textFieldMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldMobileNo.getText().length() == 10) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 10 digit mobile number.");
				
				}
			}
		});
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
		
		textFieldMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMobileNo.setColumns(10);
		textFieldMobileNo.setBounds(109, 91, 279, 28);
		panel_1.add(textFieldMobileNo);

		JLabel label_3 = new JLabel("Email  Id:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 147, 65, 17);
		panel_1.add(label_3);

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
		textFieldEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailId.setColumns(10);
		textFieldEmailId.setBounds(109, 147, 279, 28);
		panel_1.add(textFieldEmailId);

		JLabel label_4 = new JLabel("Username:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(10, 200, 74, 17);
		panel_1.add(label_4);

		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(109, 200, 279, 28);
		panel_1.add(textFieldUserName);

		JLabel label_5 = new JLabel("Password:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_5.setBounds(506, 151, 72, 17);
		panel_1.add(label_5);

		passwordFieldPassword1 = new JPasswordField();
		passwordFieldPassword1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldPassword1.setBounds(605, 147, 279, 28);
		panel_1.add(passwordFieldPassword1);

		JLabel label_6 = new JLabel("Date:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(10, 239, 37, 17);
		panel_1.add(label_6);

		textFieldType = new JTextField();
		textFieldType.setEnabled(false);
		textFieldType.setText("User");
		textFieldType.setBounds(146, 302, 240, 17);
		textFieldType.setVisible(false);
		panel_1.add(textFieldType);
		textFieldType.setColumns(10);

		dateChooserAdmiJoinDate = new JTextField();
		dateChooserAdmiJoinDate.setEnabled(false);
		dateChooserAdmiJoinDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateChooserAdmiJoinDate.setBounds(109, 246, 279, 28);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		dateChooserAdmiJoinDate.setText(date);
		
		panel_1.add(dateChooserAdmiJoinDate);
		dateChooserAdmiJoinDate.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 32, 287, 28);

		panel_1.add(scrollPane);

		JLabel lblConfrimPwd = new JLabel("Confrim Pwd:");
		lblConfrimPwd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfrimPwd.setBounds(506, 193, 102, 17);
		panel_1.add(lblConfrimPwd);

		passwordFieldPasswordConfirm = new JPasswordField();
		passwordFieldPasswordConfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String oldpa=passwordFieldPassword1.getText().toString();
				 String newpass=passwordFieldPasswordConfirm.getText().toString();

				if(oldpa.equals(newpass))
				{
			
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Plz enter new and confrim password are same.");
				}
			}
		});
		
		passwordFieldPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordFieldPasswordConfirm.setBounds(605, 189, 279, 28);
		panel_1.add(passwordFieldPasswordConfirm);

		JLabel lblHint = new JLabel("Hint:");
		lblHint.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHint.setBounds(506, 244, 45, 17);
		panel_1.add(lblHint);

		textFieldHint = new JTextField();
		textFieldHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldHint.setColumns(10);
		textFieldHint.setBounds(605, 239, 279, 28);
		panel_1.add(textFieldHint);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 386, 1099, 62);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String oldpa=passwordFieldPassword1.getText().toString();
					 String newpass=passwordFieldPasswordConfirm.getText().toString();
					if(oldpa.equals(newpass))
					{

					conn = DBConnection.getConnection();
					String query = "insert into groarybillingsystem.userloginpage values(?,?,?,?,?,?,?,?,?,?)";
					pre = conn.prepareStatement(query);
					pre.setInt(1, Integer.parseInt(textFieldSrno.getText()));
					pre.setString(2, textFieldName.getText());
					pre.setString(3, textAreaAddress.getText());
					pre.setString(4, textFieldMobileNo.getText());
					pre.setString(5, textFieldEmailId.getText());
					pre.setString(6, textFieldUserName.getText());
					pre.setString(7, passwordFieldPasswordConfirm.getText().toString());
					pre.setString(8, dateChooserAdmiJoinDate.getText());
					pre.setString(9, textFieldType.getText());
					pre.setString(10, textFieldHint.getText());
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
						JOptionPane.showConfirmDialog(null, "Old password and new password are not match.");
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
				
					String data4 = textAreaAddress.getText();
					String data5 = textFieldMobileNo.getText();
					String data6 = textFieldEmailId.getText();
					String data7 = textFieldUserName.getText();
					String data8 = dateChooserAdmiJoinDate.getText();
			
			

					mymodel.addRow(new Object[] { dataa, data2,  data4, data5, data6, data7, data8});
					reset();

				}

				catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 11, 115, 42);
		panel_2.add(btnSave);
		
		JButton buttonUpdate_1 = new JButton("Update");
		buttonUpdate_1.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/update.png")));
		buttonUpdate_1.setHorizontalAlignment(SwingConstants.LEADING);
		buttonUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					conn = DBConnection.getConnection();

					String query = "update groarybillingsystem.userloginpage set Name= ?,Address=?,EmailId=?,Username=? where MobileNo=?";
					update = conn.prepareStatement(query);

					update.setString(1, textFieldName.getText());
					update.setString(2, textAreaAddress.getText());
					update.setString(3, textFieldEmailId.getText());
					update.setString(4, textFieldUserName.getText());
					update.setString(5, textFieldMobileNo.getText());
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
		});
		buttonUpdate_1.setToolTipText("Plz first Search and then update");
		buttonUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonUpdate_1.setEnabled(false);
		buttonUpdate_1.setBounds(135, 11, 115, 42);
		panel_2.add(buttonUpdate_1);
		
		JButton buttonDelte = new JButton("Delete");
		buttonDelte.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/delete.jpg")));
		buttonDelte.setHorizontalAlignment(SwingConstants.LEADING);
		buttonDelte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					conn = DBConnection.getConnection();

					String query = "delete from groarybillingsystem.userloginpage  where MobileNo=?";
					update = conn.prepareStatement(query);
					update.setString(1, textFieldMobileNo.getText());
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
		});
		buttonDelte.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonDelte.setEnabled(false);
		buttonDelte.setBounds(260, 11, 115, 42);
		panel_2.add(buttonDelte);
		
		JButton button_4 = new JButton("Reset");
		button_4.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		button_4.setHorizontalAlignment(SwingConstants.LEADING);
		button_4.addActionListener(new ActionListener() {
			String fileArray="";
			public void actionPerformed(ActionEvent e) {
				reset();

				
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(385, 11, 115, 42);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("Exit");
		button_5.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/Exit.png")));
		button_5.setHorizontalAlignment(SwingConstants.LEADING);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(510, 11, 115, 42);
		panel_2.add(button_5);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(635, 15, 165, 25);
		panel_2.add(textFieldSearch);
		
		JRadioButton rdbtnSerachname = new JRadioButton("Search for Name");
		buttonGroup.add(rdbtnSerachname);
		rdbtnSerachname.setBounds(806, 11, 134, 23);
		panel_2.add(rdbtnSerachname);
		
		JRadioButton rdbtnSearchForMobile = new JRadioButton("Search for mobile no.");
		buttonGroup.add(rdbtnSearchForMobile);
		rdbtnSearchForMobile.setBounds(806, 30, 139, 23);
		panel_2.add(rdbtnSearchForMobile);
		
		JButton buttonSerach = new JButton("Search");
		buttonSerach.setIcon(new ImageIcon(UserLoginPage.class.getResource("/ImageButtonIcon/search_100379.jpg")));
		buttonSerach.setHorizontalAlignment(SwingConstants.LEADING);
		buttonSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSerachname.isSelected()) {
				
				try {

					conn = DBConnection.getConnection();
					String sql = "select * from groarybillingsystem.userloginpage where Name= ?;";
					pre = conn.prepareStatement(sql);
					pre.setString(1, textFieldSearch.getText());
					rs = pre.executeQuery();
					while (rs.next()) {
						String name = rs.getString("MobileNo");
						textFieldMobileNo.setText(name);
						String address = rs.getString("Address");
						textAreaAddress.setText(address);
						String mobileno = rs.getString("MobileNo");
						textFieldMobileNo.setText(mobileno);
						String EmailId = rs.getString("EmailId");
						textFieldEmailId.setText(EmailId);
						String Username = rs.getString("Username");
						textFieldUserName.setText(Username);
						String Password = rs.getString("Password");
						passwordFieldPassword1.setText(Password);
						String Date = rs.getString("Date");
						dateChooserAdmiJoinDate.setText(Date);
						// textFieldShowDate.setBounds(textFieldShowDate);
						dateChooserAdmiJoinDate.setVisible(true);
						dateChooserAdmiJoinDate.setVisible(false);
						passwordFieldPassword1.setText("");
						passwordFieldPassword1.setEnabled(false);
						dateChooserAdmiJoinDate.setEnabled(false);
						dateChooserAdmiJoinDate.setEnabled(false);
						passwordFieldPasswordConfirm.setEnabled(false);
						textFieldHint.setEnabled(false);
						buttonUpdate_1.setEnabled(true);
						buttonDelte.setEnabled(true);
						

					}

				} catch (Exception ee) {

				}
				}
				else if (rdbtnSearchForMobile.isSelected()) {

					try {

						conn = DBConnection.getConnection();
						String sql = "select * from groarybillingsystem.userloginpage where MobileNo= ?;";
						pre = conn.prepareStatement(sql);
						pre.setString(1, textFieldSearch.getText());
						rs = pre.executeQuery();
						while (rs.next()) {
							String name = rs.getString("Name");
							textFieldName.setText(name);
							String address = rs.getString("Address");
							textAreaAddress.setText(address);
							String mobileno = rs.getString("MobileNo");
							textFieldMobileNo.setText(mobileno);
							String EmailId = rs.getString("EmailId");
							textFieldEmailId.setText(EmailId);
							String Username = rs.getString("Username");
							textFieldUserName.setText(Username);
							String Password = rs.getString("Password");
							passwordFieldPassword1.setText(Password);
							String Date = rs.getString("Date");
							dateChooserAdmiJoinDate.setText(Date);
							// textFieldShowDate.setBounds(textFieldShowDate);
							dateChooserAdmiJoinDate.setVisible(true);
							dateChooserAdmiJoinDate.setVisible(false);
							passwordFieldPassword1.setText("");
							passwordFieldPassword1.setEnabled(false);
							dateChooserAdmiJoinDate.setEnabled(false);
							dateChooserAdmiJoinDate.setEnabled(false);
							passwordFieldPasswordConfirm.setEnabled(false);
							textFieldHint.setEnabled(false);
							buttonUpdate_1.setEnabled(true);
							buttonDelte.setEnabled(true);

						}

					} catch (Exception ee) {

					}
					
				}
				
			}
		});
		buttonSerach.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonSerach.setBounds(946, 11, 125, 40);
		panel_2.add(buttonSerach);
		
		

		String[] columnname = { "Sr NO", "Name", "Address", "MobileNo", "EmailId", "Username",
				"Date" };
		mymodel = new DefaultTableModel(columnname, 0);
		final JTable tableshow=new JTable(mymodel);
		JScrollPane scrollPane_1 = new JScrollPane(tableshow);
		scrollPane_1.setBounds(10, 476, 1079, 254);
		tableshow();
		contentPane.add(scrollPane_1);
	}
}
