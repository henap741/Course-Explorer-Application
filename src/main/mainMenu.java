package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class mainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu frame = new mainMenu();
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
	public mainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton settings_button = new JToggleButton("Settings");
		settings_button.setBounds(10, 231, 110, 23);
		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(settings_button);
		
		JLabel menu_label = new JLabel("Menu");
		menu_label.setBounds(274, 11, 48, 14);
		menu_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(menu_label);
		
		JButton course_lookup_label = new JButton("Course Lookup");
		course_lookup_label.setBounds(201, 50, 196, 23);
		course_lookup_label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(course_lookup_label);
		
		JButton degree_checklist_label = new JButton("Degree Checklist");
		degree_checklist_label.setBounds(201, 105, 196, 23);
		degree_checklist_label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(degree_checklist_label);
		
		JButton suggested_path_label = new JButton("Suggested Path");
		suggested_path_label.setBounds(201, 155, 196, 23);
		suggested_path_label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(suggested_path_label);
	}
}
