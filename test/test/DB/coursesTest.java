package test.DB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.DB.DB;
import main.DB.util.objects.courseObject;

//============================================================================================================================================================================
// TESTS RELATIVE TO COURSE METHODS FROM DATABASE
// ============================================================================================================================================================================

class coursesTest {
	DB db = new DB();
	boolean result;
	courseObject cobj;

//	@Test
//	// Checks if course was successfully created
//	void createCourseTest() {
//		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
//					+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
//					+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
//					"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
//	}

	@Test
	// Checks if course is retrieved successfully
	void getCourseTest() {
		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		cobj = db.getCourse("2311");
		assertEquals(cobj.getName(), "Software Development Project", "Retrieved course does not match parameters");
		db.deleteCourse("2311");
	}

	@Test
	// Checks if course update was successful
	void updateCourseTest1() {
		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		result = db.updateCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		assertTrue(result, "Required parameters to updateCourse were empty or null");
		db.deleteCourse("2311");
	}

	@Test
	// Checks if updated information is correct
	void updateCourseTest2() {
		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "W", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		// Updated courseTerm from W to F
		db.updateCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "F", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");

		cobj = db.getCourse("2311");
		assertEquals(cobj.getTerm(), "F", "Course parameter does not match input");
		db.deleteCourse("2311");
	}

	@Test
	// Checks if course deletion was successful
	void deleteCourseTest1() {
		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
				+ " testing, deployment, and user documentation.", "W", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
		result = db.deleteCourse("2311");
		assertTrue(result, "Course deletion was unsuccessful");
	}

//	@Test
//	// Checks if deleted course still exists
//	void deleteCourseTest2() {
//		db.createCourse("2311", "Software Development Project", "This course allows students to develop a significant piece of software "
//				+ "utilizing all the skills they have acquired so far. This includes requirement elicitation, system specification, implementation,"
//				+ " testing, deployment, and user documentation.", "W", "Z", "G82E02", "Hadi Hemmati", "11:30", "120", "$5.00 - Course Materials", 
//				"Hadi Hemmati", "3", "2023", "LE/EECS 1030 3.00 or LE/EECS 2030 3.00", "Software Engineering");
//		db.deleteCourse("2311");
//		cobj = db.getCourse("2311");
//		assertNull(cobj, "Course deletion was unsuccessful, course still in the database");
//
//	}


}
