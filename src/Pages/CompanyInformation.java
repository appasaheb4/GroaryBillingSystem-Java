package Pages;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class CompanyInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldMobileNo;
	private JTextField textFieldVATTANNO;
	
	public Connection conn=null;
	public PreparedStatement pre;
	public PreparedStatement update;
	public ResultSet rs;

	public JLabel lblCompanyImage;
	public java.io.File f;
	public JLabel lblMouseClick;
	private JTextField textFieldEmailId;
	private JTextField textFieldSrNo;
	public String val1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyInformation frame = new CompanyInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void increment() {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn
					.prepareStatement("select max(Srno) from groarybillingsystem.companyinfo;");
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int val = (rs.getInt(1) + 1);
				val1 = String.valueOf(val);

			}
			textFieldSrNo.setText(val1);
			

		} catch (Exception ee) {
			System.out.println(ee.getMessage());
		}
	}
	
	

	/**
	 * Create the frame.
	 */
	public CompanyInformation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				textFieldName.requestFocus();
			}
		});
		
		
		
		setBounds(270, 80, 1115, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1184, 45);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblCompanyInformation = new JLabel("Company Information");
		lblCompanyInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCompanyInformation.setBounds(10, 11, 297, 27);
		panel.add(lblCompanyInformation);
		
		JButton button = new JButton("X");
		button.setForeground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setOpaque(false);
		button.setFont(new Font("Tahoma", Font.PLAIN, 30));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(990, -1, 69, 45);
		panel.add(button);
		
		textFieldSrNo = new JTextField();
		textFieldSrNo.setEnabled(false);
		textFieldSrNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSrNo.setColumns(10);
		textFieldSrNo.setBounds(279, 10, 279, 28);
		increment();
		textFieldSrNo.setVisible(false);
		panel.add(textFieldSrNo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Company Registation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 1079, 669);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 36, 45, 17);
		panel_1.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldName.setColumns(10);
		textFieldName.setBounds(109, 31, 279, 28);
		
		panel_1.add(textFieldName);
		
		JLabel label_1 = new JLabel("Address:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(449, 31, 61, 17);
		panel_1.add(label_1);
		
		TextArea textAreaAddress = new TextArea();
		textAreaAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAddress.setBounds(548, 31, 279, 93);
		panel_1.add(textAreaAddress);
		
		JLabel lblPhoneNo = new JLabel("Mobile No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhoneNo.setBounds(10, 164, 73, 17);
		panel_1.add(lblPhoneNo);
		
		textFieldMobileNo = new JTextField();
		textFieldMobileNo.addKeyListener(new KeyAdapter() {
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
		textFieldMobileNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldMobileNo.getText().length() == 10) {

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter 10 digit mobile number.");
				
				}
			}
		});
		textFieldMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMobileNo.setColumns(10);
		textFieldMobileNo.setBounds(109, 164, 279, 28);
		panel_1.add(textFieldMobileNo);
		
		JLabel lblVatTinNo = new JLabel("VAT TIN No.");
		lblVatTinNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVatTinNo.setBounds(449, 231, 96, 17);
		panel_1.add(lblVatTinNo);
		
		textFieldVATTANNO = new JTextField();
		textFieldVATTANNO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldVATTANNO.setColumns(10);
		textFieldVATTANNO.setBounds(548, 231, 279, 28);
		panel_1.add(textFieldVATTANNO);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon(CompanyInformation.class.getResource("/ImageButtonIcon/Exit.png")));
		btnExit.setHorizontalAlignment(SwingConstants.LEADING);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setToolTipText("Plz enter mobile number.");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(135, 578, 115, 35);
		panel_1.add(btnExit);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.setIcon(new ImageIcon(CompanyInformation.class.getResource("/ImageButtonIcon/Save.png")));
		btnAdd.setHorizontalAlignment(SwingConstants.LEADING);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					FileInputStream fin=new FileInputStream(f);
					int len=(int)f.length();
				
				conn = DBConnection.getConnection();
				String query = "insert into groarybillingsystem.companyinfo values(?,?,?,?,?,?,?)";
				pre = conn.prepareStatement(query);
				pre.setInt(1, Integer.parseInt(textFieldSrNo.getText()));
				pre.setString(2, textFieldName.getText());
				pre.setString(3, textAreaAddress.getText());
				pre.setString(4, textFieldMobileNo.getText());
				pre.setString(5, textFieldVATTANNO.getText());
				pre.setBinaryStream(6,fin,len);
				pre.setString(7, textFieldEmailId.getText());
				
				int i = pre.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Data are saved.");
					dispose();
					MasterEntery se=new MasterEntery();
					se.setVisible(true);
					pre.close();
					conn.close();
				} else {
					JOptionPane.showMessageDialog(null,
							"Data are not saved.");

				}

			} catch (Exception adm) {
				System.out.println(adm.getMessage());
			}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(10, 578, 115, 35);
		panel_1.add(btnAdd);
		
		JLabel lblCompanyLogo = new JLabel("Company Logo.");
		lblCompanyLogo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompanyLogo.setBounds(10, 242, 153, 17);
		panel_1.add(lblCompanyLogo);
		
		JLabel lblEmailId = new JLabel("Email Id:");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmailId.setBounds(449, 164, 73, 17);
		panel_1.add(lblEmailId);
		
		textFieldEmailId = new JTextField();
		textFieldEmailId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if (textFieldEmailId.getText().length() != 0) {

					String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					String email1 = textFieldEmailId.getText();
					Boolean b = email1.matches(EMAIL_REGEX);
					if(b==false)
					{
					JOptionPane.showMessageDialog(null,"Plz enter correct email address.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Plz enter email id.");
				}
			}
		});
		textFieldEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEmailId.setColumns(10);
		textFieldEmailId.setBounds(548, 164, 279, 28);
		panel_1.add(textFieldEmailId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(100, 270, 644, 289);
		panel_1.add(scrollPane);
		 
		  lblMouseClick = new JLabel("Plz click mouse ->");
		  scrollPane.setRowHeaderView(lblMouseClick);
		  lblMouseClick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		  lblMouseClick.setHorizontalAlignment(SwingConstants.CENTER);
		  
		   lblCompanyImage = new JLabel("");
		   scrollPane.setViewportView(lblCompanyImage);
		   lblCompanyImage.addMouseListener(new MouseAdapter() {
		   	@Override
		   	public void mouseClicked(MouseEvent e) {
		   		JFileChooser fc=new JFileChooser();
				fc.showOpenDialog(contentPane);
				 f=fc.getSelectedFile();
				String path=f.getAbsolutePath();
				lblCompanyImage.setIcon(new ImageIcon(path));
				lblMouseClick.setVisible(false);
		   	}
		   });
		   
		   lblCompanyImage.setHorizontalAlignment(SwingConstants.CENTER);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, panel, lblCompanyInformation, button, textFieldSrNo, panel_1, label, textFieldName, label_1, textAreaAddress, lblPhoneNo, textFieldMobileNo, textFieldEmailId, lblVatTinNo, textFieldVATTANNO, btnExit, btnAdd, lblCompanyLogo, lblCompanyImage, lblMouseClick, lblEmailId}));
	}
}
