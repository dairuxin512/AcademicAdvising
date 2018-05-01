package cr.data;
/*
 * class RecLink: used for class StudentRecords
 *                RecLink stores a student's records for all courses from the same courseCode
 *                i.e., a RecLink for a student's all CSIS courses records
 */
import java.util.*;

public class RecLink {
	
	//package access for data members (class StudentRecords can access RecLink's data directly)
	String courseCode;
	Map<Integer, Double> records;  //courseNum, floating-point grade
	RecLink next;
	RecLink prev;
	
	
	public String getCourseCode() {
		return courseCode;
	}



	/*
	 * Create a recLink for storing records for a new course code
	 */
	public RecLink(String crCode, int crNum, double crGrade)
	{
		this.courseCode = crCode;
		records = new HashMap<Integer, Double>(50); //suppose a student has at most 50 courses with the same course code
		records.put(crNum, crGrade);
		next = null;
		prev = null;
	}
	
	
	
	/*
	 * Add a new record to this course code RecLink
	 */
	public void addRecord(int crNum, double crGrade)
	{
		records.put(crNum, crGrade);
	}
	
	/*
	 * Update an existing record to this course code RecLink
	 * only when the newGrade is higher than originalGrade
	 */
	public boolean updateRecord(int crNum, double newGrade)
	{
		double originalGrade = records.get(crNum);
		if(newGrade > originalGrade)
		{
			return records.replace(crNum, originalGrade, newGrade);
		}
		else
			return false;
	}
	
	/*
	 * Remove an existing record from this course code RecLink
	 * only when the course is in process (no grade)
	 */
	public boolean removeRecord(int crNum)
	{
		return records.remove(crNum, -1);
	}
	
	/*
	 * Return all the records of this course code RecLink
	 */
	public Map<Integer, Double> getRecords()
	{
		return this.records;
	}
	
	/*
	 * Return the grade of a particular course of this course code RecLink
	 */
	public double getGradeOfCourse (int crNum)
	{
		return records.get(crNum);
	}

}
