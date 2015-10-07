package cz.jalasoft.jdbc.info;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/30/15.
 */
public class DatabaseInfo {

    private final DatabaseMetaData metadata;

    public DatabaseInfo(Connection connection) throws SQLException {
        this.metadata = connection.getMetaData();
    }

    public String getInfo() throws SQLException, IOException {
        StringWriter writer = new StringWriter();
        print(writer);
        return writer.toString();
    }

    public void print(Writer writer) throws SQLException, IOException {
        printInfo(writer);
    }

    private void printInfo(Writer writer) throws SQLException, IOException {
        printDriverInfo(writer);
        printTableInfo(writer);
    }

    private void printDriverInfo(Writer writer) throws SQLException, IOException {
        writer.write("Driver name\t" + metadata.getDriverName());
        writer.write("Driver version\t" + metadata.getDriverVersion());
    }

    private void printTableInfo(Writer writer) throws SQLException, IOException{
        ResultSet rs = metadata.getTables(null, null, null, null);


    }
}
