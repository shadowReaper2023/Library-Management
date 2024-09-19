
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASS = "";

    // Establishing connection
    public Connection connect() {
        Connection connection = null;
        try {
            // Register DatabaseConnection driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            // Handle DatabaseConnection errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle Class.forName errors
            e.printStackTrace();
        }
        return connection;
    }
}