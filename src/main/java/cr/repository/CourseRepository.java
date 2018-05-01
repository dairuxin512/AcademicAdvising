package cr.repository;

import cr.entity.Course;
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
public class CourseRepository {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "CRDB")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Course> findAll() {
        String sql = "select * from Course";
        return this.jdbcTemplate.query(sql, new CourseMapper());
    }

    private static final class CourseMapper implements RowMapper<Course> {
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course s = new Course();
            s.setCourseID(rs.getInt("CourseID"));
            s.setCourseName(rs.getString("CourseName"));
            s.setTerm(rs.getString("Term"));
            s.setSection(rs.getInt("Section"));
            s.setCourseCode(rs.getString("CourseCode"));
            s.setCourseNum(rs.getInt("CourseNum"));
            return s;
        }
    }
}