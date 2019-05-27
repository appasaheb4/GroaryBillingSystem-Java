package Pages;

import java.awt.BorderLayout;


import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.jws.Oneway;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;



import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

import org.hibernate.engine.transaction.Isolater.JtaDelegate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.apache.lucene.util.automaton.CompiledAutomaton.AUTOMATON_TYPE;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.table.TableModel;
import javax.swing.JList;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SetMinimumStorck extends JFrame {

	private JPanel contentPane;
	public JTable tablesetminimumstock;
	public static DefaultTableModel modeal;
	private JTextField textFieldStockQty;
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement st = null;
	public PreparedStatement ps = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetMinimumStorck frame = new SetMinimumStorck();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void datashow() {
		try {
			conn = DBConnection.getConnection();
			String s = "select * from groarybillingsystem.purchaseinfo;";
			st = conn.createStatement();
			rs = st.executeQuery(s);
			while (rs.next()) {
				String data0 = rs.getString("ProductName");

				String data1 = rs.getString("Brand");
				String data2 = rs.getString("Qty");
				String data3 = rs.getString("Qty Type");
				String data4 = rs.getString("SetMinimumStock11");
				String data5 = rs.getString("Date");

				modeal.addRow(new Object[] { data0, data1, data2, data3, data4, data5 });
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Create the frame.
	 */
	public SetMinimumStorck() {
		
		

		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lblSetMinimumStock = new JLabel("Set Minimum Stock");
		lblSetMinimumStock.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSetMinimumStock.setBounds(10, 11, 280, 27);
		panel.add(lblSetMinimumStock);

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
		panel_1.setBounds(0, 74, 1089, 453);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		String[] columnname = { "Product Name", "Brand Name", "Current Stock", "Unit", "Minimum Stock", "Date" };
		modeal = new DefaultTableModel(columnname, 0);
		tablesetminimumstock = new JTable(modeal);
		tablesetminimumstock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablesetminimumstock.getSelectedRow();
				modeal = (DefaultTableModel) tablesetminimumstock.getModel();
				textFieldStockQty.setText(modeal.getValueAt(i, 4).toString());
			}
		});
		// tablesetminimumstock.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col0 = tablesetminimumstock.getColumnModel().getColumn(0);
		TableColumn col1 = tablesetminimumstock.getColumnModel().getColumn(1);
		TableColumn col2 = tablesetminimumstock.getColumnModel().getColumn(2);
		TableColumn col3 = tablesetminimumstock.getColumnModel().getColumn(3);
		TableColumn col4 = tablesetminimumstock.getColumnModel().getColumn(4);
		TableColumn col5 = tablesetminimumstock.getColumnModel().getColumn(5);

		col0.setPreferredWidth(70);
		col1.setPreferredWidth(70);
		col2.setPreferredWidth(70);
		col3.setPreferredWidth(70);
		col4.setPreferredWidth(70);
		col5.setPreferredWidth(70);
		JScrollPane scrollPane = new JScrollPane(tablesetminimumstock, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 11, 1069, 431);
		datashow();
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 535, 1079, 138);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Minimum Stock Quantity:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(95, 32, 247, 17);
		panel_2.add(lblNewLabel);

		textFieldStockQty = new JTextField();
		textFieldStockQty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				int i = tablesetminimumstock.getSelectedRow();

				if (i >= 0) {
					modeal.setValueAt(textFieldStockQty.getText(), i, 4);
				}
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

		textFieldStockQty.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldStockQty.setBounds(324, 32, 204, 23);
		panel_2.add(textFieldStockQty);
		textFieldStockQty.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(SetMinimumStorck.class.getResource("/ImageButtonIcon/Save.png")));
		btnSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					conn = DBConnection.getConnection();
					int ii =0;
					int i = tablesetminimumstock.getSelectedRow();
					String value=modeal.getValueAt(i, 4).toString();
					
					for (int i1 = 0; i1 <= tablesetminimumstock.getRowCount(); i1++) {
						String Srnomaster = tablesetminimumstock.getValueAt(i, 4).toString();
					
						
						String s = "update groarybillingsystem.purchaseinfo set SetMinimumStock11 =? where SetMinimumStock11 ='"
								+ value + "'";
						ps = conn.prepareStatement(s);
						ps.setString(1, Srnomaster);
						 ii = ps.executeUpdate();
					}
					if (ii > 0) {
						JOptionPane.showMessageDialog(null, "Data are update..");
					}
				} catch (Exception ee) {
					System.out.println(ee.getMessage());
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(582, 31, 115, 36);
		panel_2.add(btnSave);

		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(SetMinimumStorck.class.getResource("/ImageButtonIcon/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(718, 31, 115, 36);
		panel_2.add(btnExit);

	}
}
