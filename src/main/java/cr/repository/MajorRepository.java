package cr.repository;

import cr.entity.Major;
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
public class MajorRepository {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Resource(name = "CRDB")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Major> findAll() {
        String sql = "select * from Major";
        return this.jdbcTemplate.query(sql, new MajorMapper());
    }

    private static final class MajorMapper implements RowMapper<Major> {
        public Major mapRow(ResultSet rs, int rowNum) throws SQLException {
            Major s = new Major();
            s.setName(rs.getString("MajorName"));
            s.setCode(rs.getString("MajorCode"));
            s.setOption(rs.getString("MajorOption"));
            s.setId(rs.getInt("ID"));
            return s;
        }
    }
}