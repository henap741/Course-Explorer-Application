package main.DB;

import main.DB.util.objects.courseObject;
import main.DB.util.objects.degChecklistObject;
import main.DB.util.objects.facultyObject;
import main.DB.util.objects.programObject;
import main.DB.util.objects.userObject;

public interface DBInterface {
        // Return TRUE or FALSE for CREATE, UPDATE, DELETE
        // Return Object for READ Methods

        // Login/Signup Methods
        public Boolean createUser(String username, String password, String userChecklistRef, String userProgramRef,
                        String[] coursesArray);

        public userObject getUser(String userID);

        public Boolean deleteUser();

        // Course Methods
        public Boolean createCourse(String courseID, String courseName, String courseDesc, String courseTerm,
                        String courseSection,
                        String courseCatNum, String courseInstructor, String courseStartTime, String courseDuration,
                        String courseNotes, String courseSectionDirector, String courseCredits, String courseYear,
                        String coursePrerequisites, String degreeName);

        public courseObject getCourse(String courseID);

        public Boolean updateCourse(String courseID, String courseName, String courseDesc, String courseTerm,
                        String courseSection,
                        String courseCatNum, String courseInstructor, String courseStartTime, String courseDuration,
                        String courseNotes, String courseSectionDirector, String courseCredits, String courseYear,
                        String coursePrerequisites, String degreeName);

        public Boolean deleteCourse(String courseID);

        // Faculty/Staff Methods
        public Boolean createFaculty(String ID, String type, String name, String email, String additionalInfo);

        public facultyObject getFaculty(String facultyID);

        public Boolean updateFaculty(String ID, String type, String name, String email, String additionalInfo);

        public Boolean deleteFaculty(String facultyID);

        // Checklists Methods
        public Boolean createDegreeChecklist(String ID, String userIDRef, String[] completedCourses,
                        String[] toCompleteCourses);

        public degChecklistObject getDegreeChecklist(String ID);

        public Boolean updateDegreeChecklist(String ID, String userIDRef, String[] completedCourses,
                        String[] toCompleteCourses);

        public Boolean deleteDegreeChecklist(String ID);

        // Programs Methods
        public Boolean createProgram(String ID, String[] faculty, String department, String name, String type,
                        String reqCredits, String[] reqCourses, String duration, String desc);

        public programObject getProgram(String ID);

        public Boolean updateProgram(String ID, String[] faculty, String department, String name, String type,
                        String reqCredits, String[] reqCourses, String duration, String desc);

        public Boolean deleteProgram(String ID);

}
