package cr.repository;

	import cr.entity.StudentCourses;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.stereotype.Repository;

	import javax.annotation.Resource;
	import javax.sql.DataSource;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	@Repository
	public class StudentCoursesRepository {

	    @Autowired
	    private DataSource dataSource;
	    private JdbcTemplate jdbcTemplate;

	    @Resource(name = "CRDB")
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    public List<StudentCourses> findCourses(long stuId) {
	        String sql = "select * from StudentCourses"
	        		+ " where StudentID = ?";
	        return this.jdbcTemplate.query(sql, new Object[] {stuId}, new StudentCoursesMapper());
	    }

	    private static final class StudentCoursesMapper implements RowMapper<StudentCourses> {
	        public StudentCourses mapRow(ResultSet rs, int rowNum) throws SQLException {
	            StudentCourses s = new StudentCourses();
	            s.setStudentID(rs.getInt("StudentID"));
	            s.setCourseID(rs.getInt("CourseID"));
	            s.setCourseGrade(rs.getString("CourseGrade"));
	            s.setCourseGradeAsDouble(s.changeGrade(s.getCourseGrade()));
	            return s;
	        }
	    }
}
