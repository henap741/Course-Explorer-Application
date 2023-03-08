package test.GUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.BusinessLogic.ProgramPathway.OsgoodeLawSchool;
import main.BusinessLogic.ProgramPathway.pathwayCalculator;
import main.GUI.Pages.courseDetailsPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class courseDetailsPageTest {
	    
	    @Test
	    public void testConstructor() {
	        OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
	        courseDetailsPage page = new courseDetailsPage(osgoode);
	        
	        // Check that the degree combo box has the correct number of items
	        Assertions.assertEquals(osgoode.getDegreePrograms().size(), page.degreeComboBox.getItemCount());
	        
	        // Check that the degree info text area is initially empty
	        Assertions.assertTrue(page.degreeInfoTextArea.getText().isEmpty());
	        
	        // Check that the view courses button is initially disabled
	        Assertions.assertFalse(page.viewCoursesButton.isEnabled());
	    }

    @Test
    public void testDegreeComboBoxListener() {
        OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
        courseDetailsPage page = new courseDetailsPage(osgoode);

        // Select a degree from the combo box
        page.degreeComboBox.setSelectedIndex(0);

        // Check that the degree info text area is updated with the correct degree's description
        pathwayCalculator selectedDegree = osgoode.getDegreeProgram((String)page.degreeComboBox.getSelectedItem());
        String expectedText = "Degree Name: " + selectedDegree.getProgramName() + "\n" +
                              "Degree Duration: " + selectedDegree.getProgramDuration() + "\n" +
                              "Required Credits for Degree: " + selectedDegree.getRequiredCredits() + "\n" +
                              "Degree Description: " + selectedDegree.getProgramDescription();
        assertEquals(expectedText, page.degreeInfoTextArea.getText());

        // Check that the view courses button is enabled
        assertTrue(page.viewCoursesButton.isEnabled());
    }

    @Test
    public void testViewCoursesButtonListener() {
        OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
        courseDetailsPage page = new courseDetailsPage(osgoode);

        // Select a degree from the combo box
        page.degreeComboBox.setSelectedIndex(0);

        // Click the view courses button
        page.viewCoursesButton.doClick();

        // Check that the course panel is updated with the correct number of course buttons
        pathwayCalculator selectedDegree = osgoode.getDegreeProgram((String)page.degreeComboBox.getSelectedItem());
        assertEquals(selectedDegree.getRequiredCourses().size(), page.coursePanel.getComponentCount());
    }
}

