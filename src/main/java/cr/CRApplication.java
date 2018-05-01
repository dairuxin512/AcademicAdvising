package cr;

import cr.data.CourseRecommendation;
import cr.data.StudentRecords;
import cr.entity.Course;
import cr.entity.Major;
import cr.entity.Student;
import cr.entity.StudentCourses;
import cr.service.TestingService;
import cr.util.KnowledgeSessionHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cr")
public class CRApplication extends JFrame{
	//declare GUI components 
	//private JTextField stuIDTF;
	
	static Scanner console = new Scanner (System.in);
	/*
	public CRApplication()
	{
		stuIDTF = new JTextField(15);
	}
	*/
	
	public static void main (String [] args) {
        
	//	CRApplication test = new CRApplication();
		
		ApplicationContext ctx = SpringApplication.run(CRApplication.class,
                args);
        TestingService tServ = ctx.getBean(TestingService.class);
        /*
        tServ.test1();
        tServ.test2();
        tServ.test3();
        tServ.test4();
        */
        KieContainer kieContainer = KnowledgeSessionHelper.createRuleBase();
    	  //  StatelessKieSession sessionStateless = null;
    	    KieSession sessionStatefull = null;
    	    
    	    List<Major> allMajors = tServ.getAllMajors();
    	    Map<Integer,Major> majorMap = new HashMap<Integer,Major>();
    	    for (Major mj : allMajors) 
    	    			majorMap.put(mj.getId(),mj);
    	    
    	    List<Course> allCourses = tServ.getAllCourses();
    	    Map<Integer,Course> courseMap = new HashMap<Integer,Course>();
    	    for (Course cr : allCourses) 
    	    			courseMap.put(cr.getCourseID(),cr);
    	    
    	    sessionStatefull = KnowledgeSessionHelper
    				.getStatefulKnowledgeSessionWithCallBack(kieContainer, "ksession-csisrules");
    	    
    	    for(Major mj : allMajors)
    	    {
    	    	   sessionStatefull.insert(mj);
    	    }
    	    
    	    for(Course cr : allCourses)
    	    {
    	    	   sessionStatefull.insert(cr);
    	    }
    	    
    	    System.out.println("*****Welcome to course recommendation system*****");
    	    System.out.println("Please enter your w number (without w):" );
    	    long inputID = console.nextLong();
    	    
    	    Student csStudent = tServ.findStudent(inputID);
    	    List<StudentCourses> courseRec = tServ.getStuCourses(inputID);
    	    Major csMajor = allMajors.get(0);
    	    StudentRecords csStuRec = new StudentRecords(csStudent, csMajor);
    	    
    	    String crCode;
    	    int crNum;
    	    Course cr;
    	    for(StudentCourses sc: courseRec)
    	    {
    	    	      cr = courseMap.get(sc.getCourseID());
    	    	      crCode = cr.getCourseCode();
    	    	      crNum = cr.getCourseNum();
    	    	      csStuRec.addRecord(crCode, crNum, sc.getCourseGradeAsDouble());
    	    }
    	    
    	    sessionStatefull.insert(csStudent);
    	    sessionStatefull.insert(csMajor);
    	    sessionStatefull.insert(csStuRec);
    	    
    	    
    	    CourseRecommendation csStuRecommends = new CourseRecommendation(csStudent);
    	    sessionStatefull.insert(csStuRecommends);
    	    
    	    sessionStatefull.fireAllRules();

    	    Major stuMajor = majorMap.get(csStuRecommends.getStudent().getmajorID());
    		System.out.println("**************************");
    		System.out.println(csStudent);
    		System.out.println("Major:" + stuMajor.getName() + " Option:" + stuMajor.getOption());;
    		System.out.println("-----Recommended course list-----");
    		csStuRecommends.display();
    	    
    }
	
}
