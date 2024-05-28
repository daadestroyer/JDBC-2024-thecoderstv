import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_PreparedStatementTOInsertRecords {// database information
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

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your city:");
            String city = scanner.nextLine();
            System.out.println("Enter your email:");
            String email = scanner.nextLine();
            System.out.println("Enter salary");
            int sal = scanner.nextInt();

            String sql = "INSERT INTO STUDENT(name,city,email,salary) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4,sal);

            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("Records Inserted...");
            }

        } catch (Exception e) {
            System.out.println("Records insertion failed");

            e.printStackTrace();
        }
    }
}
