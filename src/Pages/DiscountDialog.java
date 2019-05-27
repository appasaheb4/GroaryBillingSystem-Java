package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.pdf.BidiLine;

import groovy.model.DefaultTableModel;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DiscountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField textFieldDiscount;
	public PreparedStatement ps;
	public Connection conn = null;
	public String val1;
	public static JTextField textFieldNetAmt;

	public double netamount;
	public double netamountfinal;
	public javax.swing.table.DefaultTableModel tablemodel=BillDesk.myModeal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DiscountDialog dialog = new DiscountDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public  double getnettotal() {
		int rowcount = BillDesk.tableshow.getRowCount();

		double nettoatl = 0;
		for (int i = 0; i < rowcount; i++) {
			nettoatl = nettoatl + Double.valueOf(BillDesk.tableshow.getValueAt(i, 9).toString());
		}

		return nettoatl;
	}

	public  double getvattotal() {
		int rowcount =BillDesk.tableshow.getRowCount();

		double vattotal = 0;
		for (int i = 0; i < rowcount; i++) {
			vattotal = vattotal + Double.valueOf(BillDesk.tableshow.getValueAt(i, 7).toString());

		}

		return vattotal;

	}

	public  double getgross() {
		int rowcount = BillDesk.tableshow.getRowCount();

		double gross = 0;
		for (int i = 0; i < rowcount; i++) {
			gross = gross + Double.valueOf(BillDesk.tableshow.getValueAt(i, 3).toString())
					* Double.valueOf(BillDesk.tableshow.getValueAt(i, 5).toString());

		}

		return gross;
	}

	public  Double getdiscount() {
		int rowcount = BillDesk.tableshow.getRowCount();
		double sum = 0;
		for (int i = 0; i < rowcount; i++) {
			sum = sum + Double.valueOf(BillDesk.tableshow.getValueAt(i, 8).toString());
		}

		return sum;
	}
	
	

	public static void calculation1() {

		Double totalamount1 = Double.valueOf(ItemNamewithBarcode.textFieldTotalAmount.getText());
		Double qty1 = Double.valueOf(QtyDialog.textFieldQty.getText());
		Double vat1 = Double.valueOf(VatDialoag.textFieldVaPer.getText());
		Double discount1 = Double.valueOf(DiscountDialog.textFieldDiscount.getText());
		double totalamountsum1 = totalamount1 * qty1;
		QtyDialog.textFieldQtyTotalAmount.setText(String.valueOf(totalamountsum1));

		double vatsum1 = totalamountsum1 * vat1 / 100.0;

		VatDialoag.textFieldVatAmt.setText(String.valueOf(vatsum1));

		double nettotalsum1 = totalamountsum1 + vatsum1 - discount1;

		DiscountDialog.textFieldNetAmt.setText(String.valueOf(nettotalsum1));

	}

	/**
	 * Create the dialog.
	 */
	public DiscountDialog() {
		
		

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Discount:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(45, 72, 59, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldDiscount = new JTextField();
			textFieldDiscount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					calculation1();
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

			textFieldDiscount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldDiscount.setBounds(134, 72, 167, 23);
			contentPanel.add(textFieldDiscount);
			textFieldDiscount.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("e.g. 10,40,25...");
			lblNewLabel_1.setBounds(134, 112, 79, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNetAmount = new JLabel("Net Amount:");
			lblNetAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNetAmount.setBounds(45, 186, 79, 17);
			contentPanel.add(lblNetAmount);
		}
		{
			textFieldNetAmt = new JTextField();
			textFieldNetAmt.setForeground(Color.MAGENTA);
			textFieldNetAmt.setEnabled(false);
			textFieldNetAmt.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textFieldNetAmt.setColumns(10);
			textFieldNetAmt.setBounds(134, 172, 185, 43);
			contentPanel.add(textFieldNetAmt);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
				okButton.setIcon(new ImageIcon(DiscountDialog.class.getResource("/ImageButtonIcon/add.png")));
				okButton.setHorizontalAlignment(SwingConstants.LEADING);
				okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						try {
							dispose();
						
							String data0 = ItemNamewithBarcode.textFieldSrNumber.getText();
							String data1 = ItemNamewithBarcode.textFieldCustomeSrno.getText();
							String data2 = ItemNamewithBarcode.textFieldItemName.getText();
							String data3 = ItemNamewithBarcode.textFieldTotalAmount.getText();
							String data4 = ItemNamewithBarcode.textFieldBarcode.getText();
							String data5 = QtyDialog.textFieldQty.getText();
							String data6 = VatDialoag.textFieldVaPer.getText();
							String data7 = VatDialoag.textFieldVatAmt.getText();
							String data8 = textFieldDiscount.getText();
							String data9 = textFieldNetAmt.getText();
						
							
							BillDesk.myModeal.addRow(
									new Object[] { data0, data1, data2, data3, data4, data5, data6, data7, data8, data9 });
							

							 BillDesk.textFieldDiscounttotal.setText(Double.toString(getdiscount()));
							 BillDesk.textFieldGrorssAmt.setText(Double.toString(getgross()));
							 BillDesk.textFieldvVatAmtTotal.setText(Double.toString(getvattotal()));
							 BillDesk.textFieldNetAmtTotal.setText(Double.toString(getnettotal()));
							 BillDesk.textFieldBarcodecall.setText("1");
							 String cusamee=ItemNamewithBarcode.textFieldCustomername.getText();
							 BillDesk.tfcusmname.setText(cusamee);
							 
							 BillDesk.textFieldsssssr.setText(String.valueOf(ItemNamewithBarcode.textFieldCustomeSrno.getText()));
							 
							 int ii=Integer.parseInt(BillDesk.textFieldCustomeSrno.getText());
							 int io=ii+1;
							 BillDesk.textFieldCustomeSrno.setText(String.valueOf(io));
							 
							 String iname=ItemNamewithBarcode.textFieldCustomername.getText();
							 BillDesk.textFieldCustomername.setText(iname);
							 
							
							 
							
							
						}

						catch (Exception ex) {
							System.out.println(ex.getMessage());
						}
					}

					
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(DiscountDialog.class.getResource("/ImageButtonIcon/cancel.png")));
				cancelButton.setHorizontalAlignment(SwingConstants.LEADING);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
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
