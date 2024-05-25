import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionProgram {

    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            if (connection != null) {
                System.out.println("Connection done...");
            } else {
                System.out.println("Connection fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

