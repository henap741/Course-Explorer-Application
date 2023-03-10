package main.GUI.Pages;

import java.awt.BorderLayout;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.BusinessLogic.ProgramPathway.OsgoodeLawSchool;
import main.BusinessLogic.ProgramPathway.courses;
import main.BusinessLogic.ProgramPathway.pathwayCalculator;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//	private JPanel contentPane;
//	private JPanel degreePanel;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					courseDetailsPage frame = new courseDetailsPage();
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
//	public courseDetailsPage() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JButton settings_button = new JButton("Settings");
//		settings_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		settings_button.setBounds(10, 231, 91, 23);
//		contentPane.add(settings_button);
//
//		JButton back_button = new JButton("Back");
//		back_button.setFont(new Font("Times New Roman", Font.BOLD, 12));
//		back_button.setBounds(133, 11, 63, 23);
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
//		home_button.setBounds(200, 11, 69, 23);
//		home_button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				mainMenuPage mainMenuPage = new mainMenuPage();
//				mainMenuPage.setVisible(true);
//				dispose();
//			}
//		});
//		contentPane.add(home_button, BorderLayout.EAST);
//		// contentPane.add(home_button);
//
//
//	        setTitle("Osgoode Law School");
//	        setSize(500, 300);
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	        // Create the degree panel
//	        degreePanel = new JPanel();
//
//	        // Create the course panel
//	        coursePanel = new JPanel();
//


//    private static class degreeComboBoxListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String selectedDegree = (String) degreeComboBox.getSelectedItem();
//            pathwayCalculator degreeProgram = osgoode.getDegreeProgram(selectedDegree);
//            filteredCourses = degreeProgram.getRequiredCourses().toArray(new Course[0]);
//            courseComboBox.removeAllItems();
//            for (Course course : filteredCourses) {
//                courseComboBox.addItem(course.getCourseCode());
//            }
//            courseInfoTextArea.setText("");
//        }
//    }
//
//    private static class courseComboBoxListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String selectedCourseCode = (String) courseComboBox.getSelectedItem();
//            courses selectedCourse = osgoode.getCourse(selectedCourseCode);
//            if (selectedCourse != null) {
//                String courseName = selectedCourse.getCourseName();
//                String courseDescription = selectedCourse.getCourseDescription();
//                String courseInstructor = selectedCourse.getInstructor();
//                courseInfoTextArea.setText("Course Name: " + courseName + "\n" +
//                                            "Course Description: " + courseDescription + "\n" +
//                                            "Course Professor: " + courseInstructor);
//            } else {
//                courseInfoTextArea.setText("Error: Course details not found.");
//            }
//        }
//    }

public class courseDetailsPage extends JFrame {
    private OsgoodeLawSchool osgoode;
    public JComboBox<String> degreeComboBox;
    public JTextArea degreeInfoTextArea;
    public JButton viewCoursesButton;
    private JButton backButton;
    public JPanel coursePanel;
    private JLabel courseDescriptionLabel;
    private JTextArea courseInfoTextArea;
    private JLabel lblNewLabel;
    private JLabel title;

    public static void main(String[] args) {
        OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
        courseDetailsPage page = new courseDetailsPage(osgoode);
    }
    
