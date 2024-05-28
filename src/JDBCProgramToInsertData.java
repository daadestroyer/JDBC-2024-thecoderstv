import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgramToInsertData {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your city:");
            String city = scanner.nextLine();
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter salary");
            int sal = scanner.nextInt();
            String sql = "INSERT INTO STUDENT (name,city,email,salary) values ('" + name + "','" + city + "','" + email + "','"+sal+"' )";

            int rowInserted = statement.executeUpdate(sql);
            if (rowInserted > 0) {
                System.out.println("Data inserted...");
            }
        } catch (Exception e) {
            System.out.println("Data insertion failed...");
            e.printStackTrace();
        }
    }
}
