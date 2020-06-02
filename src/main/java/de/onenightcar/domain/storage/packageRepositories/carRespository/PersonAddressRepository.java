package de.onenightcar.domain.storage.packageRepositories.carRespository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class PersonAddressRepository {

    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static ResultSet getAllPersonAddressesFromDatabase(Connection conn) throws Exception{

        String query = "SELECT * FROM personaddress";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.next()) {
                System.out.println("No Persons to be shown");
            } else {
                return rs;
            }

        } catch (Exception e) {
            LOG.log(Level.WARNING, "The Query did not worked out" + e);
        }
        return null;
    }

    public static void printAllPersonsAddressesFromDatabase(Connection conn) throws Exception {
        ResultSet rs = getAllPersonAddressesFromDatabase(conn);
        if (rs != null) {
            do {
                System.out.println( rs.getString( 1 ) + "  " +
                        rs.getString( 2 ) + "  " +
                        rs.getString( 3 ) + "  " +
                        rs.getString( 4 ) + "  " +
                        rs.getString( 5 ) + "  " +
                        rs.getString( 6 ) + "\n");

            } while (rs.next());
        }
    }
}
