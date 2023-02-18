package main.DB;

import java.util.ArrayList;

import main.DB.util.UserObject;

public class DB implements DBInterface {
    ArrayList<UserObject> usersMockArray;
    // Executable Block to Mock Data
    {
        ArrayList<UserObject> usersMockArr = new ArrayList<UserObject>();
        UserObject mockUser1 = new UserObject("steve", "123");
        usersMockArr.add(mockUser1);
        usersMockArray = usersMockArr;
    }

    @Override
    public Boolean createAccount() {
        // TODO Auto-generated method stub
        System.out.println(usersMockArray);
        return true;
    }

    @Override
    public void readAccount() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createCourseInfo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void readCourseInfo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateCourseInfo() {
        // TODO Auto-generated method stub

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

}
