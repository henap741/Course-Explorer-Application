package main.DB.util;

import java.sql.*;
import main.DB.DB;
import main.DB.util.objects.courseObject;

public class connectToDB {
    String connectionURL = "jdbc:mysql://sql.freedb.tech:3306/freedb_TestTest";
    String user = "freedb_123123123213";
    String password = "dqEn%rv@@Up%8?f";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionURL, user, password);
            return connection;
        } catch (Exception e) {
            System.out.println("Could not connect to DB ( getConnection() - connectToDB.java )");
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            DB DBInstance = new DB();
            String courseID = "fakeID";
            // String courseNotes = "fakeNotes123";
            // String courseSectionDirector = "fakeSectionDirector123";
            // String courseName = "fakeCourseNotes123";
            // String courseDesc = "fakeDesc123";
            // String courseTerm = "fakeCourseTerm123";
            // String courseSection = "fakeCourseSection123";
            // String courseCatNum = "CS2F3";
            // String courseInstructor = "fakeCourseInstruct";
            // String courseStartTime = "fakeStrtTime";
            // String courseDuration = "fakeDuration";
            // String courseCredits = "fakeCredits";

            Boolean result = DBInstance.createUser("fakeg2uy21", "fakepass", "fakeCheckl2i2stRef1",
                    "fakeyuserProgramRef",
                    new String[] { "meow", "meow2" });

            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
