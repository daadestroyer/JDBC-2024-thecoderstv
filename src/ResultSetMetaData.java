import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetMetaData {
    // database information
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1998";

    // use to make connection from db
    private static Connection connection;

    // use to fire query(select * from student where id = 101)
    private static Statement statement;
    private static java.sql.ResultSetMetaData resultSetMetaData;
    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql = "select * from STUDENT";
            ResultSet res = statement.executeQuery(sql);

            resultSetMetaData = res.getMetaData();

            System.out.println(resultSetMetaData.getColumnCount()); // gives no of column
            System.out.println(resultSetMetaData.getColumnTypeName(1)); // INT
            System.out.println(resultSetMetaData.getColumnTypeName(2)); // VARCHAR
            System.out.println(resultSetMetaData.getColumnTypeName(3)); // VARCHAR
            System.out.println(resultSetMetaData.getColumnTypeName(5)); // INT
            System.out.println(resultSetMetaData.getTableName(1));
            System.out.println(resultSetMetaData.getTableName(5));
            System.out.println(resultSetMetaData.getColumnName(1));
            System.out.println(resultSetMetaData.getColumnName(4));
            System.out.println(resultSetMetaData.getColumnName(5));

//            while(res.next()){
//                System.out.println("ID : "+res.getInt("id"));
//                System.out.println("NAME : "+res.getString("name"));
//                System.out.println("CITY : "+res.getString("city"));
//                System.out.println("EMAIL : "+res.getString("email"));
//                System.out.println("SALARY : "+res.getFloat("salary"));
//                System.out.println("-------------");
//            }
//            System.out.println("NEXT -->"+res.next());
//            System.out.println("PREVIOUS -->"+res.previous());
//            System.out.println("FIRST --> "+res.first());
//            System.out.println("LAST --> "+res.last());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
