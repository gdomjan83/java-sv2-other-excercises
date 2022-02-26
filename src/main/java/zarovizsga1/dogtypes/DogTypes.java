package zarovizsga1.dogtypes;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public List<String> getDogsByCountry(String country) {
        try (Connection conn = dataSource.getConnection();
             //language=sql
             PreparedStatement stmt = conn.prepareStatement("select (name) from dog_types where country = ? order by name")) {
            stmt.setString(1, country.toUpperCase());
            return executeQuery(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect.", sqle);
        }
        //language=sql
//        return jdbcTemplate.query("select (name) from dog_types where country = ? order by name",
//                (rs, i) -> rs.getString(1).toLowerCase(), country.toUpperCase());
    }

    private List<String> executeQuery(PreparedStatement stmt) throws SQLException{
        try (ResultSet rs = stmt.executeQuery()) {
            List<String> result = new ArrayList<>();
            while (rs.next()) {
                result.add(rs.getString("name").toLowerCase());
            }
            return result;
        }
    }
}
