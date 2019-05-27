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

public class PayVoucher extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldVouNo;
	private JTextField textFieldVouAmount;
	private JTextField textFieldExpDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PayVoucher dialog = new PayVoucher();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PayVoucher() {
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voucher Number:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(80, 11, 109, 17);
		contentPanel.add(lblNewLabel);
		
		JLabel lblVoucherAmount = new JLabel("Voucher Amount:");
		lblVoucherAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVoucherAmount.setBounds(80, 70, 109, 17);
		contentPanel.add(lblVoucherAmount);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExpiryDate.setBounds(80, 127, 109, 17);
		contentPanel.add(lblExpiryDate);
		
		textFieldVouNo = new JTextField();
		textFieldVouNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldVouNo.setBounds(223, 8, 126, 23);
		contentPanel.add(textFieldVouNo);
		textFieldVouNo.setColumns(10);
		
		textFieldVouAmount = new JTextField();
		textFieldVouAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldVouAmount.setColumns(10);
		textFieldVouAmount.setBounds(223, 70, 126, 23);
		contentPanel.add(textFieldVouAmount);
		
		textFieldExpDate = new JTextField();
		textFieldExpDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textFieldExpDate.setText("");			}
		});
		textFieldExpDate.setText("DD-MM-YYYY");
		textFieldExpDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldExpDate.setColumns(10);
		textFieldExpDate.setBounds(223, 127, 126, 23);
		contentPanel.add(textFieldExpDate);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(PayVoucher.class.getResource("/ImageButtonIcon/ok.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(PayVoucher.class.getResource("/ImageButtonIcon/cancel.png")));
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
