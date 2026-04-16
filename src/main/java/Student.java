
public class Student {
	private int studentID;
	private String name;
	private String email;
	private String passwordHash;
	
	public Student() {
	}
	
	public Student(int studentID, String name, String email, String passwordHash) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }
 
    public int getStudentID() {
        return studentID;
    }
 
    public void setStudentID(int studentID) {
        this.studentID = studentID;
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
 
    public String getPasswordHash() {
        return passwordHash;
    }
 
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
 
    @Override
    public String toString() {
        return "Student{studentID=" 
        		+ studentID 
        		+ ", name='" + name 
        		+ "', email='" + email 
        		+ "'}";
    }
}

