import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProgramtoDeleteRecords {
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
            String sql = "DELETE FROM STUDENT where salary < 50000";
            int i = statement.executeUpdate(sql);
            if(i > 0){
                System.out.println("Records Deleted...");
            }
        }
        catch(Exception e){
            System.out.println("Records not deleted! something went wrong . . .");
            e.printStackTrace();
        }
    }
}
// create db
// create table
// insert
// update
// delete
