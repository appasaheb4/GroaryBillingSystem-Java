package Pages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class BackupDiagog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldBackupname;
	private JTextField textFieldrename;
	public String path=null;
	public String path1;
	public String filename;
	public JButton button_4 ;
	public JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BackupDiagog dialog = new BackupDiagog();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BackupDiagog() {
		
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(270, 80, 582, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 570, 45);
		panel.setLayout(null);
		contentPanel.add(panel);
		
		JLabel label = new JLabel("BackUp");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(28, 11, 102, 27);
		panel.add(label);
		
		JLabel label_1 = new JLabel("You can take a BackUp of your database by clicking on this Backup button.\r\n");
		label_1.setBounds(10, 56, 460, 17);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(label_1);
		
		textFieldBackupname = new JTextField();
		textFieldBackupname.setBounds(10, 82, 280, 25);
		textFieldBackupname.setForeground(Color.BLUE);
		textFieldBackupname.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldBackupname.setEnabled(false);
		textFieldBackupname.setEditable(false);
		textFieldBackupname.setColumns(10);
		contentPanel.add(textFieldBackupname);
		
		JButton btnBrowger = new JButton("Browger");
		btnBrowger.setIcon(new ImageIcon(BackupDiagog.class.getResource("/ImageButtonIcon/Browse4.png")));
		btnBrowger.setHorizontalAlignment(SwingConstants.LEADING);
		btnBrowger.setBounds(300, 77, 126, 36);
		btnBrowger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser();
				fc.showOpenDialog(contentPanel);
				String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				try
				{
					File f=fc.getSelectedFile();
					path=f.getAbsolutePath();
					path=path.replace('\\', '/');
					path=path+"_"+date+".sql";
					textFieldBackupname.setText(path);
				}
				catch(Exception ee){}
				
				
				
				
			
			}
		});
		btnBrowger.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(btnBrowger);
		
		JButton btnNewButton = new JButton("BackUp");
		btnNewButton.setIcon(new ImageIcon(BackupDiagog.class.getResource("/ImageButtonIcon/BackUp2.jpg")));
		btnNewButton.setBounds(437, 77, 119, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Process p=null;
				if(textFieldBackupname.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Plz Backup Location Select.");
				}
				else
				{
				try
				{
					Runtime runtime=Runtime.getRuntime();
					p=runtime.exec("C:/Program Files (x86)/MySQL/MySQL Server 5.5/bin/mysqldump.exe -uroot -papple4 --add-drop-database -B groarybillingsystem -r"+path);
					int processComplete=p.waitFor();
					if(processComplete==0)
					{
						JOptionPane.showMessageDialog(null, "BackUp Creaated Succuss");
						button_4.setEnabled(true);
						okButton.setEnabled(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "BackUp not created");
						
					}
				}
				catch(Exception sq)
				{
					System.out.println(sq.getMessage());
				}
			}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(btnNewButton);
		
		JLabel label_2 = new JLabel("You can Restore your database and get complete data by clicking on this Restore button.\r\n");
		label_2.setBounds(10, 118, 548, 17);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(label_2);
		
		textFieldrename = new JTextField();
		textFieldrename.setBounds(10, 140, 280, 25);
		textFieldrename.setForeground(Color.BLUE);
		textFieldrename.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldrename.setEnabled(false);
		textFieldrename.setEditable(false);
		textFieldrename.setColumns(10);
		contentPanel.add(textFieldrename);
		
		JButton buttonRerstiveButoon = new JButton("Browger");
		buttonRerstiveButoon.setIcon(new ImageIcon(BackupDiagog.class.getResource("/ImageButtonIcon/Browse4.png")));
		buttonRerstiveButoon.setHorizontalAlignment(SwingConstants.LEADING);
		buttonRerstiveButoon.setBounds(300, 139, 126, 36);
		buttonRerstiveButoon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc1=new JFileChooser();
				fc1.showOpenDialog(contentPanel);
				try
				{
					File ff=fc1.getSelectedFile();
					path1=ff.getAbsolutePath();
					path1=path1.replace('\\', '/');
					textFieldrename.setText(path1);
				}
				catch(Exception es)
				{
					es.printStackTrace();
				}
			}
		});
		buttonRerstiveButoon.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(buttonRerstiveButoon);
		
		JButton btnRestore = new JButton("Restore");
		btnRestore.setIcon(new ImageIcon(BackupDiagog.class.getResource("/ImageButtonIcon/Restore3.jpg")));
		btnRestore.setHorizontalAlignment(SwingConstants.LEADING);
		btnRestore.setBounds(437, 139, 119, 36);
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbName = "groarybillingsystem";
	             String dbUser = "root";
	             String dbPass = "apple4";
				String [] restoreCmd=new String[]{"C:/Program Files (x86)/MySQL/MySQL Server 5.5/bin/mysql.exe", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + path1};
			
																										
				Process process;
				if(textFieldrename.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Plz Backup Location Select.");
				}
				else
				{
				
				try
				{
					process=Runtime.getRuntime().exec(restoreCmd);
					int processCom=process.waitFor();
					if(processCom==0)
					{
						JOptionPane.showMessageDialog(null,"Restored Succuss.");
						button_4.setEnabled(true);
						okButton.setEnabled(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Can't Resotore.");
					}
					
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
				}
			}
		});
		btnRestore.setFont(new Font("Dialog", Font.PLAIN, 14));
		contentPanel.add(btnRestore);
		
		JLabel label_3 = new JLabel("Exit this form.\r\n");
		label_3.setBounds(10, 177, 85, 17);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(label_3);
		
		 button_4 = new JButton("Exit");
		 button_4.setIcon(new ImageIcon(BackupDiagog.class.getResource("/ImageButtonIcon/Exit.png")));
		 button_4.setHorizontalAlignment(SwingConstants.LEADING);
		 button_4.setBounds(10, 201, 106, 36);
		button_4.setEnabled(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(button_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 241, 560, 45);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Note:");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 34, 17);
		panel_1.add(lblNewLabel);
		
		JLabel lblAtLeastBackup = new JLabel("At least Backup then exit button enable.");
		lblAtLeastBackup.setForeground(Color.BLUE);
		lblAtLeastBackup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtLeastBackup.setBounds(54, 11, 466, 17);
		panel_1.add(lblAtLeastBackup);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				 okButton = new JButton("OK");
				 okButton.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		System.exit(0);
				 	}
				 });
				okButton.setActionCommand("OK");
				okButton.setEnabled(false);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
		}
	}
}
