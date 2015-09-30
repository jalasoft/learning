package cz.jalasoft.jdbc.h2;

import cz.jalasoft.jdbc.Person;
import cz.jalasoft.jdbc.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/30/15.
 */
public final class H2PersonDao implements PersonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2PersonDao.class);

    private final String DB_URL_PATTERN = "jdbc:h2:%s";

    private static final String ALL_PERSONS_QUERY = "SELECT * FROM person";
    private static final String INSERT_PERSON_UPDATE = "INSERT INTO person (id, name, surname, email) VALUES (NULL, ?, ?, ?);";

    private final String url;

    public H2PersonDao(String location) throws IOException, SQLException {
        this.url = String.format(DB_URL_PATTERN, location);

        new DbInitializer(location).initializeDbIfNotExist();
    }

    @Override
    public Collection<Person> allPersons() throws SQLException {

        LOGGER.debug("All persons are about to be retrieved from H2 database.");

        try (Connection connection = connection()) {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(ALL_PERSONS_QUERY);

            LOGGER.debug("All persons have been successfully retrieved from H2 database.");
            return persons(result);
        }
    }

    @Override
    public void insertPerson(Person person) throws SQLException {

        LOGGER.debug("A new person is about to be inserted into H2 database: {}", person);

        try (Connection connection = connection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_UPDATE);

            statement.setString(1, person.getName());
            statement.setString(2, person.getSurname());
            statement.setString(3, person.getEmail());

            statement.execute();

            LOGGER.debug("A new person has been successfully inserted into H2 database.");
        }
    }

    private Collection<Person> persons(ResultSet result) throws SQLException {
        Collection<Person> persons = new ArrayList<>();

        while (result.next()) {

            Person p = new Person();
            p.setName(result.getString("NAME"));
            p.setSurname(result.getString("SURNAME"));
            p.setEmail(result.getString("EMAIL"));
            p.setId(result.getInt("ID"));

            persons.add(p);
        }
        return persons;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}