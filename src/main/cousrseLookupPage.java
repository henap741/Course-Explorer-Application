package main;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cousrseLookupPage extends JFrame {

	private JPanel contentPane;
	private JTextField courseLookupField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cousrseLookupPage frame = new cousrseLookupPage();
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
	public cousrseLookupPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton search_button = new JToggleButton("Search");
		search_button.setBounds(353, 38, 75, 23);
		search_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(search_button);
		
		JButton settings_button = new JButton("Settings");
		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		settings_button.setBounds(10, 231, 91, 23);
		contentPane.add(settings_button);
		
		courseLookupField = new JTextField();
		courseLookupField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		courseLookupField.setBounds(122, 39, 230, 22);
		contentPane.add(courseLookupField);
		courseLookupField.setColumns(10);
		
		JButton back_button = new JButton("Back");
		back_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		back_button.setBounds(122, 11, 62, 23);
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
		home_button.setBounds(186, 11, 68, 23);
		home_button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        mainMenuPage mainMenuPage = new mainMenuPage();
		        mainMenuPage.setVisible(true);
		        dispose();
		      }
		    });
		    contentPane.add(home_button, BorderLayout.EAST);
	}
}
