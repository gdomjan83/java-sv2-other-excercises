package zarovizsga2.peoplesql;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return getIpAddress(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect to database.", sqle);
        }
    }

    private String getIpAddress(PreparedStatement stmt) throws SQLException{
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }
            throw new IllegalStateException("No IP address found");
        }
    }
}
