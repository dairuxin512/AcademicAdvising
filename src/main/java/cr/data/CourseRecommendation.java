package cr.data;

import java.util.*;
import cr.entity.*;

public class CourseRecommendation {
	private Student student;
	private Set<Course> courseList; //change this to set
	
	public CourseRecommendation(Student stu) {
		student = stu;
		courseList = new HashSet<Course>();
	}
	
	public Student getStudent(){
		return student;
	}
	
	public Set<Course> getCourseList() {
		return courseList;
	}
	
	public boolean addCourse(Course cr) {
		return courseList.add(cr);
	}
	
	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}


	public void display() {
		//System.out.println("Course recommendation for " + student.toString());
		for(Course cr: courseList)
		{
			System.out.println(cr.getCourseCode() + " " + cr.getCourseNum() + ": " + cr.getCourseName());
		}
	}
	
}
