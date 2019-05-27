package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemNamewithBarcode extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField textFieldSrNumber;
	public static JTextField textFieldItemName;
	public static JTextField textFieldBarcode;
	public Connection conn = null;
	String val1;
	public static JTextField textFieldTotalAmount;
	public static JTextField textFieldCustomername;
	static JTextField textFieldCustomeSrno;
	

	/**
	 * Launch the application.
	 */
	
	
	

	public static void main(String[] args) {
		try {
			ItemNamewithBarcode dialog = new ItemNamewithBarcode();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * Create the dialog.
	 */
	public ItemNamewithBarcode() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				String nu=BillDesk.textFieldCustomeSrno.getText();
				
				
				if(BillDesk.textFieldCustomername.getText().length() != 0 || BillDesk.textFieldCustomeSrno.getText()!="1")
				{
					String srno=BillDesk.textFieldCustomeSrno.getText();
					textFieldCustomeSrno.setText(srno);
					
					String scanbarcodename=BillDesk.textFieldCustomername.getText();
					textFieldCustomername.setText(scanbarcodename);
				}
				else
				{
					increment();
					
					
				}
			}
		});
		
		
		
		
		setBounds(100, 100, 464, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Sr No:");
			lblNewLabel.setBounds(54, 41, 39, 17);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblItemname = new JLabel("Item Name:");
			lblItemname.setBounds(54, 125, 72, 17);
			lblItemname.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblItemname);
		}
		{
			JLabel lblBarcode = new JLabel("Barcode:");
			lblBarcode.setBounds(54, 209, 55, 17);
			lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblBarcode);
		}
		{
			textFieldSrNumber = new JTextField();
			textFieldSrNumber.setEnabled(false);
			textFieldSrNumber.setForeground(Color.MAGENTA);
			textFieldSrNumber.setBounds(21, 11, 126, 39);
			increment();
			textFieldSrNumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textFieldSrNumber.setVisible(false);
			
			contentPanel.add(textFieldSrNumber);
			textFieldSrNumber.setColumns(10);
		}
		{
			textFieldItemName = new JTextField();
			textFieldItemName.setBounds(182, 119, 126, 23);
			textFieldItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldItemName.setColumns(10);
			contentPanel.add(textFieldItemName);
		}
		{
			textFieldBarcode = new JTextField();
			textFieldBarcode.setBounds(182, 203, 126, 23);
			textFieldBarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldBarcode.setColumns(10);
			contentPanel.add(textFieldBarcode);
		}
		{
			JLabel lblTotalAmount = new JLabel("Total Amount:");
			lblTotalAmount.setBounds(54, 167, 88, 17);
			lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblTotalAmount);
		}
		{
			textFieldTotalAmount = new JTextField();
			textFieldTotalAmount.addKeyListener(new KeyAdapter() {
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
			
			
			textFieldTotalAmount.setBounds(182, 161, 126, 23);
			textFieldTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldTotalAmount.setColumns(10);
			contentPanel.add(textFieldTotalAmount);
		}

		textFieldCustomername = new JTextField();
		textFieldCustomername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCustomername.setColumns(10);
		textFieldCustomername.setBounds(182, 77, 126, 23);
		//textFieldCustomername.requestFocus();
		contentPanel.add(textFieldCustomername);

		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBounds(54, 83, 118, 17);
		contentPanel.add(lblCustomerName);
		{
			textFieldCustomeSrno = new JTextField();
			textFieldCustomeSrno.setEnabled(false);
			textFieldCustomeSrno.setFont(new Font("Tahoma", Font.BOLD, 18));
			textFieldCustomeSrno.setColumns(10);
			textFieldCustomeSrno.setBounds(182, 41, 126, 23);
			contentPanel.add(textFieldCustomeSrno);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(ItemNamewithBarcode.class.getResource("/ImageButtonIcon/ok.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						QtyDialog qd = new QtyDialog();
						qd.setVisible(true);
					
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(ItemNamewithBarcode.class.getResource("/ImageButtonIcon/cancel.png")));
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
