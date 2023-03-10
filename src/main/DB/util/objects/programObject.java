package main.DB.util.objects;

import java.util.Arrays;

public class programObject {
    String ID, department, name, type, reqCredits, duration, desc;
    String[] faculty, reqCourses;

    public programObject(String ID, String department, String name, String type, String reqCredits, String duration,
            String desc, String[] faculty, String[] reqCourses) {
        this.ID = ID;
        this.department = department;
        this.name = name;
        this.type = type;
        this.reqCredits = reqCredits;
        this.duration = duration;
        this.desc = desc;
        this.faculty = faculty;
        this.reqCourses = reqCourses;

    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReqCredits() {
        return reqCredits;
    }

    public void setReqCredits(String reqCredits) {
        this.reqCredits = reqCredits;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getFaculty() {
        return faculty;
    }

    public void setFaculty(String[] faculty) {
        this.faculty = faculty;
    }

    public String[] getReqCourses() {
        return reqCourses;
    }

    public void setReqCourses(String[] reqCourses) {
        this.reqCourses = reqCourses;
    }

    public void printProperties() {
        System.out.println("CheckList ID: " + this.ID);
        System.out.println("department: " + this.department);
        System.out.println("name: " + this.name);
        System.out.println("type: " + this.type);
        System.out.println("reqCredits: " + this.reqCredits);
        System.out.println("duration: " + this.duration);
        System.out.println("desc: " + this.desc);
        System.out.println("toCompleteCourses: " + Arrays.toString(this.faculty));
        System.out.println("completedCourses: " + Arrays.toString(this.reqCourses));
    }

}
