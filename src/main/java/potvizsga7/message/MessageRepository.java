package potvizsga7.message;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class MessageRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public MessageRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(long senderId, String receiverId, String message) {
        //language=sql
        jdbcTemplate.update("insert into messages (sender_id, receiver_id, message) values (?, ?, ?)", senderId, receiverId, message);
    }

    public List<String> findMessagesBySenderId(long id) {
        //language=sql
        return jdbcTemplate.query("select * from messages where sender_id = ?", (rs, i) -> rs.getString("message"), id);
    }
}
