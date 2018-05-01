package cr.config;

//import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    @Bean(name = "CRDB")
    @Primary
    public DataSource getICUDevDataSource() throws SQLException {

    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://uwrfawsdb.caavlybt5byq.us-east-1.rds.amazonaws.com/uwrfawsdb");
        dataSource.setUsername("uwrfcs001");
        dataSource.setPassword("cs180403");
        //dataSource.setValidationQuery("select 1");
        return dataSource;
    }
}
