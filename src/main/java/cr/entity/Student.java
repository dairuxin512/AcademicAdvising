package cr.entity;

public class Student {

    private long id ;
    private String firstName;
    private String lastName;
    private int majorID;
   
    public Student()
    {
    	
    }
    
    public Student (long id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.majorID = 101;
	}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public int getmajorID() {
        return majorID;
    }

    public void setmajorID(int majorID) {
        this.majorID = majorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString()
    {
    	   return id + ": " + lastName + "," + firstName ;
    }
}
