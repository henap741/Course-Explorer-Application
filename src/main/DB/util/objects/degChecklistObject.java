package main.DB.util.objects;

import java.util.Arrays;

public class degChecklistObject {
    String ID, userIDRef;
    String[] completedCourses, toCompleteCourses;

    public degChecklistObject(String ID, String userIDRef, String[] completedStrings, String[] toCompleteCourses) {
        this.ID = ID;
        this.userIDRef = userIDRef;
        this.completedCourses = completedStrings;
        this.toCompleteCourses = toCompleteCourses;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getUserIDRef() {
        return userIDRef;
    }

    public void setUserIDRef(String userIDRef) {
        this.userIDRef = userIDRef;
    }

    public String[] getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(String[] completedCourses) {
        this.completedCourses = completedCourses;
    }

    public String[] getToCompleteCourses() {
        return toCompleteCourses;
    }

    public void setToCompleteCourses(String[] toCompleteCourses) {
        this.toCompleteCourses = toCompleteCourses;
    }

}
