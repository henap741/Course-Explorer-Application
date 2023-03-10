package main.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.DB.util.objects.courseObject;
import main.DB.util.objects.degChecklistObject;
import main.DB.util.objects.facultyObject;
import main.DB.util.objects.programObject;
import main.DB.util.objects.userObject;
import main.DB.util.connectToDB;
import main.DB.util.utility;

public class DB implements DBInterface {
    connectToDB DB = new connectToDB();
    utility localUtils = new utility();

    // ============================================================================================================================================================================
    // USER METHODS
    // ============================================================================================================================================================================

    public Boolean createUser(String username, String password, String userChecklistRef, String userProgramRef,
            String[] coursesArray) {

        if (!localUtils.checkEmptyOrNullString(username, password)) {
            System.out.println("Required parameters to createUser were empty or null ( createUser() - DB.java )");
            return false;
        }

        try {
            String SQL = "INSERT INTO userData(userID,password,userCoursesArr,userChecklistRef,userProgramRef) VALUES(?,?,?,?,?)";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, Arrays.toString(coursesArray));
            pstmt.setString(4, userChecklistRef);
            pstmt.setString(5, userProgramRef);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            DBConnection.close();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error creating user - ( createUser() - DB.java ) \n");
            System.out.println(e);
        }
        return null;
    }

    public userObject getUser(String userID) {
        if (!localUtils.checkEmptyOrNullString(userID)) {
            System.out.println("Required parameters to getUser were empty or null ( getUser() - DB.java )");
            return null;
        }

        try {
            String SQL = "SELECT * FROM userData WHERE userID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();

            // Initialize courseObj properties
            String ID = "", password = "", userChecklistRef = "", userProgramRef = "", userCoursesArrString = "";

            while (rs.next()) {
                ID = rs.getString("userID");
                password = rs.getString("password");
                userChecklistRef = rs.getString("userChecklistRef");
                userProgramRef = rs.getString("userProgramRef");
                userCoursesArrString = rs.getString("userCoursesArrString");
            }

            // Convert Array stored as String to Array
            String[] userCourses = userCoursesArrString.substring(1, userCoursesArrString.length() - 1).split(", ");

            DBConnection.close();
            userObject returnObj = new userObject(ID, password, userChecklistRef, userProgramRef, userCourses);
            return returnObj;

        } catch (Exception e) {
            System.out.println("Error getting user - ( getUser() - DB.java ) \n");
            System.out.println(e);
        }

        return null;
    }

    public Boolean deleteUser() {
        System.out.println("deleteUser() - DB.java is not yet implemented");
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

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error inserting course - ( createCourse() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;

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
            System.out.println("Error retrieving course - ( getCourse() - DB.java ) \n");
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
            DBConnection.close();

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
            DBConnection.close();

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

    public Boolean createFaculty(String ID, String type, String name, String email, String additionalInfo) {
        // Check if any parameters are empty or invalid
        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out
                    .println("Required parameters to create faculty were empty or null ( createFaculty() - DB.java )");
            return false;
        }

        try {
            String SQL = "INSERT INTO facultyDetails(facultyID,facultyType,facultyName,facultyEmail,facultyAdditionalInfo) VALUES(?,?,?,?,?)";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, ID);
            pstmt.setString(2, type);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, additionalInfo);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            DBConnection.close();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error inserting faculty - ( createFaculty() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;

    }

    public facultyObject getFaculty(String facultyID) {

        if (!localUtils.checkEmptyOrNullString(facultyID)) {
            System.out.println("Empty facultyID provided to getFaculty (DB.java)");
            return null;
        }

        try {
            String SQL = "SELECT * FROM facultyDetails WHERE facultyID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, facultyID);
            ResultSet rs = pstmt.executeQuery();

            // Initialize courseObj properties
            String ID = "", type = "", name = "", email = "", additionalInfo = "";
            while (rs.next()) {
                ID = rs.getString("facultyID");
                type = rs.getString("facultyType");
                name = rs.getString("facultyName");
                email = rs.getString("facultyEmail");
                additionalInfo = rs.getString("facultyAdditionalInfo");
            }

            DBConnection.close();

            facultyObject returnObj = new facultyObject(ID, type, name, email, additionalInfo);
            return returnObj;

        } catch (Exception e) {
            System.out.println("Error retrieving course - ( getCourse() - DB.java ) \n");
            System.out.println(e);
            return null;
        }

    }

    public Boolean updateFaculty(String ID, String type, String name, String email, String additionalInfo) {

        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out.println("ID not provided for update - ( updateFaculty() - DB.java ) \n");
            return false;
        }

        // Create SQL Update String
        String sql = "UPDATE facultyDetails SET ";
        List<String> setClauses = new ArrayList<>();

        if (type != null) {
            setClauses.add("facultyType='" + type + "'");
        }
        if (name != null) {
            setClauses.add("facultyName='" + name + "'");
        }
        if (email != null) {
            setClauses.add("facultyEmail='" + email + "'");
        }
        if (additionalInfo != null) {
            setClauses.add("facultyAdditionalInfo='" + additionalInfo + "'");
        }

        if (setClauses.isEmpty()) {
            System.out.println("Nothing to update - ( updateFaculty() - DB.java)");
            return false;
        }
        sql += String.join(",", setClauses);
        sql += " WHERE facultyID='" + ID + "'";

        // Execute the SQL update statement
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(sql);
            int updatedRows = pstmt.executeUpdate();
            System.out.println("Updated " + updatedRows + " items successfully \n");
            DBConnection.close();

            if (updatedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error updating faculty - ( updateFaculty() - DB.java ) \n");
            System.out.println(e);
        }

        return null;

    }

    public Boolean deleteFaculty(String facultyID) {

        if (!localUtils.checkEmptyOrNullString(facultyID)) {
            System.out.println("facultyID not provided for deletion - ( deleteFaculty() - DB.java ) \n");
            return false;
        }
        String SQL = "DELETE FROM facultyDetails WHERE facultyID='" + facultyID + "'";
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            int deletedRows = pstmt.executeUpdate();
            System.out.println("Deleted " + deletedRows + " items successfully \n");
            DBConnection.close();

            if (deletedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error deleting faculty - ( deleteFaculty() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;

    }

    // ============================================================================================================================================================================
    // DEGREE CHECKLIST METHODS
    // ============================================================================================================================================================================

    public Boolean createDegreeChecklist(String ID, String userIDRef, String[] completedCourses,
            String[] toCompleteCourses) {

        // Check if any parameters are empty or invalid
        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out
                    .println("Required parameters to create faculty were empty or null ( createFaculty() - DB.java )");
            return false;
        }

        try {
            String SQL = "INSERT INTO userCheckLists(checkListID,completedCourses,toCompleteCourses,userIDRef) VALUES(?,?,?,?)";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, ID);
            pstmt.setString(2, Arrays.toString(completedCourses));
            pstmt.setString(3, Arrays.toString(toCompleteCourses));
            pstmt.setString(4, userIDRef);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            DBConnection.close();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error inserting degreeChecklist - ( createDegreeChecklist() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;

    }

    public degChecklistObject getDegreeChecklist(String checklistID) {

        if (!localUtils.checkEmptyOrNullString(checklistID)) {
            System.out.println("Empty checklistID provided to getDegreeChecklist (DB.java)");
            return null;
        }

        try {
            String SQL = "SELECT * FROM userCheckLists WHERE checkListID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, checklistID);
            ResultSet rs = pstmt.executeQuery();

            // Initialize courseObj properties
            String ID = "", userIDRef = "", completedCoursesStr = "", toCompleteCoursesStr = "";

            while (rs.next()) {
                ID = rs.getString("checkListID");
                completedCoursesStr = rs.getString("completedCourses");
                toCompleteCoursesStr = rs.getString("toCompleteCourses");
                userIDRef = rs.getString("userIDRef");
            }

            String[] completedCourses = completedCoursesStr.substring(1, completedCoursesStr.length() - 1).split(", ");
            String[] toCompleteCourses = toCompleteCoursesStr.substring(1, toCompleteCoursesStr.length() - 1)
                    .split(", ");

            DBConnection.close();

            degChecklistObject returnObj = new degChecklistObject(ID, userIDRef, completedCourses, toCompleteCourses);
            return returnObj;

        } catch (Exception e) {
            System.out.println("Error retrieving degree checklist - ( getDegChecklist() - DB.java ) \n");
            System.out.println(e);
            return null;
        }

    }

    public Boolean updateDegreeChecklist(String ID, String userIDRef, String[] completedCourses,
            String[] toCompleteCourses) {

        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out.println("ID not provided for update - ( updateDegreeChecklist() - DB.java ) \n");
            return false;
        }

        // Create SQL Update String
        String sql = "UPDATE userCheckLists SET ";
        List<String> setClauses = new ArrayList<>();

        if (userIDRef != null) {
            setClauses.add("userIDRef='" + userIDRef + "'");
        }
        if (completedCourses != null) {
            setClauses.add("completedCourses='" + Arrays.toString(completedCourses) + "'");
        }
        if (toCompleteCourses != null) {
            setClauses.add("toCompleteCourses='" + Arrays.toString(toCompleteCourses) + "'");
        }

        if (setClauses.isEmpty()) {
            System.out.println("Nothing to update - ( updateDegreeChecklist() - DB.java)");
            return false;
        }
        sql += String.join(",", setClauses);
        sql += " WHERE checkListID='" + ID + "'";

        // Execute the SQL update statement
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(sql);
            int updatedRows = pstmt.executeUpdate();
            System.out.println("Updated " + updatedRows + " items successfully \n");
            DBConnection.close();

            if (updatedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error updating degree checklist - ( updateDegreeChecklist() - DB.java ) \n");
            System.out.println(e);
        }

        return null;

    }

    public Boolean deleteDegreeChecklist(String checkListID) {

        if (!localUtils.checkEmptyOrNullString(checkListID)) {
            System.out.println("checkListID not provided for deletion - ( deleteDegreeChecklist() - DB.java ) \n");
            return false;
        }
        String SQL = "DELETE FROM userCheckLists WHERE checkListID='" + checkListID + "'";
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            int deletedRows = pstmt.executeUpdate();
            System.out.println("Deleted " + deletedRows + " items successfully \n");
            DBConnection.close();

            if (deletedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error deleting degree checklist - ( deleteDegreeChecklist() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;

    }

    // ========================================================================================================
    // PROGRAM METHODS
    // ========================================================================================================

    public Boolean createProgram(String ID, String[] faculty, String department, String name, String type,
            String reqCredits, String[] reqCourses, String duration, String desc) {

        // Check if any parameters are empty or invalid
        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out
                    .println("Required parameters to create program were empty or null ( createProgram() - DB.java )");
            return false;
        }

        try {
            String SQL = "INSERT INTO programs(programID,faculty,department,programName,programType,requiredCredits,requiredCourses,programDuration,programDesc) VALUES(?,?,?,?,?,?,?,?,?)";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, ID);
            pstmt.setString(2, Arrays.toString(faculty));
            pstmt.setString(3, department);
            pstmt.setString(4, name);
            pstmt.setString(5, type);
            pstmt.setString(6, reqCredits);
            pstmt.setString(7, Arrays.toString(reqCourses));
            pstmt.setString(8, duration);
            pstmt.setString(9, desc);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
            DBConnection.close();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error inserting program - ( createProgram() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;
    }

    public programObject getProgram(String programID) {

        if (!localUtils.checkEmptyOrNullString(programID)) {
            System.out.println("Empty programID provided to getProgram (DB.java)");
            return null;
        }

        try {
            String SQL = "SELECT * FROM programs WHERE programID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, programID);
            ResultSet rs = pstmt.executeQuery();

            // Initialize courseObj properties
            String ID = "", facultyStr = "", department = "", name = "", type = "", reqCredits = "", reqCoursesStr = "",
                    duration = "", desc = "";

            while (rs.next()) {
                ID = rs.getString("programID");
                facultyStr = rs.getString("faculty");
                department = rs.getString("department");
                name = rs.getString("programName");
                type = rs.getString("programType");
                reqCredits = rs.getString("requiredCredits");
                reqCoursesStr = rs.getString("requiredCourses");
                duration = rs.getString("programDuration");
                desc = rs.getString("programDesc");

            }

            String[] reqCourses = reqCoursesStr.substring(1, reqCoursesStr.length() - 1).split(", ");
            String[] faculty = facultyStr.substring(1, facultyStr.length() - 1)
                    .split(", ");

            DBConnection.close();

            programObject returnObj = new programObject(ID, department, name, type, reqCredits, duration, desc, faculty,
                    reqCourses);
            return returnObj;

        } catch (Exception e) {
            System.out.println("Error retrieving program - ( getProgram() - DB.java ) \n");
            System.out.println(e);
            return null;
        }
    }

    public Boolean updateProgram(String ID, String[] faculty, String department, String name, String type,
            String reqCredits, String[] reqCourses, String duration, String desc) {

        if (!localUtils.checkEmptyOrNullString(ID)) {
            System.out.println("ID not provided for update - ( updateProgram() - DB.java ) \n");
            return false;
        }

        // Create SQL Update String
        String sql = "UPDATE programs SET ";
        List<String> setClauses = new ArrayList<>();

        if (faculty != null) {
            setClauses.add("faculty='" + Arrays.toString(faculty) + "'");
        }
        if (reqCourses != null) {
            setClauses.add("requiredCourses='" + Arrays.toString(reqCourses) + "'");
        }
        if (department != null) {
            setClauses.add("department='" + department + "'");
        }
        if (name != null) {
            setClauses.add("programName='" + name + "'");
        }
        if (type != null) {
            setClauses.add("programType='" + type + "'");
        }
        if (reqCredits != null) {
            setClauses.add("requiredCredits='" + reqCredits + "'");
        }
        if (duration != null) {
            setClauses.add("programDuration='" + duration + "'");
        }
        if (desc != null) {
            setClauses.add("programDesc='" + desc + "'");
        }

        if (setClauses.isEmpty()) {
            System.out.println("Nothing to update - ( updateProgram() - DB.java)");
            return false;
        }
        sql += String.join(",", setClauses);
        sql += " WHERE programID='" + ID + "'";

        // Execute the SQL update statement
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(sql);
            int updatedRows = pstmt.executeUpdate();
            System.out.println("Updated " + updatedRows + " items successfully \n");
            DBConnection.close();

            if (updatedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error updating program- ( updateProgram() - DB.java ) \n");
            System.out.println(e);
        }

        return null;
    }

    public Boolean deleteProgram(String programID) {

        if (!localUtils.checkEmptyOrNullString(programID)) {
            System.out.println("programID not provided for deletion - ( deleteProgram() - DB.java ) \n");
            return false;
        }
        String SQL = "DELETE FROM programs WHERE programID='" + programID + "'";
        try {
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            int deletedRows = pstmt.executeUpdate();
            System.out.println("Deleted " + deletedRows + " items successfully \n");
            DBConnection.close();

            if (deletedRows > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error deleting program - ( deleteProgram() - DB.java ) \n");
            System.out.println(e);
            return false;
        }

        return null;
    }

}
