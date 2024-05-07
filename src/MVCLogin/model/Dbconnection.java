package MVCLogin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    public static Connection getMySQLConnection() throws SQLException {
        Connection connection = null;
        String hostName = "localhost";
        String dbName = "ecommercefpt";
        String userName = "root";
        String password = "";
        String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        try {
            connection = DriverManager.getConnection(connectionURL,userName,password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection ;
    }

}
