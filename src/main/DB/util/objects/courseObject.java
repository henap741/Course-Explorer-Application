package main.DB.util.objects;

public class courseObject {
    String ID, name, description, term, section,
            catNum, instructor, startTime, duration, notes, sectionDirector, credits, year, prerequisites, degreeName;

    public courseObject(String ID, String name, String description, String term, String section, String catNum,
            String instructor, String startTime, String duration, String notes, String sectionDirector, String credits,
            String year,
            String prerequisites, String degreeName) {
        this.ID = ID;
        this.name = name;
        this.notes = notes != null ? notes : "";
        this.sectionDirector = sectionDirector != null ? sectionDirector : "";
        this.description = description != null ? description : "";
        this.term = term != null ? term : "";
        this.section = section != null ? section : "";
        this.catNum = catNum != null ? catNum : "";
        this.instructor = instructor != null ? instructor : "";
        this.startTime = startTime != null ? startTime : "";
        this.duration = duration != null ? duration : "";
        this.credits = credits != null ? credits : "";
        this.year = year != null ? year : "";
        this.degreeName = degreeName != null ? degreeName : "";

    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSectionDirector() {
        return sectionDirector;
    }

    public void setSectionDirector(String sectionDirector) {
        this.sectionDirector = sectionDirector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCatNum() {
        return catNum;
    }

    public void setCatNum(String catNum) {
        this.catNum = catNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }
    
    @Override //To override the toString() method in courseObject class and display data
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Description: " + description + ", Term: " + term 
                + ", Section: " + section + ", CatNum: " + catNum + ", Instructor: " + instructor 
                + ", Start Time: " + startTime + ", Duration: " + duration + ", Notes: " + notes 
                + ", Section Director: " + sectionDirector + ", Credits: " + credits + ", Year: " + year 
                + ", Prerequisites: " + prerequisites + ", Degree Name: " + degreeName;
    }


    public void printProperties() {
        System.out.println("ID: " + this.ID);
        System.out.println("Name: " + this.name);
        System.out.println("Notes: " + this.notes);
        System.out.println("Section Director: " + this.sectionDirector);
        System.out.println("Description: " + this.description);
        System.out.println("Term: " + this.term);
        System.out.println("Section: " + this.section);
        System.out.println("Catalog Number: " + this.catNum);
        System.out.println("Instructor: " + this.instructor);
        System.out.println("Start Time: " + this.startTime);
        System.out.println("Duration: " + this.duration);
        System.out.println("Credits: " + this.credits);
        System.out.println("Year: " + this.year);
        System.out.println("Prerequisites: " + this.prerequisites);
        System.out.println("Degree Name: " + this.degreeName);
    }

}
