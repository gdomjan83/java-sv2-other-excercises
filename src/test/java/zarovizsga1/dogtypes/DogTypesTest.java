package zarovizsga1.dogtypes;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DogTypesTest {

        DogTypes dogTypes;

        @BeforeEach
        void init() throws SQLException {
            MariaDbDataSource dataSource;
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/dog_database?useUnicode=true");
            dataSource.setUser("root");
            dataSource.setPassword("root456");

            Flyway flyway = Flyway.configure().locations("/db/migration/dogs").dataSource(dataSource).load();

            flyway.clean();
            flyway.migrate();

            dogTypes = new DogTypes(dataSource);

        }

        @Test
        void testGetDogsByCountry() {
            List<String> types = dogTypes.getDogsByCountry("Great Britain");
            assertEquals(12, types.size());
            assertTrue(types.contains("bull terrier"));
            assertTrue(types.contains("english setter"));
        }

    }
