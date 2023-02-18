package main.DB;

public interface DBInterface {

    // Login/Signup Methods
    public void createAccount();

    public void readAccount();

    // Course Methods
    public void createCourseInfo();

    public void readCourseInfo();

    public void updateCourseInfo();

    // Faculty/Staff Methods
    public void createFacultyInfo();

    public void readFacultyInfo();

    public void updateFacultyInfo();

    // Degree Requirements Methods
    public void createDegreeReq();

    public void readDegreeReq();

    public void updateDegreeReq();

}
