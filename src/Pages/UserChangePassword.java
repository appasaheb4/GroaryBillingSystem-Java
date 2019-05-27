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
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;

public class UserChangePassword extends JFrame {

	private JPanel contentPane;
	public  JTextField textFieldUsername;
	private JPasswordField passwordFieldOldPass;
	private JPasswordField passwordFieldNewPass;
	private JPasswordField passwordFieldConPass;
	
	public Connection conn=null;
	public PreparedStatement pre;
	public PreparedStatement update;
	public ResultSet rs;
	public Statement st;
	public String userloginname=LoginPage.textFieldUserName.getText();
	
	public String usertype=LoginPage.textFieldType.getText();
	public String usertype1="User";
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserChangePassword frame = new UserChangePassword();
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
	public UserChangePassword() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if(usertype.equals(usertype1))
				{
					textFieldUsername.setText(usertype);
					textFieldUsername.setEnabled(false);
			
				}
			
			}
			
		});
		
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUser.setBounds(10, 11, 195, 27);
		panel.add(lblUser);
		
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
		panel_1.setBounds(0, 56, 744, 453);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 44, 125, 17);
		panel_1.add(label);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(158, 33, 267, 28);
		panel_1.add(textFieldUsername);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
						"Password", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		panel_2.setBounds(10, 88, 417, 228);
		panel_1.add(panel_2);
		
		JLabel label_1 = new JLabel("Old Password:\r\n");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 54, 125, 17);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("New Password:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(10, 97, 125, 17);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Confirm Password:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(10, 144, 138, 17);
		panel_2.add(label_3);
		
		passwordFieldOldPass = new JPasswordField();
		passwordFieldOldPass.setBounds(164, 54, 243, 29);
		panel_2.add(passwordFieldOldPass);
		
		passwordFieldNewPass = new JPasswordField();
		passwordFieldNewPass.setBounds(164, 93, 243, 29);
		panel_2.add(passwordFieldNewPass);
		
		passwordFieldConPass = new JPasswordField();
		passwordFieldConPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pass=passwordFieldNewPass.getText().toString();
				String conpass=passwordFieldConPass.getText().toString();
				if(pass.equals(conpass))
				{
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Plz enter new and confirm password are same.");
				}
			}
		});
		passwordFieldConPass.setBounds(164, 132, 243, 29);
		panel_2.add(passwordFieldConPass);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(466, 44, 213, 256);
		panel_1.add(panel_3);
		
		JButton btnChangePassword1 = new JButton("Change Password");
		btnChangePassword1.setIcon(new ImageIcon(UserChangePassword.class.getResource("/ImageButtonIcon/changepassword1.jpg")));
		btnChangePassword1.setHorizontalAlignment(SwingConstants.LEADING);
		btnChangePassword1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass1=passwordFieldNewPass.getText().toString();
				String pass2=passwordFieldConPass.getText().toString();
				if(pass1.equals(pass2))
				{
					try {

					
						conn = DBConnection.getConnection();
						st = (Statement) conn.createStatement();
						String username = textFieldUsername.getText().toString();
						String password = passwordFieldOldPass.getText().toString();
						// String type=

						rs = st.executeQuery("select Username,Password from groarybillingsystem.userloginpage where Username='"
								+ username + "' and Password='" + password + "';");
						if (rs.next()) {
							String query = "update groarybillingsystem.userloginpage set Password= ? where Username=?";
							update = conn.prepareStatement(query);
							update.setString(1, passwordFieldConPass.getText()
									.toString());
							update.setString(2, textFieldUsername.getText());
							

							int ii = update.executeUpdate();
							if (ii > 0) {
								JOptionPane.showMessageDialog(null,
										"Password are changed.");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Password are not changed");
						}

					} catch (Exception ee) {
						System.out.println(ee.getMessage());
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Plz new password and confirm password corect.");
				}

			
				
				
			}
		});
		btnChangePassword1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChangePassword1.setBounds(0, 34, 193, 69);
		panel_3.add(btnChangePassword1);
		
		JButton buttonExit = new JButton("Exit");
		buttonExit.setIcon(new ImageIcon(UserChangePassword.class.getResource("/ImageButtonIcon/Exit1.png")));
		buttonExit.setHorizontalAlignment(SwingConstants.LEADING);
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonExit.setToolTipText("Plz enter mobile number.");
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonExit.setBounds(0, 151, 193, 59);
		panel_3.add(buttonExit);
	}
}
