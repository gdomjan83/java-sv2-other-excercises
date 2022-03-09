package potvizsga8.settlers;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;

public class SettlerRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public SettlerRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public long saveNewSettler(Settler settler) {
        try (Connection conn = dataSource.getConnection();
             //language=sql
             PreparedStatement stmt = conn.prepareStatement(
                     "insert into settlers (name_of_settler, amount_of_tobacco, expected_income) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, settler.getNameOfSettler());
            stmt.setInt(2, settler.getAmountOfTobacco());
            stmt.setInt(3, settler.getExpectedIncome());
            stmt.executeUpdate();
            return returnGeneratedKey(stmt);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not connect to database.", sqle);
        }
    }

    public Settler findSettlerById(long id) {
        //language=sql
        Settler settler = jdbcTemplate.queryForObject("select * from settlers where id = ?",
                (rs, i) -> new Settler(rs.getString("name_of_settler"), rs.getInt("amount_of_tobacco")), id);
        if (settler == null) {
            throw new IllegalArgumentException("Can not find settler with this id.");
        }
        return settler;
    }

    public void updateGrowthAndIncome(long id, int amount) {
        Settler settler = findSettlerById(id);
        int newAmount = Math.max(0, settler.getAmountOfTobacco() - amount);
        int income = newAmount * Settler.COST;
        //language=sql
        jdbcTemplate.update("update settlers set amount_of_tobacco = ?, expected_income = ? where id = ?", newAmount, income, id);
    }

    private int returnGeneratedKey(PreparedStatement statement) throws SQLException {
        try (ResultSet rs = statement.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new IllegalArgumentException("Can not get id.");
        }
    }
}
