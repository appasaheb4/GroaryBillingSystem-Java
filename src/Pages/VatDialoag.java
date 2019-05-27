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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class VatDialoag extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField textFieldVaPer;
	public static JTextField textFieldVatAmt;
	public double vat;
	public double vatrate;
	public String vatshow;
	public String totalamountString = QtyDialog.textFieldQtyTotalAmount.getText();
	public double totalamount = Double.parseDouble(totalamountString);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VatDialoag dialog = new VatDialoag();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the dialog.
	 */
	public VatDialoag() {
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Vat: %");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(56, 78, 56, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldVaPer = new JTextField();
			textFieldVaPer.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String vatamount = textFieldVaPer.getText();
					vatrate = Double.parseDouble(vatamount);
					vat = totalamount * vatrate / 100.0;
					vatshow = String.valueOf(vat);
					textFieldVatAmt.setText(vatshow);
				}
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
			
			

			textFieldVaPer.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldVaPer.setBounds(122, 78, 187, 23);
			contentPanel.add(textFieldVaPer);
			textFieldVaPer.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("e.g. 12.5,10.4,13");
			lblNewLabel_1.setBounds(122, 112, 87, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblTotalVat = new JLabel("Total Vat:");
			lblTotalVat.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTotalVat.setBounds(56, 170, 59, 17);
			contentPanel.add(lblTotalVat);
		}
		{
			textFieldVatAmt = new JTextField();
			textFieldVatAmt.setForeground(Color.BLUE);
			textFieldVatAmt.setEnabled(false);
			textFieldVatAmt.setFont(new Font("Tahoma", Font.PLAIN, 25));
			textFieldVatAmt.setColumns(10);
			textFieldVatAmt.setBounds(122, 170, 216, 37);
			contentPanel.add(textFieldVatAmt);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(VatDialoag.class.getResource("/ImageButtonIcon/ok1.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DiscountDialog dd = new DiscountDialog();
						dd.setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(VatDialoag.class.getResource("/ImageButtonIcon/cancel.png")));
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
