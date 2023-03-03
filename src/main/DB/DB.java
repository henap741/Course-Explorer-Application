package main.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.DB.util.UserObject;
import main.DB.util.connectToDB;

public class DB implements DBInterface {
    connectToDB DB = new connectToDB();
    ArrayList<UserObject> usersMockArray;
    // Executable Block to Mock Data
    {
        ArrayList<UserObject> usersMockArr = new ArrayList<UserObject>();
        UserObject mockUser1 = new UserObject("steve", "123");
        usersMockArr.add(mockUser1);
        usersMockArray = usersMockArr;
    }

    @Override
    public String[] createUser() {
        // TODO Auto-generated method stub
        System.out.println(usersMockArray);

        String[] success = { "success" };
        return success;
    }

    @Override
    public String[] readUser() {
        // TODO Auto-generated method stub

        String[] success = { "success" };
        return success;
    }

    // Parameters must be passed in correct order
    public String[] createCourseInfo(String courseID, String courseName, String courseDesc, String courseTerm,
            String courseSection,
            String courseCatNum, String courseInstructor, String courseStartTime, String courseDuration,
            String courseNotes, String courseSectionDirector, String courseCredits) {

        // Check if any parameters are empty or invalid
        // If optional parameters are empty or null, set to empty string ""
        if (!checkEmptyOrNullString(new String[] { courseNotes, courseSectionDirector }, courseID, courseName,
                courseDesc,
                courseTerm, courseSection, courseCatNum, courseInstructor,
                courseStartTime, courseDuration, courseCredits)) {
            String[] failedResult = { "failure", "Required parameters were empty or null" };
            return failedResult;
        }

        try {
            String SQL = "INSERT INTO courseDetails(courseID,courseName,courseDesc,courseTerm,courseSection,courseCatNum,courseInstructor,courseStartTime,courseDuration,courseNotes,courseSectionDirector,courseCredits) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
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

            pstmt.executeUpdate();

            DBConnection.close();

        } catch (Exception e) {

            System.out.println(e);
            String[] failure = { "failure" };
            return failure;
        }

        String[] success = { "success" };
        return success;

    }

    public String[] readCourseInfo(String courseID) {

        if (!checkEmptyOrNullString(new String[] {}, courseID)) {
            String[] failedResult = { "failure", "Required courseID was empty or null" };
            return failedResult;
        }

        try {
            String SQL = "SELECT * FROM courseDetails WHERE courseID = ?";
            Connection DBConnection = DB.getConnection();
            PreparedStatement pstmt = DBConnection.prepareStatement(SQL);
            pstmt.setString(1, courseID);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberColumns = metaData.getColumnCount();

            List<String> allResults = new ArrayList<>();

            while (rs.next()) {
                String[] currentRow = new String[numberColumns];
                for (int i = 1; i <= numberColumns; i++) {
                    currentRow[i - 1] = rs.getString(i);
                }
                allResults.add(Arrays.toString(currentRow));
            }

            DBConnection.close();
            String[] returnStringArray = allResults.toArray(new String[0]);

            return returnStringArray;

        } catch (Exception e) {
            System.out.println(e);
        }

        String[] success = { "success", };
        return success;
    }

    @Override
    public String[] updateCourseInfo() {
        // TODO Auto-generated method stub
        String[] success = { "success" };
        return success;
    }

    @Override
    public void createFacultyInfo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void readFacultyInfo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateFacultyInfo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createDegreeReq() {
        // TODO Auto-generated method stub

    }

    @Override
    public void readDegreeReq() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateDegreeReq() {
        // TODO Auto-generated method stub

    }

    @Override
    public String[] createCourseInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCourseInfo'");
    }

    @Override
    public String[] readCourseInfo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readCourseInfo'");
    }

    public Boolean checkEmptyOrNullString(String[] optionalArgs, String... args) {
        for (String arg : args) {
            if (arg == null || arg.isEmpty()) {
                return false;
            }
        }
        for (String arg : optionalArgs) {
            if (arg == null || arg.isEmpty()) {
                arg = "";
            }
        }
        return true;
    }

}
