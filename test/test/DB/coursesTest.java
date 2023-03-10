package test.DB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.DB.DB;
import main.DB.util.objects.courseObject;

//============================================================================================================================================================================
// TESTS RELATIVE TO DATABASE METHODS
// ============================================================================================================================================================================

class coursesTest {
	DB db;
	boolean result;
	courseObject cobj;

	@BeforeAll
	void init() {
		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "W", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "Prerequisites: cumulative GPA of 4.50 or better over all major EECS courses (without second digit \"5\"); "
						+ "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
	}
	
	@Test
	// Checks if course was successfully created
	void createCourseTest() {
		result = db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "W", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "Prerequisites: cumulative GPA of 4.50 or better over all major EECS courses (without second digit \"5\"); "
				+ "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		assertTrue(result, "Required parameters to createCourse were empty or null");
	}

	@Test
	// Checks if course is retrieved successfully
	void getCourseTest() {
		cobj = db.getCourse("2311");
		assertEquals(cobj.getName(), "Software Development Project", "Retrieved course does not match parameters");
	}
	
	@Test
	// Checks if course update was successful
	void updateCourseTest1() {
		// Updated courseTerm from W to F
		result = db.updateCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "Prerequisites: cumulative GPA of 4.50 or better over all major EECS courses (without second digit \"5\"); "
				+ "LE/EECS 1030 3.00 or LE/EECS 2030 3.00.", "Software Engineering");
		assertTrue(result, "Required parameters to updateCourse were empty or null");
	}
	
	@Test
	// Checks if updated information is correct
	void updateCourseTest2() {
		cobj = db.getCourse("2311");
		assertEquals(cobj.getTerm(), "F", "Course parameter does not match input");
	}
	
	@Test
	// Checks if course deletion was successful
	void deleteCourseTest1() {
		result = db.deleteCourse("2311");
		assertEquals(result, "Course deletion was unsuccessful");
	}
	
	@Test
	// Checks if deleted course still exists
	void deleteCourseTest2() {
		cobj = db.getCourse("2311");
		assertNull(cobj, "Course deletion was unsuccessful, course still in the database");
	}
	

}
