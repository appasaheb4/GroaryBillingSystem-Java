package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PayByCoupan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCouName;
	private JTextField textFieldNumber;
	private JTextField textFieldExpDate;
	private JTextField textFieldBarNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PayByCoupan dialog = new PayByCoupan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PayByCoupan() {
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Coupan Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(52, 56, 92, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCoupanNumber = new JLabel("Coupan Number:");
			lblCoupanNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCoupanNumber.setBounds(52, 96, 106, 17);
			contentPanel.add(lblCoupanNumber);
		}
		{
			JLabel lblExiparyDate = new JLabel("Exipary Date:");
			lblExiparyDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblExiparyDate.setBounds(52, 139, 84, 17);
			contentPanel.add(lblExiparyDate);
		}
		{
			JLabel lblBarcodeNumber = new JLabel("Barcode Number:");
			lblBarcodeNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBarcodeNumber.setBounds(52, 180, 108, 17);
			contentPanel.add(lblBarcodeNumber);
		}
		{
			textFieldCouName = new JTextField();
			textFieldCouName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldCouName.setBounds(206, 56, 126, 23);
			contentPanel.add(textFieldCouName);
			textFieldCouName.setColumns(10);
		}
		{
			textFieldNumber = new JTextField();
			textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldNumber.setColumns(10);
			textFieldNumber.setBounds(206, 96, 126, 23);
			contentPanel.add(textFieldNumber);
		}
		{
			textFieldExpDate = new JTextField();
			textFieldExpDate.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					textFieldExpDate.setText("");
				}
			});
			textFieldExpDate.setText("DD-MM-YYYY");
			textFieldExpDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldExpDate.setColumns(10);
			textFieldExpDate.setBounds(206, 130, 126, 23);
			contentPanel.add(textFieldExpDate);
		}
		{
			textFieldBarNumber = new JTextField();
			textFieldBarNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldBarNumber.setColumns(10);
			textFieldBarNumber.setBounds(206, 174, 126, 23);
			contentPanel.add(textFieldBarNumber);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(PayByCoupan.class.getResource("/ImageButtonIcon/ok.png")));
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
				cancelButton.setIcon(new ImageIcon(PayByCoupan.class.getResource("/ImageButtonIcon/cancel.png")));
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
