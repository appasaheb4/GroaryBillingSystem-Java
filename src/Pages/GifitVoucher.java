package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GifitVoucher extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField txtDdmmyyyy;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GifitVoucher dialog = new GifitVoucher();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GifitVoucher() {
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Gifit Voucher No:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(29, 52, 103, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblExpiryDate = new JLabel("Expiry Date:");
			lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblExpiryDate.setBounds(29, 97, 103, 17);
			contentPanel.add(lblExpiryDate);
		}
		{
			JLabel lblBarcodeNumber = new JLabel("Barcode Number:");
			lblBarcodeNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBarcodeNumber.setBounds(29, 153, 115, 17);
			contentPanel.add(lblBarcodeNumber);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField.setBounds(181, 52, 126, 23);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			txtDdmmyyyy = new JTextField();
			txtDdmmyyyy.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txtDdmmyyyy.setText("");
				}
			});
			txtDdmmyyyy.setText("DD-MM-YYYY");
			txtDdmmyyyy.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDdmmyyyy.setColumns(10);
			txtDdmmyyyy.setBounds(181, 97, 126, 23);
			contentPanel.add(txtDdmmyyyy);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textField_2.setColumns(10);
			textField_2.setBounds(181, 153, 126, 23);
			contentPanel.add(textField_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(GifitVoucher.class.getResource("/ImageButtonIcon/ok.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setHorizontalAlignment(SwingConstants.LEADING);
				cancelButton.setIcon(new ImageIcon(GifitVoucher.class.getResource("/ImageButtonIcon/cancel.png")));
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
