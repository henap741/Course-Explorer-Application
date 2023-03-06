package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class courses {
	    private String courseCode;
	    private String courseName;
	    private String courseYear;
	    private String courseCredits;
	    private String courseTerm;
	    private String courseDescription;
	    private ArrayList<courses> prerequisites;
	    private String instructor;

	    public courses(String courseCode, String courseName, String courseYear, String courseCredits, String courseTerm, String courseDescription, ArrayList<courses> prerequisites, String instructor) {
	        this.courseCode = courseCode;
	        this.courseName = courseName;
	        this.courseYear = courseYear;
	        this.courseCredits = courseCredits;
	        this.courseTerm = courseTerm;
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
	    
	    public String getCourseYear() {
	    	return courseYear;
	    }

	    public String getCourseDescription() {
	        return courseDescription;
	    }

	    public String getCourseCredits() {
	        return courseCredits;
	    }

	    public String getCourseTerm() {
	        return courseTerm;
	    }
	    
	    public ArrayList<courses> getPrerequisites() {
	        return prerequisites;
	    }

	    public String getInstructor() {
	        return instructor;
	    }
	}
