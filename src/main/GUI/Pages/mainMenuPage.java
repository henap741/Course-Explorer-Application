package main.GUI.Pages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.BusinessLogic.ProgramPathway.OsgoodeLawSchool;

import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class mainMenuPage extends JFrame {

	private JPanel contentPane;
	private cousrseLookupPage courseLookupPage;
	private facultyInfoPage facultyInfoPage;
	private courseDetailsPage courseDetailsPage;
	private OsgoodeLawSchool osgoode;

    public mainMenuPage(OsgoodeLawSchool osgoode) {
        this.osgoode = osgoode;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
    
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenuPage frame = new mainMenuPage();
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
	public mainMenuPage() {
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

		JButton course_lookup_button = new JButton("Course Lookup");
		course_lookup_button.setBounds(201, 53, 196, 23);
		course_lookup_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		course_lookup_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				courseLookupPage = new cousrseLookupPage();
				courseLookupPage.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(course_lookup_button);

		JButton degree_checklist_button = new JButton("Degree Checklist");
		degree_checklist_button.setBounds(201, 102, 196, 23);
		degree_checklist_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(degree_checklist_button);

		JButton suggested_path_button = new JButton("Suggested Path");
		suggested_path_button.setBounds(201, 152, 196, 23);
		suggested_path_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		suggested_path_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
				courseDetailsPage courseDetailsPage = new courseDetailsPage(osgoode);
				courseDetailsPage.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(suggested_path_button);

		JButton faculty_info_button = new JButton("Faculty Information");
		faculty_info_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		faculty_info_button.setBounds(201, 200, 196, 23);
		faculty_info_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				facultyInfoPage = new facultyInfoPage();
				facultyInfoPage.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(faculty_info_button);
	}
}
