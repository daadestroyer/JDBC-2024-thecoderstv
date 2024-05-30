import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCBatchProcessing {
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

            // insert batch
//            statement.addBatch("insert into student (name,city,email,salary) values ('ram singh','lucknow','ram@gmail.com','10000')");
//            statement.addBatch("insert into student (name,city,email,salary) values ('ramesh singh','allahabad','ramesh@gmail.com','20000')");
//
//            // update batch
//            statement.addBatch("update student set salary = salary + 3000 where salary < 35000");
//            statement.addBatch("update student set salary = salary - 5000 where salary < 110000 && salary > 50000");

            // delete batch
            statement.addBatch("DELETE FROM STUDENT WHERE salary > 90000");

            statement.executeBatch();
            System.out.println("Batch executed...");
        }
        catch (Exception e){
            System.out.println("Batch execution failed...");
            e.printStackTrace();
        }
    }
}
