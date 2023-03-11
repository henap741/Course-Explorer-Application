package main.GUI.Pages;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.DB.DB;
import main.DB.util.objects.courseObject;

import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cousrseLookupPage extends JFrame {

//	private JPanel contentPane;
//	private JTextField courseLookupField;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					cousrseLookupPage frame = new cousrseLookupPage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public cousrseLookupPage() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JToggleButton search_button = new JToggleButton("Search");
//		search_button.setBounds(353, 38, 75, 23);
//		search_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		contentPane.add(search_button);
//
//		JButton settings_button = new JButton("Settings");
//		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		settings_button.setBounds(10, 231, 91, 23);
//		contentPane.add(settings_button);
//
//		courseLookupField = new JTextField();
//		courseLookupField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//		courseLookupField.setBounds(122, 39, 230, 22);
//		contentPane.add(courseLookupField);
//		courseLookupField.setColumns(10);
//
//		JButton back_button = new JButton("Back");
//		back_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		back_button.setBounds(122, 11, 62, 23);
//		back_button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainMenuPage mainMenuPage = new mainMenuPage();
//				mainMenuPage.setVisible(true);
//				dispose();
//			}
//		});
//		contentPane.add(back_button, BorderLayout.WEST);
//
//		JButton home_button = new JButton("Home");
//		home_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		home_button.setBounds(186, 11, 68, 23);
//		home_button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainMenuPage mainMenuPage = new mainMenuPage();
//				mainMenuPage.setVisible(true);
//				dispose();
//			}
//		});
//		contentPane.add(home_button, BorderLayout.EAST);
//	}
//	import javax.swing.*;
//	import java.awt.*;
//	import java.awt.event.ActionEvent;
//	import java.awt.event.ActionListener;
//
//	public class CourseGUI extends JFrame {
	    private JTextField courseIDField;
	    private JTextArea courseDetailsArea;

	    public cousrseLookupPage() {
	        super("Course LookUp");
	        setSize(500, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());

	        JLabel courseIDLabel = new JLabel("Enter Course ID:");
	        courseIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	        courseIDField = new JTextField(20);
	        JButton retrieveButton = new JButton("Retrieve");
	        retrieveButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
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
	        courseDetailsArea = new JTextArea(10, 40);

	        panel.add(courseIDLabel, BorderLayout.WEST);
	        panel.add(courseIDField, BorderLayout.CENTER);
	        panel.add(home_button, BorderLayout.EAST);
	        panel.add(retrieveButton, BorderLayout.AFTER_LAST_LINE);
	        add(panel, BorderLayout.NORTH);
	        add(new JScrollPane(courseDetailsArea), BorderLayout.CENTER);

	        retrieveButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String courseID = courseIDField.getText();
	                if (courseID != null && !courseID.isEmpty()) {
	                	DB db = new DB(); // create an instance of the DB class
	                	courseObject course = db.getCourse(courseID); // call getCourse on the instance

	                    //courseObject course = DB.getCourse(courseID);
	                    if (course != null) {
	                        courseDetailsArea.setText(course.toString());
	                    } else {
	                        courseDetailsArea.setText("Course not found");
	                    }
	                } else {
	                    courseDetailsArea.setText("Please enter a course ID");
	                }
	            }
	        });
	    }

	    public static void main(String[] args) {
	    	cousrseLookupPage cousrseLookupPage = new cousrseLookupPage();
	    	cousrseLookupPage.setVisible(true);
	    }
	}
