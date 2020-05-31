package de.onenightcar.domain.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static final Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static Connection getConnection() throws Exception{
        Connection conn = null;

        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/oneNightCar";
            String username = "root";
            String password = "";
            Class.forName(driver);

            conn = DriverManager.getConnection(url,username,password);
            LOG.log(Level.INFO, "Database Connection established");

            return conn;
        } catch (ClassNotFoundException | SQLException e){
            LOG.log(Level.INFO, "Database connection didnt worked out: " + e);
        }
        return conn;
    }

    public static void disconnectDatabase(Connection conn) throws Exception{
        try{
            conn.close();
            LOG.log(Level.INFO, "Database successfully disconnected");
        } catch (Exception e) {
            LOG.log(Level.INFO, "Database couldn't be disconnected, reason: " + e);
        }
    }
}
