package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.google.zxing.Result;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class DealerPayment extends JFrame {

	private JPanel contentPane;
	public Connection conn;
	public  PreparedStatement ps;
	public ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealerPayment frame = new DealerPayment();
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
	public DealerPayment() {
	
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);
		
		JLabel lblDealerPayment = new JLabel("Dealer Payment");
		lblDealerPayment.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDealerPayment.setBounds(10, 11, 258, 27);
		panel.add(lblDealerPayment);
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setOpaque(false);
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(990, -1, 69, 45);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 56, 1079, 442);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JTable tabledatashow = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tabledatashow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 11, 1059, 411);
		panel_1.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int Column) {
				switch (Column) {
				case 0:
					return Boolean.class;

				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return String.class;
				case 8:
					return String.class;
				case 9:
					return String.class;
				case 10:
					return String.class;

				default:
					return String.class;
				}
			}
		};
		tabledatashow.setModel(model);
		model.addColumn("Select");
		model.addColumn("Sr NO");
		model.addColumn("Dealer Name");
		model.addColumn("Total Amount");
		model.addColumn("Payment Mode");
		model.addColumn("Amount Paid");
		model.addColumn("In Words");
		model.addColumn("Cheque No");
		model.addColumn("Cheque Date");
		model.addColumn("Bank Name");
		model.addColumn("Balance");
		model.addColumn("Date");

		tabledatashow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i <= tabledatashow.getRowCount(); i++) {
						Boolean che = Boolean.valueOf(tabledatashow.getValueAt(i, 0).toString());
						String col = tabledatashow.getValueAt(i, 1).toString();
						int paravalue = Integer.parseInt(col);
						HashMap para = new HashMap();

						if (che) {

							para.put("SrMaster", paravalue);
							Reports r = new Reports("Dealer Reports", "src/Reports/PurchaseReports.jasper", para);
							r.setBounds(270, 80, 1100, 700);
							r.setVisible(true);

						}

					}
				} catch (Exception ee) {
					ee.getMessage();
				}
			}
		});
		button_1.setIcon(new ImageIcon(DealerPayment.class.getResource("/ImageButtonIcon/View4.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEADING);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(52, 547, 115, 38);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(DealerPayment.class.getResource("/ImageButtonIcon/Exit.png")));
		button_2.setHorizontalAlignment(SwingConstants.LEADING);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_2.setBounds(206, 547, 115, 38);
		contentPane.add(button_2);
		TableColumn col0 = tabledatashow.getColumnModel().getColumn(0);
		TableColumn col1 = tabledatashow.getColumnModel().getColumn(1);
		TableColumn col2 = tabledatashow.getColumnModel().getColumn(2);
		TableColumn col3 = tabledatashow.getColumnModel().getColumn(3);
		TableColumn col4 = tabledatashow.getColumnModel().getColumn(4);
		TableColumn col5 = tabledatashow.getColumnModel().getColumn(5);
		TableColumn col6 = tabledatashow.getColumnModel().getColumn(6);
		TableColumn col7 = tabledatashow.getColumnModel().getColumn(7);
		TableColumn col8 = tabledatashow.getColumnModel().getColumn(8);

		col0.setPreferredWidth(70);
		col1.setPreferredWidth(100);
		col2.setPreferredWidth(250);
		col3.setPreferredWidth(150);
		col4.setPreferredWidth(200);
		col5.setPreferredWidth(150);
		col6.setPreferredWidth(150);
		col7.setPreferredWidth(150);
		col8.setPreferredWidth(150);

		try {
			int i = 0;
			conn = DBConnection.getConnection();
			String query = "select * from groarybillingsystem.purchasepay order by SrNo";
			ps = (PreparedStatement) conn.prepareStatement(query);
			rs = ps.executeQuery();
			for (; rs.next();) {
				model.addRow(new Object[0]);
				model.setValueAt(false, i, 0);

				String data0 = rs.getString("SrNo");
				String data1 = rs.getString("DealerName");
				String data2 = rs.getString("TotalAmount");
				String data3 = rs.getString("PayMentMode");
				String data4 = rs.getString("AmountPaid");
				String data5 = rs.getString("InWord");
				String data6 = rs.getString("chequeno");
				String data7 = rs.getString("chequeDate");
				String data8 = rs.getString("BankName");
				String data88=rs.getString("Balance");
				String data9=rs.getString("Date");
				model.setValueAt(data0, i, 1);
				model.setValueAt(data1, i, 2);
				model.setValueAt(data2, i, 3);
				model.setValueAt(data3, i, 4);
				model.setValueAt(data4, i, 5);
				model.setValueAt(data5, i, 6);
				model.setValueAt(data6, i, 7);
				model.setValueAt(data7, i, 8);
				model.setValueAt(data8, i, 9);
				model.setValueAt(data88, i, 10);
				model.setValueAt(data9, i, 11);
				i++;

			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	}
}
