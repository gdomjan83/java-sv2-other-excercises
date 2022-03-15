package kepesitovizsga1.jurassic;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> checkOverpopulation() {
        //language=sql
        return jdbcTemplate.query("select breed from dinosaur where actual > expected order by breed",
                (rs, i) -> rs.getString("breed"));
    }
}
