package main.DB;

import main.DB.util.objects.courseObject;
import main.DB.util.objects.facultyObject;
import main.DB.util.objects.userObject;

public interface DBInterface {
    // Return TRUE or FALSE for CREATE, UPDATE, DELETE
    // Return Object for get Methods

    // Login/Signup Methods
    public Boolean createUser();

    public userObject readUser();

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
    public Boolean createFaculty();

    public facultyObject getFaculty();

    public Boolean updateFaculty();

    public Boolean deleteFaculty();

    // Degree Requirements Methods
    public Boolean createDegreeChecklist();

    public Boolean getDegreeChecklist();

    public Boolean updateDegreeChecklist();

    public Boolean deleteDegreeChecklist();

}
