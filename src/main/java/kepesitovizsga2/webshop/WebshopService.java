package kepesitovizsga2.webshop;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class WebshopService {
    private static final int MIN_PRICE = 1000;

    private JdbcTemplate jdbcTemplate;

    public WebshopService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getValuableCustomers() {
        //language=sql
        return jdbcTemplate.query("SELECT customer_name FROM orders WHERE total > 1000 ORDER BY customer_name;",
                (rs, i) -> rs.getString("customer_name"), MIN_PRICE);
    }
}
