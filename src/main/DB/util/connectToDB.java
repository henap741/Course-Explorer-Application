package main.DB.util;

import java.sql.*;

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
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            connectToDB c = new connectToDB();

            Connection c1 = c.getConnection();

            Statement stat = c1.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM userTable");

            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }

            c1.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
