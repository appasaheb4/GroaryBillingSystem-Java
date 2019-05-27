package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

public class ForgotPassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsername;
	private JTextField textFieldHint;
	
	public Connection conn=null;
	public ResultSet rs;
	public Statement st;
	public ResultSet rs1;
	public Statement st1;
	public static JTextField textFieldUseroksavename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ForgotPassword dialog = new ForgotPassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ForgotPassword() {
	
		
		setBounds(300, 200, 358, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 46);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(142, 11, 159, 19);
		panel.add(lblNewLabel);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 57, 316, 107);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel_1 = new JLabel("Username:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblNewLabel_1.setBounds(10, 11, 74, 17);
				panel_1.add(lblNewLabel_1);
			}
			
			textFieldUsername = new JTextField();
			textFieldUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
			textFieldUsername.setBounds(99, 11, 172, 23);
			panel_1.add(textFieldUsername);
			textFieldUsername.setColumns(10);
			
			JLabel lblHint = new JLabel("Hint:");
			lblHint.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblHint.setBounds(10, 50, 74, 17);
			panel_1.add(lblHint);
			
			textFieldHint = new JTextField();
			textFieldHint.setFont(new Font("Tahoma", Font.BOLD, 14));
			textFieldHint.setColumns(10);
			textFieldHint.setBounds(99, 50, 172, 23);
			panel_1.add(textFieldHint);
			
			textFieldUseroksavename = new JTextField();
			textFieldUseroksavename.setEnabled(false);
			textFieldUseroksavename.setBounds(99, 84, 148, 20);
			textFieldUseroksavename.setVisible(false);
			panel_1.add(textFieldUseroksavename);
			textFieldUseroksavename.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ForgotPassword.class.getResource("/ImageButtonIcon/ok.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {

						
							conn =DBConnection.getConnection();
							st = (Statement) conn.createStatement();
							st1 = (Statement) conn.createStatement();
							String username = textFieldUsername.getText().toString();
							String hint = textFieldHint.getText().toString();

							rs = st.executeQuery("select Username,Hint from groarybillingsystem.adminloginpage where Username='"
									+ username + "' and Hint='" + hint + "';");
							rs1 = st1
									.executeQuery("select Username,Hint from groarybillingsystem.userloginpage where Username='"
											+ username
											+ "' and Hint='"
											+ hint
											+ "';");
							// rs=st.executeQuery("select Username,Password from groarybillingsystem.userloginpage where Username='"+username+"' and Password='"+password+"';");
							if (rs.next()) {
								JOptionPane.showMessageDialog(null,
										"Username and Hint are Correct from admin.");
								textFieldUseroksavename.setText(textFieldUsername.getText());
								ForgotAdminUserChangePassword acp=new ForgotAdminUserChangePassword();
								acp.setVisible(true);
								dispose();

							} else if (rs1.next()) {
								JOptionPane.showMessageDialog(null,
										"Username and Hint are Correct from user.");
								textFieldUseroksavename.setText(textFieldUsername.getText());
								ForgotAdminUserChangePassword acp=new ForgotAdminUserChangePassword();
								acp.setVisible(true);
								
								 dispose();

							} else {
								JOptionPane.showMessageDialog(null,
										"plz enter username and hint carect..");
							}

						} catch (Exception ee) {
							System.out.println(ee.getMessage());
						}
		
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(ForgotPassword.class.getResource("/ImageButtonIcon/cancel.png")));
				cancelButton.setHorizontalAlignment(SwingConstants.LEADING);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
