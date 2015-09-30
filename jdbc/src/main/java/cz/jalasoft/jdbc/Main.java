package cz.jalasoft.jdbc;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cz.jalasoft.jdbc.h2.H2PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/29/15.
 */
public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {

        String location = readPath();

        LOGGER.debug("An interaction with a DB on location '{}' is about to be performed.", location);

        try {
            operateOnDB(location);
        } catch (SQLException exc) {
            SQLException current = exc;

            while (current != null) {
                LOGGER.error("Error code: {}", exc.getErrorCode());
                LOGGER.error("SQL state: {}", exc.getSQLState());
                LOGGER.error(current.getMessage());
                LOGGER.error("Stasktrace: ", current);
                current = current.getNextException();
            }
        }
    }

    private static String readPath() {
        Config config = ConfigFactory.load();
        String location = config.getString("db.location");


        return new HomeDirPathResolver().resolve(location);
    }

    private static void operateOnDB(String location) throws IOException, SQLException {
        PersonDao dao = new H2PersonDao(location);

        dao.insertPerson(person("Honza", "Lastovicka", "lastovicka@avast.com"));
        dao.insertPerson(person("Miska", "Lastovickova", "miska@gmail.com"));
        dao.insertPerson(person("Jirka", "Sereda", "jirka.s@seznam.cz"));
        dao.insertPerson(person("Vlasta", "Melichar", "vlastik@kolin.cz"));

        Collection<Person> persons = dao.allPersons();
        System.out.println(persons);
    }

    private static Person person(String name, String surname, String email) {
        Person p = new Person();
        p.setId(null);
        p.setName(name);
        p.setSurname(surname);
        p.setEmail(email);
        return p;
    }
}
