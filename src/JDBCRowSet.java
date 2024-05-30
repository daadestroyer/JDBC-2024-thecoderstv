import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCRowSet {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;

    public static void main(String[] args) throws SQLException {
        try{
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl(DB_URL);
            jdbcRowSet.setUsername(DB_USERNAME);
            jdbcRowSet.setPassword(DB_PASSWORD);

            jdbcRowSet.setCommand("select * from student");
            jdbcRowSet.execute();

            while(jdbcRowSet.next()){
                System.out.println("ID : "+jdbcRowSet.getInt("id"));
                System.out.println("NAME : "+jdbcRowSet.getString("name"));
                System.out.println("CITY : "+jdbcRowSet.getString("city"));
                System.out.println("EMAIL : "+jdbcRowSet.getString("email"));
                System.out.println("SALARY : "+jdbcRowSet.getFloat("salary"));

                System.out.println("-------------");
            }

        }
        catch (Exception e){
            System.out.println("failed...");
            e.printStackTrace();
        }

        
    }
}
