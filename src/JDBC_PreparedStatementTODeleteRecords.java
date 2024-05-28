import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_PreparedStatementTODeleteRecords {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "DELETE FROM STUDENT WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,5);
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("Records Deleted...");
            }

        } catch (Exception e) {
            System.out.println("Records deletion failed");

            e.printStackTrace();
        }
    }
}
