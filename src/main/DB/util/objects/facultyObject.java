package main.DB.util.objects;

public class facultyObject {
    String ID, type, name, email, additionalInfo;

    public facultyObject(String ID, String type, String name, String email, String additionalInfo) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void printProperties() {
        System.out.println("Faculty ID: " + this.ID);
        System.out.println("Faculty Type : " + this.type);
        System.out.println("Faculty Name: " + this.name);
        System.out.println("Faculty Email: " + this.email);
        System.out.println("Faculty Additional Info: " + this.additionalInfo);
    }

}
