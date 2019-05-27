package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConstmerBillReport extends JFrame {

	private JPanel contentPane;
	
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	private JTable tabledatashow_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConstmerBillReport frame = new ConstmerBillReport();
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
	public ConstmerBillReport() {
		
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblCustm = new JLabel("CustomerBillingReport");
		lblCustm.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCustm.setBounds(10, 11, 254, 27);
		panel.add(lblCustm);
		
		JButton button = new JButton("X");
		button.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 77, 1079, 415);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		final JTable tabledatashow = new JTable();
	
		
		JScrollPane scrollPane = new JScrollPane(tabledatashow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 11, 1059, 393);
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

				default:
					return String.class;
				}
			}
		};
		tabledatashow.setModel(model);
		
		model.addColumn("Select");
		model.addColumn("Sr NO");
		model.addColumn("Comstmor Name");
	
		model.addColumn("Gross Amount");
		model.addColumn("Vat Amount");
		model.addColumn("Discount Amount");
		model.addColumn("Net Amount");
		
		tabledatashow.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		TableColumn col0 = tabledatashow.getColumnModel().getColumn(0);
		TableColumn col1 = tabledatashow.getColumnModel().getColumn(1);
		TableColumn col2 = tabledatashow.getColumnModel().getColumn(2);
		TableColumn col3 = tabledatashow.getColumnModel().getColumn(3);
		TableColumn col4 = tabledatashow.getColumnModel().getColumn(4);
		TableColumn col5 = tabledatashow.getColumnModel().getColumn(5);
		TableColumn col6 = tabledatashow.getColumnModel().getColumn(6);
	
	
		
		col0.setPreferredWidth(70);
		col1.setPreferredWidth(100);
		col2.setPreferredWidth(250);
		col3.setPreferredWidth(150);
		col4.setPreferredWidth(200);
		col5.setPreferredWidth(150);
		col6.setPreferredWidth(150);
	
		
		

		try {
			int i = 0;
			conn = DBConnection.getConnection();
			String query = "select * from groarybillingsystem.billdiskmaster order by Srnomaster";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			for (; rs.next();) {
				model.addRow(new Object[0]);
				model.setValueAt(false, i, 0);

				String data0 = rs.getString("Srnomaster");
				String data1 = rs.getString("ComstmorName");
				String data2 = rs.getString("GorssAmt");
				String data3 = rs.getString("VaAmtTotal");
				String data4 = rs.getString("DiscountAmt");
				String data5 = rs.getString("NetAmt");
				
				model.setValueAt(data0, i, 1);
				model.setValueAt(data1, i, 2);
				model.setValueAt(data2, i, 3);
				model.setValueAt(data3, i, 4);
				model.setValueAt(data4, i, 5);
				model.setValueAt(data5, i, 6);
				
				i++;

			}
		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}

	
		
		JButton button_1 = new JButton("View");
		button_1.setIcon(new ImageIcon(ConstmerBillReport.class.getResource("/ImageButtonIcon/View4.png")));
		button_1.setHorizontalAlignment(SwingConstants.LEADING);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<=tabledatashow.getRowCount();i++)
				{
					Boolean che=Boolean.valueOf(tabledatashow.getValueAt(i,0).toString());
					String col=tabledatashow.getValueAt(i, 1).toString();
					int paravalue=Integer.parseInt(col);
					HashMap para = new HashMap();
					
					if(che)
					{
						para.put("SrMaster", paravalue);
						Reports r = new Reports("INVOICE",
								"src/Reports/InvoiceBill.jasper",para);
						r.setBounds(270, 80, 1100, 700);
						r.setVisible(true);
						
						
					}
					
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(38, 546, 115, 38);
		contentPane.add(button_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(ConstmerBillReport.class.getResource("/ImageButtonIcon/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(183, 546, 115, 38);
		contentPane.add(btnExit);
	}
}
