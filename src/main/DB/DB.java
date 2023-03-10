package main.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.DB.util.objects.courseObject;
import main.DB.util.objects.facultyObject;
import main.DB.util.objects.userObject;
import main.DB.util.connectToDB;
import main.DB.util.utility;

public class DB implements DBInterface {
    connectToDB DB = new connectToDB();
    utility localUtils = new utility();

    // ============================================================================================================================================================================
    // USER METHODS
    // ============================================================================================================================================================================

    public Boolean createUser() {

        return false;
    }

    public userObject readUser() {

        return null;
    }

    public Boolean deleteUser() {

        return null;
    }

    // ============================================================================================================================================================================
    // COURSES METHODS
    // ============================================================================================================================================================================

    // Parameters must be passed in correct order

    public Boolean createCourse(String courseID, String courseName, String courseDesc, String courseTerm,
            String courseSection,
            String courseCatNum, String courseInstructor, String courseStartTime, String courseDuration,
            String courseNotes, String courseSectionDirector, String courseCredits, String courseYear,
            String coursePrerequisites, String degreeName) {

        // Check if any parameters are empty or invalid
        if (!localUtils.checkEmptyOrNullString(courseID, courseName)) {
            System.out.println("Required parameters to createCourse were empty or null ( createCourse() - DB.java )");
            return false;
        }

        try {
            String SQL = "INSERT INTO courseDetails(courseID,courseName,courseDesc,courseTerm,courseSection,courseCatNum,courseInstructor,courseStartTime,courseDuration,courseNotes,courseSectionDirector,courseCredits,courseYear,coursePrerequisites,degreeName) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, courseID);
            pstmt.setString(2, courseName);
            pstmt.setString(3, courseDesc);
            pstmt.setString(4, courseTerm);
            pstmt.setString(5, courseSection);
            pstmt.setString(6, courseCatNum);
            pstmt.setString(7, courseInstructor);
            pstmt.setString(8, courseStartTime);
            pstmt.setString(9, courseDuration);
            pstmt.setString(10, courseNotes);
            pstmt.setString(11, courseSectionDirector);
            pstmt.setString(12, courseCredits);
            pstmt.setString(13, courseYear);
            pstmt.setString(14, coursePrerequisites);
            pstmt.setString(15, degreeName);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            DBConnection.close();

        } catch (Exception e) {

            System.out.println(e);
            return false;
        }

        return true;

    }

