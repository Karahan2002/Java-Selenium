package jdbctests;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@52.87.154.190:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("select * from employees");


        while(rs.next()){
            System.out.println(rs.getString("first_name"));
        }

        rs.close();
        statement.close();
        connection.close();
    }
}