//    private OsgoodeLawSchool osgoode;
//    private courseDetailsPage page;
//    
//    @Before
//    public void setUp() {
//        osgoode = new OsgoodeLawSchool();
//        page = new courseDetailsPage(osgoode);
//    }
//    
//    public Component findComponentByName(Container container, String componentName) {
//        Component[] components = container.getComponents();
//        for (Component component : components) {
//            String name = component.getName();
//            if (name != null && name.equals(componentName)) {
//                return component;
//            }
//            if (component instanceof Container) {
//                Component child = findComponentByName((Container) component, componentName);
//                if (child != null) {
//                    return child;
//                }
//            }
//        }
//        return null;
//    }
//
//    
//    @Test
//    public void testDegreeComboBox() {
//        // Test that the degree combo box is initialized with the correct items
//        @SuppressWarnings("unchecked")
//		JComboBox<String> degreeComboBox = (JComboBox<String>) findComponentByName(page, "degreeComboBox");
//        assertEquals(osgoode.getDegreePrograms().size(), degreeComboBox.getItemCount());
//        for (pathwayCalculator degree : osgoode.getDegreePrograms()) {
//        	// Check that the degree combo box has the correct program selected
//        	ComboBoxModel<String> degreeModel = degreeComboBox.getModel();
//        	assertTrue(((DefaultComboBoxModel<String>) degreeModel).getIndexOf(degree.getProgramName()) >= 0);
//
//        }
//    }
//    
//    @Test
//    public void testDegreeInfoTextArea() {
//        // Test that the degree info text area displays the correct information when a degree is selected
//        @SuppressWarnings("unchecked")
//		JComboBox<String> degreeComboBox = (JComboBox<String>) findComponentByName(page, "degreeComboBox");
//        JTextArea degreeInfoTextArea = (JTextArea) findComponentByName(page, "degreeInfoTextArea");
//        pathwayCalculator selectedDegree = osgoode.getDegreeProgram((String) degreeComboBox.getSelectedItem());
//        degreeComboBox.setSelectedIndex(0);
//        String expectedText = "Degree Name: " + selectedDegree.getProgramName() + "\n" +
//                "Degree Duration: " + selectedDegree.getProgramDuration() + "\n" +
//                "Required Credits for Degree: " + selectedDegree.getRequiredCredits() + "\n" +
//                "Degree Description: " + selectedDegree.getProgramDescription();
//        assertEquals(expectedText, degreeInfoTextArea.getText());
//    }
//    
//    @Test
//    public void testViewCoursesButton() {
//        // Test that the view courses button is disabled when no degree is selected
//        JButton viewCoursesButton = (JButton) findComponentByName(page, "viewCoursesButton");
//        assertFalse(viewCoursesButton.isEnabled());
//        
//        // Test that the view courses button is enabled when a degree is selected
//        @SuppressWarnings("unchecked")
//		JComboBox<String> degreeComboBox = (JComboBox<String>) findComponentByName(page, "degreeComboBox");
//        degreeComboBox.setSelectedIndex(0);
//        assertTrue(viewCoursesButton.isEnabled());
//    }
//    
//    @Test
//    public void testBackButton() {
//        // Test that the back button returns to the home page
//        JButton backButton = (JButton) findComponentByName(page, "backButton");
//        backButton.doClick();
//        assertTrue(page.isVisible()); // assuming that the home page is shown when the frame is made visible
//    }
////    @Test
////    public void testAddCourse() {
////        // Create an instance of OsgoodeLawSchool
////        OsgoodeLawSchool osgoode = new OsgoodeLawSchool();
////        
////        // Create a new course
////        courses newCourse = new courses("LAW 4000", "Constitutional Law", "Second Year", "3", "Winter", "An examination of the Canadian Constitution and the division of powers between the federal and provincial governments.", null, "Prof. White");
////        
////        // Add the new course to the degree program
////        pathwayCalculator jdProgram = osgoode.getDegreeProgram("Juris Doctor (JD)");
////        jdProgram.getRequiredCourses().add(newCourse);
////        
////        // Create a new course panel
////        coursePanel coursePanel = new coursePanel(jdProgram, osgoode);
////        JPanel panel = coursePanel.createPanel();
////        
////        // Test that the course panel contains the new course
////        assertTrue(panel.toString().contains("LAW 4000"));
////    }
//
////        		@Test
////        		public void testCoursePanel() {
////        		    // Test that the course panel is initially empty
////        		    JPanel coursePanel = (JPanel) findComponentByName(page, "coursePanel");
////        		    assertEquals(0, coursePanel.getComponentCount());
////
////        		    // Add a course and verify that it is displayed in the course panel
////        		    courses course = new courses("LAW 1000", "Introduction to Canadian Law", "First Year", "4", "Fall", "An introduction to the Canadian legal system and the role of law in Canadian society.", null, "Prof. Smith");
////        		    page.addcourses(course);
////        		    assertEquals(1, coursePanel.getComponentCount());
////
////        		    // Verify that the course panel displays the course name and instructor correctly
////        		    JPanel coursePanelEntry = (JPanel) coursePanel.getComponent(0);
////        		    JLabel courseNameLabel = (JLabel) findComponentByName(coursePanelEntry, "courseNameLabel");
////        		    JLabel instructorLabel = (JLabel) findComponentByName(coursePanelEntry, "instructorLabel");
////        		    assertEquals(course.getCourseName(), courseNameLabel.getText());
////        		    assertEquals("Instructor: " + course.getInstructor(), instructorLabel.getText());
////
////        		    // Add another course and verify that both courses are displayed in the course panel
////        		    courses course2 = new courses("LAW 3000", "Torts", "First Year", "4", "Winter", "An examination of the law of torts, including negligence, intentional torts, and strict liability.", null, "Prof. Brown");
////        		    page.addCourse(course2);
////        		    assertEquals(2, coursePanel.getComponentCount());
////
////        		    // Verify that both courses are displayed correctly in the course panel
////        		    JPanel coursePanelEntry2 = (JPanel) coursePanel.getComponent(1);
////        		    JLabel courseNameLabel2 = (JLabel) findComponentByName(coursePanelEntry2, "courseNameLabel");
////        		    JLabel instructorLabel2 = (JLabel) findComponentByName(coursePanelEntry2, "instructorLabel");
////        		    assertEquals(course2.getCourseName(), courseNameLabel2.getText());
////        		    assertEquals("Instructor: " + course2.getInstructor(), instructorLabel2.getText());
////        		}
//    }