package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class OsgoodeLawSchool {
	 private ArrayList<pathwayCalculator> degreePrograms;

	    public OsgoodeLawSchool() {
	        degreePrograms = new ArrayList<pathwayCalculator>();

	        // Populate degreePrograms ArrayList with sample data
	        ArrayList<courses> requiredCourses1 = new ArrayList<courses>();
	        requiredCourses1.add(new courses("LAW 1000", "Introduction to Canadian Law", "An introduction to the Canadian legal system and the role of law in Canadian society.", null, "Prof. Smith"));
	        requiredCourses1.add(new courses("LAW 2000", "Contracts", "An exploration of the legal principles governing contracts, including formation, interpretation, and remedies for breach.", null, "Prof. Jones"));
	        requiredCourses1.add(new courses("LAW 3000", "Torts", "An examination of the law of torts, including negligence, intentional torts, and strict liability.", null, "Prof. Brown"));
	        degreePrograms.add(new pathwayCalculator("Juris Doctor (JD)", "This degree is for Juris Doctor (JD) ", requiredCourses1));

	        ArrayList<courses> requiredCourses2 = new ArrayList<courses>();
	        requiredCourses2.add(new courses("LLM 4000", "International Human Rights Law", "An exploration of the international legal framework for the protection of human rights.", null, "Prof. Lee"));
	        requiredCourses2.add(new courses("LLM 5000", "International Trade Law", "An examination of the legal principles governing international trade, including the World Trade Organization and regional trade agreements.", null, "Prof. Patel"));
	        degreePrograms.add(new pathwayCalculator("Master of Laws (LLM)", "This degree is for Master of Laws (LLM)", requiredCourses2));
	    }

	    public ArrayList<pathwayCalculator> getDegreePrograms() {
	        return degreePrograms;
	    }

//	    public pathwayCalculator getDegreeProgram(String programName) {
//	        for (pathwayCalculator pathwayCalculator : degreePrograms) {
//	            if (pathwayCalculator.getProgramName().equals(programName)) {
//	                return pathwayCalculator;
//	            }
//	        }
//	        return null;
//	    }

	    public courses getCourse(String courseCode) {
	        for (pathwayCalculator pathwayCalculator : degreePrograms) {
	            for (courses course : pathwayCalculator.getRequiredCourses()) {
	                if (course.getCourseCode().equals(courseCode)) {
	                    return course;
	                }
	            }
	        }
	        return null;
	    }

		public pathwayCalculator getDegreeProgram(String degreeName) {
			for (pathwayCalculator pathwayCalculator : degreePrograms) {
	            if (pathwayCalculator.getProgramName().equals(degreeName)) {
	                return pathwayCalculator;
	            }
	        }
	        return null;
		}
	}