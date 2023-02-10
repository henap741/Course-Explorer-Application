package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class loginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginScreen frame = new loginScreen();
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
	public loginScreen() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title_label = new JLabel("Course Explorer");
		title_label.setFont(new Font("Verdana", Font.BOLD, 16));
		title_label.setBounds(147, 25, 144, 31);
		contentPane.add(title_label);
		
		JLabel username_label = new JLabel("Username");
		username_label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		username_label.setBounds(87, 88, 62, 14);
		contentPane.add(username_label);
		
		JButton login_button = new JButton("Login");
		login_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		login_button.setBounds(173, 153, 91, 23);
		contentPane.add(login_button);
		
		JLabel password_label = new JLabel("Password");
		password_label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		password_label.setBounds(87, 119, 62, 14);
		contentPane.add(password_label);
		
		usernameField = new JTextField();
		usernameField.setBounds(168, 86, 164, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 117, 166, 20);
		contentPane.add(passwordField);
		
		JButton guest_button = new JButton("Guest");
		guest_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		guest_button.setBounds(121, 215, 91, 23);
		contentPane.add(guest_button);
		
		JButton sign_up_button = new JButton("Sign up");
		sign_up_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		sign_up_button.setBounds(228, 215, 91, 23);
		contentPane.add(sign_up_button);
	}
}
