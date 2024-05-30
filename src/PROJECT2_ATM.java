import java.sql.*;
import java.util.Scanner;

public class PROJECT2_ATM {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;

    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Press 1 to open account");
                System.out.println("Press 2 to check account balance");
                System.out.println("Press 3 to withdraw amount");
                System.out.println("Press 4 to submit cash");
                System.out.println("Press 5 to exit");

                int choice = sc.nextInt();

                if (choice == 1) {
                    // first check user with email exist or not

                    // if exit
                    System.out.println("Enter your email");
                    String email = sc.next();
                    preparedStatement = connection.prepareStatement("select * from user where email = ?");
                    preparedStatement.setString(1, email);
                    boolean res = preparedStatement.execute();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    if (resultSet.next()) {
                        System.out.println("---------------------------");
                        System.out.println("user account already opened");
                        System.out.println("---------------------------");
                    } else {
                        System.out.println("Enter name");
                        String name = sc.next();
                        System.out.println("Enter city");
                        String city = sc.next();
                        System.out.println("Enter amount");
                        int amount = sc.nextInt();

                        preparedStatement = connection.prepareStatement("INSERT INTO USER (name,city,email,acct_balance) VALUES (?,?,?,?)");
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, city);
                        preparedStatement.setString(3, email);
                        preparedStatement.setInt(4, amount);

                        int i = preparedStatement.executeUpdate();
                        if (i > 0) {
                            System.out.println("Records Inserted...");
                        } else {
                            System.out.println("Records not inserted...");
                        }

                    }
                } else if (choice == 2) {
                    System.out.println("Enter your email");
                    String email = sc.next();
                    preparedStatement = connection.prepareStatement("select * from user where email = ?");
                    preparedStatement.setString(1, email);
                    boolean res = preparedStatement.execute();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    if (resultSet.next()) {
                        connection.prepareStatement("SELECT acct_balance from USER where email = ?");
                        preparedStatement.setString(1, email);
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next())
                            System.out.println("User account balance is : " + rs.getString("acct_balance"));

                    } else {
                        System.out.println("---------------------------");
                        System.out.println("user account not found");
                        System.out.println("---------------------------");
                    }
                } else if (choice == 3) {
                    System.out.println("Enter your email");
                    String email = sc.next();
                    preparedStatement = connection.prepareStatement("select * from user where email = ?");
                    preparedStatement.setString(1, email);
                    boolean res = preparedStatement.execute();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    if (resultSet.next()) {
                        System.out.println("Enter the amount to withdraw");
                        int amount = sc.nextInt();
                        preparedStatement = connection.prepareStatement("UPDATE USER set acct_balance = acct_balance - ? where email = ?");

                        preparedStatement.setInt(1, amount);
                        preparedStatement.setString(2, email);
                        int i = preparedStatement.executeUpdate();
                        if (i > 0) {
                            System.out.println("------------------------------------------");
                            System.out.println("Amount " + amount + " withdraw successfully...");
                            System.out.println("------------------------------------------");
                        }
                        preparedStatement = connection.prepareStatement("SELECT acct_balance from USER where email = ?");
                        preparedStatement.setString(1, email);
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            System.out.println("----------------------------------------------------------------------------");
                            System.out.println("Your current account balance is : " + rs.getString("acct_balance"));
                            System.out.println("----------------------------------------------------------------------------");
                        }
                    } else {
                        System.out.println("---------------------------");
                        System.out.println("user account not found");
                        System.out.println("---------------------------");
                    }
                } else if (choice == 4) {
                    System.out.println("Enter your email");
                    String email = sc.next();
                    preparedStatement = connection.prepareStatement("select * from user where email = ?");
                    preparedStatement.setString(1, email);
                    boolean res = preparedStatement.execute();
                    ResultSet resultSet = preparedStatement.getResultSet();
                    if (resultSet.next()) {
                        System.out.println("Enter the amount to submit");
                        int amount = sc.nextInt();
                        preparedStatement = connection.prepareStatement("UPDATE USER set acct_balance = acct_balance + ? where email = ?");

                        preparedStatement.setInt(1, amount);
                        preparedStatement.setString(2, email);
                        int i = preparedStatement.executeUpdate();
                        if (i > 0) {
                            System.out.println("------------------------------------------");
                            System.out.println("Amount " + amount + " withdraw successfully...");
                            System.out.println("------------------------------------------");
                        }
                        preparedStatement = connection.prepareStatement("SELECT acct_balance from USER where email = ?");
                        preparedStatement.setString(1, email);
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            System.out.println("----------------------------------------------------------------------------");
                            System.out.println("Your current account balance is : " + rs.getString("acct_balance"));
                            System.out.println("----------------------------------------------------------------------------");
                        }
                    } else {
                        System.out.println("----------------------------");
                        System.out.println("user account not found");
                        System.out.println("---------------------------");
                    }
                } else if (choice == 5) {
                    System.out.println("Thanks for choosing us !");
                    break;
                } else {
                    System.out.println("Choose correct option");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
