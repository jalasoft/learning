package cz.jalasoft.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/29/15.
 */
public interface PersonDao {

    Collection<Person> allPersons() throws SQLException;

    void insertPerson(Person person) throws SQLException;

    void printMetadata() throws SQLException, IOException;
}
