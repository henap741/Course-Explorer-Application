package test.BusinessLogic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.BusinessLogic.ProgramPathway.OsgoodeLawSchool;
import main.BusinessLogic.ProgramPathway.courses;
import main.BusinessLogic.ProgramPathway.pathwayCalculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

/**
 * @author Hena Patel
 *
 */

class programPathwayTest {
	
	public static void main(String[] args) {
        
        // create a list of required courses
        ArrayList<courses> requiredCourses = new ArrayList<courses>();
        courses course1 = new courses("CSCI101", "Introduction to Computer Science", "First Year", "4", "Winter", null, requiredCourses, null);
        courses course2 = new courses("CSCI201", "Data Structures and Algorithms", "First Year", "3", "Fall", null, requiredCourses, null);
        requiredCourses.add(course1);
        requiredCourses.add(course2);

        // create a pathway calculator
        pathwayCalculator calculator = new pathwayCalculator("Computer Science", "4", "This program prepares students for a career in software development", "190", requiredCourses);

        // test the getters
        assert(calculator.getProgramName().equals("Computer Science"));
        assert(calculator.getProgramDescription().equals("This program prepares students for a career in software development"));
        assert(calculator.getRequiredCourses().size() == 2);
        assert(calculator.getRequiredCourses().get(0).getCourseCode().equals("CSCI101"));
        assert(calculator.getRequiredCourses().get(0).getCourseName().equals("Introduction to Computer Science"));
        assert(calculator.getRequiredCourses().get(1).getCourseCode().equals("CSCI201"));
        assert(calculator.getRequiredCourses().get(1).getCourseName().equals("Data Structures and Algorithms"));

        // add more test cases as needed

        System.out.println("All tests passed.");
    }

    @Test
    public void testPathwayCalculator() {
        ArrayList<courses> coursesList = new ArrayList<>();
        coursesList.add(new courses("Course 1", "Course Name 1", "First Year", "4", "Winter", null, coursesList, null));
        coursesList.add(new courses("Course 2", "Course Name 2", "Second Year", "4", "Fall", null, coursesList, null));
        pathwayCalculator calculator = new pathwayCalculator("Program Name", "Program Duration", "Program Description", "Requried Credits", coursesList);
        assertNotNull(calculator);
        assertEquals("Program Name", calculator.getProgramName());
        assertEquals("Program Duration", calculator.getProgramDuration());
        assertEquals("Requried Credits", calculator.getRequiredCredits());
        assertEquals("Program Description", calculator.getProgramDescription());
        assertEquals(2, calculator.getRequiredCourses().size());

        // test the courses class
        courses course1 = calculator.getRequiredCourses().get(0);
        assertEquals("Course 1", course1.getCourseCode());
        assertEquals("Course Name 1", course1.getCourseName());
        assertEquals("First Year", course1.getCourseYear());
        assertEquals("4", course1.getCourseCredits());
        assertEquals("Winter", course1.getCourseTerm());
        assertEquals(2, course1.getPrerequisites().size());

        courses course2 = calculator.getRequiredCourses().get(1);
        assertEquals("Course 2", course2.getCourseCode());
        assertEquals("Course Name 2", course2.getCourseName());
        assertEquals("Second Year", course2.getCourseYear());
        assertEquals("4", course2.getCourseCredits());
        assertEquals("Fall", course2.getCourseTerm());
        assertEquals(2, course2.getPrerequisites().size());
    }
   
        @Test
        public void testGetDegreePrograms() {
            OsgoodeLawSchool lawSchool = new OsgoodeLawSchool();
            ArrayList<pathwayCalculator> degreePrograms = lawSchool.getDegreePrograms();
            
            // Check that the degreePrograms ArrayList is not null and has two elements
            assertEquals(2, degreePrograms.size());
            assertEquals("Juris Doctor (JD)", degreePrograms.get(0).getProgramName());
            assertEquals("Master of Laws (LLM)", degreePrograms.get(1).getProgramName());
        }
        
        @Test
        public void testGetCourse() {
            OsgoodeLawSchool lawSchool = new OsgoodeLawSchool();
            
            // Check that the getCourse() method returns the expected course for a given course code
            courses course = lawSchool.getCourse("LAW 2000");
            assertEquals("Contracts", course.getCourseName());
            assertEquals("Second Year", course.getCourseYear());
            assertEquals("Fall", course.getCourseTerm());
            assertEquals("Prof. Jones", course.getInstructor());
            
            // Check that the getCourse() method returns null if an invalid course code is provided
            assertNull(lawSchool.getCourse("XXX 1234"));
        }
        
        @Test
        public void testGetDegreeProgram() {
            OsgoodeLawSchool lawSchool = new OsgoodeLawSchool();
            
            // Check that the getDegreeProgram() method returns the expected degree program for a given program name
            pathwayCalculator program = lawSchool.getDegreeProgram("Master of Laws (LLM)");
            assertEquals("This degree is for Master of Laws (LLM)", program.getProgramDescription());
            assertEquals(2, program.getRequiredCourses().size());
            assertEquals("LLM 5000", program.getRequiredCourses().get(1).getCourseCode());
            assertEquals("Prof. Patel", program.getRequiredCourses().get(1).getInstructor());
            
            // Check that the getDegreeProgram() method returns null if an invalid program name is provided
            assertNull(lawSchool.getDegreeProgram("Invalid Program Name"));
        }
}

