package cr.entity;

public class StudentCourses {
	private int studentID;
    private int courseID;
    private String courseGrade;
    private double courseGradeAsDouble;
    
	public double getCourseGradeAsDouble() {
		return courseGradeAsDouble;
	}
	public void setCourseGradeAsDouble(double courseGradeAsDouble) {
		this.courseGradeAsDouble = courseGradeAsDouble;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}
	public double changeGrade(String grade){
		if(grade.equalsIgnoreCase("A")) {
			return 4.0;
		}
		else if(grade.equalsIgnoreCase("A-")) {
			return 3.67;
		}
		else if(grade.equalsIgnoreCase("B+")) {
			return 3.33;
		}
		else if(grade.equalsIgnoreCase("B")) {
			return 3.0;
		}
		else if(grade.equalsIgnoreCase("B-")) {
			return 2.67;
		}
		else if(grade.equalsIgnoreCase("C+")) {
			return 2.33;
		}
		else if(grade.equalsIgnoreCase("C")) {
			return 2.0;
		}
		else if(grade.equalsIgnoreCase("C-")) {
			return 1.67;
		}
		else if(grade.equalsIgnoreCase("D+")) {
			return 1.33;
		}
		else if(grade.equalsIgnoreCase("D")) {
			return 1.0;
		}
		else if(grade.equalsIgnoreCase("D-")) {
			return 0.67;
		}
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "studentClasses studentID: " + studentID + ", courseID: " + courseID + ", courseGrade: " 
				+ courseGradeAsDouble + " courseGrade: " + courseGrade;
	}
    
    
}
