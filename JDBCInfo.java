package jdbctests;

import java.sql.*;

public class JDBCInfo {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@52.87.154.190:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("select * from employees");

        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("User : "+dbMetadata.getUserName());
        System.out.println("Database Product Name : "+dbMetadata.getDatabaseProductName());
        System.out.println("Database Product Version : "+dbMetadata.getDatabaseProductVersion());
        System.out.println("Driver Name : "+dbMetadata.getDriverName());
        System.out.println("Driver Version : "+dbMetadata.getDriverVersion());

        rs.close();
        statement.close();
        connection.close();
    }
}