    public courseObject getCourse(String courseID) {

        if (!localUtils.checkEmptyOrNullString(courseID)) {
            System.out.println("Empty courseID provided to getCourse (DB.java)");
            return null;
        }

        try {
            String SQL = "SELECT * FROM courseDetails WHERE courseID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, courseID);
            ResultSet rs = pstmt.executeQuery();

            // Initialize courseObj properties
            String ID = "", name = "", description = "", term = "", section = "",
                    catNum = "", instructor = "", startTime = "", duration = "", notes = "", sectionDirector = "",
                    credits = "", year = "",
                    prerequisites = "",
                    degreeName = "";
            while (rs.next()) {
                ID = rs.getString("courseID");
                name = rs.getString("courseName");
                description = rs.getString("courseDesc");
                term = rs.getString("courseTerm");
                section = rs.getString("courseSection");
                catNum = rs.getString("courseCatNum");
                instructor = rs.getString("courseInstructor");
                startTime = rs.getString("courseStartTime");
                duration = rs.getString("courseDuration");
                notes = rs.getString("courseNotes");
                sectionDirector = rs.getString("courseSectionDirector");
                credits = rs.getString("courseCredits");
                year = rs.getString("courseYear");
                prerequisites = rs.getString("coursePrerequisites");
                degreeName = rs.getString("degreeName");
            }

            DBConnection.close();
            courseObject returnObj = new courseObject(ID, name, description, term, section, catNum, instructor,
                    startTime, duration, notes, sectionDirector, credits, year, prerequisites, degreeName);
            return returnObj;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Boolean updateCourse(String courseID, String courseName, String courseDesc, String courseTerm,
            String courseSection,
            String courseCatNum, String courseInstructor, String courseStartTime, String courseDuration,
            String courseNotes, String courseSectionDirector, String courseCredits, String courseYear,
            String coursePrerequisites, String degreeName) {

        if (!localUtils.checkEmptyOrNullString(courseID)) {
            System.out.println("CourseID not provided for update - ( updateCourse() - DB.java ) \n");
            return false;
        }

        // Create SQL Update String
        String sql = "UPDATE courseDetails SET ";
        List<String> setClauses = new ArrayList<>();

        if (courseName != null) {
            setClauses.add("courseName='" + courseName + "'");
        }
        if (courseDesc != null) {
            setClauses.add("courseDesc='" + courseDesc + "'");
        }
        if (courseTerm != null) {
            setClauses.add("courseTerm='" + courseTerm + "'");
        }
        if (courseSection != null) {
            setClauses.add("courseSection='" + courseSection + "'");
        }
        if (courseCatNum != null) {
            setClauses.add("courseCatNum='" + courseCatNum + "'");
        }
        if (courseInstructor != null) {
            setClauses.add("courseInstructor='" + courseInstructor + "'");
        }
        if (courseStartTime != null) {
            setClauses.add("courseStartTime='" + courseStartTime + "'");
        }
        if (courseDuration != null) {
            setClauses.add("courseDuration='" + courseDuration + "'");
        }
        if (courseNotes != null) {
            setClauses.add("courseNotes='" + courseNotes + "'");
        }
        if (courseSectionDirector != null) {
            setClauses.add("courseSectionDirector='" + courseSectionDirector + "'");
        }
        if (courseCredits != null) {
            setClauses.add("courseCredits='" + courseCredits + "'");
        }
        if (courseYear != null) {
            setClauses.add("courseYear='" + courseYear + "'");
        }

        if (coursePrerequisites != null) {
            setClauses.add("coursePrerequisites='" + coursePrerequisites + "'");
        }

        if (degreeName != null) {
            setClauses.add("degreeName='" + degreeName + "'");
        }
        if (setClauses.isEmpty()) {
            System.out.println("Nothing to update - (updateCourses() - DB.java)");
            return false;
        }
        sql += String.join(",", setClauses);
        sql += " WHERE courseID='" + courseID + "'";

        // Execute the SQL update statement
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(sql);
            int updatedRows = pstmt.executeUpdate();
            System.out.println("Updated " + updatedRows + " items successfully \n");

            if (updatedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error updating course - ( updateCourse() - DB.java ) \n");
            System.out.println(e);
        }

        return null;
    }

    public Boolean deleteCourse(String courseID) {

        if (!localUtils.checkEmptyOrNullString(courseID)) {
            System.out.println("CourseID not provided for update - ( deleteCourse() - DB.java ) \n");
            return false;
        }
        String SQL = "DELETE FROM courseDetails WHERE courseID='" + courseID + "'";
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            int deletedRows = pstmt.executeUpdate();
            System.out.println("Deleted " + deletedRows + " items successfully \n");

            if (deletedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error deleting course - ( deleteCourse() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;
    }

    // ============================================================================================================================================================================
    // FACULTY METHODS
    // ============================================================================================================================================================================

    public Boolean createFaculty() {
        // TODO Auto-generated method stub
        return null;

    }

    public facultyObject getFaculty() {
        // TODO Auto-generated method stub
        return null;

    }

    public Boolean updateFaculty() {
        // TODO Auto-generated method stub
        return null;

    }

    public Boolean deleteFaculty() {
        // TODO Auto-generated method stub
        return null;

    }

    // ============================================================================================================================================================================
    // DEGREE CHECKLIST METHODS
    // ============================================================================================================================================================================

    public Boolean createDegreeChecklist() {
        // TODO Auto-generated method stub
        return null;

    }

    public Boolean getDegreeChecklist() {
        // TODO Auto-generated method stub
        return null;

    }

    public Boolean updateDegreeChecklist() {
        // TODO Auto-generated method stub
        return null;

    }

    public Boolean deleteDegreeChecklist() {
        return null;
    }

}
