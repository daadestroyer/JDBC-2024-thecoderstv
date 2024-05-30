import java.sql.*;
import java.util.Scanner;

public class PROJECT1_StudentManagementSystem {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;

    private static PreparedStatement preparedStatement;

    public static void main(String[] args) throws SQLException {
        // database connection
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("******* WELCOME TO STUDENT MANAGEMENT SYSTEM *******");
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to update student");
            System.out.println("Press 3 to delete student");
            System.out.println("Press 4 to get all student");
            System.out.println("Press 5 to exit");

            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                try {
                    // take all the data from user
                    System.out.println("Enter user name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter user email");
                    String email = scanner.nextLine();
                    System.out.println("Enter user city");
                    String city = scanner.nextLine();
                    System.out.println("Enter user salary");
                    int salary = scanner.nextInt();

                    // first check user is present or not
                    System.out.println(email);
                    boolean res = statement.execute("SELECT * from STUDENT where email = '" + email + "'");
                    ResultSet resultSet = statement.getResultSet();
                    if (resultSet.next()) {
                        System.out.println("user already added . . .");
                    } else {
                        preparedStatement = connection.prepareStatement("INSERT INTO STUDENT(name,city,email,salary) VALUES(?,?,?,?)");
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, city);
                        preparedStatement.setString(3, email);
                        preparedStatement.setInt(4, salary);
                        int i = preparedStatement.executeUpdate();
                        if (i > 0) {
                            System.out.println("Records Inserted...");
                        } else {
                            System.out.println("Records not inserted...");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Something went wrong . . .");
                }
            } else if (choice.equalsIgnoreCase("2")) {

                System.out.println("enter the mail of the user to update : ");
                String userToUpdate = scanner.nextLine();
                boolean res = statement.execute("SELECT * from STUDENT where email = '" + userToUpdate + "'");
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    System.out.println("Enter updated user name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter updated user email");
                    String email = scanner.nextLine();
                    System.out.println("Enter updated user city");
                    String city = scanner.nextLine();
                    System.out.println("Enter updated user salary");
                    int salary = scanner.nextInt();
                    preparedStatement = connection.prepareStatement("UPDATE STUDENT set name = ? , city = ? , email = ? , salary = ? where email = ?");
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, city);
                    preparedStatement.setString(3, email);
                    preparedStatement.setInt(4, salary);
                    preparedStatement.setString(5, userToUpdate);
                    int i = preparedStatement.executeUpdate();
                    if (i > 0) {
                        System.out.println("Records updated...");
                    } else {
                        System.out.println("Records not updated...");
                    }
                } else {
                    System.out.println("user not found");
                }

            } else if (choice.equalsIgnoreCase("3")) {
                System.out.println("enter the mail of the user to update : ");
                String userToDelete = scanner.nextLine();
                boolean res = statement.execute("SELECT * from STUDENT where email = '" + userToDelete + "'");
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    preparedStatement = connection.prepareStatement("DELETE from STUDENT where email = ?");
                    preparedStatement.setString(1, userToDelete);
                    int i = preparedStatement.executeUpdate();
                    if (i > 0) {
                        System.out.println("Records deleted...");
                    } else {
                        System.out.println("Records not deleted...");
                    }
                } else {
                    System.out.println("user not found");
                }
            } else if (choice.equalsIgnoreCase("4")) {
                preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT");
                ResultSet res = preparedStatement.executeQuery();
                if(res.next()){
                    System.out.println("ID : "+res.getInt("id"));
                    System.out.println("NAME : "+res.getString("name"));
                    System.out.println("CITY : "+res.getString("city"));
                    System.out.println("EMAIL : "+res.getString("email"));
                    System.out.println("SALARY : "+res.getFloat("salary"));
                    System.out.println("-------------");
                }
                else{
                    System.out.println("no records found");
                }
            } else if (choice.equalsIgnoreCase("5")) {
                System.out.println("Thanks for visiting . . .");
                break;
            } else {
                System.out.println("Choose correction option");
            }
        }
    }
}
