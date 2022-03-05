package potvizsga7.message;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUser(String username) {
        //language=sql
        jdbcTemplate.update("insert into users (username) values (?)", username);
    }

    public Optional<User> findUserByName(String userName) {
        //language=sql
        List<User> result = jdbcTemplate.query("select * from users where username = ?", (rs, i) -> createUser(rs), userName);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result.get(0));
    }

    private User createUser(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"), rs.getString("username"));
    }
}
