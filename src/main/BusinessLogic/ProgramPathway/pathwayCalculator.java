package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class pathwayCalculator {
	    private String programName;
	    private String programDescription;
	    private String programDuration;
	    private String requiredCredits;
	    private ArrayList<courses> requiredCourses;

	    public pathwayCalculator(String programName, String programDuration, String programDescription, String requiredCredits, ArrayList<courses> requiredCourses) {
	        this.programName = programName;
	        this.programDuration = programDuration;
	        this.requiredCredits = requiredCredits;
	        this.programDescription = programDescription; //added
	        this.requiredCourses = requiredCourses;
	    }

	    public String getProgramName() {
	        return programName;
	    }

	    public String getProgramDuration() {
	        return programDuration;
	    }
	    
	    public String getRequiredCredits() {
	    	return requiredCredits;
	    }
	    
	    public String getProgramDescription() {
	    	return programDescription;
	    }
	    
	    public ArrayList<courses> getRequiredCourses() {
	        return requiredCourses;
	    }

	}