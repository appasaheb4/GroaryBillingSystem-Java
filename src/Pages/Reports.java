package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.exolab.castor.mapping.xml.Container;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLang;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.web.servlets.ReportServlet;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Reports extends JFrame {

	private JPanel contentPane;
	public Connection conn = null;
	public String suername;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Reports(String supername, String filename) {
		this(supername, filename, null);
	}

	public Reports(String supername, String filename, HashMap map) {
		super(supername);
		this.suername = supername;
		try {
			conn = DBConnection.getConnection();

			JasperPrint print = JasperFillManager.fillReport(filename, map, conn);
			JRViewer viewer = new JRViewer(print);
			java.awt.Container c = getContentPane();

			scrollPane = new JScrollPane(viewer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setBounds(10, 0, 988, 449);
			c.add(scrollPane);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Create the frame.
	 */
	public Reports() {
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(28, 56, 237, 136);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("ADMIN REPORT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Reports r = new Reports("Comapany Information",
							"src/Reports/AdminReport.jasper");
					r.setBounds(270, 80, 1100, 700);
					r.setVisible(true);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setBounds(0, 102, 237, 36);
		panel.add(btnNewButton);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 237, 102);
		panel.add(label);
		label.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/1687-977791.png")));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1184, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblReports = new JLabel("Reports");
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblReports.setBounds(10, 11, 125, 27);
		panel_1.add(lblReports);

		JButton button_12 = new JButton("X");
		button_12.setForeground(Color.RED);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_12.setOpaque(false);
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button_12.setContentAreaFilled(false);
		button_12.setBorderPainted(false);
		button_12.setBounds(990, -1, 69, 45);
		panel_1.add(button_12);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(275, 56, 237, 136);
		contentPane.add(panel_2);

		JButton btnUserReport = new JButton("USER REPORT");
		btnUserReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Reports r = new Reports("Comapany Information",
							"src/Reports/UserReport.jasper");
					r.setBounds(270, 80, 1100, 700);
					r.setVisible(true);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		btnUserReport.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUserReport.setBackground(new Color(65, 105, 225));
		btnUserReport.setForeground(Color.WHITE);
		btnUserReport.setBounds(0, 100, 237, 36);
		panel_2.add(btnUserReport);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/vend.png")));
		label_1.setBounds(0, 0, 237, 101);
		panel_2.add(label_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(522, 56, 237, 136);
		contentPane.add(panel_3);

		JButton btnDealerDetails = new JButton("DEALER DETAILS");
		btnDealerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Reports r = new Reports("Comapany Information",
							"src/Reports/DealerReport.jasper");
					r.setBounds(270, 80, 1100, 700);
					r.setVisible(true);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		btnDealerDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDealerDetails.setBackground(new Color(65, 105, 225));
		btnDealerDetails.setForeground(Color.WHITE);
		btnDealerDetails.setBounds(0, 98, 237, 38);
		panel_3.add(btnDealerDetails);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/vlidett.png")));
		label_2.setBounds(0, 0, 237, 99);
		panel_3.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(28, 203, 237, 145);
		contentPane.add(panel_4);

		JButton btnStockOut = new JButton("STOCK OUT");
		btnStockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reports r = new Reports("Comapany Information",
							"src/Reports/STOCKOUT.jasper");
					r.setBounds(270, 80, 1100, 700);
					r.setVisible(true);

				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
			}
		});
		btnStockOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStockOut.setBackground(new Color(65, 105, 225));
		btnStockOut.setForeground(Color.WHITE);
		btnStockOut.setBounds(0, 103, 237, 42);
		panel_4.add(btnStockOut);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/cust.png")));
		label_3.setBounds(0, 0, 237, 105);
		panel_4.add(label_3);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(275, 203, 237, 145);
		contentPane.add(panel_5);

		JButton btnStockMaintained = new JButton("STOCK MAINTAINED");
		btnStockMaintained.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Reports r = new Reports("Comapany Information",
							"src/Reports/StockMantained.jasper");
					r.setBounds(270, 80, 1100, 700);
					r.setVisible(true);

				} catch (Exception ew) {
					System.out.println(ew.getMessage());
				}
			}
		});
		btnStockMaintained.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStockMaintained.setBackground(new Color(65, 105, 225));
		btnStockMaintained.setForeground(Color.WHITE);
		btnStockMaintained.setBounds(0, 107, 237, 38);
		panel_5.add(btnStockMaintained);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/stock.png")));
		label_4.setBounds(0, 0, 237, 105);
		panel_5.add(label_4);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(769, 56, 237, 136);
		contentPane.add(panel_8);

		JButton btnPurchaseDetails = new JButton("PURCHASE DETAILS");
		btnPurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PurchaseReports pr = new PurchaseReports();
				pr.setUndecorated(true);
				pr.setVisible(true);

			}
		});
		btnPurchaseDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPurchaseDetails.setBackground(new Color(65, 105, 225));
		btnPurchaseDetails.setForeground(Color.WHITE);
		btnPurchaseDetails.setBounds(0, 99, 237, 37);
		panel_8.add(btnPurchaseDetails);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/pur.png")));
		label_7.setBounds(0, 0, 237, 100);
		panel_8.add(label_7);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(522, 203, 237, 145);
		contentPane.add(panel_6);

		JButton btnCustomerBills = new JButton("CUSTOMER BILLS");
		btnCustomerBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConstmerBillReport cbr = new ConstmerBillReport();
				cbr.setUndecorated(true);
				cbr.setVisible(true);
			}
		});
		btnCustomerBills.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomerBills.setBackground(new Color(65, 105, 225));
		btnCustomerBills.setForeground(Color.WHITE);
		btnCustomerBills.setBounds(0, 107, 237, 38);
		panel_6.add(btnCustomerBills);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/Sales Report.png")));
		label_5.setBounds(0, 0, 237, 107);
		panel_6.add(label_5);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBounds(769, 203, 237, 145);
		contentPane.add(panel_7);

		JButton btnDealerPayment = new JButton("DEALER PAYMENT");
		btnDealerPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DealerPayment dp=new DealerPayment();
				dp.setUndecorated(true);
				dp.setVisible(true);
				
			}
		});
		btnDealerPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDealerPayment.setBackground(new Color(65, 105, 225));
		btnDealerPayment.setForeground(Color.WHITE);
		btnDealerPayment.setBounds(0, 108, 237, 37);
		panel_7.add(btnDealerPayment);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/paybill.png")));
		label_6.setBounds(0, 0, 237, 108);
		panel_7.add(label_6);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBounds(28, 359, 237, 145);
		contentPane.add(panel_9);

		JButton btnCustomerPayment = new JButton("CUSTOMER PAYMENT");
		btnCustomerPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomerPayment.setBackground(new Color(65, 105, 225));
		btnCustomerPayment.setForeground(Color.WHITE);
		btnCustomerPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomerPayment.setBounds(0, 106, 237, 39);
		panel_9.add(btnCustomerPayment);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/clienybill.png")));
		label_8.setBounds(0, 0, 237, 106);
		panel_9.add(label_8);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.setBounds(275, 359, 237, 145);
		contentPane.add(panel_10);

		JButton btnExpenditure = new JButton("EXPENDITURE");
		btnExpenditure.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExpenditure.setBackground(new Color(65, 105, 225));
		btnExpenditure.setForeground(Color.WHITE);
		btnExpenditure.setBounds(0, 107, 237, 38);
		panel_10.add(btnExpenditure);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/exp.jpg")));
		label_9.setBounds(38, 0, 156, 108);
		panel_10.add(label_9);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.setBounds(522, 359, 237, 145);
		contentPane.add(panel_11);

		JButton btnVatStatement = new JButton("VAT STATEMENT");
		btnVatStatement.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVatStatement.setBackground(new Color(65, 105, 225));
		btnVatStatement.setForeground(Color.WHITE);
		btnVatStatement.setBounds(0, 108, 237, 37);
		panel_11.add(btnVatStatement);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/Vat Consultancy.jpg")));
		label_10.setBounds(10, 0, 217, 111);
		panel_11.add(label_10);

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.setBounds(769, 359, 237, 145);
		contentPane.add(panel_12);

		JButton btnNoVatStatement = new JButton("NO VAT STATEMENT");
		btnNoVatStatement.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNoVatStatement.setBackground(new Color(65, 105, 225));
		btnNoVatStatement.setForeground(Color.WHITE);
		btnNoVatStatement.setBounds(0, 108, 237, 37);
		panel_12.add(btnNoVatStatement);

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/novat.png")));
		label_11.setBounds(31, 0, 206, 109);
		panel_12.add(label_11);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_13.setBounds(28, 515, 237, 136);
		contentPane.add(panel_13);

		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(Reports.class.getResource("/Image/imageall/pl3.jpg")));
		label_12.setBounds(10, 0, 227, 96);
		panel_13.add(label_12);

		JButton btnNewButton_1 = new JButton("PROFIT LOSS");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(0, 96, 237, 40);
		panel_13.add(btnNewButton_1);
	}
}
