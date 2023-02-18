package main.GUI.Pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class courseDetailsPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseDetailsPage frame = new courseDetailsPage();
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
	public courseDetailsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton settings_button = new JButton("Settings");
		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		settings_button.setBounds(10, 231, 91, 23);
		contentPane.add(settings_button);

		JButton back_button = new JButton("Back");
		back_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		back_button.setBounds(133, 11, 63, 23);
		back_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenuPage mainMenuPage = new mainMenuPage();
				mainMenuPage.setVisible(true);
				dispose();
			}
		});
		contentPane.add(back_button, BorderLayout.WEST);

		JButton home_button = new JButton("Home");
		home_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		home_button.setBounds(200, 11, 63, 23);
		home_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenuPage mainMenuPage = new mainMenuPage();
				mainMenuPage.setVisible(true);
				dispose();
			}
		});
		contentPane.add(home_button, BorderLayout.EAST);
		// contentPane.add(home_button);
	}

}
