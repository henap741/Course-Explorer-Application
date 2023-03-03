package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class courses {
	    private String courseCode;
	    private String courseName;
	    private String courseDescription;
	    private ArrayList<courses> prerequisites;
	    private String instructor;

	    public courses(String courseCode, String courseName, String courseDescription, ArrayList<courses> prerequisites, String instructor) {
	        this.courseCode = courseCode;
	        this.courseName = courseName;
	        this.courseDescription = courseDescription;
	        this.prerequisites = prerequisites;
	        this.instructor = instructor;
	    }

	    public String getCourseCode() {
	        return courseCode;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public String getCourseDescription() {
	        return courseDescription;
	    }

	    public ArrayList<courses> getPrerequisites() {
	        return prerequisites;
	    }

	    public String getInstructor() {
	        return instructor;
	    }
	}
