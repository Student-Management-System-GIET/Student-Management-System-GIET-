package collegeapplication.common;

import java.sql.*;

public class DataBaseConnection {

    // Connection object to hold the active database connection
    private static Connection con = null;
    // Connection details
    private static final String url = "jdbc:mysql://192.168.1.100:3306/collegedata?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String uname = "root";
    private static final String password = "";

    // This method returns the connection. Creates a new one if not available.
    public static synchronized Connection getConnection() {
        if (con != null) {
            try {
                // Check if the connection is valid
                if (!con.isClosed()) {
                    return con;
                } else {
                    con = createConnection();
                    return con;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return createConnection();
        }
    }

    // Method to create a new connection
    private static Connection createConnection() {
        try {
            // Create a new connection if it's not already available
            con = DriverManager.getConnection(url, uname, password);
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to check if the connection is successful
    public static boolean checkConnection() {
        try (Connection conn = DriverManager.getConnection(url, uname, password)) {
            // If connection is successful, return true
            return conn != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to close the connection
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con = null; // Set connection to null once closed
        }
    }
}
