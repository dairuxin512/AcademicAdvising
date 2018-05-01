package cr.entity;

public class Course {
	  
	    private int courseID ;
	    private String courseName;
	    private String term;
	    private int section;
	    private String courseCode;
	    private int courseNum;
	    
	    public Course()
	    {
	    	
	    }
	    
	    public Course(int cNum, String cName, String cCode) {
			courseNum = cNum;
			courseName = cName;
			courseCode = cCode;
			section = 1;
			term = "Fall, Spring";
		}
	    
		public int getCourseID() {
			return courseID;
		}
		public void setCourseID(int courseID) {
			this.courseID = courseID;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getTerm() {
			return term;
		}
		public void setTerm(String term) {
			this.term = term;
		}
		public int getSection() {
			return section;
		}
		public void setSection(int section) {
			this.section = section;
		}
		public String getCourseCode() {
			return courseCode;
		}
		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}
		public int getCourseNum() {
			return courseNum;
		}
		public void setCourseNum(int courseNum) {
			this.courseNum = courseNum;
		}
		@Override
		public String toString() {
			return "Course courseID: " + courseID + ", courseName: " + courseName + ", term: " + term + ", section: "
					+ section + ", courseCode: " + courseCode + ", courseNum: " + courseNum;
		}

	    
}
