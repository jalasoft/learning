package cz.jalasoft.jdbc.h2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/29/15.
 */
final class DbInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbInitializer.class);

    private final String location;

    public DbInitializer(String location) {
        this.location = location;
    }

    void initializeDbIfNotExist() throws IOException, SQLException {
        Path locationPath = Paths.get(location + ".mv.db");

        if (!Files.exists(locationPath)) {
            LOGGER.warn("Database does not exist on location {}.", locationPath);
            createDatabase();
            return;
        }

        LOGGER.debug("Database already exists.");
    }

    private void createDatabase() throws IOException, SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:h2:" + location)) {
            Statement s = con.createStatement();

            String createTablesSql = loadScript();
            s.addBatch(createTablesSql);
            int[] result = s.executeBatch();

            LOGGER.debug("Database has been created with result: {}", result[0]);
        }
    }

    private String loadScript() throws IOException {
        InputStream input = DbInitializer.class.getClassLoader().getResourceAsStream("init.sql");

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        StringBuilder bldr = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null) {
            bldr.append(line);
        }

        LOGGER.debug("Script for initialization of a new database has been loaded.");

        return bldr.toString();
    }
}
