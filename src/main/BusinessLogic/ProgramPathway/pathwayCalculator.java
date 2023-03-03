package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class pathwayCalculator {
	    private String programName;
	    private String programDescription;
	    private ArrayList<courses> requiredCourses;

	    public pathwayCalculator(String programName, String programDescription, ArrayList<courses> requiredCourses) {
	        this.programName = programName;
	        this.programDescription = programDescription;
	        this.requiredCourses = requiredCourses;
	    }

	    public String getProgramName() {
	        return programName;
	    }

	    public String getProgramDescription() {
	    	return programDescription;
	    }
	    
	    public ArrayList<courses> getRequiredCourses() {
	        return requiredCourses;
	    }
	}
	   