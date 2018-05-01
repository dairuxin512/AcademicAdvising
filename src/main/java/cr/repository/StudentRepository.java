package cr.repository;

import cr.entity.Student;

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
public class StudentRepository {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "CRDB")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Student> findAll() {
        String sql = "select * from Student";
        return this.jdbcTemplate.query(sql, new StudentMapper());
    }
    
    public Student find(long stuId)
    {
    	    String sql = "select * from Student where ID = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[] {stuId},
        		new StudentMapper());
    }

    private static final class StudentMapper implements RowMapper<Student> {
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt("ID"));
            s.setFirstName(rs.getString("FirstName"));
            s.setLastName(rs.getString("LastName"));
            s.setmajorID(rs.getInt("MajorID"));
            return s;
        }
    }

}
