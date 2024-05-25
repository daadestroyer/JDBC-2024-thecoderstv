import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProgramToCreateDB {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";
    private static Connection connection;

    // use to fire query
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();

            // our query
            String sql = "CREATE DATABASE IF NOT EXISTS JDBC";

            // fire query
            int i = statement.executeUpdate(sql);

            System.out.println("DATABASE CREATED");

        } catch (Exception e) {
            System.out.println("DATABASE CREATION FAILED...");
            e.printStackTrace();
        }
    }
}
