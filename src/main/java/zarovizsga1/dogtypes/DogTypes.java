package zarovizsga1.dogtypes;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DogTypes {
    private JdbcTemplate jdbcTemplate;

    public DogTypes(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<String> getDogsByCountry(String country) {

        //language=sql
        return jdbcTemplate.query("select (name) from dog_types where country = ? order by name",
                (rs, i) -> rs.getString(1).toLowerCase(), country.toUpperCase());
    }
}
