package cr.data;
/*
 * class StudentRecords
 */
import java.util.*;
import cr.entity.*;

public class StudentRecords {
	
	private Student student;
	private Major major;
	private LinkedList<RecLink> records;
	
	
	public StudentRecords(Student student, Major major)
	{
		this.student = student;
		this.major = major;
		this.records = new LinkedList<RecLink>();
	}
	
	public Major getMajor() {
		return major;
	}

	//check student's record is satisfied requiredGrade or not
	public boolean checkRecord(String crCode, int crNum, double requiredGrade)
	{
		RecLink rl = this.getCourseBlock(crCode);
		if (rl == null)
			return false;
		else
		{
			if(rl.records.get(crNum) != null && rl.records.get(crNum) >= requiredGrade)
				return true;
			else
				return false;
		}
	}
	
	//change major 
	public void setMajor(Major major) {
		this.major = major;
	}

	public Student getStudent() {
		return student;
	}
	
	public LinkedList<RecLink> getAllRecords() {
		return records;
	}

	/*
	 * Get student records of the same course code
	 */
	public RecLink getCourseBlock (String crCode)
	{
		for (int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getCourseCode().equals(crCode))
				return records.get(i);
		}
		return null;
	}
	
	/*
	 * Add a record 
	 */
	public void addRecord(String crCode, int crNum, double crGrade)
	{
		for(RecLink rl: records)
		{
			if(rl.getCourseCode().equals(crCode))
				rl.addRecord(crNum, crGrade);
		}
		//cannot find the crCode link - never take this crCode class before
		RecLink newLink = new RecLink(crCode, crNum, crGrade);
		records.add(newLink);
	}
	
	/*
	 * Update a record
	 */
	public boolean updateRecord(String crCode, int crNum, double newGrade)
	{
		for(RecLink rl: records)
		{
			if(rl.getCourseCode().equals(crCode))
				return rl.updateRecord(crNum, newGrade);
		}
		return false; //cannot find the crCode
	}
	
	/*
	 * Remove a record
	 */
	public boolean removeRecord(String crCode, int crNum)
	{
		for(RecLink rl: records)
		{
			if(rl.getCourseCode().equals(crCode))
				return rl.removeRecord(crNum);
		}
		return false; //cannot find the crCode
	}

}
