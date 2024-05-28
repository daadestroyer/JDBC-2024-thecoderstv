import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCProgramtoSelectAllData {
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
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from STUDENT";
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                System.out.println("ID : "+res.getInt("id"));
                System.out.println("NAME : "+res.getString("name"));
                System.out.println("CITY : "+res.getString("city"));
                System.out.println("EMAIL : "+res.getString("email"));
                System.out.println("SALARY : "+res.getFloat("salary"));
                System.out.println("-------------");
            }
            System.out.println("NEXT -->"+res.next());
            System.out.println("PREVIOUS -->"+res.previous());
            System.out.println("FIRST --> "+res.first());
            System.out.println("LAST --> "+res.last());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
