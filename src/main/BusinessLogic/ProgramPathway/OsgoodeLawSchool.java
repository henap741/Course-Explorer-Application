package main.BusinessLogic.ProgramPathway;

import java.util.ArrayList;

public class OsgoodeLawSchool {
	 private ArrayList<pathwayCalculator> degreePrograms;

	    public OsgoodeLawSchool() {
	        degreePrograms = new ArrayList<pathwayCalculator>();

	        // Populate degreePrograms ArrayList with sample data
	        ArrayList<courses> requiredCourses1 = new ArrayList<courses>();
	        requiredCourses1.add(new courses("LAW 1000", "Introduction to Canadian Law", "First Year", "4", "Fall", "An introduction to the Canadian legal system and the role of law in Canadian society.", null, "Prof. Smith"));
	        requiredCourses1.add(new courses("LAW 2000", "Contracts", "Second Year", "3", "Fall", "An exploration of the legal principles governing contracts, including formation, interpretation, and remedies for breach.", null, "Prof. Jones"));
	        requiredCourses1.add(new courses("LAW 3000", "Torts", "First Year", "4", "Winter", "An examination of the law of torts, including negligence, intentional torts, and strict liability.", null, "Prof. Brown"));
	        requiredCourses1.add(new courses("LAW1004", "Criminal Law", "First Year", "3", "Winter", "An introduction to criminal law", null, "Prof. Linken"));
	        requiredCourses1.add(new courses("LAW1005", "Legal Process", "First Year", "3", "Fall", "An introduction to the legal process", null, "Prof. Wesley"));
	        requiredCourses1.add(new courses("LAW1006", "Public Law and Legislation", "3", "Winter", "First Year", "An introduction to public law and legislation", null, "Prof. James"));
	        degreePrograms.add(new pathwayCalculator("Juris Doctor (JD)", "4", "This degree is for Juris Doctor (JD) ", "158", requiredCourses1));
	        
	        ArrayList<courses> requiredCourses2 = new ArrayList<courses>();
	        requiredCourses2.add(new courses("LLM 4000", "International Human Rights Law", "First Year", "4", "Fall", "An exploration of the international legal framework for the protection of human rights.", null, "Prof. Lee"));
	        requiredCourses2.add(new courses("LLM 5000", "International Trade Law", "First Year", "3", "Winter", "An examination of the legal principles governing international trade, including the World Trade Organization and regional trade agreements.", null, "Prof. Patel"));
	        degreePrograms.add(new pathwayCalculator("Master of Laws (LLM)", "4", "This degree is for Master of Laws (LLM)", "206", requiredCourses2));
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