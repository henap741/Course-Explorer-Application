package main.DB.util.objects;

import java.util.Arrays;

public class userObject {

    String username, password, userChecklistRef, userProgramRef;
    String[] coursesArray;

    public userObject(String username, String password, String userChecklistRef, String userProgramRef,
            String[] coursesArray) {
        this.username = username;
        this.password = password;
        this.userChecklistRef = userChecklistRef != null ? userChecklistRef : "";
        this.userProgramRef = userProgramRef != null ? userProgramRef : "";
        this.coursesArray = coursesArray;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserChecklistRef() {
        return userChecklistRef;
    }

    public void setUserChecklistRef(String userChecklistRef) {
        this.userChecklistRef = userChecklistRef;
    }

    public String[] getCourses() {
        return coursesArray;
    }

    public void setCourses(String[] coursesArray) {
        this.coursesArray = coursesArray;
    }

    public String getUserProgramRef() {
        return userProgramRef;
    }

    public void setUserProgramRef(String userProgramRef) {
        this.userProgramRef = userProgramRef;
    }

    public void printProperties() {
        System.out.println("User ID: " + this.username);
        System.out.println("Password: " + this.password);
        System.out.println("userChecklistRef: " + this.userChecklistRef);
        System.out.println("userProgramRef: " + this.userProgramRef);
        System.out.println("coursesArray: " + Arrays.toString(this.coursesArray));
    }

}