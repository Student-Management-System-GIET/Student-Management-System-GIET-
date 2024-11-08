import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/Collegedata?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "";

        try {
            // For MySQL Connector 9.x
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
