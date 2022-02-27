package zarovizsga3.housecup;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class HouseCup {
    private JdbcTemplate jdbcTemplate;

    public HouseCup(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public int getPointsOfHouse(String houseName) {
        try {
            return jdbcTemplate.queryForObject("select SUM(points_earned) as total from house_points where house_name = ?",
                    (rs, i) -> rs.getInt("total"), houseName);
        } catch (NullPointerException npe) {
            throw new IllegalStateException("House by that name does not exist", npe);
        }
    }
}
