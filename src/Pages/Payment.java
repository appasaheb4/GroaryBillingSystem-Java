package Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		
		setBounds(270, 80, 1115,811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 45);
		contentPane.add(panel);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPayment.setBounds(10, 11, 125, 27);
		panel.add(lblPayment);
		
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 47, 1099, 698);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(36, 28, 237, 136);
		panel_1.add(panel_2);
		
		JButton btnVendorPayment = new JButton("VENDOR PAYMENT");
		btnVendorPayment.setForeground(Color.WHITE);
		btnVendorPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVendorPayment.setBackground(new Color(65, 105, 225));
		btnVendorPayment.setBounds(0, 102, 237, 36);
		panel_2.add(btnVendorPayment);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Payment.class.getResource("/Image/imageall/VendorPayment.png")));
		label_1.setBounds(22, 0, 215, 102);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(283, 28, 237, 136);
		panel_1.add(panel_3);
		
		JButton btnCustomerPayment = new JButton("CUSTOMER PAYMENT");
		btnCustomerPayment.setForeground(Color.WHITE);
		btnCustomerPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCustomerPayment.setBackground(new Color(148, 0, 211));
		btnCustomerPayment.setBounds(0, 102, 237, 36);
		panel_3.add(btnCustomerPayment);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Payment.class.getResource("/Image/imageall/customerpayment.png")));
		label_2.setBounds(22, 0, 215, 102);
		panel_3.add(label_2);
	}
}
