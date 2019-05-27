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
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class QtyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField textFieldQty;
	public static JTextField textFieldQtyTotalAmount;
	public double totalprice1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			QtyDialog dialog = new QtyDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the dialog.
	 */
	public QtyDialog() {
		
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Quantity:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(37, 83, 58, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldQty = new JTextField();
			textFieldQty.addKeyListener(new KeyAdapter() {
				
				
					
				
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
				@Override
				public void keyReleased(KeyEvent e) {
					
					
					String qtystring=textFieldQty.getText();
					double qty=Double.parseDouble(qtystring);
					String totalamounti=ItemNamewithBarcode.textFieldTotalAmount.getText();
					double totalamount=Double.parseDouble(totalamounti);
					totalprice1=qty*totalamount;
					String totalprice=String.valueOf(totalprice1);
					textFieldQtyTotalAmount.setText(totalprice);
				}
			});
			textFieldQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldQty.setBounds(136, 77, 193, 23);
			contentPanel.add(textFieldQty);
			textFieldQty.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("e.g. 1,2,3,..");
			lblNewLabel_1.setBounds(105, 117, 138, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldQtyTotalAmount = new JTextField();
			textFieldQtyTotalAmount.setEnabled(false);
			textFieldQtyTotalAmount.setBounds(136, 161, 193, 33);
			contentPanel.add(textFieldQtyTotalAmount);
			textFieldQtyTotalAmount.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(QtyDialog.class.getResource("/ImageButtonIcon/ok1.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VatDialoag vd = new VatDialoag();
						vd.setVisible(true);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(QtyDialog.class.getResource("/ImageButtonIcon/cancel.png")));
				cancelButton.setHorizontalAlignment(SwingConstants.LEADING);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
