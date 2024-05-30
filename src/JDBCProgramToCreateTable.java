import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProgramToCreateTable {

    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;
    public static void main(String[] args) {
        try{
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USER(ACCOUNT_NO INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200) , city VARCHAR(50), email VARCHAR(50) , acct_balance int(200))";
            String sqlAlterTable = "ALTER TABLE USER AUTO_INCREMENT = 36870001";

            // fire query
            statement.executeUpdate(sql);
            statement.executeUpdate(sqlAlterTable);
            System.out.println("Table created...");
        }
        catch (Exception e){
            System.out.println("Table creation failed...");
            e.printStackTrace();
        }
    }
}
