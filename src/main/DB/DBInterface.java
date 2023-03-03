package main.DB;

public interface DBInterface {

    // Login/Signup Methods
    public String[] createUser();

    public String[] readUser();

    // Course Methods
    public String[] createCourseInfo();

    public String[] readCourseInfo();

    public String[] updateCourseInfo();

    // Faculty/Staff Methods
    public void createFacultyInfo();

    public void readFacultyInfo();

    public void updateFacultyInfo();

    // Degree Requirements Methods
    public void createDegreeReq();

    public void readDegreeReq();

    public void updateDegreeReq();

}
