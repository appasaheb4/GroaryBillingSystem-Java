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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;



import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ExpenditurePage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldExpAmount;
	private JTextField textFieldExpFor;
	private JTextField textField;

	public Connection conn = null;
	public PreparedStatement pre;
	public PreparedStatement update;
	public ResultSet rs;
	public Statement st;
	private JTextField dateChooserExpDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpenditurePage frame = new ExpenditurePage();
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
	public ExpenditurePage() {
		
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);

		JLabel lblExpenditure = new JLabel("Expenditure");
		lblExpenditure.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblExpenditure.setBounds(10, 11, 195, 27);
		panel.add(lblExpenditure);

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
		panel_1.setBounds(0, 56, 1099, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Expenditure Amount:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 23, 170, 17);
		panel_1.add(lblNewLabel);

		textFieldExpAmount = new JTextField();
		textFieldExpAmount.addKeyListener(new KeyAdapter() {
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
		textFieldExpAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldExpAmount.setBounds(189, 23, 233, 23);
		panel_1.add(textFieldExpAmount);
		textFieldExpAmount.setColumns(10);

		textFieldExpFor = new JTextField();
		textFieldExpFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldExpFor.setColumns(10);
		textFieldExpFor.setBounds(645, 23, 295, 23);
		panel_1.add(textFieldExpFor);

		JLabel lblExpenditureFor = new JLabel("Expenditure for:");
		lblExpenditureFor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblExpenditureFor.setBounds(466, 23, 170, 17);
		panel_1.add(lblExpenditureFor);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(10, 86, 170, 17);
		panel_1.add(lblDate);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(466, 80, 170, 17);
		panel_1.add(lblDescription);

		TextArea textAreaExpDesicription = new TextArea();
		textAreaExpDesicription.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAreaExpDesicription.setBounds(645, 69, 295, 93);
		panel_1.add(textAreaExpDesicription);

		JLabel lblPaymentMode = new JLabel("Payment Mode:");
		lblPaymentMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentMode.setBounds(10, 145, 170, 17);
		panel_1.add(lblPaymentMode);

		JComboBox comboBoxPaymentMode = new JComboBox();
		comboBoxPaymentMode.setModel(new DefaultComboBoxModel(new String[] {
				"fdasf", "dsfaf" }));
		comboBoxPaymentMode.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxPaymentMode.setBounds(189, 142, 233, 23);
		panel_1.add(comboBoxPaymentMode);

		dateChooserExpDate = new JTextField();
		dateChooserExpDate.setEnabled(false);
		dateChooserExpDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		dateChooserExpDate.setBounds(189, 83, 233, 23);
		dateChooserExpDate.setVisible(false);
		panel_1.add(dateChooserExpDate);
		dateChooserExpDate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 275, 1099, 59);
		contentPane.add(panel_2);

		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					conn = DBConnection.getConnection();
					String query = "insert into groarybillingsystem.expenditureinfo values(null,?,?,?,?,?);";
					pre = conn.prepareStatement(query);
					pre.setDouble(1,
							Double.valueOf(textFieldExpAmount.getText()));
					pre.setString(2, textFieldExpFor.getText());
					pre.setString(3, dateChooserExpDate.getText());
					pre.setString(4, textAreaExpDesicription.getText());
					pre.setString(5, comboBoxPaymentMode.getSelectedItem()
							.toString());
					int i = pre.executeUpdate();
					if (i > 0) {
						JOptionPane.showMessageDialog(null, "Data are saved.");
						pre.close();
						conn.close();
					} else {
						JOptionPane.showMessageDialog(null,
								"Data are not saved.");

					}

				} catch (Exception adm) {
					System.out.println(adm.getMessage());
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 11, 115, 37);
		panel_2.add(btnSave);

		JButton buttonUpdate = new JButton("Update");
		buttonUpdate.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/update.png")));
		buttonUpdate.setHorizontalAlignment(SwingConstants.LEADING);
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					conn = DBConnection.getConnection();

					String query = "update groarybillingsystem.expenditureinfo set ExpAmount= ?,Description=?,PaymentMode=? where ExpName=?";
					update = conn.prepareStatement(query);

					update.setString(1, textFieldExpAmount.getText());
					update.setString(2, textAreaExpDesicription.getText());
				
					update.setString(3, comboBoxPaymentMode.getSelectedItem()
							.toString());
					update.setString(4, textField.getText());
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
		buttonUpdate.setToolTipText("Plz first Search and then update");
		buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonUpdate.setEnabled(false);
		buttonUpdate.setBounds(135, 11, 115, 37);
		panel_2.add(buttonUpdate);

		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/delete5.jpg")));
		buttonDelete.setHorizontalAlignment(SwingConstants.LEADING);
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					conn = DBConnection.getConnection();

					String query = "delete from groarybillingsystem.expenditureinfo  where ExpName=?";
					update = conn.prepareStatement(query);
					update.setString(1, textField.getText());
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
		buttonDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonDelete.setEnabled(false);
		buttonDelete.setBounds(260, 11, 115, 37);
		panel_2.add(buttonDelete);

		JButton button_4 = new JButton("Reset");
		button_4.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/Reset5.jpg")));
		button_4.setHorizontalAlignment(SwingConstants.LEADING);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldExpAmount.setText("");
				textFieldExpFor.setText("");
				textAreaExpDesicription.setText("");
				dateChooserExpDate.setVisible(false);
				dateChooserExpDate.setText("");
				dateChooserExpDate.setVisible(true);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_4.setBounds(385, 11, 115, 37);
		panel_2.add(button_4);

		JButton button_5 = new JButton("Exit");
		button_5.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/Exit.png")));
		button_5.setHorizontalAlignment(SwingConstants.LEADING);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_5.setBounds(510, 11, 115, 37);
		panel_2.add(button_5);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(635, 15, 165, 25);
		panel_2.add(textField);

		JRadioButton rdbtnSearchForExp = new JRadioButton(
				"Search for Exp for name");
		rdbtnSearchForExp.setBounds(820, 7, 143, 23);
		panel_2.add(rdbtnSearchForExp);

		JButton button_6 = new JButton("Search");
		button_6.setIcon(new ImageIcon(ExpenditurePage.class.getResource("/ImageButtonIcon/Search2.jpg")));
		button_6.setHorizontalAlignment(SwingConstants.LEADING);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSearchForExp.isSelected()) {
					try {

						conn = DBConnection.getConnection();
						String sql = "select * from groarybillingsystem.expenditureinfo where ExpName= ?;";
						pre = conn.prepareStatement(sql);
						pre.setString(1, textField.getText());
						rs = pre.executeQuery();
						while (rs.next()) {
							String expamo = rs.getString("ExpAmount");
							textFieldExpAmount.setText(expamo);
							String date = rs.getString("Date");
							dateChooserExpDate.setVisible(false);
							dateChooserExpDate.setVisible(true);
							dateChooserExpDate.setText(date);
							String expdes = rs.getString("Description");
							textAreaExpDesicription.setText(expdes);
							String paym = rs.getString("PaymentMode");
							comboBoxPaymentMode.setSelectedItem(paym);
							buttonUpdate.setEnabled(true);
							buttonDelete.setEnabled(true);

						}

					} catch (Exception ee) {

					}
				} else {
					JOptionPane.showMessageDialog(null, "Plz enter the name.");
				}

			}
		});
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.setBounds(969, 11, 120, 37);
		panel_2.add(button_6);
	}
}