    public courseDetailsPage(OsgoodeLawSchool osgoode) {
        this.osgoode = osgoode;

        // Set up window
        setTitle("Course Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        // Set up main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Set up degree combo box
        degreeComboBox = new JComboBox<String>();
        for (pathwayCalculator pathwayCalculator : osgoode.getDegreePrograms()) {
            degreeComboBox.addItem(pathwayCalculator.getProgramName());
        }
        degreeComboBox.addActionListener(new degreeComboBoxListener());

        // Set up degree info text area
        degreeInfoTextArea = new JTextArea();
        degreeInfoTextArea.setEditable(false);
        JScrollPane degreeInfoScrollPane = new JScrollPane(degreeInfoTextArea);
        degreeInfoScrollPane.setPreferredSize(new Dimension(0, 100));

        // Set up view courses button
        viewCoursesButton = new JButton("View Courses");
        viewCoursesButton.setEnabled(false);
        viewCoursesButton.addActionListener(new viewCoursesButtonListener());

        // Set up back button
        backButton = new JButton("Home");
        backButton.addActionListener(new backButtonListener());

        // Set up top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(backButton, BorderLayout.EAST);
        topPanel.add(degreeComboBox, BorderLayout.CENTER);
        topPanel.add(viewCoursesButton, BorderLayout.AFTER_LAST_LINE);//.AFTER_LAST_LINE);

        // Set up degree panel
        JPanel degreePanel = new JPanel(new BorderLayout());
        degreePanel.add(new JLabel("Degree Description:"), BorderLayout.NORTH);
        degreePanel.add(degreeInfoScrollPane, BorderLayout.CENTER);
        //degreePanel.add(backButton, BorderLayout.SOUTH);
        
        // Set up course panel
        coursePanel = new JPanel(new GridBagLayout());
        
        // Set up course description label
        courseDescriptionLabel = new JLabel();
        courseDescriptionLabel.setPreferredSize(new Dimension(200, 100));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        coursePanel.add(courseDescriptionLabel, gbc);

        // Set up course info text area
        courseInfoTextArea = new JTextArea();
        courseInfoTextArea.setEditable(false);
        JScrollPane courseInfoScrollPane = new JScrollPane(courseInfoTextArea);
        courseInfoScrollPane.setPreferredSize(new Dimension(0, 100));

        // Set up split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, degreePanel, courseInfoScrollPane);
        splitPane.setResizeWeight(0.5);
        splitPane.setDividerSize(10);
        
        // Add components to main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        title = new JLabel("Select Degree");
        title.setFont(new Font("Times New Roman", Font.BOLD, 16));
        topPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(splitPane, BorderLayout.CENTER);
        //mainPanel.add(degreePanel, BorderLayout.WEST);
        mainPanel.add(coursePanel, BorderLayout.EAST);
        //mainPanel.add(courseInfoScrollPane, BorderLayout.CENTER);
        
        lblNewLabel = new JLabel("Course Description:");
        courseInfoScrollPane.setColumnHeaderView(lblNewLabel);
        
        // Add main panel to window
        getContentPane().add(mainPanel);
        
        // Show window
        setVisible(true);
    }

          private class degreeComboBoxListener implements ActionListener {
          public void actionPerformed(ActionEvent e) {
              // Update degree info text area with selected degree's description
              pathwayCalculator selectedDegree = osgoode.getDegreeProgram((String)degreeComboBox.getSelectedItem());
              degreeInfoTextArea.setText("Degree Name: " + selectedDegree.getProgramName() + "\n" +
            		  "Degree Duration: " + selectedDegree.getProgramDuration() + "\n" +
            		  "Required Credits for Degree: " + selectedDegree.getRequiredCredits() + "\n" +
                      "Degree Description: " + selectedDegree.getProgramDescription());
 
              // Enable view courses button
              viewCoursesButton.setEnabled(true);
//            if (selectedDegree != null) {
//                degreeInfoTextArea.setText(selectedDegree.getProgramDescription());
//                viewCoursesButton.setEnabled(true);
//            }
        }
    }

    private class viewCoursesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Clear current course panel and course information
            coursePanel.removeAll();
//            courseDescriptionLabel.setText("");
//            courseInfoTextArea.setText("");

            // Add course buttons for selected degree's courses
            pathwayCalculator selectedDegree = osgoode.getDegreeProgram((String)degreeComboBox.getSelectedItem());
            for (courses course : selectedDegree.getRequiredCourses()) {
                JButton courseButton = new JButton(course.getCourseCode());
                courseButton.addActionListener(new courseButtonListener(course));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = selectedDegree.getRequiredCourses().indexOf(course);
                gbc.insets = new Insets(5, 5, 5, 5);
                coursePanel.add(courseButton, gbc);
            }

            coursePanel.revalidate();
            coursePanel.repaint();
        }
    }

    private class courseButtonListener implements ActionListener {
        private courses course;

        public courseButtonListener(courses course) {
            this.course = course;
        }

        public void actionPerformed(ActionEvent e) {
            // Update course description label with selected course's description
            courseDescriptionLabel.setText(course.getCourseDescription());

            // Update course information text area with selected course's information
            String selectedCourseCode = course.getCourseCode();
            courses selectedCourse = osgoode.getCourse(selectedCourseCode);
            if (selectedCourse != null) {
                String courseName = selectedCourse.getCourseName();
                String courseCredits = selectedCourse.getCourseCredits();
                String courseTerm = selectedCourse.getCourseTerm();
                String courseDuration = selectedCourse.getCourseDuration();
                String courseDescription = selectedCourse.getCourseDescription();
                String courseInstructor = selectedCourse.getInstructor();
                courseInfoTextArea.setText("Course Name: " + courseName + "\n" +
                							"Course Credits: " + courseCredits + "\n" +
                							"Course Duration: " + courseDuration + "\n" +
                							"Course Term: " + courseTerm + "\n" +
                                            "Course Professor: " + courseInstructor + "\n" +
                                            "Course Description: " + courseDescription);
            } else {
                courseInfoTextArea.setText("Error: Course details not found.");
            }
        }
    }

	  private class backButtonListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	      mainMenuPage mainMenuPage = new mainMenuPage();
			mainMenuPage.setVisible(true);
			dispose();
	  }
  }
}

       
