package cr.service;

import cr.entity.Student;
import cr.entity.Major;
import cr.entity.Course;
import cr.entity.StudentCourses;
import cr.repository.StudentCoursesRepository;
import cr.repository.StudentRepository;
import cr.repository.MajorRepository;
import cr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class TestingService {

    @Autowired
    private StudentRepository stRepo;
   
    @Autowired
    private StudentCoursesRepository stClaRepo;
    
    @Autowired
    private MajorRepository mRepo;
    
    @Autowired
    private CourseRepository cRepo;

    
    public Student findStudent(long stuId)
    {
    	     return stRepo.find(stuId);
    }
    
    public List<Student> getAllStudents(){
        List<Student> sList = stRepo.findAll();
        return sList;
    }
    
    public List<StudentCourses> getStuCourses(long stuId){
        List<StudentCourses> scList = stClaRepo.findCourses(stuId);
        return scList;
    }
    
    public List<Major> getAllMajors(){
        List<Major> mList = mRepo.findAll();
        return mList;
    }
    
    public List<Course> getAllCourses(){
        List<Course> cList = cRepo.findAll();
        return cList;
    }

}
